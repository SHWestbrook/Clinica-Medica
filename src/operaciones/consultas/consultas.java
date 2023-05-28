package operaciones.consultas;

import utilidades.dbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class consultas {

    static Connection conn= dbConnection.getConnection();

    public static void consultarPorCampo(String dni, String campo){//se puede aprovechar para consultarlo por lo que quieras
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{

            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("select * from pacientes where "+campo+" = "+dni);
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

}
