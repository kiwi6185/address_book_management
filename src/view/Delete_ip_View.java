package view;

import controller.Delete_ip_Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2021/12/24 - 11:02.
 *
 * @author CaseyLee
 */
public class Delete_ip_View extends JFrame {

    JLabel label_tips;
    JLabel label_ID;
    JTextField text_ID;
    JButton btn;

    public Delete_ip_View(){

        setBounds(10, 500, 250, 190);
        //设置窗体为空布局
        setLayout(null);

        label_tips = new JLabel("请输入要删除 ip 信息的姓名");
        label_ID = new JLabel("姓名：");
        text_ID = new JTextField();
        btn = new JButton("删除记录");

        label_tips.setBounds(40, 15, 200, 25);
        label_ID.setBounds(40, 60, 80, 25);
        text_ID.setBounds(90, 60, 100, 25);
        btn.setBounds(60, 110, 100, 25);

        add(label_tips);
        add(label_ID);
        add(text_ID);
        add(btn);

        setTitle("删除通讯ip");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src\\images\\删除.png");
        setIconImage(img);
        //pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);                  //让窗体居中显示

        btn.addActionListener((actionEvent -> {   //删除按钮

            Delete_ip_Controller delete_ip_controller = new Delete_ip_Controller();
            if(delete_ip_controller.delete(text_ID.getText())){
                setVisible(false);
            }

        }));
    }

}
