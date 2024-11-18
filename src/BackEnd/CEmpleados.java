/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import BackEnd.Conexion;

/**
 *
 * @author robek
 */
public class CEmpleados {
    private Conexion cn;
    private String n;
    
    public CEmpleados() {
        this.cn = new Conexion("TIENDA");
    }
    
    public List<String> genero() {
        List<String> GeneroList = new ArrayList<>();  
    
        try (Connection conn = cn.conectar()) {
                String consulta = "SELECT GENDER FROM EMPLOYEES;";
                try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            GeneroList.add(rs.getString("GENDER"));  
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al intentar obtener el genero: " + e.getMessage());
            }

        return GeneroList;  
    }
     public void add(String CURP, String password, String FirstName, String lastname, int phone) {
        try (Connection conn = cn.conectar()) {
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(48) + 18;
            // Inserción de los datos en las columnas especificadas de la tabla PRODUCTS
            String consulta = "INSERT INTO EMPLOYEES (CURP, username, Password, FirstName, LastName, Age, phone) " +
                              "VALUES (?, ?, sha2(?,256), ?, ?, ?, ?);";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, CURP);  // Nombre del producto
                pstmt.setString(2, FirstName);       // ID de la categoría
                pstmt.setString(3, password); // Cantidad del producto
                pstmt.setString(4, FirstName);
                pstmt.setString(5, lastname);
                pstmt.setInt(6, numeroAleatorio);
                pstmt.setInt(7, phone);

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Empleado agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el empleado: " + e.getMessage());
        }
    }
     public void delete(String CURP) {
        try (Connection conn = cn.conectar()) {
            // Consulta para eliminar el producto especificado por su nombre
            String consulta = "DELETE FROM EMPLOYEES WHERE CURP = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (nombre del producto a eliminar)
                pstmt.setString(1, CURP);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Empleado eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el Empleado para eliminar.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el Empleado: " + e.getMessage());
        }
    }
   public void update(String CURP, String password, String FirstName, String lastname, int phone) {
        try (Connection conn = cn.conectar()) {
            // Verificar si el CategoryID existe
            String verificarCategoria = "SELECT COUNT(*) FROM employees WHERE CURP = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(verificarCategoria)) {
                checkStmt.setString(1, CURP);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) == 0) {
                        System.out.println("Error: El CategoryID especificado no existe.");
                        return;
                    }
                }
            }

            // Actualizar los datos en la tabla products
            String consulta = "UPDATE EMPLOYEES SET CURP = ?, Username = ?, Password = sha2(?,256), FirstName = ?,"
                    + " LastName = ?, age = ?, phone = ? WHERE CURP = ?";
            
            Random rand = new Random();
            int numeroAleatorio = rand.nextInt(48) + 18;
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, CURP);  // Nombre del producto
                pstmt.setString(2, FirstName);       // ID de la categoría
                pstmt.setString(3, password); // Cantidad del producto
                pstmt.setString(4, FirstName);
                pstmt.setString(5, lastname);
                pstmt.setInt(6, numeroAleatorio);
                pstmt.setInt(7, phone);

                // Ejecutar la consulta de inserción
                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Producto editado exitosamente.");
                } else {
                    System.out.println("Error: No se encontró un empleado con el nombre especificado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar editar el empleado: " + e.getMessage());
        }
    }
   public String[] select(String CURP) {
        // Inicializamos el arreglo que contendrá los detalles del producto.
        String[] productDetails = new String[5];  // 6 posiciones para cada dato

        try (Connection conn = cn.conectar()) {
            String consulta = "SELECT CURP, Password, Firstname, LastName, phone FROM Employees WHERE CURP = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, CURP);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        productDetails[0] = rs.getString("firstName");         
                        productDetails[1] = rs.getString("LastName");
                        productDetails[2] = rs.getString("CURP");
                        productDetails[3] = String.valueOf(rs.getInt("phone"));
                        productDetails[4] = rs.getString("password"); 
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el empleado: " + e.getMessage());
        }

        return productDetails;
    }
}