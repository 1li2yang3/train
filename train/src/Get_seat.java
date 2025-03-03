import java.sql.*;

public class Get_seat {
    String num="";

    public Get_seat(String train_num,String start_time,String seat_kind) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="select "+seat_kind+" from train where train_num='"+train_num+"' and start_time='"+start_time+"'";

        stat=com.createStatement();
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        num=rs.getString(seat_kind);

        stat.close();
        com.close();

    }
}
