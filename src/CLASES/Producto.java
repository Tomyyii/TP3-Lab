package CLASES;

public abstract class Producto {

    private double precio;
    private int stock;
    private String estado;
    private boolean disponible;

    //Coleccion


    public Producto() {
        precio=0;
        stock=0;
        estado="";
        disponible=false;
    }

    public Producto(double precio, int stock, String estado, boolean disponible) {
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
        this.disponible = disponible;
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





}
