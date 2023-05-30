package generar;

import utilidades.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;

import static utilidades.utilities.generarDNI;

public class cobros {
    public void crearCobros(){
        Properties properties = new Properties();
        try(FileInputStream fileInputStream = new FileInputStream("src/hola.properties")){
            properties.load(new FileInputStream("src/hola.properties"));//cargo los datos del .properties

            try (FileWriter fileWriter = new FileWriter("src/BBDD/ficheros/Cobros.txt")) {
                int numCoboros = (int) properties.get("numCobros");
                for (int i = 0; i < numCoboros; i++) {
                    //random de pacientes
                    //random de formas de cobros
                    //fecha que es un getDate
                    //lo que se ha cobrado
                    //imputado, que es lo que se ha cobrado
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("se ha generado con exito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
