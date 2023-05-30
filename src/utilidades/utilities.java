package utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class utilities {
    /*clase que contiene metodos normalmente utilizados como un numero random convertir las fechas, pedir numeros y que
    *no explote el programa
    */
    public static void leerArchivo(String ruta, ArrayList<String> list){

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(ruta))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                list.add(line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String generarDNI(int num){
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        return letras.substring(num % 23, num % 23 + 1);
    }

    public static void pideHastaQueExista(){
        //pedir algo hasta que exista
    //do{
        //dentro del while llamar a comprobarSiCampoExiste
    //}while(  );//sigue si es true, tiene que devolver false para salir
    }

    public static void calcularLiquidacion(){
        /*calculo la liquidacion a partir de la comision del profesional
        sumo todos los cobros que ha realizado
        calculo el porcentaje de esos cobros
         */
    }


}
