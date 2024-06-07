package CLASES;

import ENUMERACION.Sucursales;
import ENUMERACION.TipoEmpleado;
import INTERFACES.ISucursales;

import java.io.Serializable;
public class Empleado implements Serializable, ISucursales {
//VARIABLES
    private String nombre;
    private int id;
    private TipoEmpleado tipoEmpleado;
    private boolean estado;
    private int dni;
//CONSTRUCTOR
    public Empleado(String nombre, int id, TipoEmpleado tipoEmpleado, boolean estado, int dni) {
        this.nombre = nombre;
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
        this.dni=dni;
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

//METODO ToString
    @Override
    public String toString() {
        return
                "\nnombre='" + nombre +
                "\nid=" + id +
                "\ntipoEmpleado=" + tipoEmpleado +
                "\nestado=" + estado;
    }
    @Override
    public String cambiarSucursal(int opcion) {
        String rta=null;
        if(opcion==1)
        {
            Sucursales aux=Sucursales.ALEM;
            rta=("Cambiado a: "+aux.name());
        } else if (opcion==2)
        {
            Sucursales aux=Sucursales.CENTRO;
            rta=("Cambiado a: "+aux.name());
        }
        return rta;
    }
}
