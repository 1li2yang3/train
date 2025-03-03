import java.sql.*;

public class Buy_ticket {

    
    public Buy_ticket(String day,String end,String end_time,String phone,String seat,String start,String start_time,String train_num) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="INSERT into ticket(day,end,end_time,phone,seat,start,start_time,train_num) values(?,?,?,?,?,?,?,?)";
        stat=com.createStatement();
        PreparedStatement ps = com.prepareStatement(sql);
        ps.setString(1,day);
        ps.setString(2,end);
        ps.setString(3,end_time);
        ps.setString(4,phone);
        ps.setString(5,seat);
        ps.setString(6,start);
        ps.setString(7,start_time);
        ps.setString(8,train_num);
        ps.executeUpdate();

        stat.close();
        com.close();
    }
}