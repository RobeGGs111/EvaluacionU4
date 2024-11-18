/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BackEnd;

import com.mysql.cj.xdevapi.Statement;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lenovo
 */
public class CVentas {
    private Conexion conexion;
      public CVentas() {
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
    public int id(double total){
        int id = 0; 
        String t= String.valueOf(total);
        try (Connection conn = conexion.conectar()) {
            String consulta="Select SaleID  from sale where Total= ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, t);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("SaleID");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el nombre completo: " + e.getMessage());
        }
        return id;
    }
    public int idUser(String user){
            int id=0; 
        try (Connection conn = conexion.conectar()) {
            String consulta = "SELECT EmployeeID AS IDUser FROM Employees WHERE UserName = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, user);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        id = rs.getInt("IDUser");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al intentar obtener el ID: " + e.getMessage());
        }
        return id;
    }
    
    public Object[] buscarProductoPorId(int productId) {
        String query = "SELECT ProductID, ProductName, UnitPrice,Discontinued,Quantity  FROM PRODUCTS WHERE ProductID = ?";
        Object[] producto= null;
        try (Connection connection = conexion.conectar(); 
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);  
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int descontinuado =rs.getInt("Discontinued");
                if(descontinuado==0){
                    return null;
                }else{
                        producto = new Object[]{
                        rs.getInt("ProductID"),  
                        rs.getString("ProductName"),  
                        rs.getDouble("UnitPrice"),
                        rs.getInt("Quantity") 
                        };
                }
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return producto; 
    }
    
    public void realizarTransaccion(DefaultTableModel  tabla,int empleadoId, String fecha,double total,String user,double iva)  {
          DefaultTableModel modelo = tabla;
         List<String> queries = new ArrayList<>();
         String sale = "INSERT INTO SALE (EmployeeID, OrderDate, Total) VALUES (" + empleadoId + ", '" + fecha + "', " + total + ")";
        queries.add(sale);
        queries.add("SET @saleId = LAST_INSERT_ID();");
        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object IdDelProducto = modelo.getValueAt(i, 0); 
            Object cantidadDelProducto = modelo.getValueAt(i, 3); 
            Object importeDelProducto = modelo.getValueAt(i, 4); 
            Object precioDelProducto=modelo.getValueAt(i,2);
            if (IdDelProducto != null && cantidadDelProducto != null) {
                int ID = (int) IdDelProducto;
                int cantidad = (int) cantidadDelProducto;
                double importe=(double)importeDelProducto;
                double precio=(double)precioDelProducto;
                if (cantidad > 0) {
                    String query = "UPDATE PRODUCTS SET Quantity = Quantity - " + cantidad + 
                                   " WHERE ProductID = " + ID + " AND Quantity >= " + cantidad;
                    queries.add(query);
                    String Descontinuar = "UPDATE PRODUCTS SET Discontinued = 0 WHERE ProductID = " + ID + " AND Quantity <= 0";
                    queries.add(Descontinuar);
                    String sale_details = "INSERT INTO SALES_DETAIL (SaleID, ProductID, Quantity, UnitPrice, Total) " +
                                                "VALUES (@saleId, " + ID + ", " + cantidad + ", " + precio + ", " + importe + ")";
                    queries.add(sale_details);
                }
                
            }
        }

        ImprimirTicket(tabla,user,fecha,total,iva);
        Conexion conexion = new Conexion("tienda");
        conexion.ejecutarTransaccion(queries.toArray(new String[0]));
        
    }
    
        public void ImprimirTicket(DefaultTableModel  tabla,String user, String fecha,double total,double iva) {
            int n=contarTickets();
            String nombreArchivo = "ticket"+n+".txt";
            File Archivo=new File(nombreArchivo);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(Archivo))) {
                writer.write("===== Ticket de Venta =====");
                writer.newLine();
                writer.write("Empleado: " + user);
                writer.newLine();
                writer.write("Fecha: " + fecha);
                writer.newLine();
                writer.write("===========================");
                writer.newLine();
                writer.write("Detalles de la Venta:");
                writer.newLine();
                writer.write(String.format("%-15s %-25s %-15s %-15s", "ID Producto", "Cantidad", "Precio Unit.", "Total"));
                writer.newLine();
                for (int i = 0; i < tabla.getRowCount(); i++) {
                    int ID = (int) tabla.getValueAt(i, 0);
                    int cantidad = (int) tabla.getValueAt(i, 3);
                    double precio = (double) tabla.getValueAt(i, 2);
                    double importe = (double) tabla.getValueAt(i, 4);

                    writer.write(String.format("%-15d %-25d %-15.2f %-15.2f", ID, cantidad, precio, importe));
                    writer.newLine();
           
                }
                writer.write("===========================");
                writer.newLine();
                writer.write(String.format("IVA 16p:  %.2f",iva));
                writer.newLine();
                writer.write(String.format("Total de la venta: %.2f", total));
                writer.newLine();
                writer.write("===========================");
                writer.newLine();
                writer.write("Gracias por su compra!");
                writer.newLine();
        
                System.out.println("Ticket generado exitosamente en " + nombreArchivo);
            } catch (IOException e) {
                e.printStackTrace();
            }

}
         private int contarTickets() {
        int n = 1;
        File archivoDelTicket = new File("ticket" + n + ".txt");
        // busca el ticket que hay y obtiene el siguiente
        while (archivoDelTicket.exists()) {
            n++;
            archivoDelTicket = new File("ticket" + n + ".txt");
        }
        
        return n;
    }
}
    
