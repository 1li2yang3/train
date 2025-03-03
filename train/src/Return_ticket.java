import java.sql.*;

public class Return_ticket {

    int n=0;
    public Return_ticket(String day,String end,String end_time,String phone,String seat,String start,String start_time,String train_num) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="delete from ticket where day='"+day+"' and "+"end='"+end+"' and "+"end_time='"+end_time+"' and "+"phone='"+phone+"' and "+"seat='"+seat+"' and "+"start='"+start+"' and "+"start_time='"+start_time+"' and "+"train_num='"+train_num+"'";
        stat=com.createStatement();
        n=stat.executeUpdate(sql);
        System.out.println(n);
        stat.close();
        com.close();
    }
}