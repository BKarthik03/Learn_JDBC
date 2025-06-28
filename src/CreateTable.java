import java.sql.*;
public class CreateTable {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "Create Table table1(" +
                "Id int primary key," +
                "Name varchar(20));";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            Statement st = conn.createStatement();
            st.execute(query);
            System.out.println("Table Created Successfully");
            st.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
