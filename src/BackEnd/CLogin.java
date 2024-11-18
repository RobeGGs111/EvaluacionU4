/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author s2212
 */
public class CLogin {
    
    private Conexion conexion;
    public String n;
     
     public CLogin(){
         this.conexion = new Conexion("TIENDA");
     }
     public boolean login(String user, String pas){
        boolean pasa = false;
                try (Connection conn = conexion.conectar()) {
                    String consulta = "SELECT * FROM Employees where UserName = ? AND password = SHA2(?, 256);";
                    //SELECT * FROM usuario where nombreUsuario = 'Usuario' and contraseña = SHA2('Contraseña',256);
                    try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                        pstmt.setString(1, user);
                        pstmt.setString(2, pas);
                        try (ResultSet rs = pstmt.executeQuery()) {
                                 if (rs.next()) {
                                  pasa = true;
                             }
                         }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Error al intentar iniciar sesión: " + e.getMessage());
                }
                return pasa;
     }
     
      public boolean loginP(String user){
       boolean pasa = false;
               try (Connection conn = conexion.conectar()) {
                   String consulta = "SELECT * FROM usuario where nombreUsuario = ?;";
                   //SELECT * FROM usuario where nombreUsuario = 'Usuario' and contraseña = SHA2('Contraseña',256);
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, user);
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 pasa = true;
                            }
                        }
                   }
               } catch (Exception e) {
                   e.printStackTrace();
                   JOptionPane.showMessageDialog(null, "Usuario no encontrado ");
               }
               return pasa;
     }
}
