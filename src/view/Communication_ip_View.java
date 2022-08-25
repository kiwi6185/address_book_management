package view;

import controller.Communication_ip_Controller;
import controller.Search_ip_Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2021/12/24 - 23:18.
 *
 * @author CaseyLee
 */
public class Communication_ip_View extends JFrame {

    JLabel label_tips;
    JLabel label_name;
    JTextField text_name;
    JButton btn;

    public Communication_ip_View(){

        setBounds(10, 500, 250, 190);
        //设置窗体为空布局
        setLayout(null);

        label_tips = new JLabel("输入通讯服务端持有者姓名");
        label_name = new JLabel("姓名：");
        text_name = new JTextField();
        btn = new JButton("呼叫他/她");

        label_tips.setBounds(40, 15, 200, 25);
        label_name.setBounds(40, 60, 80, 25);
        text_name.setBounds(90, 60, 100, 25);
        btn.setBounds(60, 110, 100, 25);

        add(label_tips);
        add(label_name);
        add(text_name);
        add(btn);

        setTitle("通讯页面");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src\\images\\通讯.png");
        setIconImage(img);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);                  //让窗体居中显示

        btn.addActionListener((actionEvent -> {   //呼叫按钮

            String name = text_name.getText();

            Search_ip_Controller search_ip_controller = new Search_ip_Controller();
            if(search_ip_controller.search(name) != null) {

                setVisible(false);
                String ip = search_ip_controller.search(name).getIp();
                ChatRoom_View chatRoom_view = new ChatRoom_View(ip);

            }

        }));
    }

}

