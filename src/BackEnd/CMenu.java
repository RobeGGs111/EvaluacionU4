/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author s2212
 */
public class CMenu {
    
    private boolean caja;
    private Conexion conexion;

    public CMenu() {
        this.conexion = new Conexion("TIENDA");
    }
    
    public String name(String user) {
        String fullName = ""; 
    
        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT CONCAT(FirstName, ' ', LastName) AS FullName FROM Employees WHERE UserName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, user);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        fullName = rs.getString("FullName");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el nombre completo: " + e.getMessage());
        }
    
        return fullName;
    }
    
    
    
    
    
    
}
