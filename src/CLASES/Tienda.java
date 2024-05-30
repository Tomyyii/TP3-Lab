package CLASES;

import java.util.HashSet;
import java.util.Iterator;

public class Tienda {

    private String nombre;
    private ContenedorHashSetGenerico<Producto> Productos;

    public Tienda(String nombre, ContenedorHashSetGenerico<Producto> productos) {
        this.nombre = nombre;
        Productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ContenedorHashSetGenerico<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(ContenedorHashSetGenerico<Producto> productos) {
        Productos = productos;
    }


    public boolean Vender(String nombre)
    {
        HashSet<Producto> auxiliar=new HashSet<>();
        boolean flag=true;
        auxiliar=Productos.getSet();
        Iterator iterator=auxiliar.iterator();
        while (iterator.hasNext() && flag)
        {
            Producto productoaux= (Producto) iterator.next();
            if(productoaux.getNombre()==nombre && productoaux.isDisponible()==true)
            {
                productoaux.setDisponible(false);
                flag=false;
            }

        }
        return flag;
    }

    public Producto buscarProducto(String Nombre) {
        HashSet<Producto> auxiliar = new HashSet<>();
        boolean flag = true;
        auxiliar = Productos.getSet();
        Iterator iterator = auxiliar.iterator();
        Producto aux = null;
        while (iterator.hasNext() && flag) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getNombre() == nombre && productoaux.isDisponible() == true) {
                aux = productoaux;
                flag = false;
            }

        }
        return aux;
    }

    public void mostrarProductos()
    {
        HashSet<Producto> auxiliar=new HashSet<>();
        auxiliar=Productos.getSet();
        Iterator iterator= auxiliar.iterator();
        while (iterator.hasNext())
        {

        }
    }



}
