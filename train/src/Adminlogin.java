import java.sql.*;

public class Adminlogin {
    boolean isin = false;
    public Adminlogin(String phone,String password){
        try {


            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection com = DriverManager.getConnection("jdbc:mysql://localhost:3306/aa", "root", "123456");
            Statement stat = com.createStatement();
            String sql = "SELECT * FROM admin where phone='" + phone + "' and password ='" + password + "'";
            ResultSet rs = stat.executeQuery(sql);
            if (rs.next()) {
                isin = true;
            }
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
