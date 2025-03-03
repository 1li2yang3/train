import java.sql.*;

public class Add_seat {
    String num=" ";

    public Add_seat(String train_num,String start_time,String seat_kind,int cot) throws ClassNotFoundException, SQLException {
        Get_seat get_seat=new Get_seat(train_num,start_time,seat_kind);
        num=get_seat.num;
        //System.out.println(cot);
        num= String.valueOf(Integer.parseInt(num) + cot);
        //System.out.println(Integer.parseInt(num) + cot);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="update train set "+seat_kind+" = '"+num+"' where train_num='"+train_num+"' and start_time='"+start_time+"'";
        stat=com.createStatement();
        //System.out.println(sql);
        stat.executeUpdate(sql);


    }
}
