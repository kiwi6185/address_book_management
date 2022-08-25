package view;

import controller.Add_ip_Controller;
import controller.Show_ip_Controller;
import model.Update;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2021/12/24 - 11:06.
 *
 * @author CaseyLee
 */
public class Add_ip_View extends JFrame {

    JLabel label_tips;
    JLabel label_ID, label_name, label_ip;
    JTextField text_ID, text_name, text_ip;
    JButton btn;

    public Add_ip_View(){

        setBounds(10, 500, 250, 270);
        //设置窗体为空布局
        setLayout(null);

        label_tips = new JLabel("请输入要添加的 ip 信息");
        label_ID = new JLabel("ID：");
        label_name = new JLabel("姓名：");
        label_ip = new JLabel("ip地址：");
        text_ID = new JTextField();
        text_name = new JTextField();
        text_ip = new JTextField();
        btn = new JButton("添加记录");

        label_tips.setBounds(50, 15, 200, 25);
        label_ID.setBounds(40, 60, 80, 25);
        text_ID.setBounds(90, 60, 100, 25);
        label_name.setBounds(40, 100, 80, 25);
        text_name.setBounds(90, 100, 100, 25);
        label_ip.setBounds(40, 140, 80, 25);
        text_ip.setBounds(90, 140, 100, 25);
        btn.setBounds(60, 190, 100, 25);

        add(label_tips);
        add(label_ID);
        add(text_ID);
        add(label_name);
        add(text_name);
        add(label_ip);
        add(text_ip);
        add(btn);

        btn.addActionListener((actionEvent -> {   //添加ip

            String ID = text_ID.getText();
            String name = text_name.getText();
            String ip = text_ip.getText();

            Add_ip_Controller add_ip_controller = new Add_ip_Controller();
            if(add_ip_controller.add(ID, name, ip).isSuccessOrNot()){
                setVisible(false);
            }

        }));

        setTitle("增加通讯ip");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src\\images\\增加.png");
        setIconImage(img);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);                  //让窗体居中显示

    }

}
