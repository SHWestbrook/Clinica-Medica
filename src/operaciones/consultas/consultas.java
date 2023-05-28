package operaciones.consultas;

import utilidades.dbConnection;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class consultas {
    public static void consultarPorId(String id){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            Connection conn= dbConnection.getConnection();
            Statement st= conn.createStatement();
            ResultSet rs=st.executeQuery("select * from pacientes where id="+id);
            while(rs.next()){
                int idC= rs.getInt("id");
                String nombre= rs.getString("nombre");
                String apellidos= rs.getString("apellidos");
                LocalDate fecha= rs.getDate("fechaNacimiento").toLocalDate();
                String formatfecha=fecha.format(dateTimeFormatter);
                String numTelf= rs.getString("numeroTelef");
                String genero= rs.getString("genero");
                String dni=rs.getString("dni");
                System.out.println(idC+" "+nombre+" "+apellidos+" "+formatfecha+" "+numTelf+" "+genero+" "+dni);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
