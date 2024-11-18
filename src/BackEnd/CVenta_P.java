/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class CVenta_P {
     private Conexion conexion;
      public CVenta_P() {
        this.conexion = new Conexion("TIENDA");
    }
    public List<Object[]> buscarVentaPorPeriodo(String FI, String FF) {
        String query = "SELECT SaleID, EmployeeID, OrderDate,Total FROM SALE WHERE OrderDate  BETWEEN  ? AND ?";
        List<Object[]> ventas = new ArrayList<>();
        try (Connection connection = conexion.conectar(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, FI);  
            stmt.setString(2, FF);  
            ResultSet rs = stmt.executeQuery();
           while (rs.next()) {
                Object[] venta = new Object[]{
                    rs.getInt("SaleID"),
                    rs.getInt("EmployeeID"),
                    rs.getDate("OrderDate"),
                    rs.getDouble("Total")
                };
                ventas.add(venta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ventas; 
    }
}
