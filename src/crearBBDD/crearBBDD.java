package crearBBDD;
import utilidades.dbConnection;

import java.sql.SQLException;
import java.sql.Statement;


public class crearBBDD {//clase que crea la base de datos
    public void creacionBBDD(){
        try {
            //creacion de la base de datos
            Statement st_ = dbConnection.getConnection().createStatement();

            st_.executeUpdate("create database clinica");
            st_.executeUpdate("use clinica");
            st_.executeUpdate("create table pacientes( id int AUTO_INCREMENT unique," +
                    " historia varchar(50)not null," +
                    " apellidos varchar(50)not null," +
                    "dni varchar(9)not null," +
                    "fechaNacimiento date not null," +
                    "genero varchar(1)not null )");


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    }