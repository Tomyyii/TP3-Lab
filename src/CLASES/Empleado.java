package CLASES;

public class Empleado {

    private String nombre;
    private int id;
    private String tipoEmpleado;
    private boolean estado;

    public Empleado(String nombre, int id, String tipoEmpleado, boolean estado) {
        this.nombre = nombre;
        this.id = id;
        this.tipoEmpleado = tipoEmpleado;
        this.estado = estado;
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
        return tipoEmpleado;
    }

    public void setTipoEmpleado(String tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }


}
