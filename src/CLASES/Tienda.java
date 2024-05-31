package CLASES;

import java.util.HashSet;
import java.util.Iterator;

public class Tienda {

    private String nombre;
    private ContenedorHashSetGenerico<Producto> productos;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ContenedorHashSetGenerico<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContenedorHashSetGenerico<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ContenedorHashSetGenerico<Producto> productos) {
        this.productos = productos;
    }


    public boolean Vender(String modelo) {
        boolean flag = true;
        Iterator iterator = productos.getIterator();
        while (iterator.hasNext() && flag) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getTipo().equals(nombre) && productoaux.isDisponible() == true) {
                productoaux.setDisponible(false);
                flag = false;
            }

        }
        return flag;
    }

    public Producto buscarProducto(String modelo) {
        boolean flag = true;
        Iterator iterator = productos.getIterator();
        Producto aux = null;
        while (iterator.hasNext() && flag) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getTipo().equals(modelo) && productoaux.isDisponible() == true) {
                aux = productoaux;
                flag = false;
            }
        }
        return aux;
    }

    public void cargarDatos(Producto elemento) {
        productos.agregar(elemento);
    }

    public StringBuilder mostrarProductos() {
        return productos.mostrar();
    }


    public void modificarPrecio(double precio,String modelo)
    {
        Producto aux=buscarProducto(modelo);
        aux.setPrecio(precio);
    }

    public void sumarStock(int stockNuevo, Producto producto)
    {
        int suma=producto.getStock()+stockNuevo;
        producto.setStock(suma);
    }
    public String mostrarDisponibles (){
        String rta ="";
        Iterator iterator = productos.getIterator();
        while(iterator.hasNext()){
            Producto aux = (Producto) iterator.next();
            if(aux.isDisponible()){
                rta += aux.toString();
            }
        }
        return rta;
    }

    public String mostrarNoDisponibles (){
        String rta ="";
        Iterator iterator = productos.getIterator();
        while(iterator.hasNext()){
            Producto aux = (Producto) iterator.next();
            if(aux.isDisponible() == false){
                rta += aux.toString();
            }
        }
        return rta;
    }







}
