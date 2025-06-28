import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteValues {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "Delete from table1 where id = ?;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            PreparedStatement pt =  conn.prepareStatement(query);
            pt.setInt(1,4);
            System.out.println(pt.executeUpdate());
            pt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
