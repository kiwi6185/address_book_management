package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2021/12/25 - 23:02.
 *
 * @author CaseyLee
 */

public class Client {
    public void call(){
        //        String [] mess ={"Calling吴凤莹，收唔收到？","今晚返屋企","今次会唔会甩底？"};
        Socket mysocket;
        DataInputStream in = null;
        DataOutputStream out = null;
        try{  mysocket = new Socket("127.0.0.1",2010);
            //本机ip127.0.0.1
            //芳 218.192.81.141
            //梦 192.168.137.1
            //Sean 159.75.55.71   192.168.43.234
            in = new DataInputStream(mysocket.getInputStream());
            out = new DataOutputStream(mysocket.getOutputStream());
//            for(int i=0;i<mess.length;i++) {
//                out.writeUTF(mess[i]);
//                String s = in.readUTF();   //in读取信息，堵塞状态
//                System.out.println("客户收到服务器的回答:"+s);
//                Thread.sleep(1000);
//            }
            while(true){
                String s = in.readUTF();   //in读取信息，堵塞状态
                System.out.println("客户收到服务器的回答:"+s);
                Scanner scan = new Scanner(System.in);
                out.writeUTF(scan.nextLine());
                Thread.sleep(1000);
            }
        }
        catch(Exception e) {
            System.out.println("服务器已断开"+e);
        }
    }
}