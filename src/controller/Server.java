package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2021/12/25 - 23:02.
 *
 * @author CaseyLee
 */

public class Server {
    public static void main(String args[]) {
//        String [] answer ={"Roger roger，咩事？","坚定流噶，咁我约你听朝星爸爸温书喇","I promise唔会"};
        ServerSocket serverForClient=null;
        Socket socketOnServer = null;
        DataOutputStream out = null;
        DataInputStream in = null;
        try { serverForClient = new ServerSocket(2010);
        }
        catch(IOException e1) {
            //如果端口号已经被占用，将触发异常
            System.out.println(e1);
        }
        try{ System.out.println("等待客户呼叫");
            socketOnServer = serverForClient.accept(); //堵塞状态，除非有客户呼叫
            System.out.println("客户的地址:" + socketOnServer.getInetAddress());
            System.out.println("客户的端口:" + socketOnServer.getPort());
            out = new DataOutputStream(socketOnServer.getOutputStream());
            in = new DataInputStream(socketOnServer.getInputStream());
//            for(int i=0;i<answer.length;i++) {
//                String s = in.readUTF(); // in读取信息，堵塞状态
//                System.out.println("服务器收到客户的提问:"+s);
//                out.writeUTF(answer[i]);
//                Thread.sleep(1000);
//            }
            while(true){
                Scanner scan = new Scanner(System.in);
                out.writeUTF(scan.nextLine());
                String s = in.readUTF();   //in读取信息，堵塞状态
                System.out.println("客户收到服务器的回答:"+s);
                Thread.sleep(1000);
            }
        }
        catch(Exception e) {
            System.out.println("客户已断开"+e);
        }
    }
}