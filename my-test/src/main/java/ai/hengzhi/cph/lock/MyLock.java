package ai.hengzhi.cph.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author gaokun
 * @date 2019/3/6 16:39
 */
public class MyLock {
    
    Lock lock = new ReentrantLock(); 
    
    public void process() {
        lock.lock();
        String name = Thread.currentThread().getName();
        System.out.println(name +"获取到锁");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        System.out.println(name +"处理完业务流程，释放锁完毕");
    }

    public void process1() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (lock.tryLock()) {
            System.out.println(name +"获取到锁");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            System.out.println(name +"处理完业务流程，释放锁完毕");
        } else {
            System.out.println(name +"没有获取到锁，放弃执行");
        };
    }

    private class Thread1 extends Thread{

        @Override
        public void run() {
            try {
                process1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        MyLock myLock = new MyLock();
        for (int i = 0; i < 5; i++) {
            Thread1 thread1 = myLock.new Thread1();
            thread1.setName("线程"+i);
            thread1.start();
        }
    }
}
