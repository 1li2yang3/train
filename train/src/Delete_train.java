import java.io.IOException;
import java.sql.*;

public class Delete_train {
    public Delete_train(String train_num) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
        Statement stat = com.createStatement();
        String sql = "delete from train where train_num ='"+train_num+"'";
        stat.executeUpdate(sql);
        Manage_train manage_train=new Manage_train();
    }
}
