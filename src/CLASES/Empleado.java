package CLASES;

import ENUMERACION.TipoEmpleado;

public class Empleado {

    private String nombre;
    private int id;
    private TipoEmpleado tipoEmpleado;
    private boolean estado;

    private int dni;

    public Empleado(String nombre, int id, TipoEmpleado tipoEmpleado, boolean estado, int dni) {
        this.nombre = nombre;
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
        this.dni=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoEmpleado() {
        return tipoEmpleado.name();
    }

    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return
                "\nnombre='" + nombre +
                "\nid=" + id +
                "\ntipoEmpleado=" + tipoEmpleado +
                "\nestado=" + estado;
    }
}
