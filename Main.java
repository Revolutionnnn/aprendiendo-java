import java.sql.*;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        Connection myConn = null;
        Statement myStant = null;
        ResultSet myRest = null;
        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            myStant = myConn.createStatement();
            myRest = myStant.executeQuery("SELECT * FROM employees");
            while(myRest.next()){
                System.out.println(myRest.getString("first_name"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}