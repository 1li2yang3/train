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

public class Manage_train {
    public Manage_train() throws ClassNotFoundException, SQLException, IOException {

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
        String train_num;

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
        p1.setBorder(border);
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(0));
        p1.setBounds(20,100,950,400);
        p2=new JPanel();
        p2.setOpaque(false);
        p1.add(p2);
        //p2.setBorder(border);
        p2.setPreferredSize(new Dimension(940,40));
        p2.setLayout(new FlowLayout(0,15,0));
        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("车次");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p2.add(p3);
        label=new JLabel("起点");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p3.add(label);
        p2.add(p3);
        label=new JLabel("终点");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p3.add(label);
        p2.add(p3);
        label=new JLabel("出发时间");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);


        label=new JLabel("到达时间");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(130,30));
        p3.add(label);
        p2.add(p3);
        label=new JLabel("日期");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(110,30));
        p3.add(label);
        p2.add(p3);

        label=new JLabel("一等座价格");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p3.add(label);
        p2.add(p3);

        label=new JLabel("二等座价格");
        label.setFont(font);
        p3=new JPanel();
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p3.add(label);
        p2.add(p3);

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql = "SELECT * FROM train";
        ResultSet rs = stat.executeQuery(sql);
        while(rs.next()) {

            p2 = new JPanel();
            p2.setOpaque(false);
            //p2.setBorder(border);
            p2.setPreferredSize(new Dimension(940, 40));
            p2.setLayout(new FlowLayout(0, 15, 0));
            train_num=rs.getString("train_num");
            label = new JLabel(train_num);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("start"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("end"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("start_time"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("end_time"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(130, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("day"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(110, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("seat1_price"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("seat2_price"));
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);

            String finalTrain_num = train_num;
            m = new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {

                    try {
                        f1.dispose();
                        Edit_train edit_train=new Edit_train(finalTrain_num);
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


        btn1=new JButton("添加列车");
        btn1.setBounds(450,550,100,40);
        btn1.addActionListener(e -> {
            try {
                f1.dispose();
                Add_train add_train=new Add_train();
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
