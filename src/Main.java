import BBDD.crearBBDD;
import BBDD.insertarArchivos;
import operaciones.consultas.consultas;
import utilidades.dbConnection;
import utilidades.menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {

        //hay que validar las cosas

        // Clientes.crearClientes();//la generacion de clientes funciona
        //Profesionales.crearProfesionales();//generacion de profesionales funciona

        Connection conn=dbConnection.getConnection();//conexion a base de datos
        Statement st_= conn.createStatement();

        st_.executeUpdate("use clinica");


        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n----- Menú Principal -----");
            System.out.println("1. Pacientes");
            System.out.println("2. Profesionales");
            System.out.println("3. Servicios");
            System.out.println("4. Cobros");
            System.out.println("5. Tratamientos");
            System.out.println("6. Gestión BBDD");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Pacientes.");
                    // Aquí va la lógica relacionada con los pacientes

                    break;
                case 2:
                    System.out.println("Has seleccionado Profesionales.");
                    // Aquí va la lógica relacionada con los profesionales

                    break;
                case 3:
                    System.out.println("Has seleccionado Servicios.");
                    // Aquí va la lógica relacionada con los servicios

                    break;
                case 4:
                    System.out.println("Has seleccionado Cobros.");
                    // Aquí va la lógica relacionada con los cobros

                    break;
                case 5:
                    System.out.println("Has seleccionado Tratamientos.");
                    // Aquí va la lógica relacionada con los tratamientos

                    break;
                case 6:
                    System.out.println("Has seleccionado Gestión BBDD.");
                    // Aquí va la lógica relacionada con la gestión de la base de datos
                    menu.menuBBDD();
                    break;
                case 0:
                    System.out.println("Has seleccionado Salir.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
        dbConnection.closeConnection();
    }



}