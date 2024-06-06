package CLASES;


import INTERFACES.cuaklquiercosa;

public abstract class Producto implements cuaklquiercosa {
//VARIABLES
    private double precio;
    private int stock;
    private boolean disponible;
    private String nombre;
//CONSTRUCTORES
    public Producto() {
        precio=0;
        stock=0;
        disponible=false;
        nombre="";
    }
    public Producto(double precio, int stock, String nombre) {
        this.precio = precio;
        this.stock = stock;
        setDisponible(true);
        this.nombre = nombre;
    }
//GETTERS
    public double getPrecio() {
        return precio;
    }
    public int getStock() {
        return stock;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public String getNombre() {
        return nombre;
    }
//SETTES
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
//METODO ToString
    @Override
    public String toString() {
        return "Producto"+
                "\n{" +
                "\nnombre=" + nombre +
                ",\nstock=" + stock +
                ",\ndisponible=" + disponible +
                ",\nprecio='" + precio;
    }
}
