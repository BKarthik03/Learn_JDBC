import java.sql.*;

public class CallProcedure {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "CALL AddStudent(?,?);";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            CallableStatement ct =  conn.prepareCall(query);
            ct.setInt(1,5);
            ct.setString(2,"Five");
            ct.execute();
            System.out.println("Procedure executed successfully");
            ct.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getClass());
        }
    }
}
