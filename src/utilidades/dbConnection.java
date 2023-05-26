package utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    //clase que realiza la conexion a base de datos

    private static final String url = "jdbc:sqlserver://localhost:1433;TrustServerCertificate=True;";
    private static final String username = "sa";
    private static final String passwd = "12345Ab##";

    private static Connection connection;

    public static Connection getConnection() {
        if(connection == null){
            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connection = DriverManager.getConnection(url, username, passwd);
                System.out.println("Conexion establecida");
            }catch (SQLException e){
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection(){
        if (connection != null){
            try {
                connection.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
