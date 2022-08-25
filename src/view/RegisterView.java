package view;

import controller.InsertController;
import model.Register;

import javax.swing.*;
import java.awt.*;

/**
 * Created on 2021/12/23 - 21:22.
 *
 * @author CaseyLee
 */

public class RegisterView {

    JFrame fr;
    JButton a;//, b;
    JLabel label1, label2, label3;
    JTextField textField1, textField2, textField3;
    JCheckBox check1, check2;

    RegisterView() {

        fr = new JFrame();
        fr.setBounds(10, 500, 230, 300);
        //设置窗体为空布局
        fr.setLayout(null);

        label1 = new JLabel("请注册后登入系统~");

        a = new JButton("注册");

        fr.add(label1);
        label1.setBounds(50, 15, 200, 25);

        fr.getContentPane().add(a);
        a.setBounds(60, 200, 100, 25);

        label1 = new JLabel("账号：");
        label1.setBounds(40, 60, 80, 25);
        fr.add(label1);
        textField1 = new JTextField(12);
        textField1.setBounds(90, 60, 80, 25);
        fr.add(textField1);

        label2 = new JLabel("姓名：");
        label2.setBounds(40, 100, 80, 25);
        fr.add(label2);
        textField2 = new JTextField(12);
        textField2.setBounds(90, 100, 80, 25);
        fr.add(textField2);

        label3 = new JLabel("密码：");
        label3.setBounds(40, 140, 80, 25);
        fr.add(label3);
        textField3 = new JTextField(12);
        textField3.setBounds(90, 140, 80, 25);
        fr.add(textField3);

        /*
            使用addActionListener(ActionListener l)方法为jButton（按钮）添加监听事件
            实现addActionListener里的参数接口ActionListener，重写ActionListener接口的actionPerformed方法
            如果发生了点击事件，系统将会回调actionPerformed方法
             */
        a.addActionListener((actionEvent -> {
            String s1 = textField1.getText();
            String s2 = textField2.getText();
            String s3 = textField3.getText();

            Register register = new Register(s1, s2, s3);

            InsertController iu = new InsertController();
            if(iu.writeRegisterModel(register)){
                fr.setVisible(false);
            }

            System.out.println("用户" + s1 + "注册中……");
        }));

        fr.setTitle("注册页面");
        Toolkit tk = Toolkit.getDefaultToolkit();
        java.awt.Image img = tk.getImage("src\\images\\注册.png");
        fr.setIconImage(img);
        fr.setVisible(true);
        fr.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fr.setLocationRelativeTo(null);                  //让窗体居中显示

    }

}