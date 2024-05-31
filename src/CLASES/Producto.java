package CLASES;


import INTERFACES.cuaklquiercosa;

public abstract class Producto implements cuaklquiercosa {

    private double precio;
    private int stock;
    private boolean disponible;
    private String nombre;

    //Coleccion


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
        return "Producto"+
                "\n{" +
                "\nnombre=" + nombre +
                ",\nstock=" + stock +
                ",\ndisponible=" + disponible +
                ",\nprecio='" + precio;
    }

   /* @Override
    public int compareTo(Object o) {
        int aux = 0;
        if(o != null){
            if(o instanceof  Producto){
                Producto aux2 = (Producto) o;
                if(aux2.getStock()> getStock()){
                    aux = 1;
                } else if(aux2.getStock()<getStock()) {
                    aux = -1;
                }
            }
        }
        return aux;
    }*/

}
