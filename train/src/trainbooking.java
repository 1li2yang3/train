


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class trainbooking extends JFrame  {
    JTextField start=new JTextField(20);//设置输入用户名的文本框
    JTextField end=new JTextField(20);//设置输入密码的文本框
    JTextField day=new JTextField(20);//设置输入密码的文本框
    JTextField name=new JTextField();
    JLabel label1=new JLabel("起点:");
    JLabel label2=new JLabel("终点:");
    JLabel label3=new JLabel("日期:");
    JButton button=new JButton("确定");
    JPanel p1=new JPanel();
    JPanel p2=new JPanel();
    JPanel p3=new JPanel();
    JButton btn=new JButton("返回");
    Font font = new Font("微软雅黑", Font.BOLD, 40);

    public trainbooking(String phone) throws IOException {

        setDefaultCloseOperation(2);
        setLocationRelativeTo(null);
        setLayout(null);
        setSize(1000,700);
        setLocation(250,75);
        button.setBackground(Color.white);
        button.setBounds(400,450,120,50);
        getContentPane().add(button);
        button.addActionListener(e -> {
            dispose();

            try {
                Buy buy = new Buy(phone, start.getText(), end.getText(), day.getText());
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        label1.setFont(font);
        label2.setFont(font);
        label3.setFont(font);
        start.setPreferredSize(new Dimension (20,35));
        end.setPreferredSize(new Dimension (20,35));
        day.setPreferredSize(new Dimension (20,35));



        p1.setLayout(new FlowLayout());
        p2.setLayout(new FlowLayout());
        p3.setLayout(new FlowLayout());
        p1.add(label1);
        p1.add(start);
        p2.add(label2);
        p2.add(end);
        p3.add(label3);
        p3.add(day);
        p1.setBounds(150,100,600,100);
        p2.setBounds(150,200,600,100);
        p3.setBounds(150,300,600,100);
        p1.setOpaque(false);
        p2.setOpaque(false);
        p3.setOpaque(false);
        getContentPane().add(p1);
        getContentPane().add(p2);
        getContentPane().add(p3);

        btn=new JButton("返回");
        btn.setBounds(10,10,100,40);
        add(btn);
        btn.addActionListener(e -> {
            dispose();
            try {
                home_page home=new home_page(phone);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });



        Image img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        JLabel label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        add(label);

        setVisible(true);
    }

}