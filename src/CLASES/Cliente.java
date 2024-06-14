package CLASES;

import INTERFACES.IAccionesEmpleadosClientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Cliente implements Serializable,IAccionesEmpleadosClientes {

    private int id;
    private int dni;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String domicilio;
    private ContenedorHashSetGenerico<Tarjeta> tarjetas;
    private ContenedorListaGenerica<Cupon> cupones;
    private int nivel;
    private ContenedorListaGenerica<Producto> compras;

    public Cliente(int id, int dni, String nombre, String usuario, String contrasena, String domicilio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.domicilio = domicilio;
        this.tarjetas = new ContenedorHashSetGenerico<>();
        this.cupones = new ContenedorListaGenerica<>();
        nivel=0;
        compras=new ContenedorListaGenerica<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int cantidadDeCompras()
    {
        return compras.size();
    }
    public void agregarCupones(Cupon cupon)
    {
        cupones.agregar(cupon);
    }

    public ContenedorHashSetGenerico<Tarjeta> getMediosDePago() {
        return tarjetas;
    }

    public ContenedorListaGenerica<Cupon> getCupones() {
        return cupones;
    }

    public void setMediosDePago(ContenedorHashSetGenerico<Tarjeta> mediosDePago) {
        this.tarjetas = mediosDePago;
    }

    public void setCupones(ContenedorListaGenerica<Cupon> cupones) {
        this.cupones = cupones;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    @Override
    public String toString() {
        return "\nCliente{" +
                "id=" + id +
                ", dni=" + dni +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", domicilio='" + domicilio +
                ", nivel=" + nivel+
                '}';
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        boolean aux = false;
        if(obj != null){
            if(obj instanceof Cliente){
                Cliente clienteAagregar = (Cliente) obj;
                if(clienteAagregar.getDni()==getDni()){
                    aux = true;
                }
            }
        }
        return aux;
    }


    @Override
    public StringBuilder verHistorialDeCompras(Cliente cliente) {
        return cliente.compras.mostrar();
    }

    @Override
    public StringBuilder verProductos(Tienda tienda) {
        return tienda.mostrarProductos();
    }

    @Override
    public StringBuilder verCuponesDisponibles(Cliente cliente){
        return cliente.cupones.mostrar();
    }

    public StringBuilder verCartera()
    {
        return tarjetas.mostrar();
    }

    public void sumarCompra(Producto producto)
    {
        compras.agregar(producto);
    }

    public StringBuilder verMediosDePago()
    {
        return tarjetas.mostrar();
    }

    public void eliminarTarjeta(String nombreTarjeta)
    {
        Tarjeta tarjeta=buscarTarjetaPorNombre(nombreTarjeta);
        tarjetas.eliminar(tarjeta);
    }

    public void agregarMedioDePago(Tarjeta tarjeta)
    {
        tarjetas.agregar(tarjeta);
    }



    public Tarjeta buscarTarjetaPorNombre(String nombre)
    {
        Tarjeta aux=null;
        boolean flag=false;
        Iterator iterator=tarjetas.getIterator();
        while (iterator.hasNext() && !flag)
        {
            Tarjeta tarjeta= (Tarjeta) iterator.next();
            if(tarjeta.getNombreTarjeta().equals(nombre))
            {
                aux=tarjeta;
                flag=true;
            }
        }
        return aux;
    }

    public boolean comprar(Producto producto,String nombreTarjeta)
    {
        boolean rta=false;
        Tarjeta tarjeta=buscarTarjetaPorNombre(nombreTarjeta);
        if(tarjeta!=null)
        {
            if(producto.isDisponible())
            {
                if(tarjeta.getMontoTarjeta()>=producto.getPrecio())
                {
                    tarjeta.setMontoTarjeta(tarjeta.getMontoTarjeta()-(int)producto.getPrecio());
                    compras.agregar(producto);
                    producto.setStock(producto.getStock()-1);
                    producto.setCantidadVendida(producto.getCantidadVendida()+1);
                }
            }
        }
        return rta;
    }

    public double comprarDos(ArrayList<Producto> productos)
    {
        double TOTAL=0;
        Producto aux=null;
        if(!productos.isEmpty())
        {
            for (int i = 0; i<productos.size(); i++)
            {
                aux=productos.get(i);
                compras.agregar(aux);
                productos.get(i).setStock(productos.get(i).getStock()-1);
                productos.get(i).setCantidadVendida(productos.get(i).getCantidadVendida()+1);
                TOTAL=TOTAL+productos.get(i).getPrecio();
            }
        }
        return TOTAL;
    }

    public Cupon buscarCupon(int tipo)
    {
        boolean flag=false;
        Cupon cupon=null;
        for (int i=0;i<cupones.size();i++)
        {
            if(cupones.get(i).getTipoCupon()==tipo)
            {
                cupon=cupones.get(i);
                flag=true;
            }
        }
        return cupon;
    }

}
