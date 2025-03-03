
import java.sql.*;

public class mysqlsignin {
    private String url="jdbc:mysql://localhost:3306/aa";
    private String user="root";
    private String psd="123456";

    Connection conn2 =null;
    PreparedStatement ps2 =null;
    ResultSet rs2 =null;
    Statement stmt=null;
    public int count=0;

    public mysqlsignin(String phone, String password,String name,String sex,String ID){
        try {
            //注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接数据库
            conn2 = DriverManager.getConnection(url,this.user,psd);
            //数据库预编译操作对象获取
            String sql1="INSERT into user(phone,password,name,sex,ID) values(?,?,?,?,?)";
            String sql2="select * from user where phone='"+phone+"'";
            stmt=conn2.createStatement();
            rs2=stmt.executeQuery(sql2);
            if(!rs2.next()){
                ps2 = conn2.prepareStatement(sql1);
                ps2.setString(1,phone);
                ps2.setString(2,password);
                ps2.setString(3,name);
                ps2.setString(4,sex);
                ps2.setString(5,ID);
                count=ps2.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(rs2 !=null){
                try {
                    rs2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps2 !=null){
                try {
                    ps2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn2 !=null){
                try {
                    conn2.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}