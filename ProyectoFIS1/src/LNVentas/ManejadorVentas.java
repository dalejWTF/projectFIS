/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LNVentas;

import DATVentas.DATventa;
import clases.Producto;
import clases.Repartidor;
import clases.Usuario;
import clases.Vehiculo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author SMART
 */
public class ManejadorVentas {

    //Llama a todos los prodctos ingresados en la base de datos
    public ArrayList<Producto> obtenerProducto() throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ResultSet rs = datv.obtenerProductos();
        ArrayList<Producto> listaProductos = new ArrayList<>();
        while (rs.next()) {
            //int idProducto, int idPropietario, String nombre, String tipo, String descripcion, int cantidad, double precio
            Producto p = new Producto(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6), rs.getDouble(7));
            listaProductos.add(p);
        }

        return listaProductos;
    }
    
    //Se llama a la base para buscar al usuario que vende el producto
    public Usuario obtenerUsuarioCed(int cedula) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ResultSet rs = datv.getUsuarioCed(cedula);
        Usuario usuario=new Usuario();
        while (rs.next()) {
            //int dni, String nombre, String apellido, String telefono, String correo, String pass
            Usuario c = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
            usuario=c;
        }

        return usuario;
    }
    
    //Busqueda en base al buscador por nombre
    public ArrayList<Producto> busquedaProductosNombre(String busqueda) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ArrayList<Producto> filtrada = new ArrayList<>();
        ResultSet rs = datv.getProductoNombre(busqueda);

        while (rs.next()) {

            //idProducto, nombre, tipo, descripcion, cantidad, precio
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setTipo(rs.getNString(3));
            producto.setDescripcion(rs.getString(4));
            producto.setCantidad(rs.getDouble(5));
            producto.setPrecio(rs.getDouble(6));
            filtrada.add(producto);
        }

        return filtrada;
    }
    
    //Busqueda en base al buscador por Categorio/Tipo
    public ArrayList<Producto> busquedaProductosCategoria(String busqueda) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ArrayList<Producto> filtrada = new ArrayList<>();
        ResultSet rs = datv.getProductoTipo(busqueda);
        while (rs.next()) {

            //idProducto, nombre, tipo, descripcion, cantidad, precio
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setTipo(rs.getNString(3));
            producto.setDescripcion(rs.getString(4));
            producto.setCantidad(rs.getDouble(5));
            producto.setPrecio(rs.getDouble(6));
            filtrada.add(producto);
        }

        return filtrada;
    }
    
    //Busqueda en base al buscador por Precio Menor
    public ArrayList<Producto> busquedaProductosPrecioMenor(double busqueda) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ArrayList<Producto> filtrada = new ArrayList<>();
        ResultSet rs = datv.getProductoPrecioMenorIgual(busqueda);
        
        while (rs.next()) {

            //idProducto, nombre, tipo, descripcion, cantidad, precio
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setTipo(rs.getNString(3));
            producto.setDescripcion(rs.getString(4));
            producto.setCantidad(rs.getDouble(5));
            producto.setPrecio(rs.getDouble(6));
            filtrada.add(producto);
            
            
        }
        
        return filtrada;
    }
    
    //Busqueda en base al buscador por Precio Mayor
    public ArrayList<Producto> busquedaProductosPrecioMayor(double busqueda) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ArrayList<Producto> filtrada = new ArrayList<>();
        ResultSet rs = datv.getProductoPrecioMayorIgual(busqueda);
        
        while (rs.next()) {

            //idProducto, nombre, tipo, descripcion, cantidad, precio
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setTipo(rs.getNString(3));
            producto.setDescripcion(rs.getString(4));
            producto.setCantidad(rs.getDouble(5));
            producto.setPrecio(rs.getDouble(6));
            filtrada.add(producto);
            
            
        }
        
        return filtrada;
    }
    
    //Busqueda en base al buscador por Precio Entre X y Y
    public ArrayList<Producto> busquedaProductosPrecioEntre(double menor, double mayor) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ArrayList<Producto> filtrada = new ArrayList<>();
        ResultSet rs = datv.getProductoPrecioEntre(menor,mayor);
        
        while (rs.next()) {

            //idProducto, nombre, tipo, descripcion, cantidad, precio
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt(1));
            producto.setNombre(rs.getString(2));
            producto.setTipo(rs.getNString(3));
            producto.setDescripcion(rs.getString(4));
            producto.setCantidad(rs.getDouble(5));
            producto.setPrecio(rs.getDouble(6));
            filtrada.add(producto);
        }

        return filtrada;
    }
    
    //Para actualizar base de datos luego de una compra
    public boolean GuardarCambios(Producto producto, int cantidad) throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        PreparedStatement ps = datv.actualizarInventarioCompra(producto, cantidad);
        if (ps != null) {
            ps.executeUpdate();
            return true;
        } else {
            throw new SQLException();
        }
    }
    
    //Registro de productos nuevos
    public boolean AgregarProducto(Producto product) throws ClassNotFoundException, SQLException {
        DATventa dATClienteCedula = new DATventa();
        PreparedStatement ps = dATClienteCedula.createProducto(product);
        if (ps != null) {
            ps.executeUpdate();
            return true;
        } else {
            throw new SQLException();
        }
    }
    
    
    //Se llama a la base de datos para buscar a los repartidores
    public ArrayList<Repartidor> obtenerRepartidor() throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ResultSet rs = datv.getRepartidores();
        ArrayList<Repartidor> listaProductos = new ArrayList<>();
        while (rs.next()) {
            //u.nombre, v.tipo, concat_ws(' ',v.marca,v.modelo) AS Marca, v.color, v.placa, u.telefono
            Repartidor r= new Repartidor();
            Vehiculo v= new Vehiculo();
            r.setNombre(rs.getString(1));
            
            v.setTipo(rs.getString(2));
            v.setMarca(rs.getString(3));
            v.setColor(rs.getString(4));
            v.setPlaca(rs.getString(5));
            
            r.setTelefono(rs.getString(6));
            r.setVehiculo(v);
            listaProductos.add(r);
            
        }

        return listaProductos;
    }
    
    
    public ArrayList<Usuario> obtenerUsuarios() throws ClassNotFoundException, SQLException {
        DATventa datv = new DATventa();
        ResultSet rs = datv.getUsuarios();
        ArrayList<Usuario> users= new ArrayList<>();
        while (rs.next()) {
            //int dni, String nombre, String apellido, String telefono, String correo, String pass
            Usuario c = new Usuario(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
            users.add(c);
        }

        return users;
    }
}
