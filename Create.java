import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Create {
    public static void main(String[] args) {
        Connection myConn = null;
        PreparedStatement myStant = null;

        try {
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            String sql = ("INSERT INTO employees (first_name, last_name) VALUES (?, ?)");
            myStant = myConn.prepareStatement(sql);
            myStant.setString(1, "Maicol");
            myStant.setString(2, "Buritica");
            int rowsAffected = myStant.executeUpdate();
            if (rowsAffected > 0){
                System.out.println("Se ha creado un nuevo empleado");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
