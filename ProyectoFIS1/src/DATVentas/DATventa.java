/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATVentas;

import clases.Producto;
import java.sql.*;

/**
 *
 * @author SMART
 */
public class DATventa {
    private connectionSQL conecta= new connectionSQL();
    
    public ResultSet obtenerProductos() throws ClassNotFoundException, SQLException{
        Statement st= conecta.getConnection().createStatement();
        String sql="SELECT * FROM PRODUCTO;";
        return st.executeQuery(sql);
    }
    
    public ResultSet getProductoTipo(String tipo) throws ClassNotFoundException, SQLException {        
        String sql = "SELECT idProducto, nombre, tipo, descripcion, cantidad, precio FROM PRODUCTO WHERE tipo= '" + tipo+"';";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
    
    public ResultSet getProductoNombre(String nombre) throws ClassNotFoundException, SQLException {      
        String sql = "SELECT idProducto, nombre, tipo, descripcion, cantidad, precio FROM PRODUCTO WHERE nombre LIKE '%"+nombre+"%';";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
    
    public ResultSet getProductoPrecioMenorIgual(double menor) throws ClassNotFoundException, SQLException {        
        String sql = "SELECT idProducto, nombre, tipo, descripcion, cantidad, precio FROM PRODUCTO WHERE precio <= "+menor+";";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
    
    public ResultSet getProductoPrecioMayorIgual(double mayor) throws ClassNotFoundException, SQLException {        
        String sql = "SELECT idProducto, nombre, tipo, descripcion, cantidad, precio FROM PRODUCTO WHERE precio >= "+mayor+";";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
    
    public ResultSet getProductoPrecioEntre(double menor, double mayor) throws ClassNotFoundException, SQLException {       
        String sql = "SELECT idProducto, nombre, tipo, descripcion, cantidad, precio FROM PRODUCTO WHERE precio BETWEEN "+ menor +" AND "+ mayor +";";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    
    }
    
    public PreparedStatement actualizarInventarioCompra(Producto producto,int cantidad) throws SQLException{
        String sql="UPDATE producto SET cantidad=?  WHERE idProducto= ?;";
        PreparedStatement ps=conecta.getConnection().prepareStatement(sql);
        ps.setInt(1, cantidad);
        ps.setInt(2, producto.getIdProducto());
        return ps;
    }
    
    public ResultSet obtenerUsuarios() throws ClassNotFoundException, SQLException{
        Statement st= conecta.getConnection().createStatement();
        String sql="SELECT * FROM USUARIO;";
        return st.executeQuery(sql);
    }
    
    public ResultSet getUsuarioCed(int cedula) throws ClassNotFoundException, SQLException {
        String sql = "SELECT dni, nombre, apellido, telefono, correo, pass FROM USUARIO WHERE dni= '" + cedula+"';";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public ResultSet getUsuarios() throws ClassNotFoundException, SQLException {
        String sql = "SELECT dni, nombre, apellido, telefono, correo, pass FROM USUARIO;";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    public PreparedStatement createProducto(Producto product) throws SQLException{
        String sql="INSERT INTO producto (idProducto, idPropietario, nombre, tipo, "
                + "descripcion, cantidad, precio) VALUES (?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement ps=conecta.getConnection().prepareStatement(sql);
        ps.setInt(1, product.getIdProducto());
        ps.setInt(2, product.getIdPropietario());
        ps.setString(3, product.getNombre());
        ps.setString(4, product.getTipo());
        ps.setString(5, product.getDescripcion());
        ps.setDouble(6, product.getCantidad());
        ps.setDouble(7, product.getPrecio());
        return ps;
    }
    
    public ResultSet getRepartidores() throws ClassNotFoundException, SQLException {
        String sql = "SELECT u.nombre, v.tipo, concat_ws(' ',v.marca,v.modelo) AS Marca, v.color, v.placa, u.telefono FROM usuario u, vehiculo v, repartidor r WHERE u.dni=r.idUsuario AND v.placa=r.idVehiculo;";
        Statement st = conecta.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
}
