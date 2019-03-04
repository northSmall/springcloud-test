package ai.hengzhi.cph.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void accept() throws IOException, ClassNotFoundException {

        ServerSocket serverSocket = new ServerSocket(5555);
        while (true) {
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
//            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//            Object readObject = objectInputStream.readObject();
//            System.out.println(readObject);
            InputStreamReader isr =new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(isr);
            String info =null;
            while((info=br.readLine())!=null){
                System.out.println("我是服务器，客户端说："+info);
            }

            OutputStream outputStream = accept.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.write("服务端已经收到你发的信息");
            printWriter.flush();
            accept.shutdownOutput();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Server server = new Server();
        server.accept();
    }
}
