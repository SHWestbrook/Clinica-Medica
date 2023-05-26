import BBDD.crearBBDD;
import BBDD.insertar;
import generar.Clientes;
import generar.Profesionales;
import utilidades.dbConnection;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //Clientes.crearClientes();//la generacion de clientes funciona
        //Profesionales.crearProfesionales();//generacion de profesionales funciona

        dbConnection.getConnection();
        //crearBBDD.creacionBBDD();//crear la base de datos clientes funciona
        //insertar en la base de datos los datos
        //insertar.insertarClientes();
        //insertar.insertarTratamientos();
        //insertar.insertarProfesionales();

        dbConnection.closeConnection();



    }
}