package BBDD;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import utilidades.*;

public class crearBBDD {//clase que crea la base de datos
    public static void creacionBBDD() throws IOException {

        Properties properties = new Properties();
        try (FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            Statement st_= dbConnection.getConnection().createStatement();

            properties.load(new FileInputStream("src/hola.properties"));//cargo los datos del .properties
            String crearBBDD=(String) properties.get("consultasCrearBBDD");

            ArrayList<String>creates=new ArrayList<>();
            utilities.leerArchivo(crearBBDD,creates);

            for (int i = 0; i < creates.size(); i++) {
                st_.executeUpdate(creates.get(i));
            }
            insertarArchivos.insertarClientes();
            insertarArchivos.insertarProfesionales();
            insertarArchivos.insertarTratamientos();

            System.out.println("se ha creado la base de datos con exito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }