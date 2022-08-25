package view;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created on 2021/12/25 - 9:49.
 *
 * @author CaseyLee
 */

class ReaderListener implements ActionListener {
    ChatRoom_View view;

    public void setView(ChatRoom_View V){
        this.view = V;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view.msg_send) {
            String str = view.msg_send.getText();
            view.msg_get.append("我：" + str + '\n');
        }
    }
}

public class ChatRoom_View extends JFrame {

    JLabel label_tips, label_ip;
    JTextField msg_send;
    JTextArea msg_get;
    BufferedImage image;
    JLabel label;
    ReaderListener readerListener;

    public ChatRoom_View(String ip){

        image = null;
        try{
            image = ImageIO.read(new File("src\\images\\蓝色长条.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

        setBounds(10, 500, 400, 400);
        //设置窗体为空布局
        setLayout(null);

        label_tips = new JLabel("我们可以开始聊天啦~");
        label_ip = new JLabel("对方ip：" + ip);
        msg_send = new JTextField();
        label = new JLabel(new ImageIcon(image));
        msg_get = new JTextArea();
        readerListener = new ReaderListener();
        readerListener.setView(this);

        label_tips.setBounds(140, 10, 370, 15);
        label_ip.setBounds(140, 25, 370, 20);
        msg_get.setBounds(10, 45, 370, 200);
        label.setBounds(10, 240, 370, 20);
        msg_send.setBounds(10, 260, 370, 90);
        msg_send.addActionListener(readerListener);

        add(label_tips);
        add(label_ip);
        add(msg_get);
        add(label);
        add(msg_send);

        setTitle("聊天室");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src\\images\\聊天.png");
        setIconImage(img);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);                  //让窗体居中显示


    }

}
