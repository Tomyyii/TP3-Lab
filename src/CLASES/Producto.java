package CLASES;


import java.io.Serializable;

public abstract class Producto implements Serializable {
//VARIABLES
    private double precio;
    private int stock;
    private boolean disponible;
    private String nombre;
    private int cantidadVendida;

//CONSTRUCTORES
    public Producto() {
        precio=0;
        stock=0;
        disponible=false;
        nombre="";
        cantidadVendida=0;
    }
    public Producto(double precio, int stock, String nombre,int cantidadVendida) {
        this.precio = precio;
        this.stock = stock;
        setDisponible(true);
        this.nombre = nombre;
        this.cantidadVendida=cantidadVendida;
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
    public abstract String getTipo();

    public int getCantidadVendida() {
        return cantidadVendida;
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

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    //METODO ToString
    @Override
    public String toString() {
        return "Producto"+
                "\n{" +
                "\nnombre=" + nombre +
                "\nstock=" + stock +
                "\ndisponible=" + disponible +
                "\nprecio=" + precio +
                "\ncantidad vendida="+ cantidadVendida;
    }

}
