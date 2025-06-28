import java.sql.*;
public class CreateDB {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "Create DataBase JDBC;";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url,username,passwd);
            Statement st = conn.createStatement();
            st.execute(query);
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
