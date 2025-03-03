import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Edit_train {
    public Edit_train(String train_num) throws IOException {
        JFrame f1;
        Image img;
        JLabel label;
        JButton btn1;
        JButton btn2;
        JButton btn3;
        Font font;

        f1=new JFrame();
        f1.setLayout(null);
        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);



        btn3=new JButton("返回");
        btn3.setBounds(10,10,100,40);
        f1.add(btn3);
        btn3.addActionListener(e -> {
            try {
                f1.dispose();
                Manage_train manage_train=new Manage_train();
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        btn1=new JButton("修改列车信息");
        btn1.setBounds(150,250,250,70);
        btn1.addActionListener(e -> {
            try {
                f1.dispose();
                Change_train change_train=new Change_train(train_num);
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        btn2=new JButton("删除列车信息");
        btn2.setBounds(550,250,250,70);
        btn2.addActionListener(e -> {
            try {
                Delete_train delete_train=new Delete_train(train_num);
            } catch (ClassNotFoundException | SQLException | IOException ex) {
                throw new RuntimeException(ex);
            }
            f1.dispose();
        });
        f1.add(btn1);
        f1.add(btn2);

        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);

        f1.setVisible(true);
    }
}
