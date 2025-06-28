import java.sql.*;

public class AlterTable {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "Alter Table STable rename to table1;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
//            PreparedStatement pt =  conn.prepareStatement(query);
//            pt.execute();
            Statement st =  conn.createStatement();
            st.execute(query);
            st.close();
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
