package utilidades;

import java.util.Scanner;

public class menu {
    static Scanner scanner = new Scanner(System.in);
    public static void menuBBDD(){
        int opcion;

        do {
            System.out.println("\n----- Menú BBDD -----");
            System.out.println("1. Crear BBDD");
            System.out.println("2. Generar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Has seleccionado Crear BBDD.");
                    // Aquí va la lógica para crear la base de datos
                    break;
                case 2:
                    System.out.println("Has seleccionado Generar.");
                    // Aquí va la lógica para generar lo que sea necesario
                    break;
                case 0:
                    System.out.println("Has seleccionado Salir.");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);
    }

}
