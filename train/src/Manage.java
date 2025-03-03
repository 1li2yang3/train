import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Manage {
    public  Manage() throws IOException {
        JFrame f1;
        Image img;
        JLabel label;
        JButton btn1;
        JButton btn2;
        Font font;
        JButton btn3;

        f1=new JFrame();
        f1.setLayout(null);
        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        label=new JLabel("你好，管理员");
        font = new Font("微软雅黑", Font.BOLD, 40);
        label.setFont(font);
        label.setBounds(370,20,400,100);
        f1.add(label);
        btn3=new JButton("返回");
        btn3.setBounds(10,10,100,40);
        btn3.addActionListener(e -> {
            f1.dispose();
            try {
                Login login=new Login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        f1.add(btn3);

        btn1=new JButton("车次管理");
        btn1.setBounds(150,250,250,70);
        btn1.addActionListener(e -> {
            f1.dispose();
            try {
                Manage_train manage_train=new Manage_train();
            } catch (ClassNotFoundException | IOException | SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
        f1.add(btn1);

        btn2=new JButton("用户管理");
        btn2.setBounds(550,250,250,70);
        btn2.addActionListener(e -> {
            try {
                f1.dispose();
                Manage_user manage_user=new Manage_user();
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }

        });


        f1.add(btn2);

        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);

        f1.setVisible(true);
    }
}
