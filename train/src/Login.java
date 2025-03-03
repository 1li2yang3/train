import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Login{
    JFrame f1;
    JLabel label1;
    Font font;
    JPanel p1;
    JLabel label2;
    JTextField text;
    JPanel p2;
    JPanel p3;
    JLabel label3;
    int flag=0;

    JRadioButton rb1;
    JRadioButton rb2;

    ButtonGroup bg=new ButtonGroup();
    JPasswordField password;
    JButton button;
    Image img;
    JLabel label4;

    public Login() throws IOException {
        f1 = new JFrame("火车售票管理信息系统");

        f1.setLocation(250, 75);
        f1.setSize(1000, 700);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        label1 = new JLabel("火车售票管理信息系统");
        font = new Font("微软雅黑", Font.BOLD, 50);
        label1.setFont(font);
        label1.setBounds(250, 0, 600, 200);
        f1.add(label1);

        p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout());
        JLabel label2 = new JLabel("账号:");
        font = new Font("微软雅黑", Font.BOLD, 40);
        label2.setFont(font);
        p1.add(label2);


        text = new JTextField(20);
        text.setPreferredSize(new Dimension (20,35));
        p1.add(text);
        p1.setBounds(150, 250, 600, 100);
        p1.setBackground(null);
        f1.add(p1);

        p2 = new JPanel();
        p2.setOpaque(false);
        p2.setLayout(new FlowLayout());
        JLabel label3 = new JLabel("密码:");
        label3.setFont(font);
        p2.add(label3);


        password = new JPasswordField(20);

        password.setPreferredSize(new Dimension (20,35));
        p2.add(password);
        p2.setBounds(150, 320, 600, 100);
        f1.add(p2);

        rb1=new JRadioButton("用户");
        rb2=new JRadioButton("管理员");
        rb1.setOpaque(false);
        rb2.setOpaque(false);
        rb1.addActionListener(e -> {
            flag=1;
        });
        rb2.addActionListener(e ->{
            flag=2;
        });

        bg.add(rb1);
        bg.add(rb2);
        p3=new JPanel();
        p3.setLayout(new FlowLayout(1,50,20));
        p3.add(rb1);
        p3.add(rb2);
        p3.setBounds(150,400,600,100);
        p3.setOpaque(false);
        f1.add(p3);
        button = new JButton("登录");
        button.addActionListener(e -> {
            if(flag==1){
                clogin connectMysqlforlogin=new clogin(text.getText(),new String(password.getPassword()));
                if(connectMysqlforlogin.isIn){
                    f1.dispose();
                    try {
                        home_page hopa=new home_page(text.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    //trainbooking book=new trainbooking(text.getText());
                }
                else{
                    JOptionPane.showMessageDialog(null, "登录失败");
                }
            }
            else if(flag==2){
                Adminlogin adminlogin=new Adminlogin(text.getText(),new String(password.getPassword()));
                if(adminlogin.isin){
                    f1.dispose();
                    try {
                        Manage manage=new Manage();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "登录失败");
                }
            }
            else{

                JOptionPane.showMessageDialog(null, "未选择身份");
            }

        });
        button.setBounds(350, 500, 100, 40);
        f1.add(button);

        button = new JButton("注册");
        button.addActionListener(e -> {
            f1.setVisible(false);
            try {
                signin Signin=new signin();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        });
        button.setBounds(480, 500, 100, 40);
        f1.add(button);

        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label4 = new JLabel(new ImageIcon(img));

        label4.setBounds(0, 0, 1000, 700);

        f1.add(label4);
        //设置窗口对象可见
        f1.setVisible(true);
    }


}