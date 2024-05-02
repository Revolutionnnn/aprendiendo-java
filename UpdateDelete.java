import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UpdateDelete {
        public static void main(String[] args) {
        Connection myConn = null;
        Statement myStant = null;
        ResultSet myRest = null;

        try {
            // Conexion con base de datos
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            // Setencia para actualizar
            String sql = "UPDATE employees SET email='maicol@gmail.com' WHERE first_name='Maicol'";
            //En caso que quisiera eliminar solo cambiar la consulta
            // String sql = "DELETE FROM employees WHERE first_name='Maicol'";
            // Crea el estado para ejecutar las consultas
            myStant = myConn.createStatement();
            // Ejecuta la sentencia para actualiazar
            int rowsAffected = myStant.executeUpdate(sql);
            // Ejecuta consulta para buscar todos los empleados ordenados por su last_name
            myRest = myStant.executeQuery("SELECT * FROM employees order by last_name");

            while(myRest.next()){
                System.out.println(myRest.getString("first_name") + "," + myRest.getString("email"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
