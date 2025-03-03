import java.sql.*;

public class Do_add_train {

    public Do_add_train(String train_num,String start,String end,String start_time,String end_time,String day,String seat1_price,String seat2_price)throws ClassNotFoundException, SQLException {
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="INSERT into train(train_num,start,end,start_time,end_time,seat1,seat2,day,seat1_price,seat2_price) values(?,?,?,?,?,?,?,?,?,?)";
        stat=com.createStatement();
        PreparedStatement ps = com.prepareStatement(sql);
        ps.setString(1,train_num);
        ps.setString(2,start);
        ps.setString(3,end);
        ps.setString(4,start_time);
        ps.setString(5,end_time);
        ps.setString(6,"20");
        ps.setString(7,"10");
        ps.setString(8,day);
        ps.setString(9,seat1_price);
        ps.setString(10,seat2_price);
        ps.executeUpdate();
        com.close();
        stat.close();
    }
}