package CLASES;

import ENUMERACION.TipoEmpleado;
import INTERFACES.IAccionesEmpleadosClientes;

import java.io.Serializable;
public class Empleado implements Serializable, IAccionesEmpleadosClientes {
    //VARIABLES
    private String nombre;
    private int id;
    private TipoEmpleado tipoEmpleado;
    private boolean estado;
    private int dni;
    private String usuario;
    private String contrasena;
    private double sueldo;
//CONSTRUCTOR

    public Empleado(String nombre, int id, TipoEmpleado tipoEmpleado, boolean estado, int dni, String usuario, String contrasena) {
        this.nombre = nombre;
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
        this.dni = dni;
        this.usuario = usuario;
        this.contrasena = contrasena;
        sueldo=0;
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public String getTipoEmpleado() {
        return tipoEmpleado.name();
    }
    public boolean isEstado() {
        return estado;
    }

    //SETTERS
    public int getDni() {
        return dni;
    }
    public void setDni(int dni) {
        this.dni = dni;
    }
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }
    public void setNombre(String nombre) {
        nombre = nombre;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void calcularSueldo()
    {
        if(getTipoEmpleado().equals("VENDEDOR"))
        {
            sueldo=300000;
        } else if (getTipoEmpleado().equals("ADMINISTRADOR")) {
            sueldo=500000;
        }
    }

    @Override
    public String toString() {
        return "nombre=" + nombre +
                "\nid=" + id +
                "\ntipoEmpleado=" + tipoEmpleado +
                "\nestado=" + estado +
                "\ndni=" + dni +
                "\nusuario=" + usuario +
                "\ncontrasena=" + contrasena;
    }

    //METODO ToString


    @Override
    public StringBuilder verHistorialDeCompras(Cliente cliente) {
        return cliente.verHistorialDeCompras(cliente);
    }

    @Override
    public StringBuilder verProductos(Tienda tienda) {
        return tienda.mostrarProductos();
    }

    @Override
    public StringBuilder verCuponesDisponibles(Cliente cliente) {
        return cliente.verCuponesDisponibles(cliente);
    }
}
