import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateProcedure {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "CREATE PROCEDURE AddStudent(IN studId INT, IN stuName VARCHAR(20)) " +
                "BEGIN " +
                "    INSERT INTO table1 VALUES (studId, stuName); " +
                "END ";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try{
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            Statement st = conn.createStatement();
            st.execute(query);
            System.out.println("Procedure Added Successfully;");
            st.close();
            conn.close();
        }catch (SQLException e) {
            if (e.getErrorCode() == 1304) {
                System.out.println("⚠️ Procedure already exists.");
            } else {
                System.out.println(e);
            }
        }
    }
}
