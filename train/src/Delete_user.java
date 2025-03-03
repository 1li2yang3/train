import java.io.IOException;
import java.sql.*;

public class Delete_user {
    public Delete_user(String phone) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql = "delete from user where phone ='"+phone+"'";
        stat.executeUpdate(sql);
        Manage_user manage_user=new Manage_user();
    }
}
