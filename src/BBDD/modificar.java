package BBDD;

import utilidades.dbConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class modificar {
    private static Connection conn = dbConnection.getConnection();

    public static void updateTabla(String tabla, String columna, String valor, String id ){
        try {
            Statement st = conn.createStatement();
            st.executeUpdate("update "+tabla+" set"+columna+" = '"+valor+"' where id ='"+id+"' ");
            System.out.println("Se actualizó con éxito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
