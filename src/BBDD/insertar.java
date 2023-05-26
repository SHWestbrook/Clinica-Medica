package BBDD;

import utilidades.dbConnection;

import java.io.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class insertar {

    public static void insertarTratamientos(){

        Properties properties = new Properties();
        try(FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            PreparedStatement ps= dbConnection.getConnection().prepareStatement("insert into tratamientos values (?,?,?,?)");
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("tratamientos")));

            String a = file.readLine();
            file.readLine();
            while(a!=null){
                String[] remplazar=a.split(";");
                ps.setString(1,remplazar[0]);
                ps.setString(2,remplazar[1]);
                ps.setString(3,remplazar[2]);
                ps.setString(4,remplazar[3]);
                a = file.readLine();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void insertarClientes(){//esto solo sirve para el texto plano
        Properties properties = new Properties();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try(FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            Connection conn = dbConnection.getConnection();
            PreparedStatement ps= conn.prepareStatement("insert into pacientes values (?,?,?,?,?,?)");
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("clientes")));

            String a = file.readLine();
            while(a!=null){
                String[] remplazar=a.split(",");
                ps.setString(1,remplazar[0]);
                ps.setString(2,remplazar[1]);
                LocalDate b = LocalDate.parse(remplazar[2]);
                String formateo=b.format(dateTimeFormatter);
                ps.setString(3, formateo);
                ps.setString(4,remplazar[3]);
                ps.setString(5,remplazar[4]);
                ps.setString(6,remplazar[5]);
                a = file.readLine();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void insertarProfesionales(){
        Properties properties = new Properties();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try(FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            PreparedStatement ps= dbConnection.getConnection().prepareStatement("insert into profesionales values (?,?,?,?,?,?,?)");
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("profesionales")));

            String a = file.readLine();
            while(a!=null){
                String[] remplazar=a.split(",");
                ps.setString(1,remplazar[0]);
                ps.setString(2,remplazar[1]);
                ps.setString(3,remplazar[2]);
                ps.setString(4,remplazar[3]);
                ps.setString(5,remplazar[4]);
                a = file.readLine();
            }

        }catch(SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
