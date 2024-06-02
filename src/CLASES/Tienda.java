package CLASES;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Tienda {

    private String nombre;
    private ContenedorHashSetGenerico<Producto> productos;
    private ContenedorListaGenerica<Empleado> empleados;

    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ContenedorHashSetGenerico<>();
        this.empleados= new ContenedorListaGenerica<>();
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


    public ContenedorListaGenerica<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ContenedorListaGenerica<Empleado> empleados) {
        this.empleados = empleados;
    }

    public boolean Vender(String modelo) {
        boolean flag = false;
        Iterator iterator = productos.getIterator();
        while (iterator.hasNext() && flag == false) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getTipo().equals(modelo) && productoaux.isDisponible() == true) {
                if(productoaux.getStock()>0){
                    flag = true;
                    productoaux.setStock(productoaux.getStock()-1);
                    if(productoaux.getStock() == 0){
                        productoaux.setDisponible(false);
                    }
                }
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
            if (productoaux.getTipo().equals(modelo)) {
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

    public void cargarDatosEmpleado(Empleado elemento) {
        empleados.agregar(elemento);
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
            if(!aux.isDisponible()){
                rta += aux.toString();
            }
        }
        return rta;
    }

    public StringBuilder mostrarEmpleados()
    {
        return empleados.mostrar();
    }

    public String mostrarEmpleadosNoActivos()
    {
        String rta="";
        ArrayList<Empleado> list=empleados.getLista();
        for (Empleado empleado: list)
        {
            if(!empleado.isEstado())
            {
                rta+=empleado.toString();
            }
        }
        return rta;
    }

    public String mostrarEmpleadosActivos()
    {
        String rta="";
        for (Empleado empleado: empleados.getLista())
        {
            if(empleado.isEstado())
            {
                rta+=empleado.toString();
            }
        }
        return rta;
    }

    public Empleado buscarEmpleadoPorID(int id)
    {
        boolean flag=false;
        Empleado empleado=null;
        int i=0;
        while (i<empleados.size() && !flag)
        {
            empleado=empleados.get(i);
            if(empleado.getId()==id)
            {
                flag=true;
            }
            i++;
        }
        return empleado;
    }

    public Empleado buscarEmpleadoPorNombre(String nombre)
    {
        boolean flag=false;
        Empleado empleado=null;
        int i=0;
        while (i<empleados.size() && !flag)
        {
            empleado=empleados.get(i);
            if(empleado.getNombre().equals(nombre))
            {
                flag=true;
            }
            i++;
        }
        return empleado;
    }

    public Empleado buscarEmpleadoPorDNI(int DNI)
    {
        boolean flag=false;
        Empleado empleado=null;
        int i=0;
        while (i<empleados.size() && !flag)
        {
            empleado=empleados.get(i);
            if(empleado.getDni()==DNI)
            {
                flag=true;
            }
            i++;
        }
        return empleado;
    }

    public void modificarEstado(Empleado empleado,int opcion)
    {
        if(opcion==1)
        {
            empleado.setEstado(true);
        } else if (opcion==2)
        {
            empleado.setEstado(false);
        }
    }










}
