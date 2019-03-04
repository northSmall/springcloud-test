package ai.hengzhi.cph.redisson;

import org.junit.Test;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

public class RedisLock {

    @Test
    public void config() {

        // 构造redisson实现分布式锁必要的Config
        Config config = new Config();
        config.useSingleServer().setAddress("redis://192.168.147.129:6379");
//        config.useSingleServer().setAddress("redis://192.168.147.129:6379").setPassword("a123456").setDatabase(0);
        // 构造RedissonClient
        RedissonClient redissonClient = Redisson.create(config);
        // 设置锁定资源名称
        RLock disLock = redissonClient.getLock("DISLOCK");
        boolean isLock;
        try {
            //尝试获取分布式锁
            isLock = disLock.tryLock(500, 15000, TimeUnit.MILLISECONDS);
            if (isLock) {
                //TODO if get lock success, do something;
                Thread.sleep(15000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 无论如何, 最后都要解锁
            disLock.unlock();
        }
    }
}
