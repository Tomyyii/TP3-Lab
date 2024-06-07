package CLASES;

import ENUMERACION.*;
import EXCEPCIONES.MiExcepcion;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Menu  {
    public static Scanner scan= new Scanner(System.in);


    public Menu() {
    }

    public void menuPrinc()
    {

        //Descarga desde el archivo y el json
        int opcion=0;
        Tienda tienda=new Tienda("Tiendita");
        tienda.descargarDatosDeJson();
        if(tienda.verificarSiEstaVacioArchivo()) {
            tienda.leerArchivoEmpleados();
        }
        try
        {
            do {
                System.out.println("||------------------------------------||");
                System.out.println("||           MENU PRINCIPAL           ||");
                System.out.println("||------------------------------------||");
                System.out.println("||   1-Agregar Producto               ||");
                System.out.println("||   2-Buscar Producto                ||");
                System.out.println("||   3-Mostrar Productos              ||");
                System.out.println("||   4-Modificar Precio Productos     ||");
                System.out.println("||   5-Vender productos               ||");
                System.out.println("||   6-Cambiar de Sucursal Productos  ||");
                System.out.println("||------------------------------------||");
                System.out.println("||          OPCIONES EMPLEADOS        ||");
                System.out.println("||   7-Menu Empleados                 ||");
                System.out.println("||------------------------------------||");
                System.out.println("||   8-Cerrar programa y Guardar      ||");
                System.out.println("||------------------------------------||");
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
                        if(buscado != null){
                            System.out.println("Producto encontrado:");
                            System.out.println(buscado);
                        }else{
                            System.out.println("Producto no encontrado");
                        }
                        break;

                    case 3:
                        menuMostrar(tienda);
                        break;
                    case 4:
                        try{

                            System.out.println("Ingrese el modelo del producto que desee modificar: ");
                            scan.nextLine();
                            String modelo = scan.nextLine();

                            System.out.println("Ingrese el nuevo precio:");
                            double precio = scan.nextDouble();
                            try{
                                tienda.modificarPrecio(precio,modelo);
                            }catch (MiExcepcion e) {
                                System.out.println("Solo se admiten precios positivos");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor ingrese un número válido para el precio.");
                            scan.next(); // Limpiar el valor incorrecto del escáner
                        }
                        break;
                    case 5:
                        try{
                            int flag=1;
                                try{
                                    while (flag==1) {
                                    System.out.println("Ingrese el modelo que desee vender ");
                                    scan.nextLine();
                                    String modelo1 = scan.nextLine();
                                        boolean vendido = tienda.Vender(modelo1);
                                        if (vendido) {
                                            System.out.println("Vendido con exito");
                                        } else {
                                            Producto producto=tienda.buscarProducto(modelo1);
                                            if(producto!=null)
                                            {
                                                System.out.println("Sin stock para la venta");
                                            }
                                            else {
                                                System.out.println("No se encontro el producto");
                                            }

                                        }
                                        System.out.println("Quiere vender otro producto? 1 si/ 0 no");
                                        flag=scan.nextInt();
                                    }
                                }catch (Exception e){
                                    System.out.println("Ocurrió un error al intentar vender el producto");
                                }
                        }catch (InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor intente nuevamente.");
                            scan.next(); // Limpiar el valor incorrecto del escáner
                        }
                        break;
                    case 6:
                        menuCambioSucursal(tienda);
                        break;
                    case 7:
                        menuEmpleados(tienda);
                        break;
                    case 8:
                        System.out.println("Saliendo del programa y guardando los cambios, ¡Hasta Pronto!");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            }while (opcion!=8);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
            scan.next();
        }


        //guarda datos(producto) en el json
        // guarda datos(empleados) en el archivo
        tienda.cargarDatosEnJson();
        tienda.agregarArchivoEmpleados();

    }

    private void menuMostrar(Tienda tienda)
    {
        int opcion=0;
        ArrayList<Producto> listaProductosOrdenados= new ArrayList<Producto>(tienda.getProductos().getSet());

        try {

            do {
                System.out.println("||----------------------------------------||");
                System.out.println("||           MENU MOSTRAR                 ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   1-Mostrar Productos                  ||");
                System.out.println("||   2-Mostrar por Stock                  ||");
                System.out.println("||   3-Mostrar Productos Disponibles      ||");
                System.out.println("||   4-Mostrar Productos No Disponibles   ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   5-Volver Atras                       ||");
                System.out.println("||----------------------------------------||");
                opcion = scan.nextInt();

                switch (opcion) {
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
                        break;
                    case 5:
                        System.out.println("Volviendo Atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 5);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten Opciones con numeros");
        }
    }

    private void menuAgregar(Tienda tienda)
    {
        int opcion=0;
        try {

            do {
                System.out.println("||----------------------------------------||");
                System.out.println("||       MENU AGREGAR PRODUCTOS           ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   1-Agregar un Pantalon                ||");
                System.out.println("||   2-Agregar una Remera                 ||");
                System.out.println("||   3-Agregar un Buzo                    ||");
                System.out.println("||   4-Agregar Medias                     ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   5-Volver Atras                       ||");
                System.out.println("||----------------------------------------||");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        menuAgregarPantalon(tienda);
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
                    case 5:
                        System.out.println("Volviendo Atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 5);
        }catch (InputMismatchException e )
        {
            System.out.println("Solo se admiten opciones con numeros");
        }

    }

    private void menuEmpleados(Tienda tienda)
    {
        int opcion=0;
        try {

            do {
                System.out.println("||--------------------------------||");
                System.out.println("||         MENU EMPLEADOS         ||");
                System.out.println("||--------------------------------||");
                System.out.println("||--------------------------------||");
                System.out.println("||   1-Agregar Empleado           ||");
                System.out.println("||   2-Buscar Empleado            ||");
                System.out.println("||   3-Mostrar Empleados          ||");
                System.out.println("||   4-Modificar Empleados        ||");
                System.out.println("||--------------------------------||");
                System.out.println("||   5-Salir                      ||");
                System.out.println("||--------------------------------||");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        int i = 1;
                        while (i == 1) {
                            AgregarEmpleado(tienda);
                            System.out.println("Quiere seguir agregando empleados? 1 si/ 0 no");
                            i = scan.nextInt();
                        }
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
                        System.out.println("Volviendo Atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 5);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }
    }

    private void menuBuscarEmpleado(Tienda tienda)
    {
        int opcion=0;
        try {
            do {
                System.out.println("||--------------------------------||");
                System.out.println("||      MENU BUSCAR EMPLEADO      ||");
                System.out.println("||--------------------------------||");
                System.out.println("||--------------------------------||");
                System.out.println("||   1-Buscar por ID              ||");
                System.out.println("||   2-Buscar por DNI             ||");
                System.out.println("||   3-Buscar por Nombre          ||");
                System.out.println("||--------------------------------||");
                System.out.println("||   4-Volver Atras               ||");
                System.out.println("||--------------------------------||");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        try {
                            System.out.println("Ingrese el id del empleado que desea buscar:");
                            int i = scan.nextInt();

                            try {
                                Empleado empleado = tienda.buscarEmpleadoPorID(i);
                                if (empleado != null) {
                                    System.out.println("EMPLEADO ENCONTRADO:");
                                    System.out.println(empleado);
                                } else {
                                    System.out.println("No se pudo encontrar el empleado con el id: " + i);
                                }
                            } catch (Exception e) {
                                System.out.println("Ocurrió un error al buscar el empleado.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Por favor ingrese un número entero válido.");
                            scan.next(); // Limpiar el valor incorrecto del escáner

                        }


                        break;

                    case 2:
                        System.out.println("Ingrese el dni del empleado que desea buscar:");
                        int dni = scan.nextInt();
                        Empleado empleado1 = tienda.buscarEmpleadoPorDNI(dni);
                        if (empleado1 != null) {
                            System.out.println("EMPLEADO ENCONTRADO:");
                            System.out.println(empleado1);
                        } else {
                            System.out.println("No se pudo encontrar el empleado con el dni: " + dni);
                        }
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre del empleado que desea buscar:");
                        scan.nextLine();
                        String nombre = scan.nextLine();
                        Empleado empleado2 = tienda.buscarEmpleadoPorNombre(nombre);
                        if (empleado2 != null) {
                            System.out.println("EMPLEADO ENCONTRADO:");
                            System.out.println(empleado2);
                        } else {
                            System.out.println("No se pudo encontrar el empleado con el nombre: " + nombre);
                        }
                        break;
                    case 4:
                        System.out.println("Volviendo Atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 4);
        } catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }

    }

    private void menuMostrarEmpleados(Tienda tienda)
    {
        int opcion=0;
        try {

            do {
                System.out.println("||----------------------------------------||");
                System.out.println("||         MENU MOSTRAR EMPLEADOS         ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   1-Mostrar Empleados                  ||");
                System.out.println("||   2-Mostrar Empleados Activos          ||");
                System.out.println("||   3-Mostrar Empleados no Activos       ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   4-Volver Atras                       ||");
                System.out.println("||----------------------------------------||");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        System.out.println(tienda.mostrarEmpleados());
                        break;
                    case 2:
                        System.out.println(tienda.mostrarEmpleadosActivos());
                        break;
                    case 3:
                        System.out.println(tienda.mostrarEmpleadosNoActivos());
                        break;
                    case 4:
                        System.out.println("Volviendo atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 4);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }

    }

    private void menuCambioSucursal(Tienda tienda)
    {
        int opcion=0;
        try {

            do {
                System.out.println("||----------------------------------------||");
                System.out.println("||   1-Cambiar Sucursal Empleado          ||");
                System.out.println("||   2-Cambiar Sucursal Producto          ||");
                System.out.println("||----------------------------------------||");
                System.out.println("||   3-Volver Atras                       ||");
                System.out.println("||----------------------------------------||");
                opcion = scan.nextInt();
                scan.nextLine();
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el empleado que desea cambiar de sucursal");
                        //scan.nextLine();
                        String nombre = scan.nextLine();
                        Empleado empleado = tienda.buscarEmpleadoPorNombre(nombre);
                        System.out.println("Ingrese a que sucursal desea enviar al empleado:");
                        System.out.println("1- CENTRO");
                        System.out.println("2- ALEM");
                        int opcion2 = scan.nextInt();
                        if (empleado != null) {
                            String ab = empleado.cambiarSucursal(opcion2);
                            System.out.println("EMPLEADO: " + empleado.getNombre() + ab);
                        } else {
                            System.out.println("No se encontro al empleado");
                        }
                        break;
                    case 2:
                        System.out.println("Ingrese el modelo de producto que desea cambiar de sucursal");
                        String modelo = scan.nextLine();
                        System.out.println(modelo);
                        Producto producto = tienda.buscarProducto(modelo);
                        System.out.println("Ingrese a que sucursal desea enviar el producto:");
                        System.out.println("1- CENTRO");
                        System.out.println("2- ALEM");
                        int opcion3 = scan.nextInt();
                        scan.nextLine();
                        if (producto != null) {
                            String ab = producto.cambiarSucursal(opcion3);
                            System.out.println("PRODUCTO: " + producto.getNombre() + " MODELO " + producto.getTipo() + ab);
                        } else {
                            System.out.println("No se encontro el producto");
                        }
                        break;
                    case 3:
                        System.out.println("Volviendo Atras");
                        break;
                    default:
                        System.out.println("Error, Intente nuevamente");
                        break;
                }
            } while (opcion != 3);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
            scan.nextLine();
        }
    }

        private void menuAgregarRemera(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        try {

            do {
                System.out.println("Que tipo de remera desea agregar?");
                System.out.println("1- OVERSIZE");
                System.out.println("2- CLASICO");
                System.out.println("3- Volver atras");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        String over;
                        over = ("OVERSIZE");
                        producto = tienda.buscarProducto(over);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaRemera(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 2:
                        String clas;
                        clas = ("CLASICO");
                        producto = tienda.buscarProducto(clas);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaRemera(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                }
            } while (opcion != 3);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }
    }

    private void menuAgregarPantalon(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        try {
            do {
                System.out.println("Que tipo de Pantalon desea agregar?");
                System.out.println("1- JOGGING");
                System.out.println("2- VAQUERO");
                System.out.println("3- CHINO");
                System.out.println("4- Volver atras");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        String jogg;
                        jogg = ("JOGGING");
                        producto = tienda.buscarProducto(jogg);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaPantalon(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 2:
                        String vaq;
                        vaq = ("VAQUERO");
                        producto = tienda.buscarProducto(vaq);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaPantalon(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 3:
                        String chino;
                        chino = ("CHINO");
                        producto = tienda.buscarProducto(chino);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaPantalon(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                }
            } while (opcion != 4);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }
    }

    private void menuAgregarMedia(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        try {

            do {
                System.out.println("Que tipo de Medias desea agregar?");
                System.out.println("1- SOQUETE");
                System.out.println("2- LARGAS");
                System.out.println("3- TRES CUARTOS");
                System.out.println("4- Volver atras");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        String soquete;
                        soquete = ("SOQUETE");
                        producto = tienda.buscarProducto(soquete);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaMedia(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 2:
                        String largas;
                        largas = ("LARGAS");
                        producto = tienda.buscarProducto(largas);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaMedia(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 3:
                        String trescuartos;
                        trescuartos = ("TRESCUARTOS");
                        producto = tienda.buscarProducto(trescuartos);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaMedia(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                }
            } while (opcion != 4);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }
    }

    private void menuAgregarBuzo(Tienda tienda)
    {
        int opcion=0;
        Producto producto=null;
        try {
            do {
                System.out.println("Que tipo de Buzo desea agregar?");
                System.out.println("1- SUDADERA");
                System.out.println("2- SWEATER");
                System.out.println("3- Volver atras");
                opcion = scan.nextInt();
                switch (opcion) {
                    case 1:
                        String sudadera;
                        sudadera = ("SUDADERA");
                        producto = tienda.buscarProducto(sudadera);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaBuzo(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                    case 2:
                        String sweater;
                        sweater = ("SWEATER");
                        producto = tienda.buscarProducto(sweater);
                        if (producto != null) {
                            if (!producto.isDisponible()) {
                                producto.setDisponible(true);
                            }
                            System.out.println("Ingrese el stock nuevo");
                            int stock = scan.nextInt();
                            tienda.sumarStock(stock, producto);
                        } else {
                            producto = cargaBuzo(opcion);
                            tienda.cargarDatos(producto);
                        }
                        break;
                }
            } while (opcion != 3);
        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
        }
    }


    private void menuModificarEstado(Tienda tienda)
    {
        int opcion=0;
        Empleado empleado=null;
        try {

                System.out.println("1- Modificar estado a activo");
                System.out.println("2- Modificar estado a inactivo");
                opcion = scan.nextInt();
                scan.nextLine();
                        System.out.println("Ingrese el nombre del empledo que desea modificar el estado:");
                        String nombre = scan.nextLine();
                        empleado = tienda.buscarEmpleadoPorNombre(nombre);

                        if(empleado == null){
                            System.out.println("Empleado no encotrado");
                        }else{
                            tienda.modificarEstado(empleado, opcion);
                            System.out.println("Empleado modificado con exito");
                        }

        }catch (InputMismatchException e)
        {
            System.out.println("Solo se admiten opciones con numeros");
            scan.nextLine();
        }
    }

    private Producto cargaPantalon(int opcion)
    {


        String nombre= ("Pantalon");

        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el Tipo de tela:");
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
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

    private Producto cargaRemera(int opcion)
    {

        String nombre= ("Remera");
        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el Tipo de tela:");
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
        scan.next();
        String cuello=scan.nextLine();
        System.out.println("Ingrese mangas:");
        String mangas=scan.nextLine();

        return new Remera(precio,stock,nombre,tipotela,color,talle,cuello,mangas,tipo);
    }

    private Producto cargaBuzo(int opcion)
    {

        String nombre= ("Buzo");

        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el Tipo de tela:");
        String tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
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

    private Producto cargaMedia(int opcion)
    {
        String tipotela;
        String color;
        String nombre=("Media");

        System.out.println("Ingrese el Precio:");
        double precio=scan.nextDouble();
        scan.nextLine();
        System.out.println("Ingrese el Stock:");
        int stock=scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el Tipo de tela:");
       // scan.next();
        tipotela=scan.nextLine();
        System.out.println("Ingrese el Color:");
       // scan.next();
        color=scan.nextLine();
        System.out.println(color);
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
        System.out.println(color);
        return new Media(precio,stock,nombre,tipotela,color,antideslizante,tipo);
    }


    private NivelDeTalle cargaTalle() {
        NivelDeTalle tipo = null;
        try {
            tipo = null;
            int i = 0;
            System.out.println("1- S");
            System.out.println("2- M");
            System.out.println("3- L");
            System.out.println("4- XL");
            i = scan.nextInt();
            if (i == 1) {
                tipo = NivelDeTalle.S;
            } else if (i == 2) {
                tipo = NivelDeTalle.M;
            } else if (i == 3) {
                tipo = NivelDeTalle.L;
            } else if (i == 4) {
                tipo = NivelDeTalle.XL;
            }
        } catch (InputMismatchException e) {
            System.out.println("Solo se admiten numeros");
        }
        return tipo;
    }

    private void AgregarEmpleado(Tienda tienda)
    {
        int opcion=0;
        Empleado empleado;
            System.out.println("1- REPOSITOR");
            System.out.println("2- CAJERO");
            opcion=scan.nextInt();
            try {
                empleado=cargarEmpleado(opcion,tienda.getEmpleados().size());
                tienda.cargarDatosEmpleado(empleado);
            }catch (MiExcepcion e)
            {
                System.out.println(e.getMessage());
            }
    }

    private Empleado cargarEmpleado(int opcion,int size) throws MiExcepcion {
        TipoEmpleado tipoEmpleado=null;
        System.out.println("Ingrese el nombre");
        scan.nextLine();
        String nombre=scan.nextLine();
        System.out.println("Ingrese el dni");
        int dni=scan.nextInt();
        if(dni<1000000 || dni >99999999)
        {
            throw new MiExcepcion("DOCUMENTO INVALIDO (entre 7 y 8 digitos)");
        }
        if(opcion==1)
        {
            tipoEmpleado=TipoEmpleado.REPOSITOR;
        } else if (opcion==2) {
            tipoEmpleado=TipoEmpleado.CAJERO;
        }
        return new Empleado(nombre,size+1,tipoEmpleado,true,dni);
    }

}
