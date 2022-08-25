package controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created on 2021/12/25 - 9:35.
 *
 * @author CaseyLee
 */
public class Communication_ip_Controller {
    public Communication_ip_Controller(String ip) {
        Socket mysocket;
        DataInputStream in = null;
        DataOutputStream out = null;
        try{  mysocket = new Socket(ip,2010);
            //本机ip127.0.0.1
            //梦 192.168.137.1
            //Sean 159.75.55.71   192.168.43.234
            in = new DataInputStream(mysocket.getInputStream());
            out = new DataOutputStream(mysocket.getOutputStream());
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
