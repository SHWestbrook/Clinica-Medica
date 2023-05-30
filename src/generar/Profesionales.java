package generar;

import utilidades.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

import static utilidades.utilities.generarDNI;

public class Profesionales {

    private static final Random R = new Random();

    public static void crearProfesionales() {
        //cada vez que haya una transaccion formatear la fecha
        Properties properties = new Properties();
        LocalDate fechaMin = LocalDate.now().minusYears(65);
        LocalDate fechaMax = LocalDate.now().minusYears(25);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));//cargo los datos del .properties

            String[] archivos={ (String)properties.get("mujeres"), (String)properties.get("hombres"), (String)properties.get("apellidos") };//recopilo todos los archivos


            ArrayList[] list=new ArrayList[3];
            for(int i=0;i< list.length;i++){
                list[i]=new ArrayList<String>();
                utilities.leerArchivo(archivos[i], list[i]);
            }

            try(FileWriter fileWriter = new FileWriter("src/BBDD/ficheros/Profesionales.txt")){
                int numProfesionales= (int) properties.get("numProfesionales");
                for(int i=0;i<numProfesionales;i++){
                    double numeroAleatorio= Math.random();
                    if (numeroAleatorio>0.45){

                        fileWriter.write(list[0].get(R.nextInt(list[0].size()))+",");//mujer
                    }else {
                        fileWriter.write(list[1].get(R.nextInt(list[1].size()))+",");//hombre
                    }

                    fileWriter.write(list[2].get(R.nextInt(list[2].size()))+" "+list[2].get(R.nextInt(list[2].size()))+",");//apellido

                    int numTelef = R.nextInt(800000000-600000000)+600000000;
                    fileWriter.write(numTelef+",");//telefono tiene que empezar en 6 o 7

                    int numDNI=R.nextInt(99999999);
                    fileWriter.write(numDNI+generarDNI(numDNI)+",");//dni
                    int comision=R.nextInt(20-5)+5;
                    fileWriter.write(comision+"\n");//comision
                }
            }catch (IOException e){
                e.printStackTrace();
            }

        }catch ( IOException e){
            e.printStackTrace();
        }
        System.out.println("se ha generado con exito");

    }
}