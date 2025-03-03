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
import java.util.Objects;

public class user_information {
    String Phone;

    JFrame f1;

    JButton btn = new JButton("返回");
    JLabel label;

    JLabel label1 = new JLabel("用户名:");
    JLabel label2 = new JLabel("姓名:");
    JLabel label3 = new JLabel("性别:");
    JLabel label4 = new JLabel("身份证号:");

    JTextField jt1;
    JTextField jt2;

    JTextField jt3;
    JTextField jt4;

    JTextField jt5;
    Image img;

    JPanel p1;
    JPanel p2;
    JPanel p3;
    private String url = "jdbc:mysql://localhost:3306/aa";
    private String user = "root";
    private String psd = "123456";

    Connection conn2 = null;

    PreparedStatement ps2 = null;
    Font font;

    JButton btn1;

    Border border;

    MouseListener m;
    ResultSet rs2 = null;
    Statement stmt = null;
    public int count = 0;

    String phone;
    String train_num;
    String day;
    String start;
    String end;
    int n=0;
    String start_time;
    String end_time;
    String seat;

    public user_information(String phone) throws IOException, ClassNotFoundException, SQLException {

        f1 = new JFrame();
        f1.setLocation(250,75);
        f1.setTitle("用户信息");
        f1.setSize(1000, 700);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f1.setLayout(null);
        f1.setResizable(false);

        font = new Font("微软雅黑", Font.BOLD, 20);


        btn.setBounds(10, 10, 100, 40);
        f1.add(btn);
        btn.addActionListener(e -> {
            try {
                f1.dispose();
                home_page home = new home_page(phone);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });




        Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动
        conn2 = DriverManager.getConnection(url, this.user, psd);//连接数据库

        String sql = "select * from user where phone='" + phone + "'";
        stmt = conn2.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        rs.next();
        String ph = rs.getString("phone");
        String name = rs.getString("name");
        String sex = rs.getString("sex");
        String ID = rs.getString("ID");


        JTextField ph_field = new JTextField(20);
        ph_field.setPreferredSize(new Dimension (20,35));
        ph_field.setText(ph);
        p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(2));
        label1.setFont(font);
        p1.add(label1);
        p1.setBounds(20, 100, 300, 80);
        p1.add(ph_field);

        f1.add(p1);

        JTextField name_field = new JTextField(20);
        name_field.setText(name);
        name_field.setPreferredSize(new Dimension (20,35));
        p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(2));
        p1.setBounds(20, 200, 300, 80);
        label2.setFont(font);
        p1.add(label2);
        p1.add(name_field);

        f1.add(p1);

        JTextField sex_field = new JTextField(20);
        sex_field.setPreferredSize(new Dimension (20,35));
        sex_field.setText(sex);
        p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(2));
        label3.setFont(font);
        p1.add(label3);
        p1.add(sex_field);
        p1.setBounds(20, 300, 300, 80);
        f1.add(p1);

        JTextField ID_field = new JTextField(20);
        ID_field.setPreferredSize(new Dimension (20,35));
        ID_field.setText(ID);
        p1 = new JPanel();
        p1.setOpaque(false);
        p1.setLayout(new FlowLayout(2));
        label4.setFont(font);
        p1.add(label4);
        p1.add(ID_field);
        p1.setBounds(20, 400, 300, 80);
        f1.add(p1);


        conn2.close();
        stmt.close();



        border = BorderFactory.createLineBorder(Color.BLACK, 7, true);


        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        sql = "SELECT * FROM ticket where phone='"+phone+"'";
        rs = stat.executeQuery(sql);



        p1=new JPanel();
        //p1.setBackground(Color.white);
        p1.setBorder(border);
        p1.setOpaque(false);
        p1.setBounds(350,100,600,500);
        f1.add(p1);
        p1.setLayout(new FlowLayout(0,0,0));
        p2=new JPanel();
        p2.setOpaque(false);
        p2.setLayout(new FlowLayout(0,0,2));
        //p2.setBorder(border);
        p2.setPreferredSize(new Dimension(500,40));
        p2.setLayout(new FlowLayout(0,15,0));

        p3=new JPanel();
        label=new JLabel("车次");
        label.setFont(font);
        p3.add(label);
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(60,30));
        p2.add(p3);

        p3=new JPanel();
        label=new JLabel("起点");
        label.setFont(font);
        p3.add(label);
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p2.add(p3);

        p3=new JPanel();
        label=new JLabel("终点");
        label.setFont(font);
        p3.add(label);
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(80,30));
        p2.add(p3);

        p3=new JPanel();
        label=new JLabel("出发时间");
        label.setFont(font);
        p3.add(label);
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(110,30));
        p2.add(p3);

        p3=new JPanel();
        label=new JLabel("座位");
        label.setFont(font);
        p3.add(label);
        p3.setOpaque(false);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(60,30));
        p2.add(p3);
        p1.add(p2);

        while(rs.next()) {

            p2 = new JPanel();
            p2.setOpaque(false);
            //p2.setBorder(border);
            p2.setPreferredSize(new Dimension(940, 40));
            p2.setLayout(new FlowLayout(0, 15, 0));
            train_num = rs.getString("train_num");
            label = new JLabel(train_num);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(60, 30));
            p3.add(label);
            p2.add(p3);


            start = rs.getString("start");
            label = new JLabel(start);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);


            end = rs.getString("end");
            label = new JLabel(end);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(80, 30));
            p3.add(label);
            p2.add(p3);


            start_time = rs.getString("start_time");
            label = new JLabel(start_time);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(110, 30));
            p3.add(label);
            p2.add(p3);




            seat = rs.getString("seat");
            label = new JLabel(seat);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(60, 30));
            p3.add(label);
            p2.add(p3);

            day=rs.getString("day");
            end_time=rs.getString("end_time");

            btn1=new JButton("退票");
            btn1.setPreferredSize(new Dimension(60,25));
            btn1.addActionListener(e -> {
                int userOption =  JOptionPane.showConfirmDialog(null,"确定要退掉这张票吗","确认",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);

                if (userOption == JOptionPane.OK_OPTION) {
                    try {

                        Return_ticket return_ticket=new Return_ticket(day,end,end_time,phone,seat,start,start_time,train_num);
                        if(Objects.equals(seat, "A")){


                            Add_seat add_seat=new Add_seat(train_num,start_time,"seat1", return_ticket.n);

                        }
                        else{
                            Add_seat add_seat=new Add_seat(train_num,start_time,"seat2", return_ticket.n);
                        }
                        f1.dispose();
                        user_information in=new user_information(phone);

                    } catch (ClassNotFoundException | SQLException | IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    JOptionPane.showMessageDialog(null,"退票成功","提示",JOptionPane.PLAIN_MESSAGE);

                }else {}
            });
            p2.add(btn1);

            p1.add(p2);
        }







        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);

        f1.setVisible(true);
    }
}
