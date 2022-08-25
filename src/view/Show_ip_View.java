package view;

import controller.Show_ip_Controller;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created on 2021/12/24 - 8:42.
 *
 * @author CaseyLee
 */

public class Show_ip_View extends JFrame{

    JButton buttonA, buttonB, buttonC, buttonD, button_chat, button_refresh;
    JLabel label1;
    Show_ip_Controller show_ip_controller;
    String[] tableHead;
    String[][] content;
    JTable table;
    DefaultTableModel tableModel;

    public Show_ip_View(){

        setBounds(10, 50, 400, 230);
        //设置窗体为空布局
        setLayout(new FlowLayout());

        label1 = new JLabel("                              客官你好，等待你许久了~                          ");

        buttonA = new JButton("返回");
        buttonB = new JButton("增加");
        buttonC = new JButton("删除");
        buttonD = new JButton("修改");
        button_chat = new JButton("通讯");
        button_refresh = new JButton("升/降序");

        add(label1);

//        add(buttonA);
        add(buttonB);
        add(buttonC);
        add(buttonD);
        add(button_refresh);
        add(button_chat);


        show_ip_controller = new Show_ip_Controller();
        content = show_ip_controller.getRecord(0);
        tableHead = show_ip_controller.getColumnName();
        tableModel = new DefaultTableModel(content, tableHead);
        table = new JTable(tableModel);

//        TableColumn column = table.getColumnModel().getColumn(0);
//        column.setPreferredWidth(40);
//        column.setMaxWidth(40);
//        column.setMinWidth(40);

        AtomicReference<JScrollPane> jScrollPane = new AtomicReference<>(new JScrollPane(table,
                ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS));
        jScrollPane.get().setPreferredSize(new Dimension(380, 130));

        add(jScrollPane.get());

        setTitle("查看页面");
        Toolkit tk = Toolkit.getDefaultToolkit();
        Image img = tk.getImage("src\\images\\查看.png");
        setIconImage(img);
        //pack();
        setBounds(10, 50, 400, 230);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);                  //让窗体居中显示

        buttonA.addActionListener((actionEvent -> {   //返回按钮
            setVisible(false);
        }));

        buttonB.addActionListener((actionEvent-> {      //增加
            Add_ip_View add_ip_view = new Add_ip_View();
        }));

        buttonC.addActionListener((actionEvent-> {      //删除
            Delete_ip_View delete_ip_view = new Delete_ip_View();
        }));

        button_chat.addActionListener((actionEvent-> {    //通讯
            Communication_ip_View communication_ip_view = new Communication_ip_View();
        }));

        buttonD.addActionListener((actionEvent-> {      //修改
            Modify_ip_View modify_ip_view = new Modify_ip_View();
        }));

        button_refresh.addActionListener((actionEvent-> {      //升/降序

            show_ip_controller = new Show_ip_Controller();
            content = show_ip_controller.getRecord(1);
            tableHead = show_ip_controller.getColumnName();
            tableModel.getDataVector().clear();
            tableModel.setDataVector(content, tableHead);

            jScrollPane.get().validate();

        }));

    }

}
