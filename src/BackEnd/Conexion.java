/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s2212
 */
public class Conexion {
    
    String bd;
    String url = "jdbc:mysql://localhost:3306/";
    String user = "root";
    String password = "";
    String driver = "com.mysql.cj.jdbc.Driver";
    
    Connection cx;

    public Conexion(String bd) {
    this.bd = bd;
    }
    
    public Connection conectar(){
        try {
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd, user, password);
            System.out.println("SE CONECTO A LA BASE DE DATOS: " + bd);
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("NO SE CONECTO CON LA BASE DE DATOS");
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        return cx;
    }
    
    public void desconectar(){
        try {
            cx.close();
            System.out.println("LA CONEXION SE DESCONECTO CON EXITO");
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     public void ejecutarTransaccion(String[] queries) {
        try {
            
            Connection conexion = conectar();
            conexion.setAutoCommit(false); 
            Statement stmt = conexion.createStatement();
            for (String query : queries) {
                stmt.executeUpdate(query);
            }
            conexion.commit();
            System.out.println("Transacción ejecutada exitosamente.");
        } catch (SQLException ex) {
            try {
                cx.rollback();
                System.out.println("Transacción revertida.");
            } catch (SQLException ex1) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            desconectar();
        }
    }
     
   public List<String> obtenerDatos(String query) {
        List<String> lista = new ArrayList<>();
        try (Connection conexion = conectar(); 
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
             
            while (rs.next()) {
                // Supongamos que estás obteniendo una columna llamada "nombre"
                lista.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    
}
