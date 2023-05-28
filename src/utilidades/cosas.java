package utilidades;

import java.io.*;

public class cosas {//buscar un archivo

    //para los transact
    //connection.setAutoCommit(false);
    //operaciones
    //connection.commit();
    //si sale mal (meter en try catch) connection.rollback();
    
    public static void hola() {
        File startDirectory = new File("/ruta/a/tu/directorio"); // Reemplaza esto con tu ruta de directorio
        FileFilter filter = new FileFilter() {
            public boolean accept(File file) {
                return file.isDirectory() || file.getName().endsWith(".java");
            }
        };
        search(startDirectory, filter);
    }

    public static void search(File file, FileFilter filter) {//file filter
        if (filter.accept(file)) {
            if (file.isDirectory()) {
                for (File child : file.listFiles()) {
                    search(child, filter);
                }
            } else {
                System.out.println("Archivo encontrado: " + file.getAbsolutePath());
            }
        }
    }

    //recorer contenido de carpetas
    public static void adios() {//recorrer un directorio
        File directory = new File("/ruta/a/tu/directorio"); // Reemplaza esto con tu ruta de directorio

        // Verifica si el directorio existe y es un directorio
        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            // Verifica si el directorio está vacío
            if (files != null && files.length > 0) {
                //for (int i = 0; i < files.length; i++)files[i].getName()
                for (File file : files) {
                    System.out.println(file.getName());
                }
            } else {
                System.out.println("El directorio está vacío.");
            }
        } else {
            System.out.println("El directorio especificado no existe o no es un directorio.");
        }
    }
    public static void leer() {//file reader
        File file = new File("/ruta/al/archivo.txt"); // Reemplaza esto con la ruta a tu archivo

        try (FileReader fileReader = new FileReader(file)) {
            int data;
            while ((data = fileReader.read()) != -1) {
                char character = (char) data;
                System.out.print(character);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo");
            e.printStackTrace();
        }
    }
    public static void leer2() {//buffered reader
        File file = new File("/ruta/al/archivo.txt"); // Reemplaza esto con la ruta a tu archivo

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo");
            e.printStackTrace();
        }
    }
    public static void escribir() {//file writer
        File file = new File("/ruta/al/archivo.txt"); // Reemplaza esto con la ruta a tu archivo

        try (FileWriter fileWriter = new FileWriter(file)) {
            String content = "Este es un texto de ejemplo.";
            fileWriter.write(content);
            System.out.println("El contenido ha sido escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo");
            e.printStackTrace();
        }
    }
}
