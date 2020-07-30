/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


/**
 *
 * @author SMART
 */
public class Repartidor extends Usuario {
    private Vehiculo vehiculo;

    public Repartidor() {}
    public Repartidor(Vehiculo vehiculo, int dni, String nombre, String apellido, String telefono, String correo, String pass) {
        super(dni, nombre, apellido, telefono, correo, pass);
        this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    
 
    
}
