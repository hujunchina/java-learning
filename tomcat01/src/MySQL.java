import java.sql.*;

public class MySQL {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection cn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hujun");
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("select * from goods");
        while (rs.next()){
            System.out.println(rs.getString(2));
            System.out.println(rs.getDouble(3));
            System.out.println(rs.getString(7));
        }
        cn.close();
    }
}
