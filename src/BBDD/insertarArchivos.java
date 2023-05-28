package BBDD;

import utilidades.dbConnection;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class insertarArchivos {

    public static void insertarTratamientos(){

        Properties properties = new Properties();
        try(FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            PreparedStatement ps= dbConnection.getConnection().prepareStatement("insert into tratamientos  (claveCorta,nombre,precio,idFamilia)values (?,?,?,?)");
            PreparedStatement ps1= dbConnection.getConnection().prepareStatement("insert into familias (NombreFam) values (?)");
            PreparedStatement ps2= dbConnection.getConnection().prepareStatement("select id from familias where NombreFam=?");
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("tratamientos")));

            String a = file.readLine();
            String NombreIN="";
            a = file.readLine();
            while(a!=null){

                String[] remplazar=a.split(";");
                ps2.setString(1,remplazar[0]);

                if(!NombreIN.equals(remplazar[0])){
                    NombreIN=remplazar[0];
                    ps1.setString(1,remplazar[0]);
                    ps1.executeUpdate();
                }

                ResultSet rs = ps2.executeQuery();
                rs.next();

                ps.setString(1,remplazar[1]);
                ps.setString(2,remplazar[2]);
                ps.setInt(3, Integer.parseInt(remplazar[3]));
                ps.setInt(4,rs.getInt("id"));

                ps.executeUpdate();
                a = file.readLine();
            }
            System.out.println("Se ha insertado tratamientos y familias con exito");
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
            PreparedStatement ps= conn.prepareStatement("insert into pacientes (nombre,apellidos, fechaNacimiento,numeroTelef,genero,dni) values (?,?,?,?,?,?)");
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
                ps.executeUpdate();
                a = file.readLine();
            }
            System.out.println("Se ha insertado pacientes con exito");
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
            PreparedStatement ps= dbConnection.getConnection().prepareStatement("insert into dbo.profesionales (nombre, apellidos,dni,telefono,comision) values (?,?,?,?,?)");
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("profesionales")));

            String a = file.readLine();
            while(a!=null){
                String[] remplazar=a.split(",");
                ps.setString(1,remplazar[0]);
                ps.setString(2,remplazar[1]);
                ps.setString(3,remplazar[2]);
                ps.setString(4,remplazar[3]);
                ps.setString(5,remplazar[4]);
                ps.executeUpdate();
                a = file.readLine();
            }
            System.out.println("Se ha insertado profesionales con exito");
        }catch(SQLException e){
            e.printStackTrace();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
