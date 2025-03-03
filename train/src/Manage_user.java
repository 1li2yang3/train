import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;

public class Manage_user {
    public Manage_user() throws ClassNotFoundException, SQLException, IOException {

        Image img;
        JLabel label;
        JFrame f1;
        Border border;
        Font font;
        JTable table;
        JPanel p1;
        JPanel p2;
        JPanel p3;
        JButton btn1;
        JButton btn2;
        String phone;

        MouseListener m;


        f1=new JFrame();
        f1.setLayout(null);
        f1.setLocation(250,75);
        f1.setSize(1000,700);
        f1.setResizable(false);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        font = new Font("微软雅黑", Font.BOLD, 15);
        border = BorderFactory.createLineBorder(Color.BLACK, 7, true);

        btn2=new JButton("返回");
        btn2.setBounds(10,10,100,40);
        f1.add(btn2);
        btn2.addActionListener(e -> {
            f1.dispose();
            try {
                Manage manage=new Manage();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        p1=new JPanel();
        p1.setOpaque(false);
        p1.setBorder(border);
        p1.setLayout(new FlowLayout(0));
        p1.setBounds(20,100,950,400);
        p2=new JPanel();
        p2.setOpaque(false);
        p1.add(p2);
        //p2.setBorder(border);
        p2.setPreferredSize(new Dimension(940,40));
        p2.setLayout(new FlowLayout(0,50,0));
        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("电话号码");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p2.add(p3);
        label=new JLabel("密码");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);
        label=new JLabel("证件号");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);
        label=new JLabel("姓名");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);


        label=new JLabel("性别");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);



        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql = "SELECT * FROM user";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {

            p2 = new JPanel();
            p2.setOpaque(false);
            //p2.setBorder(border);
            p2.setPreferredSize(new Dimension(940, 40));
            p2.setLayout(new FlowLayout(0, 50, 0));
            phone=rs.getString("phone");
            label = new JLabel(phone);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);

            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("password"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("ID"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("name"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("sex"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);


            String finalPhone = phone;
            m = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                    try {
                        f1.dispose();
                        Edit_user edit_user=new Edit_user(finalPhone);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                }



            };

            p2.addMouseListener(m);
            p1.add(p2);


            //tableDate[row][0]=rs.getString("train_num");
            /// tableDate[row][1]=rs.getString("start");
            /// tableDate[row][2]=rs.getString("end");
            // tableDate[row][3]=rs.getString("start_time");
            ///  tableDate[row][4]=rs.getString("end_time");
            ///  row++;

        }
        com.close();
        stat.close();

        f1.add(p1);


        btn1=new JButton("添加用户");
        btn1.setBounds(450,550,100,40);
        btn1.addActionListener(e -> {
            try {
                f1.dispose();
                Add_user add_user=new Add_user();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        f1.add(btn1);

        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);
        f1.setVisible(true);
    }
}
