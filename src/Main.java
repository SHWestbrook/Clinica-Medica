import operaciones.consultas.consultas;
import utilidades.dbConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        // Clientes.crearClientes();//la generacion de clientes funciona
        //Profesionales.crearProfesionales();//generacion de profesionales funciona

        Connection conn=dbConnection.getConnection();
        //crearBBDD.creacionBBDD();//crear la base de datos e inserta clientes, profesionales y tratamientos funciona
        Statement st_= conn.createStatement();
        st_.executeUpdate("use clinica");
        consultas.consultarPorId("2");

        dbConnection.closeConnection();



    }
}