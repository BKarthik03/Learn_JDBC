import java.sql.*;

public class GetValues {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query = "select * from table1;";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            PreparedStatement pt =  conn.prepareStatement(query);
            ResultSet rs = pt.executeQuery();
            while(rs.next()){
                System.out.print(rs.getInt(1)+"\t"+rs.getString(2));
                System.out.println();
            }
            rs.close();
            pt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
