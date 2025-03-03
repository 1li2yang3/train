import java.net.IDN;
import java.sql.*;

public class Do_add_user {

    public Do_add_user(String phone,String password,String ID,String name,String sex)throws ClassNotFoundException, SQLException {
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql="INSERT into user(phone,password,ID,name,sex) values(?,?,?,?,?)";
        stat=com.createStatement();
        PreparedStatement ps = com.prepareStatement(sql);
        ps.setString(1,phone);
        ps.setString(2,password);
        ps.setString(3,ID);
        ps.setString(4,name);
        ps.setString(5,sex);

        ps.executeUpdate();
        com.close();
        stat.close();
    }
}