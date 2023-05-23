package generarClientes;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Clientes {
    private static final Random R = new Random();
    //leer hombres y mujeres generando 3000 clientes pasarlo a csv y meterlo en la tabla clientes

    public static void crearClientes() {

        Properties properties = new Properties();
        LocalDate fechaMin = LocalDate.now().minusYears(100);
        LocalDate fechaMax = LocalDate.now().minusYears(6);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));//cargo los datos del .properties

            String[] archivos={ (String)properties.get("mujeres"), (String)properties.get("hombres"), (String)properties.get("apellidos") };//recopilo todos los archivos


            ArrayList[] list=new ArrayList[3];
            for(int i=0;i< list.length;i++){
                list[i]=new ArrayList<String>();
                leerArchivo(archivos[i], list[i]);
            }

            try(FileWriter fileWriter = new FileWriter("Clientes.txt")){

                for(int i=0;i<3000;i++){
                    String genero;
                    double numeroAleatorio= Math.random();
                    if (numeroAleatorio>0.45){
                        genero="M";

                        fileWriter.write(list[0].get(R.nextInt(list[0].size()))+",");//mujer
                    }else {
                        genero="H";
                        fileWriter.write(list[1].get(R.nextInt(list[1].size()))+",");//hombre
                    }

                    fileWriter.write(list[2].get(R.nextInt(list[2].size()))+",");//apellido

                    LocalDate cumple = fechaMin.plusDays(R.nextInt((int) ChronoUnit.DAYS.between(fechaMin, fechaMax)));//esto devuelve una fecha aleatoria
                    String fomatCumple=cumple.format(dateTimeFormatter);//formatear la fecha a string
                    fileWriter.write(fomatCumple+",");//fecha nacimiento entre 6 y 100 años

                    int numTelef = R.nextInt(800000000-600000000)+600000000;
                    fileWriter.write(numTelef+",");//telefono tiene que empezar en 6 o 7
                    fileWriter.write(genero+",");//genero

                    int numDNI=R.nextInt(99999999);
                    fileWriter.write(generarDNI(numDNI)+"\n");//dni
                }

            }catch (IOException e){
                e.printStackTrace();
            }

        }catch ( IOException e){
            e.printStackTrace();
        }
        System.out.println("se ha generado con exito");
    }
    protected static void leerArchivo(String ruta, ArrayList<String> list){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                list.add(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    //crear un dni
    protected static String generarDNI(int num){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.substring(num % 23, num % 23 + 1);
    }

}
