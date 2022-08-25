package view;

/**
 * Created on 2021/12/23 - 16:32.
 *
 * @author CaseyLee
 */

import controller.SearchController;
import controller.Show_ip_Controller;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2021/12/23 - 13:43.
 *
 * @author CaseyLee
 */
//public class Login {}

public class LoginView {

    JFrame fr;
    JButton a, b;
    JLabel label1, label2, label3;
    JTextField textField1, textField2;
    JCheckBox check1, check2;

    public LoginView() {

        fr = new JFrame();
        fr.setBounds(10, 50, 400, 230);
        //设置窗体为空布局
        fr.setLayout(null);

        label1 = new JLabel("你终于来啦！！kiwi页面欢迎你~");
        label1.setFont(new Font(null, Font.BOLD, 15));

        a = new JButton("登录");
        b = new JButton("注册");

        fr.add(label1);
        label1.setBounds(80, 15, 400, 25);

        fr.getContentPane().add(a);
        a.setBounds(100, 130, 80, 25);
        fr.getContentPane().add(b);
        b.setBounds(240, 130, 80, 25);

        label2 = new JLabel("账号：");
//        label2.setFont(Font.getFont("SIZE_LARGE"));
        label2.setBounds(60, 60, 80, 25);
        fr.add(label2);
        textField1 = new JTextField(12);
        textField1.setBounds(100, 60, 80, 25);
        fr.add(textField1);

        label3 = new JLabel("密码：");
        label3.setBounds(200, 60, 80, 25);
        fr.add(label3);
        textField2 = new JTextField(12);
        textField2.setBounds(240, 60, 80, 25);
        fr.add(textField2);

        /*
            使用addActionListener(ActionListener l)方法为jButton（按钮）添加监听事件
            实现addActionListener里的参数接口ActionListener，重写ActionListener接口的actionPerformed方法
            如果发生了点击事件，系统将会回调actionPerformed方法
             */
        a.addActionListener((actionEvent -> {   //登录按钮
            String ID = textField1.getText();
            String psw = textField2.getText();

            SearchController su = new SearchController();
            if(su.IsUserID_Exist_n_password_verified(ID, psw)){

                //查询页面
                Show_ip_Controller show_ip_controller = new Show_ip_Controller();
                Show_ip_View show_ip_view = new Show_ip_View();

            }

            System.out.println("用户" + ID + "登录中……");

        }));

        b.addActionListener(( actionEvent-> {   //注册按钮

            RegisterView RV = new RegisterView();

        }));

        check1 = new JCheckBox("自动登录");
        check2 = new JCheckBox("记住密码");
        check1.setBounds(100, 100, 80, 25);
        fr.add(check1);
        check2.setBounds(240, 100, 80, 25);
        fr.add(check2);

        fr.setTitle("登录页面");
        Toolkit tk = Toolkit.getDefaultToolkit();
        java.awt.Image img = tk.getImage("src\\images\\登录.png");
        fr.setIconImage(img);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);                  //让窗体居中显示

    }

}