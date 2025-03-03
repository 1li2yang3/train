import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class home_page{
    JFrame f1;
    JButton btn1=new JButton("用户信息");
    JButton btn2=new JButton("车票查询");


    Image img;

    JButton btn4=new JButton("返回");
    JTextField usernamefield=new JTextField();
    JTextField passwordfeild=new JTextField();

    JLabel label=new JLabel();

    String phone;

    public home_page(String phone) throws IOException {
        f1=new JFrame();
        f1.setTitle("首页");

        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f1.setLayout(null);


        btn1.setBounds(150,250,250,70);
        f1.getContentPane().add(btn1);
        btn1.addActionListener(e -> {
            f1.dispose();
            try {
                user_information information =new user_information(phone);
            } catch (IOException | SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });


        btn2.setBounds(550,250,250,70);
        f1.getContentPane().add(btn2);
        btn2.addActionListener(e -> {
            f1.dispose();
            try {
                trainbooking booking=new trainbooking(phone);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });







        btn4.setBounds(10,10,100,40);
        f1.getContentPane().add(btn4);
        btn4.addActionListener(e ->{
            f1.dispose();
            try {
                Login login=new Login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });


        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);
        f1.setVisible(true);
    }


}