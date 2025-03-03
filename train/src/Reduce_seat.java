import java.sql.*;

public class Reduce_seat {
    String num=" ";

    public Reduce_seat(String train_num,String start_time,String seat_kind) throws ClassNotFoundException, SQLException {
        Get_seat get_seat=new Get_seat(train_num,start_time,seat_kind);
        num=get_seat.num;
        num= String.valueOf(Integer.parseInt(num) - 1);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="update train set "+seat_kind+" = '"+num+"' where train_num='"+train_num+"' and start_time='"+start_time+"'";
        stat=com.createStatement();
        stat.executeUpdate(sql);
        System.out.println(sql);

    }
}