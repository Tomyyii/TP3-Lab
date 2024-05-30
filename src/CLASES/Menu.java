package CLASES;

import ENUMERACION.MedidaMedia;
import ENUMERACION.ModeloPantalon;
import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;
import EXCEPCIONES.ExceptionEjemplo;

import java.util.Scanner;

public class Menu {
    Scanner scan=new Scanner(System.in);

//mini menu ¿que tipo de media?


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
                    Producto producto=menuAgregar();
                    tienda.cargarDatos(producto);
                    break;

                case 2:

                    break;

                case 3:
                    menuMostrar();
                    break;
                case 4:
                    //menuModificar();
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


    private void menuMostrar()
    {
        int opcion=0;

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
                    //Metodo Mostrar por Stock
                    break;
                case 2:
                    //Metodo Mostrar Productos Disponibles
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

    private void menuModificar()
    {
        int opcion=0;
        do {
            System.out.println("||----------------------------------------||");
            System.out.println("||   1-Modificar Nombre                   ||");
            System.out.println("||   2-Modificar Precio                   ||");
            System.out.println("||   3-Modificar Color                    ||");
            System.out.println("||   4-Modificar Tipo de tela             ||");
            System.out.println("||----------------------------------------||");
            System.out.println("||   5-Salir                              ||");
            System.out.println("||----------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    //Metodo Modificar Nombre
                    break;
                case 2:
                    //Metodo Modificar Precio
                    break;
                case 3:
                    //Metodo Modificar color
                    break;
                case 4:
                    //Metodo Modificar tipo de tela
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);
    }


    private Producto menuAgregar()
    {
        int opcion=0;
        Producto producto=null;
        do {
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

                    try {
                        producto=CargaPantalon();
                    } catch (ExceptionEjemplo e) {
                        e.getMessage();
                    }
                    break;
                case 2:
                    //Metodo Agregar Remera
                    break;
                case 3:
                    //Metodo Agregar Buzo
                    break;
                case 4:
                    //Agregar Medias
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=5);
        return producto;

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
            System.out.println("||   5-Salir                              ||");
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

    public Producto CargaPantalon()throws ExceptionEjemplo
    {


        System.out.println("Ingrese el Nombre:");
        String nombre= scan.nextLine();
        if(nombre.equals(""))
        {
            throw new ExceptionEjemplo("El nombre no puede ser vacio");
        }

        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        System.out.println("Ingrese el Estado:");
        String estado=scan.nextLine();
        System.out.println("Ingrese el Tipo de tela:");
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
        String color=scan.nextLine();
        TipoEstilo estilo=cargaEstilo();
        NivelDeTalle talle=cargaTalle();
        ModeloPantalon modelo=cargaModeloPantalon();
        System.out.println("Ingrese el Tamaño de cintura");
        double tamañoCintura=scan.nextDouble();

        return new Pantalon(precio,stock,estado,nombre,tipotela,color,estilo,talle,tamañoCintura,modelo);
    }

    public TipoEstilo cargaEstilo()
    {
        TipoEstilo tipo = null;
        int i=0;
        System.out.println("1- Oversize");
        System.out.println("2- Clasico");
        i=scan.nextInt();
        if(i==1)
        {
            tipo=TipoEstilo.OVERSIZE;
        } else if (i==2)
        {
            tipo=TipoEstilo.CLASICO;
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


}
