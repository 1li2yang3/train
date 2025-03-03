

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
import java.util.concurrent.atomic.AtomicReference;

public class Buy {
    JFrame f1;
    JButton button;
    Image img;

    MouseListener m;

    JPanel p1;
    JPanel p2;
    JPanel p3;
    Border border;
    Font font;

    JLabel label;
    JButton btn1;
    JButton btn2;
    public  Buy(String phone,String start,String end,String day) throws Exception {
        f1=new JFrame("购票");
        f1.setLocation(250, 75);
        f1.setSize(1000, 700);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f1.setVisible(true);
        f1.setResizable(false);

        button=new JButton("返回");
        button.setBounds(10,10,100,40);
        button.addActionListener(e -> {
            f1.dispose();
            try {
                trainbooking trainbooking=new trainbooking(phone);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        f1.add(button);


        p1=new JPanel();
        p1.setOpaque(false);


        border = BorderFactory.createLineBorder(Color.BLACK, 7, true);

        //p1.setBorder(border);

        p1.setLayout(new FlowLayout());
        p1.setBounds(20,100,950,500);
        font = new Font("微软雅黑", Font.BOLD, 15);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql= "SELECT * FROM train where start='" + start + "'and end='" + end + "'and day='" + day + "'";

        ResultSet rs = stat.executeQuery(sql);

        p2=new JPanel();
        p2.setOpaque(false);
        p2.setPreferredSize(new Dimension(950,40));
        p2.setLayout(new FlowLayout(0,15,0));
        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("车次");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(60,30));
        p2.add(p3);

        p3=new JPanel();
        label=new JLabel("出发时间");
        p3.setOpaque(false);
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(100,30));
        p2.add(p3);

        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("到达时间");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(100,30));
        p2.add(p3);

        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("一等座剩余");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(90,30));
        p2.add(p3);

        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("一等座价格");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(90,30));
        p2.add(p3);

        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("二等座剩余");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(90,30));
        p2.add(p3);

        p3=new JPanel();
        p3.setOpaque(false);
        label=new JLabel("二等座价格");
        label.setFont(font);
        p3.add(label);
        //p3.setBorder(border);
        p3.setPreferredSize(new Dimension(90,30));
        p2.add(p3);
        p1.add(p2);

        String train_num;
        String start_time;
        String seat1 = "";
        String seat2 = "";
        String zero="0";
        String end_time;
        while (rs.next()){

            p2 = new JPanel();
            p2.setOpaque(false);
            //p2.setBorder(border);
            p2.setPreferredSize(new Dimension(950, 40));
            p2.setLayout(new FlowLayout(0, 15, 0));
            train_num=rs.getString("train_num");
            label = new JLabel(train_num);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(60, 30));
            p3.add(label);
            p2.add(p3);

            start_time=rs.getString("start_time");
            label = new JLabel(start_time);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(100, 30));
            p3.add(label);
            p2.add(p3);

            end_time=rs.getString("end_time");
            label = new JLabel(end_time);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(100, 30));
            p3.add(label);
            p2.add(p3);


            seat1=rs.getString("seat1");
            label = new JLabel(seat1);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(90, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("seat1_price")+"￥");
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(90, 30));
            p3.add(label);
            p2.add(p3);

            seat2=rs.getString("seat2");
            label = new JLabel(seat2);
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(90, 30));
            p3.add(label);
            p2.add(p3);

            label = new JLabel(rs.getString("seat2_price")+"￥");
            label.setFont(font);
            p3 = new JPanel();
            p3.setOpaque(false);
            //p3.setBorder(border);
            p3.setPreferredSize(new Dimension(90, 30));
            p3.add(label);
            p2.add(p3);

            JButton btn1=new JButton("购买一等座");
            String finalTrain_num = train_num;
            String finalStart_time = start_time;
            String finalEnd_time = end_time;
            String finalTrain_num1 = train_num;
            String finalStart_time1 = start_time;
            String finalSeat = seat1;
            btn1.addActionListener(e -> {

                int userOption =  JOptionPane.showConfirmDialog(null,"确定要买这张票吗","确认",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);

                if (userOption == JOptionPane.OK_OPTION) {
                    if(finalSeat.equals("0")){
                        JOptionPane.showMessageDialog(null, "一等座已售完");
                    }
                    else {
                        try {
                            Buy_ticket buy_ticket = new Buy_ticket(day, end, finalEnd_time, phone, "A", start, finalStart_time, finalTrain_num);
                            Reduce_seat reduce_seat=new Reduce_seat(finalTrain_num1, finalStart_time1,"seat1");
                            f1.dispose();
                            Buy buy=new Buy(phone,start,end,day);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }

                        JOptionPane.showMessageDialog(null,"购票成功","提示",JOptionPane.PLAIN_MESSAGE);
                    }

                }else {}

            });
            p2.add(btn1);
            JButton btn2=new JButton("购买二等座");
            String finalTrain_num2 = train_num;
            String finalStart_time2 = start_time;
            String finalSeat1 = seat2;
            btn2.addActionListener(e -> {
                int userOption =  JOptionPane.showConfirmDialog(null,"确定要买这张票吗","确认",JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);

                if (userOption == JOptionPane.OK_OPTION) {
                    if(finalSeat1.equals("0")){
                        JOptionPane.showMessageDialog(null, "二等座已售完");
                    }
                    else {
                        try {

                            Buy_ticket buy_ticket = new Buy_ticket(day, end, finalEnd_time, phone, "B", start, finalStart_time, finalTrain_num);
                            Reduce_seat reduce_seat=new Reduce_seat(finalTrain_num2, finalStart_time2,"seat2");
                            f1.dispose();
                            Buy buy=new Buy(phone,start,end,day);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        JOptionPane.showMessageDialog(null,"购票成功","提示",JOptionPane.PLAIN_MESSAGE);
                    }

                }else {}
            });
            p2.add(btn2);






            p2.addMouseListener(m);
            p1.add(p2);
        }

        f1.add(p1);
        com.close();
        stat.close();

        img = ImageIO.read(new File("./img/img1.jpg"));

        img = img.getScaledInstance(1000, 700, Image.SCALE_SMOOTH);


        label = new JLabel(new ImageIcon(img));

        label.setBounds(0, 0, 1000, 700);

        f1.add(label);

    }

}
