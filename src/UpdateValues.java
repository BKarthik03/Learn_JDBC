import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateValues {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "Update table1 set name = ? where id = ?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            PreparedStatement pt =  conn.prepareStatement(query);
            pt.setString(1,"Four");
            pt.setInt(2,4);
            System.out.println(pt.executeUpdate());
            pt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
