


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

public class signin extends JFrame implements MouseListener {
    JTextField phonefield=new JTextField(20);//设置输入用户名的文本框
    JTextField passwordfield=new JTextField(20);//设置输入密码的文本框
    JTextField passwordfieldAgain=new JTextField(20);//再次输入密码


    JButton btn1=new JButton("返回");

    Image img;
    JLabel label;
    JTextField namefield=new JTextField(20);
    JTextField sexfield=new JTextField(20);
    JTextField idfield=new JTextField(20);
    JLabel label1=new JLabel("手机号:");
    JLabel label2=new JLabel("密码:");
    JLabel label2again=new JLabel("再次确认密码:");
    JLabel label3=new JLabel("姓名:");
    JLabel label4=new JLabel("性别:");
    JLabel label5=new JLabel("身份证号:");
    JButton btn=new JButton("确定");

    Font font;

    JPanel p;

    public signin() throws IOException {//之前输入的是400
        setLocation(250,75);
        setSize(1000,700);
        setTitle("用户注册");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        int height=800;
        int width=800;
        font = new Font("微软雅黑", Font.BOLD, 25);



        btn1.setBounds(10,10,100,40);
        getContentPane().add(btn1);
        btn1.addMouseListener(this);

        btn.setBounds(450,500,100,40);
        getContentPane().add(btn);
        btn.addMouseListener(this);

        //添加用户名、密码
        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label1.setFont(font);
        p.add(label1);
        phonefield.setPreferredSize(new Dimension (20,35));
        p.add(phonefield);
        p.setBounds(50,100,400,60);
        getContentPane().add(p);

        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label2.setFont(font);
        p.add(label2);
        passwordfield.setPreferredSize(new Dimension (20,35));
        p.add(passwordfield);
        p.setBounds(50,200,400,60);
        getContentPane().add(p);

        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label2again.setFont(font);
        p.add(label2again);
        p.add(passwordfieldAgain);
        passwordfieldAgain.setPreferredSize(new Dimension (20,35));
        p.setBounds(50,300,400,60);
        getContentPane().add(p);

        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label3.setFont(font);
        p.add(label3);
        p.add(namefield);
        namefield.setPreferredSize(new Dimension (20,35));
        p.setBounds(550,100,400,60);
        getContentPane().add(p);

        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label4.setFont(font);
        p.add(label4);
        p.add(sexfield);
        getContentPane().add(p);

        p=new JPanel();
        p.setLayout(new FlowLayout(0));
        label5.setFont(font);
        p.add(label5);
        p.add(idfield);
        idfield.setPreferredSize(new Dimension (20,35));
        p.setBounds(550,200,400,60);
        getContentPane().add(p);


        



        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        add(label);
        setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj=e.getSource();

        if(obj==btn1){
            dispose();
            try {
                Login ui=new Login();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        if(obj==btn) {
            if(phonefield.getText().length()!=11) {
                JOptionPane.showMessageDialog(null, "手机号码必须为11位");
            }
            else if(!passwordfield.getText().equals(passwordfieldAgain.getText())){
                JOptionPane.showMessageDialog(null, "密码必须一致");
            }
            else if(!sexfield.getText().trim().equals("男")&&!sexfield.getText().trim().equals("女")) {
                JOptionPane.showMessageDialog(null, "性别必须为男或女");
            }
            else if(phonefield.getText().trim().isEmpty() || passwordfield.getText().trim().isEmpty() || namefield.getText().trim().isEmpty() || sexfield.getText().trim().isEmpty() || idfield.getText().trim().isEmpty()){
                JOptionPane.showMessageDialog(null, "注册信息不能为空");
            }
            else {
                mysqlsignin judge = new mysqlsignin(phonefield.getText(), passwordfield.getText(), namefield.getText(), sexfield.getText(), idfield.getText());
                //csign judge=new csign(phonefield.getText(), passwordfield.getText());
                if (judge.count == 1) {
                    JOptionPane.showMessageDialog(null,"注册成功","提示",JOptionPane.PLAIN_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "该账号已存在");
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}