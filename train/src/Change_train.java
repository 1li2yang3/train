import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Change_train {
    public Change_train(String train_num) throws ClassNotFoundException, SQLException, IOException {
        JFrame f1;

        Image img;
        JLabel label;
        JPanel p1;
        JTextField jt1;
        JTextField jt2;
        JTextField jt3;
        JTextField jt4;
        JTextField jt5;
        JTextField jt6;
        JTextField jt7;
        JTextField jt8;
        Font font;
        JButton btn1;
        JButton btn2;

        f1=new JFrame();
        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setLayout(null);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        font = new Font("微软雅黑", Font.BOLD, 25);
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("车次");
        label.setFont(font);
        jt1=new JTextField(20);
        jt1.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt1);
        p1.setBounds(50,100,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("起点");
        label.setFont(font);
        jt2=new JTextField(20);
        jt2.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt2);
        p1.setBounds(50,200,400,60);
        f1.add(p1);


        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("终点");
        label.setFont(font);
        jt3=new JTextField(20);
        jt3.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt3);
        p1.setBounds(50,300,400,60);
        f1.add(p1);

        btn2=new JButton("返回");
        btn2.setBounds(10,10,100,40);
        f1.add(btn2);
        btn2.addActionListener(e -> {
            try {
                f1.dispose();
                Edit_train edit_train=new Edit_train(train_num);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("出发时间");
        label.setFont(font);
        jt4=new JTextField(20);
        jt4.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt4);
        p1.setBounds(550,100,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("到达时间");
        label.setFont(font);
        jt5=new JTextField(20);
        jt5.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt5);
        p1.setBounds(550,200,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("日期");
        label.setFont(font);
        jt6=new JTextField(20);
        jt6.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt6);
        p1.setBounds(550,300,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("一等座价格");
        label.setFont(font);
        jt7=new JTextField(20);
        jt7.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt7);
        p1.setBounds(550,400,400,60);
        f1.add(p1);

        p1=new JPanel();
        p1.setLayout(new FlowLayout());
        label=new JLabel("二等座价格");
        label.setFont(font);
        jt8=new JTextField(20);
        jt8.setPreferredSize(new Dimension (20,35));
        p1.add(label);
        p1.add(jt8);
        p1.setBounds(50,400,400,60);
        f1.add(p1);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql = "SELECT * FROM train where train_num='"+train_num+"'";
        ResultSet rs = stat.executeQuery(sql);

        rs.next();
        jt1.setText(rs.getString("train_num"));
        jt2.setText(rs.getString("start"));
        jt3.setText(rs.getString("end"));
        jt4.setText(rs.getString("start_time"));
        jt5.setText(rs.getString("end_time"));
        jt6.setText(rs.getString("day"));
        jt7.setText(rs.getString("seat1_price"));
        jt8.setText(rs.getString("seat2_price"));

        com.close();
        stat.close();



        btn1=new JButton("提交");
        btn1.setBounds(430,500,100,40);
        f1.add(btn1);
        btn1.addActionListener(e -> {
            if(jt1.getText().isEmpty()||jt2.getText().isEmpty()||jt3.getText().isEmpty()||jt4.getText().isEmpty()||jt5.getText().isEmpty()||jt6.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "输入不能为空");
            }
            else{

                try {
                    Delete_train delete_train=new Delete_train(train_num);
                    Do_add_train do_add_train=new Do_add_train(jt1.getText(),jt2.getText(),jt3.getText(),jt4.getText(),jt5.getText(),jt6.getText(), jt7.getText(), jt8.getText());
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    throw new RuntimeException(ex);
                }


                try {
                    f1.dispose();
                    Manage_train manage_train=new Manage_train();
                } catch (ClassNotFoundException | SQLException | IOException ex) {
                    throw new RuntimeException(ex);
                }
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
