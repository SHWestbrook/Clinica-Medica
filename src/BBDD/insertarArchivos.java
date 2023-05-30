package BBDD;

import utilidades.dbConnection;

import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class insertarArchivos {

    private static Connection conn = dbConnection.getConnection();

    public static void insertarTratamientos(){

        Properties properties = new Properties();
        try(FileInputStream fileInputStream=new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            PreparedStatement ps= conn.prepareStatement("insert into tratamientos  (claveCorta,nombre,precio,idFamilia)values (?,?,?,?)");
            PreparedStatement ps1= conn.prepareStatement("insert into familias (NombreFam) values (?)");
            PreparedStatement ps2= conn.prepareStatement("select id from familias where NombreFam=?");
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
            PreparedStatement ps= conn.prepareStatement("insert into dbo.profesionales (nombre, apellidos,dni,telefono,comision) values (?,?,?,?,?)");
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

    public static void insertarLiquidaciones(){

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try{
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from profesionales");
            PreparedStatement ps = conn.prepareStatement("insert into dbo.liquidaciones (fecha, idProfesional, comision) values(?,?,?)");

            while(rs.next()){
                int idProfesional = rs.getInt("id");
                int comision = rs.getInt("comision");
                LocalDate hoy = LocalDate.now();
                String formateo = hoy.format(dateTimeFormatter);

                ps.setString(1,formateo);
                ps.setInt(2,idProfesional);
                ps.setInt(3,comision);
                ps.executeUpdate();
            }


            System.out.println("Se ha insertado liquidaciones con exito");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertarFcobros(){
        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("FCobros")));
            PreparedStatement ps = conn.prepareStatement("insert into dbo.formasCobro (idGrupoCaja, nombre) values(?,?)");

            String a = file.readLine();
            while(a!=null){
                String[] remplazar=a.split(",");
                ps.setInt(1, Integer.parseInt(remplazar[0]));
                ps.setString(2,remplazar[1]);
                ps.executeUpdate();
                a = file.readLine();
            }
            System.out.println("Se ha insertado Formas de cobro con exito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertarGCobros(){

        Properties properties = new Properties();

        try(FileInputStream fileInputStream = new FileInputStream("src/hola.properties")){

            properties.load(new FileInputStream("src/hola.properties"));
            BufferedReader file= new BufferedReader(new FileReader((String) properties.get("GCobros")));
            PreparedStatement ps = conn.prepareStatement("insert into dbo.grupocaja (nombre) values(?)");

            String a = file.readLine();
            while(a!=null){
                String[] remplazar=a.split(",");
                ps.setString(1,remplazar[0]);
                ps.executeUpdate();
                a = file.readLine();
            }

            System.out.println("Se han insertado los grupos de cobro con exito");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertarCobros(){

    }

    public static void insertarServicios(){

    }
}
