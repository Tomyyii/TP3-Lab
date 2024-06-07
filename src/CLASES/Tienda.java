package CLASES;

import JSON.Json;
import org.json.JSONException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Tienda extends Json {
    //VARIABLES
    private String nombre;
    private ContenedorHashSetGenerico<Producto> productos;
    private ContenedorListaGenerica<Empleado> empleados;

    //CONSTRUCTOR
    public Tienda(String nombre) {
        this.nombre = nombre;
        this.productos = new ContenedorHashSetGenerico<>();
        this.empleados = new ContenedorListaGenerica<>();
    }

    //GETTERS
    public String getNombre() {
        return nombre;
    }

    public ContenedorHashSetGenerico<Producto> getProductos() {
        return productos;
    }

    public ContenedorListaGenerica<Empleado> getEmpleados() {
        return empleados;
    }

    //SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProductos(ContenedorHashSetGenerico<Producto> productos) {
        this.productos = productos;
    }

    public void setEmpleados(ContenedorListaGenerica<Empleado> empleados) {
        this.empleados = empleados;
    }

    //METODOS PRODUCTOS
    public boolean Vender(String modelo) {//mandamos el modelo que deseamos vender
        boolean flag = false;
        Iterator iterator = productos.getIterator();
        while (iterator.hasNext() && flag == false) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getTipo().equals(modelo) && productoaux.isDisponible() == true) {
                if (productoaux.getStock() > 0) {
                    flag = true;
                    productoaux.setStock(productoaux.getStock() - 1);//si lo tenemos en stock le restamos uno
                    if (productoaux.getStock() == 0) {
                        productoaux.setDisponible(false);//si vendimos el ultimo cambiamos la disponibilidad
                    }
                }
            }
        }
        return flag;//retornamos true o false si se realizo la venta
    }

    public Producto buscarProducto(String modelo) {
        boolean flag = true;
        Iterator iterator = productos.getIterator();
        Producto aux = null;
        while (iterator.hasNext() && flag) {
            Producto productoaux = (Producto) iterator.next();
            if (productoaux.getTipo().equals(modelo)) {
                aux = productoaux;
                flag = false;//si se encuentra terminamos el while
            }
        }
        return aux;//retornamos el producto
    }

    public void modificarPrecio(double precio, String modelo) {
        Producto aux = buscarProducto(modelo);
        aux.setPrecio(precio);//solo se puede modificar el precio de los productos
    }

    public void sumarStock(int stockNuevo, Producto producto) {
        int suma = producto.getStock() + stockNuevo;
        producto.setStock(suma);
    }

    public String mostrarDisponibles() {
        String rta = "";
        Iterator iterator = productos.getIterator();//creamos terador del set de productos
        while (iterator.hasNext()) {
            Producto aux = (Producto) iterator.next();
            if (aux.isDisponible()) {//si el producto esta disponible entra al if
                rta += aux.toString();
            }
        }
        return rta;//retorna el toString de todos los productos disponibles
    }

    public String mostrarNoDisponibles() {
        String rta = "";
        Iterator iterator = productos.getIterator();
        while (iterator.hasNext()) {
            Producto aux = (Producto) iterator.next();
            if (!aux.isDisponible()) {//si el producto no esta disponible entra al if
                rta += aux.toString();
            }
        }
        return rta;//retorna el toString de todos los productos disponibles
    }

    //METODOS EMPLEADOS
    public String mostrarEmpleadosNoActivos() {
        String rta = "";
        ArrayList<Empleado> list = empleados.getLista();
        for (Empleado empleado : list) {
            if (!empleado.isEstado()) {
                rta += empleado.toString();
            }
        }
        return rta;
    }

    public String mostrarEmpleadosActivos() {
        String rta = "";
        for (Empleado empleado : empleados.getLista()) {
            if (empleado.isEstado())//si el estado es true entra
            {
                rta += empleado.toString();
            }
        }
        return rta;//retoran el toString de todos los empleados activos
    }

    public Empleado buscarEmpleadoPorID(int id)//pasamos el id a buscar por parametro
    {
        boolean flag = false;
        Empleado empleado = null;
        int i = 0;
        while (i < empleados.size() && !flag) {
            empleado = empleados.get(i);//guardamos en la variable empleado un empleado del arrayList
            if (empleado.getId() == id)//una vez encontrado el nombre cortamos el ciclo while
            {
                flag = true;
            }
            i++;
        }
        return empleado;
    }

    public Empleado buscarEmpleadoPorNombre(String nombre)//pasamos el nombre a buscar por parametro
    {
        boolean flag = false;
        Empleado empleado = null;
        int i = 0;
        while (i < empleados.size() && !flag) {
            empleado = empleados.get(i);//guardamos en la variable empleado un empleado del arrayList
            if (empleado.getNombre().equals(nombre))//una vez encontrado el nombre cortamos el ciclo while
            {
                flag = true;
            }
            i++;
        }
        return empleado;
    }

    public Empleado buscarEmpleadoPorDNI(int DNI)//pasamos el dni a buscar por parametro
    {
        boolean flag = false;
        Empleado empleado = null;
        int i = 0;
        while (i < empleados.size() && !flag) {
            empleado = empleados.get(i);//guardamos en la variable empleado un empleado de arrayList
            if (empleado.getDni() == DNI)//si coinciden con el dni buscado terminams el ciclo while
            {
                flag = true;
            }
            i++;
        }
        return empleado;
    }

    public void modificarEstado(Empleado empleado, int opcion)//pasamos por parametro el empleado a modificar
    {//solo se puede modificar el estado de los empleados
        if (opcion == 1) {
            empleado.setEstado(true);
        } else if (opcion == 2) {
            empleado.setEstado(false);
        }
    }

    public void agregarAcrhivoEmpleados() {
        ObjectOutputStream objectOutputStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("empleados.dat");//definimos el nombre del archivo
            objectOutputStream = new ObjectOutputStream(fileOutputStream);//instanciamos el objetOuputStream
            for (int i = 0; i < empleados.size(); i++) {//for para recorrer y grabar el arrayList de empleados
                objectOutputStream.writeObject(empleados.get(i));
            }
        } catch (FileNotFoundException ex)//exepciones de la carga del archivo
        {
            ex.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } finally {
            try {
                objectOutputStream.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    //METODOS DE ARCHIVOS
    public void leerArchivoEmpleados() {
        ObjectInputStream objectInputStream = null;
        try {
            FileInputStream fileInputStream = new FileInputStream("empleados.dat");//definimos el nombre del archivo a leer
            objectInputStream = new ObjectInputStream(fileInputStream);//instanciamos el objectImputStream

            while (true) {
                Empleado empleado = (Empleado) objectInputStream.readObject();//leemos el archivo
                System.out.println(empleado);
            }


        } catch (EOFException ex)//exepciones de la lectura de archivo
        {
            System.out.println("FIN");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                objectInputStream.close();
            } catch (IOException ex) {

            }
        }
    }

    //METODOS GENERICOS
    public void cargarDatos(Producto elemento) {
        productos.agregar(elemento);
    }

    public StringBuilder mostrarProductos() {
        return productos.mostrar();
    }

    public void cargarDatosEmpleado(Empleado elemento) {
        empleados.agregar(elemento);
    }

    public StringBuilder mostrarEmpleados() {
        return empleados.mostrar();
    }

    //metodos json
    public void cargarDatosEnJson() {
        jsonObAJsArray(productos.getIterator());
    }
    public void descargarDatosDeJson(){
        try{
            jsonAJava("productos",productos.getSet());
        }catch (JSONException e)
        {
            e.printStackTrace();
        }



    }
}
