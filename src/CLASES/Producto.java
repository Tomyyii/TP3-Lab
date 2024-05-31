package CLASES;

public abstract class Producto {

    private double precio;
    private int stock;
    private String estado;
    private boolean disponible;
    private String nombre;

    //Coleccion


    public Producto() {
        precio=0;
        stock=0;
        estado="";
        disponible=false;
        nombre="";
    }

    public Producto(double precio, int stock, String estado, String nombre) {
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        setDisponible(true);
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "precio=" + precio +
                ", stock=" + stock +
                ", estado='" + estado + '\'' +
                ", disponible=" + disponible +
                ", nombre='" + nombre + '\'' +
                '}';
    }


}
