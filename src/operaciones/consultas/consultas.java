package operaciones.consultas;

import utilidades.dbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class consultas {

    static Connection conn = dbConnection.getConnection();

    public static void consultarPorCampo(String tabla, String campo, String valor){//se puede aprovechar para consultarlo por lo que quieras
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{

            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("select * from "+tabla+" where "+campo+" = '"+valor+"'");
            while(rs.next()){
                int idC= rs.getInt("id");
                String nombre= rs.getString("nombre");
                String apellidos= rs.getString("apellidos");
                LocalDate fecha= rs.getDate("fechaNacimiento").toLocalDate();
                String formatfecha=fecha.format(dateTimeFormatter);
                String numTelf= rs.getString("numeroTelef");
                String genero= rs.getString("genero");
                String dni1=rs.getString("dni");
                System.out.println(idC+" "+nombre+" "+apellidos+" "+formatfecha+" "+numTelf+" "+genero+" "+dni1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean comprobarSiCampoExiste(String tabla, String campo, String valor) {
        try {
            //Revisa que el dato que se le ha introducido existe en el campo de una tabla determinada
            boolean ret= false;
            Statement st = conn.createStatement();
            if (st.executeQuery("SELECT 1 FROM " + tabla + " WHERE " + campo + "='" + valor + "'").next()) {
                st.close();
                ret=true;
            }
            st.close();
            return ret;
        } catch (SQLException sqle) {
            System.err.println("SQLException found while trying to validate field content existance");
            sqle.printStackTrace();
            return false;
        }

    }

}
