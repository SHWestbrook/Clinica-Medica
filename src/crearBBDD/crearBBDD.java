package crearBBDD;
import utilidades.dbConnection;

import java.sql.SQLException;
import java.sql.Statement;


public class crearBBDD {//clase que crea la base de datos
    public void creacionBBDD(){
        try {
            //creacion de la base de datos
            Statement st_ = dbConnection.getConnection().createStatement();
            st_.executeUpdate("");
            st_.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(e);
        }

    }
    }