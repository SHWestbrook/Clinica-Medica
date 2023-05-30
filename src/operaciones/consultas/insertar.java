package operaciones.consultas;

import utilidades.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class insertar {
    private static Connection conn = dbConnection.getConnection();

    public static void insertarServicio(){
        //insertar Servicio por consola
        try {
            PreparedStatement ps = conn.prepareStatement("insert into Servicios ()");
            //fecha
            //idPaciente
            //idProfesional
            //idTratamiento
            //idLiquidacion
            //precio
            //cobrado
            System.out.println("Se inserto con exito");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertarCobro(){
        //insertar Cobro por consola

    }
}
