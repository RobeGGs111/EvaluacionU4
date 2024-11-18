/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author s2212
 */
public class CProductos {
    private Conexion conexion;
    public String n;

    public CProductos() {
        this.conexion = new Conexion("TIENDA");
    }
    
    public List<String> categorias() {
        List<String> categoriasList = new ArrayList<>();  
    
        try (Connection conn = conexion.conectar()) {
                String consulta = "SELECT CATEGORYNAME FROM CATEGORIES;";
                try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                    try (ResultSet rs = pstmt.executeQuery()) {
                        while (rs.next()) {
                            categoriasList.add(rs.getString("CATEGORYNAME"));  
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error al intentar obtener las categorías: " + e.getMessage());
            }

        return categoriasList;  
    }
    
    public void add(String name, int id, int cantidad, double precio) {
        try (Connection conn = conexion.conectar()) {
            // Inserción de los datos en las columnas especificadas de la tabla PRODUCTS
            String consulta = "INSERT INTO PRODUCTS (ProductName, CategoryID, Quantity, UnitPrice, Discontinued) " +
                              "VALUES (?, ?, ?, ?, ?);";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer los parámetros de la consulta
                pstmt.setString(1, name);  // Nombre del producto
                pstmt.setInt(2, id);       // ID de la categoría
                pstmt.setInt(3, cantidad); // Cantidad del producto
                pstmt.setDouble(4, precio);  // Precio del producto
                pstmt.setInt(5, 1);        // Descontinuado (1 = sí, 0 = no)

                // Ejecutar la consulta de inserción
                pstmt.executeUpdate();

                System.out.println("Producto agregado exitosamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar agregar el producto: " + e.getMessage());
        }
    }
    
    public void delete(String name) {
        try (Connection conn = conexion.conectar()) {
            // Consulta para eliminar el producto especificado por su nombre
            String consulta = "DELETE FROM products WHERE ProductName = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                // Establecer el parámetro de la consulta (nombre del producto a eliminar)
                pstmt.setString(1, name);  

                // Ejecutar la consulta de eliminación
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Producto eliminado exitosamente.");
                } else {
                    System.out.println("No se encontró el producto para eliminar.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar eliminar el producto: " + e.getMessage());
        }
    }
    
   public void update(String name, int id, int cantidad, double precio) {
        try (Connection conn = conexion.conectar()) {
            // Verificar si el CategoryID existe
            String verificarCategoria = "SELECT COUNT(*) FROM categories WHERE CategoryID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(verificarCategoria)) {
                checkStmt.setInt(1, id);
                try (ResultSet rs = checkStmt.executeQuery()) {
                    if (rs.next() && rs.getInt(1) == 0) {
                        System.out.println("Error: El CategoryID especificado no existe.");
                        return;
                    }
                }
            }

            // Actualizar los datos en la tabla products
            String consulta = "UPDATE products SET ProductName = ?, CategoryID = ?, Quantity = ?, UnitPrice = ? WHERE ProductName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, name);  // Nombre del producto
                pstmt.setInt(2, id);       // ID de la categoría
                pstmt.setInt(3, cantidad); // Cantidad del producto
                pstmt.setDouble(4, precio); // Precio del producto
                pstmt.setString(5, name);  // Filtro del producto a actualizar

                // Ejecutar la actualización
                int filasActualizadas = pstmt.executeUpdate();
                if (filasActualizadas > 0) {
                    System.out.println("Producto editado exitosamente.");
                } else {
                    System.out.println("Error: No se encontró un producto con el nombre especificado.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar editar el producto: " + e.getMessage());
        }
    }
    
    public String[] select(String name) {
        // Inicializamos el arreglo que contendrá los detalles del producto.
        String[] productDetails = new String[4];  // 4 posiciones para cada dato

        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT ProductName, CategoryID, Quantity, UnitPrice FROM products WHERE ProductName = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {

                pstmt.setString(1, name);  


                try (ResultSet rs = pstmt.executeQuery()) {
                    // Si hay resultados, guardamos cada dato en su posición correspondiente
                    if (rs.next()) {
                        productDetails[0] = rs.getString("ProductName");         
                        productDetails[1] = String.valueOf(rs.getInt("CategoryID")); 
                        productDetails[2] = String.valueOf(rs.getInt("Quantity"));    
                        productDetails[3] = String.valueOf(rs.getDouble("UnitPrice")); 
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener los productos: " + e.getMessage());
        }

        return productDetails;
    }
}
