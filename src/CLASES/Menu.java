package CLASES;

import ENUMERACION.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

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
            System.out.println("||--------------------------------||");
            System.out.println("||   1-Agregar Producto           ||");
            System.out.println("||   2-Buscar Producto            ||");
            System.out.println("||   3-Mostrar Productos          ||");
            System.out.println("||   4-Modificar Productos        ||");
            System.out.println("||--------------------------------||");
            System.out.println("||OPCIONES EMPLEADOS              ||");
            System.out.println("||   5-Menu Empleados             ||");
            System.out.println("||--------------------------------||");
            System.out.println("||   6-Salir                      ||");
            System.out.println("||--------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    menuAgregar(tienda);
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

                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=6);
        //dentro de un try catch
        //Guardar datos archivos
        //guarda datos en el json

    }

    private void menuMostrar(Tienda tienda)
    {
        int opcion=0;
        ArrayList<Producto> listaProductosOrdenados= new ArrayList<Producto>(tienda.getProductos().getSet());

        do {
            System.out.println("||----------------------------------------||");
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
                    //Metodo Mostrar por Stock


                    break;
                case 2:
                    System.out.println(tienda.mostrarProductos());
                    break;
                case 3:
                    //Metodo Mostrar Productos No Disponibles
                    break;
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

    private void menuEmpleados()
    {
        int opcion=0;
        do {
            System.out.println("||--------------------------------||");
            System.out.println("||   1-Agregar Empleado           ||");
            System.out.println("||   2-Buscar Empleado            ||");
            System.out.println("||   3-Mostrar Empleados          ||");
            System.out.println("||   4-Modificar Empleados        ||");
            System.out.println("||--------------------------------||");
            System.out.println("||   5-Salir                      ||");
            System.out.println("||--------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    //Metodo Agregar Empleado
                    break;
                case 2:
                    menuBuscarEmpleado();
                    break;
                case 3:
                    menuMostrarEmpleados();
                    break;
                case 4:
                    menuModificarEmpleados();
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);
    }

    private void menuBuscarEmpleado()
    {
        int opcion=0;
        do {
            System.out.println("||--------------------------------||");
            System.out.println("||   1-Buscar por ID              ||");
            System.out.println("||   2-Buscar por DNI             ||");
            System.out.println("||   3-Buscar por Nombre          ||");
            System.out.println("||   4-Buscar por Apellido        ||");
            System.out.println("||--------------------------------||");
            System.out.println("||   5-Salir                      ||");
            System.out.println("||--------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    //Metodo Buscar por ID
                    break;

                case 2:
                    //Metodo Buscar por DNI
                    break;

                case 3:
                    //Metodo Buscar por Nombre
                    break;
                case 4:
                    //Metodo Buscar por Apellido
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);

    }

    private void menuMostrarEmpleados()
    {
        int opcion=0;

        do {
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Mostrar por Nombre                 ||");
            System.out.println("||   2-Mostrar Empleados Activos          ||");
            System.out.println("||   3-Mostrar Empleados no Activos       ||");
            System.out.println("||   4-Mostrar Empleados por ID           ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   5-Salir                              ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    //Metodo Mostrar por Nombre
                    break;
                case 2:
                    //Metodo Mostrar Empleados Activos
                    break;
                case 3:
                    //Metodo Mostrar Empleados no Activos
                    break;
                case 4:
                    //Metodo Mostrar Empleados por ID
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);

    }

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
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String clas;
                    clas=("CLASICO");
                    producto=tienda.buscarProducto(clas);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
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
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String vaq;
                    vaq=("VAQUERO");
                    producto=tienda.buscarProducto(vaq);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 3:
                    String chino;
                    chino=("CHINO");
                    producto=tienda.buscarProducto(chino);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaPantalon();
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
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String largas;
                    largas=("LARGAS");
                    producto=tienda.buscarProducto(largas);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 3:
                    String trescuartos;
                    trescuartos=("TRESCUARTOS");
                    producto=tienda.buscarProducto(trescuartos);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
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
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
                        tienda.cargarDatos(producto);
                    }
                    break;
                case 2:
                    String sweater;
                    sweater=("SWEATER");
                    producto=tienda.buscarProducto(sweater);
                    if(producto!=null)
                    {
                        System.out.println("Ingrese el stock nuevo");
                        int stock=scan.nextInt();
                        tienda.sumarStock(stock,producto);
                    }
                    else
                    {
                        producto=cargaRemera();
                        tienda.cargarDatos(producto);
                    }
                    break;
            }
        }while (opcion!=3);
    }

    public Producto cargaPantalon()
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
        scan.nextLine();
        String color=scan.nextLine();
        NivelDeTalle talle=cargaTalle();
        ModeloPantalon modelo=cargaModeloPantalon();
        System.out.println("Ingrese el Tamaño de cintura");
        double tamañoCintura=scan.nextDouble();

        return new Pantalon(precio,stock,nombre,tipotela,color,talle,tamañoCintura,modelo);
    }

    public Producto cargaRemera()
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
        TipoEstiloRemera estilo=cargaEstiloRemera();
        NivelDeTalle talle=cargaTalle();
        System.out.println("Ingrese el Tipo de Cuello");
        scan.nextLine();
        String cuello=scan.nextLine();
        System.out.println("Ingrese mangas:");
        String mangas=scan.nextLine();

        return new Remera(precio,stock,nombre,tipotela,color,talle,cuello,mangas,estilo);
    }

    public Producto cargaBuzo()
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
        scan.nextLine();
        String color=scan.nextLine();
        TipoEstiloBuzo estilo=cargaEstiloBuzo();
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

        System.out.println("Tiene capucha: 1 para si 0 para no");
        int aux3=scan.nextInt();
        boolean bolsillo=false;
        if(aux==1)
        {
            bolsillo=true;
        }

        return new Buzo(precio,stock,nombre,tipotela,color,talle,capucha,cierre,bolsillo,estilo);
    }

    public Producto cargaMedia()
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
        scan.nextLine();
        String color=scan.nextLine();
        System.out.println("Es antideslizante: 1 para si 0 para no");
        int aux=scan.nextInt();
        boolean antideslizante=false;
        if(aux==1)
        {
            antideslizante=true;
        }
        MedidaMedia medidaMedia=cargaMedidaMedia();

        return new Media(precio,stock,nombre,tipotela,color,antideslizante,medidaMedia);
    }

    public TipoEstiloRemera cargaEstiloRemera()
    {
        TipoEstiloRemera tipo = null;
        int i=0;
        System.out.println("1- Oversize");
        System.out.println("2- Clasico");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=TipoEstiloRemera.OVERSIZE;
        } else if (i==2)
        {
            tipo=TipoEstiloRemera.CLASICO;
        }
        return tipo;
    }

    public TipoEstiloBuzo cargaEstiloBuzo()
    {
        TipoEstiloBuzo tipo = null;
        int i=0;
        System.out.println("1- SUDADERA");
        System.out.println("2- SWEATER");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=TipoEstiloBuzo.SUDADERA;
        } else if (i==2)
        {
            tipo=TipoEstiloBuzo.SWEATER;
        }
        return tipo;
    }

    public MedidaMedia cargaMedidaMedia()
    {
        MedidaMedia tipo = null;
        int i=0;
        System.out.println("1- Soquete");
        System.out.println("1- Larga");
        System.out.println("2- Tres Cuartos");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=MedidaMedia.SOQUETE;
        } else if (i==2)
        {
            tipo=MedidaMedia.LARGA;
        } else if (i==3)
        {
            tipo=MedidaMedia.TRESCUARTOS;
        }
        return tipo;
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

    public ModeloPantalon cargaModeloPantalon()
    {
        ModeloPantalon tipo = null;
        int i=0;
        System.out.println("1- Chino");
        System.out.println("1- Vaquero");
        System.out.println("2- Jogging");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=ModeloPantalon.CHINO;
        } else if (i==2)
        {
            tipo=ModeloPantalon.VAQUERO;
        } else if (i==3)
        {
            tipo=ModeloPantalon.JOGGING;
        }
        return tipo;
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


}
