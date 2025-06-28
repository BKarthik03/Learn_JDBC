import java.sql.*;

public class InsertValues {
    public static void main(String[] args) {
        String url = Credentials.url;
        String username = Credentials.username;
        String passwd = Credentials.passwd;
        String query1 = "Insert into table1 values(1,\"Name1\")," +
                "(2,\"Name2\"),(3,\"Name3\");";
        String query2 = "Insert into table1 values(?,?);";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        try {
            Connection conn = DriverManager.getConnection(url+"JDBC",username,passwd);
            PreparedStatement pt =  conn.prepareStatement(query2);
            pt.setInt(1,4);
            pt.setString(2,"Name4");
            System.out.println(pt.executeUpdate());
            pt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

}
