package CLASES;

public class Cliente {

    private int id;
    private int dni;
    private String nombre;
    private String usuario;
    private String contrasena;
    private String domicilio;
    private ContenedorHashSetGenerico<Tarjeta> mediosDePago;
    private ContenedorListaGenerica<Cupon> cupones;
    private int nivel;
    private int cantCompras;

    public Cliente(int id, int dni, String nombre, String usuario, String contrasena, String domicilio) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.domicilio = domicilio;
        this.mediosDePago = new ContenedorHashSetGenerico<>();
        this.cupones = new ContenedorListaGenerica<>();
        this.cantCompras=0;
        nivel=0;
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

    public ContenedorHashSetGenerico<Tarjeta> getMediosDePago() {
        return mediosDePago;
    }

    public ContenedorListaGenerica<Cupon> getCupones() {
        return cupones;
    }

    public void setMediosDePago(ContenedorHashSetGenerico<Tarjeta> mediosDePago) {
        this.mediosDePago = mediosDePago;
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

    public int getCantCompras() {
        return cantCompras;
    }

    public void setCantCompras(int cantCompras) {
        this.cantCompras = cantCompras;
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



}
