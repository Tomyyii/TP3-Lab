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


    public boolean Vender(String nombre)
    {
        HashSet<Producto> auxiliar=new HashSet<>();
        boolean flag=true;
        auxiliar=productos.getSet();
        Iterator iterator=auxiliar.iterator();
        while (iterator.hasNext() && flag)
        {
            Producto productoaux= (Producto) iterator.next();
            if(productoaux.getNombre().equals(nombre) && productoaux.isDisponible()==true)
            {
                productoaux.setDisponible(false);
                flag=false;
            }

        }
        return flag;
    }

    public Producto buscarProducto(String nombre) {
        boolean flag = true;
        Iterator iterator = productos.getIterator();
        Producto aux = null;
        while (iterator.hasNext() && flag) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getNombre().equals(nombre) && productoaux.isDisponible() == true) {
                aux = productoaux;
                flag = false;
            }
        }
        return aux;
    }

    public void cargarDatos(Producto elemento)
    {
        productos.agregar(elemento);
    }

    public StringBuilder mostrarProductos()
    {
        return productos.mostrar();
    }





}
