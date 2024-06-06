package CLASES;

import ENUMERACION.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Menu  {
    Scanner scan=new Scanner(System.in);

    public Menu() {
    }

    public void menuPrinc()
    {

        //Descarga desde el archivo y el json
        int opcion=0;
        Tienda tienda=new Tienda("Tiendita");
        do {
            System.out.println("||           MENU PRINCIPAL         ||");
            System.out.println("||----------------------------------||");
            System.out.println("||   1-Agregar Producto             ||");
            System.out.println("||   2-Buscar Producto              ||");
            System.out.println("||   3-Mostrar Productos            ||");
            System.out.println("||   4-Modificar Precio Productos   ||");
            System.out.println("||   5-Vender productos             ||");
            System.out.println("||----------------------------------||");
            System.out.println("||          OPCIONES EMPLEADOS      ||");
            System.out.println("||   6-Menu Empleados               ||");
            System.out.println("||----------------------------------||");
            System.out.println("||   7-Cerrar programa              ||");
            System.out.println("||----------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    menuAgregar(tienda);
                    System.out.println("OPCION:"+opcion);
                    break;

                case 2:
                    System.out.println("Que producto desea buscar (ingrese el modelo):");
                    scan.nextLine();
                    String aux=scan.nextLine();
                    Producto buscado=tienda.buscarProducto(aux);
                    System.out.println(systemCLS());
                    System.out.println("Producto encontrado:");
                    System.out.println(buscado);
                    break;

                case 3:
                    menuMostrar(tienda);
                    break;
                case 4:
                    System.out.println("Ingrese el modelo que desee modificar: ");
                    scan.next();
                    String modelo = scan.nextLine();
                    System.out.println("Ingrese el nuevo precio:");
                    double precio = scan.nextDouble();
                    tienda.modificarPrecio(precio,modelo);
                    break;
                case 5:
                    System.out.println("Ingrese el modelo que desee vender ");
                    scan.nextLine();
                    String modelo1 = scan.nextLine();
                    boolean vendido =tienda.Vender(modelo1);
                    if(vendido){
                        System.out.println("Vendido con exito");
                    }
                    else{
                        System.out.println("Sin stock para la venta");
                    }
                    break;
                case 6:
                    menuEmpleados(tienda);
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=7);
        //dentro de un try catch
        //guarda datos(producto) en el json
        tienda.cargarDatosEnJson();

    }

    private void menuMostrar(Tienda tienda)
    {
        int opcion=0;
        ArrayList<Producto> listaProductosOrdenados= new ArrayList<Producto>(tienda.getProductos().getSet());

        do {
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Mostrar Productos                  ||");
            System.out.println("||   1-Mostrar por Stock                  ||");
            System.out.println("||   2-Mostrar Productos Disponibles      ||");
            System.out.println("||   3-Mostrar Productos No Disponibles   ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   4-Salir                              ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();

            switch (opcion)
            {
                case 1:
                    System.out.println(tienda.mostrarProductos());
                    break;
                case 2:
                    Collections.sort(listaProductosOrdenados, new Comparator<Producto>() {
                        @Override
                        public int compare(Producto o1, Producto o2) {
                            int aux = 0;
                            if (o1.getStock() > o2.getStock()) {
                                aux = 1;
                            } else if (o1.getStock() < o2.getStock()) {
                                aux = -1;
                            }
                            return aux;
                        }
                    });
                    System.out.println("LISTADOS POR STOCK:");
                    System.out.println(listaProductosOrdenados);
                    break;
                case 3:
                    System.out.println(tienda.mostrarDisponibles());
                    break;
                case 4:
                    System.out.println(tienda.mostrarNoDisponibles());
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=4);
    }

    private void menuAgregar(Tienda tienda)
    {
        int opcion=0;
        do {
            System.out.println(systemCLS());
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Agregar un Pantalon                ||");
            System.out.println("||   2-Agregar una Remera                 ||");
            System.out.println("||   3-Agregar un Buzo                    ||");
            System.out.println("||   4-Agregar Medias                     ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   5-Salir                              ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion){
                case 1:

                    menuAgregarPantalon(tienda);
                    /*try {
                        producto=CargaPantalon();
                    } catch (ExceptionEjemplo e) {
                        e.getMessage();
                    }*/
                    break;
                case 2:
                    menuAgregarRemera(tienda);
                    break;
                case 3:
                    menuAgregarBuzo(tienda);
                    break;
                case 4:
                    menuAgregarMedia(tienda);
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);

    }

    private void menuEmpleados(Tienda tienda)
    {
        int opcion=0;
        do {
            System.out.println("||--------------------------------||");
            System.out.println("||   1-Agregar Empleado           ||");
            System.out.println("||   2-Buscar Empleado            ||");
            System.out.println("||   3-Mostrar Empleados          ||");
            System.out.println("||   4-Modificar Empleados        ||");
            System.out.println("||   5-Cargar empleados en archivo||");
            System.out.println("||   6-Mostrar archivo cargado    ||");
            System.out.println("||--------------------------------||");
            System.out.println("||   7-Salir                      ||");
            System.out.println("||--------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    menuAgregarEmpleado(tienda);
                    break;
                case 2:
                    menuBuscarEmpleado(tienda);
                    break;
                case 3:
                    menuMostrarEmpleados(tienda);
                    break;
                case 4:
                    menuModificarEstado(tienda);
                    break;
                case 5:
                    archivarEmpleados(tienda);
                    break;
                case 6:
                    leerArchivo(tienda);
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=7);
    }

    private void menuBuscarEmpleado(Tienda tienda)
    {
        int opcion=0;
        do {
            System.out.println("||--------------------------------||");
            System.out.println("||   1-Buscar por ID              ||");
            System.out.println("||   2-Buscar por DNI             ||");
            System.out.println("||   3-Buscar por Nombre          ||");
            System.out.println("||--------------------------------||");
            System.out.println("||   4-Salir                      ||");
            System.out.println("||--------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println("Ingrese el id del empleado que desea buscar:");
                    int i= scan.nextInt();
                    Empleado empleado=tienda.buscarEmpleadoPorID(i);
                    if(empleado!=null)
                    {
                        System.out.println("EMPLEADO ENCONTRADO:");
                        System.out.println(empleado);
                    }
                    else
                    {
                        System.out.println("No se pudo encontrar el empleado con el id: " + i);
                    }

                    break;

                case 2:
                    System.out.println("Ingrese el dni del empleado que desea buscar:");
                    int dni=scan.nextInt();
                    Empleado empleado1=tienda.buscarEmpleadoPorDNI(dni);
                    if(empleado1!=null)
                    {
                        System.out.println("EMPLEADO ENCONTRADO:");
                        System.out.println(empleado1);
                    }
                    else
                    {
                        System.out.println("No se pudo encontrar el empleado con el dni: " + dni);
                    }
                    break;

                case 3:
                    System.out.println("Ingrese el nombre del empleado que desea buscar:");
                    String nombre=scan.nextLine();
                    Empleado empleado2=tienda.buscarEmpleadoPorNombre(nombre);
                    if(empleado2!=null)
                    {
                        System.out.println("EMPLEADO ENCONTRADO:");
                        System.out.println(empleado2);
                    }
                    else
                    {
                        System.out.println("No se pudo encontrar el empleado con el nombre: " + nombre);
                    }
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=4);

    }

    private void menuMostrarEmpleados(Tienda tienda)
    {
        int opcion=0;

        do {
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Mostrar Empleados                  ||");
            System.out.println("||   2-Mostrar Empleados Activos          ||");
            System.out.println("||   3-Mostrar Empleados no Activos       ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   4-Salir                              ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println(tienda.mostrarEmpleados());
                    break;
                case 2:
                    System.out.println(tienda.mostrarEmpleadosActivos());
                    break;
                case 3:
                    System.out.println(tienda.mostrarEmpleadosNoActivos());
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=4);

    }
    /*
    private void menuModificarEmpleados()
    {
        int opcion=0;
        do {
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Modificar Nombre                   ||");
            System.out.println("||   2-Modificar Apellido                 ||");
            System.out.println("||   3-Modificar DNI                      ||");
            System.out.println("||   4-Modificar ...                      ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   5-Volver                             ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    //Metodo Modificar Nombre
                    break;
                case 2:
                    //Metodo Modificar Apellido
                    break;
                case 3:
                    //Metodo Modificar DNI
                    break;
                case 4:
                    //Metodo Modificar ...
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);

    }

     */

    private void menuAgregarRemera(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        do {
            System.out.println("Que tipo de remera desea agregar?");
            System.out.println("1- OVERSIZE");
            System.out.println("2- CLASICO");
            System.out.println("3- Volver atras");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    String over;
                    over=("OVERSIZE");
                    producto=tienda.buscarProducto(over);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String clas;
                    clas=("CLASICO");
                    producto=tienda.buscarProducto(clas);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
            }
        }while (opcion!=3);
    }

    private void menuAgregarPantalon(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        do {
            System.out.println("Que tipo de Pantalon desea agregar?");
            System.out.println("1- JOGGING");
            System.out.println("2- VAQUERO");
            System.out.println("3- CHINO");
            System.out.println("4- Volver atras");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    String jogg;
                    jogg=("JOGGING");
                    producto=tienda.buscarProducto(jogg);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String vaq;
                    vaq=("VAQUERO");
                    producto=tienda.buscarProducto(vaq);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 3:
                    String chino;
                    chino=("CHINO");
                    producto=tienda.buscarProducto(chino);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
            }
        }while (opcion!=4);
    }

    private void menuAgregarMedia(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        do {
            System.out.println("Que tipo de Medias desea agregar?");
            System.out.println("1- SOQUETE");
            System.out.println("2- LARGAS");
            System.out.println("3- TRES CUARTOS");
            System.out.println("4- Volver atras");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    String soquete;
                    soquete=("SOQUETE");
                    producto=tienda.buscarProducto(soquete);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaMedia(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String largas;
                    largas=("LARGAS");
                    producto=tienda.buscarProducto(largas);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 3:
                    String trescuartos;
                    trescuartos=("TRESCUARTOS");
                    producto=tienda.buscarProducto(trescuartos);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
            }
        }while (opcion!=4);
    }

    private void menuAgregarBuzo(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        do {
            System.out.println("Que tipo de Buzo desea agregar?");
            System.out.println("1- SUDADERA");
            System.out.println("2- SWEATER");
            System.out.println("3- Volver atras");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    String sudadera;
                    sudadera=("SUDADERA");
                    producto=tienda.buscarProducto(sudadera);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaBuzo(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String sweater;
                    sweater=("SWEATER");
                    producto=tienda.buscarProducto(sweater);
                    if(producto!=null)
                    {
                        if(!producto.isDisponible())
                        {
                            producto.setDisponible(true);
                        }
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaBuzo(opcion);
                        tienda.cargarDatos(producto);
                    }
                    break;
            }
        }while (opcion!=3);
    }


    private void menuModificarEstado(Tienda tienda)
    {
        int opcion=0;
        Empleado empleado=null;
        do {
            System.out.println("1- Modificar estado a activo");
            System.out.println("2- Modificar estado a inactivo");
            System.out.println("3- Volver atras");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println("Ingrese el nombre del empledo que desea modificar el estado:");
                    scan.nextLine();
                    String nombre=scan.nextLine();
                    empleado=tienda.buscarEmpleadoPorNombre(nombre);
                    tienda.modificarEstado(empleado,opcion);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del empledo que desea modificar el estado:");
                    scan.nextLine();
                    String nombre1=scan.nextLine();
                    empleado=tienda.buscarEmpleadoPorNombre(nombre1);
                    tienda.modificarEstado(empleado,opcion);
                    break;
            }
        }while (opcion!=3);
    }

    public Producto cargaPantalon(int opcion)
    {


        String nombre= ("Pantalon");
        /*if(nombre.equals(""))
        {
            throw new ExceptionEjemplo("El nombre no puede ser vacio");
        }*/
        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        System.out.println("Ingrese el Tipo de tela:");
        scan.nextLine();
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
        //scan.nextLine();
        String color=scan.nextLine();
        NivelDeTalle talle=cargaTalle();
        ModeloPantalon tipo = null;
        if(opcion==1)
        {
            tipo=ModeloPantalon.CHINO;
        } else if (opcion==2)
        {
            tipo=ModeloPantalon.VAQUERO;
        } else if (opcion==3)
        {
            tipo=ModeloPantalon.JOGGING;
        }
        System.out.println("Ingrese el Tamaño de cintura");
        double tamañoCintura=scan.nextDouble();

        return new Pantalon(precio,stock,nombre,tipotela,color,talle,tamañoCintura,tipo);
    }

    public Producto cargaRemera(int opcion)
    {


        String nombre= ("Remera");
        /*if(nombre.equals(""))
        {
            throw new ExceptionEjemplo("El nombre no puede ser vacio");
        }*/
        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        System.out.println("Ingrese el Tipo de tela:");
        scan.nextLine();
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
        String color=scan.nextLine();
        TipoEstiloRemera tipo = null;
        if(opcion==1)
        {
            tipo=TipoEstiloRemera.OVERSIZE;
        } else if (opcion==2)
        {
            tipo=TipoEstiloRemera.CLASICO;
        }
        NivelDeTalle talle=cargaTalle();
        System.out.println("Ingrese el Tipo de Cuello");
        scan.nextLine();
        String cuello=scan.nextLine();
        System.out.println("Ingrese mangas:");
        String mangas=scan.nextLine();

        return new Remera(precio,stock,nombre,tipotela,color,talle,cuello,mangas,tipo);
    }

    public Producto cargaBuzo(int opcion)
    {

        String nombre= ("Buzo");
        /*if(nombre.equals(""))
        {
            throw new ExceptionEjemplo("El nombre no puede ser vacio");
        }*/
        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        System.out.println("Ingrese el Tipo de tela:");
        scan.nextLine();
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
        //scan.nextLine();
        String color=scan.nextLine();
        TipoEstiloBuzo tipo = null;
        if(opcion==1)
        {
            tipo=TipoEstiloBuzo.SUDADERA;
        } else if (opcion==2)
        {
            tipo=TipoEstiloBuzo.SWEATER;
        }
        NivelDeTalle talle=cargaTalle();
        System.out.println("Tiene capucha: 1 para si 0 para no");
        int aux=scan.nextInt();
        boolean capucha=false;
        if(aux==1)
        {
            capucha=true;
        }

        System.out.println("Tiene cierre: 1 para si 0 para no");
        int aux2=scan.nextInt();
        boolean cierre=false;
        if(aux==1)
        {
            cierre=true;
        }

        System.out.println("Tiene bolsillo: 1 para si 0 para no");
        int aux3=scan.nextInt();
        boolean bolsillo=false;
        if(aux==1)
        {
            bolsillo=true;
        }

        return new Buzo(precio,stock,nombre,tipotela,color,talle,capucha,cierre,bolsillo,tipo);
    }

    public Producto cargaMedia(int opcion)
    {

        String nombre=("Media");
        /*if(nombre.equals(""))
        {
            throw new ExceptionEjemplo("El nombre no puede ser vacio");
        }*/
        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        System.out.println("Ingrese el Tipo de tela:");
        scan.nextLine();
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
       // scan.nextLine();
        String color=scan.nextLine();
        System.out.println("Es antideslizante: 1 para si 0 para no");
        int aux=scan.nextInt();
        boolean antideslizante=false;
        if(aux==1)
        {
            antideslizante=true;
        }
        MedidaMedia tipo=null;
        if(opcion==1)
        {
            tipo=MedidaMedia.SOQUETE;
        } else if (opcion==2)
        {
            tipo=MedidaMedia.LARGA;
        } else if (opcion==3)
        {
            tipo=MedidaMedia.TRESCUARTOS;
        }

        return new Media(precio,stock,nombre,tipotela,color,antideslizante,tipo);
    }


    public NivelDeTalle cargaTalle()
    {
        NivelDeTalle tipo = null;
        int i=0;
        System.out.println("1- S");
        System.out.println("2- M");
        System.out.println("3- L");
        System.out.println("4- XL");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=NivelDeTalle.S;
        } else if (i==2)
        {
            tipo=NivelDeTalle.M;
        } else if (i==3)
        {
            tipo=NivelDeTalle.L;
        } else if (i==4)
        {
            tipo=NivelDeTalle.XL;
        }
        return tipo;
    }


    public void menuAgregarEmpleado(Tienda tienda)
    {
        int opcion=0;
        Empleado empleado;
        do {
            System.out.println("1- REPOSITOR");
            System.out.println("2- CAJERO");
            System.out.println("3- Salir");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                   empleado=cargarEmpleado(opcion,tienda.getEmpleados().size());
                   tienda.cargarDatosEmpleado(empleado);
                    break;
                case 2:
                    empleado=cargarEmpleado(opcion,tienda.getEmpleados().size());
                    tienda.cargarDatosEmpleado(empleado);
                    break;
            }
        }while (opcion!=3);
    }

    public Empleado cargarEmpleado(int opcion,int size)
    {
        TipoEmpleado tipoEmpleado=null;
        System.out.println("Ingrese el nombre");
        scan.nextLine();
        String nombre=scan.nextLine();
        System.out.println("Ingrese el dni");
        int dni=scan.nextInt();
        if(opcion==1)
        {
            tipoEmpleado=TipoEmpleado.REPOSITOR;
        } else if (opcion==2) {
            tipoEmpleado=TipoEmpleado.CAJERO;
        }
        return new Empleado(nombre,size+1,tipoEmpleado,true,dni);
    }







    public String systemCLS()
    {
        String system;
        system=("\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n");
        return system;
    }
   /* public void  grabarArchivoEmpleados () {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream();
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("Empleados.dat");
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for(int i=0;i<)
        }
    }*/
    public void archivarEmpleados(Tienda tienda){
        tienda.agregarAcrhivoEmpleados();
    }
    public void leerArchivo(Tienda tienda){
        tienda.leerArchivoEmpleados();
    }

}
