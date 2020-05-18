package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {

    private static Connection conect = null;

    public static Connection getConnect() {
        if (conect == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conect = DriverManager.getConnection("jdbc:mysql://localhost/crudtest", "root", "");
                System.out.println("se conecto");
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                System.out.println("No se pudo conectar con la Base de datos");
            }
        }
        return conect;
    }

}
