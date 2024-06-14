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

    public void menuLogin() {
        //descarga archivo clientes
        //descarga archivo empleados
        //descarga JSON productos

        Tienda tienda = new Tienda("Tiendita");
        tienda.descargarDatosDeJson();
        Empleado empleado = new Empleado("ADMIN", 0, TipoEmpleado.ADMINISTRADOR, true, 11111111, "ADMIN", "12345");
        if(!tienda.buscarEmpleadoPorDNIBoolean(11111111))
        {
            tienda.cargarDatosEmpleado(empleado);
        }


        if(tienda.verificarSiEstaVacioArchivo()) {
            tienda.leerArchivoEmpleados();
        }
        if(tienda.verificarSiEstaVacioArchivoClientes())
        {
            tienda.leerArchivoClientes();
        }


        int opcion=0;
        String usuario;
        String contrasena;
        do {
            System.out.println("||------------------------------------||");
            System.out.println("||               LOGIN                ||");
            System.out.println("||------------------------------------||");
            System.out.println("|| 1- Ingresar como usuario           ||");
            System.out.println("|| 2- Ingresar como empleado          ||");
            System.out.println("|| 3- Ingresar como administrador     ||");
            System.out.println("|| 4- Salir                           ||");
            System.out.println("||------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    menuClienteLogin(tienda);
                    break;
                case 2:
                    System.out.println("|| USUARIO:    ");
                    scan.nextLine();
                    usuario=scan.nextLine();
                    System.out.println("|| CONTRASEÑA:  ");
                    contrasena=scan.nextLine();

                    if (tienda.verificarUsuarioEmpleado(usuario,contrasena))
                    {
                        Empleado empleado1=tienda.buscarEmpleadoPorUsuario(usuario);
                        menuEmpleadosVendedor(tienda,empleado1);
                    }
                    else{
                        System.out.println("Error usuario o contraseña mal ingresados, vuelva a intentarlo");
                    }
                    break;
                case 3:
                    System.out.println("|| USUARIO:    ");
                    scan.nextLine();
                    usuario=scan.nextLine();
                    System.out.println("|| CONTRASEÑA:  ");
                    contrasena=scan.nextLine();
                    if (tienda.verificarUsuarioAdministrador(usuario,contrasena))
                    {
                        menuPrincAdmin(tienda);
                    }
                    else{
                        System.out.println("Error usuario o contraseña mal ingresados, vuelva a intentarlo");
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del programa y guardando los cambios, ¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Error, intente nuevamente");
                    break;
            }

        }while (opcion!=4);

        //guarda datos(producto) en el json
        // guarda datos(empleados) en el archivo
        tienda.cargarDatosEnJson();
        tienda.agregarArchivoEmpleados();
        tienda.agregarArchivoClientes();

    }

    private void menuClienteLogin(Tienda tienda)
    {
        int opcion=0;
        boolean flag=true;
        String usuario;
        Cliente cliente;
        String contrasena;
        do {
            System.out.println("||------------------------------------||");
            System.out.println("|| 1- Iniciar sesion                  ||");
            System.out.println("|| 2- Registrarse                     ||");
            System.out.println("|| 3- Volver Atras                    ||");
            System.out.println("||------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println("|| USUARIO:    ");
                    scan.nextLine();
                    usuario=scan.nextLine();
                    System.out.println("|| CONTRASEÑA:  ");
                    contrasena=scan.nextLine();
                    if(tienda.verificarUsuarioCliente(usuario,contrasena))
                    {
                        cliente=tienda.buscarClientePorUsuario(usuario);
                        menuCliente(tienda,cliente);
                    }
                    else
                    {
                        System.out.println("El usuario y/o contraseña estan mal, vuelva a intentarlo");
                    }
                    break;
                case 2:
                    while(flag) {
                        try {
                            cliente = cargaCliente(tienda.getClientes().size());
                            tienda.cargarDatosCliente(cliente);
                            flag=false;
                        } catch (MiExcepcion e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 3:
                    System.out.println("Volviendo atras...");
                    break;
                default:
                    System.out.println("Error, intente nuevamente");
                    break;
            }
        }while (opcion!=3);

    }

    private void menuCliente(Tienda tienda,Cliente cliente)
    {
        int opcion=0;
        ArrayList<Producto> carritoDeCompras=new ArrayList<>();
        Producto producto;
        int flag=1;
        int opcion2=0;
        int opcion3=0;

        do {
            System.out.println("||------------------------------------||");
            System.out.println("||       MENU PRINCIPAL CLIENTE       ||");
            System.out.println("||------------------------------------||");
            System.out.println("||   1-Ver Historial de compras       ||");
            System.out.println("||   2-Ver cupones Acumulados         ||");
            System.out.println("||   3-Agrear al carrito              ||");
            System.out.println("||   4-Agregar una Tarjeta            ||");
            System.out.println("||   5-Mostrar Cartera                ||");
            System.out.println("||   6-Ver Productos                  ||");
            System.out.println("||   7-Ver Carrito de Compras         ||");
            System.out.println("||   8-Reclamar Cupones Pendientes    ||");
            System.out.println("||   9-Pagar                          ||");
            System.out.println("||------------------------------------||");
            System.out.println("||   10-Cerrar Sesion                 ||");
            System.out.println("||------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println(cliente.verHistorialDeCompras(cliente));
                    break;
                case 2:
                    System.out.println(cliente.verCuponesDisponibles(cliente));
                    break;
                case 3:
                    System.out.println(tienda.mostrarProductos());
                    while (flag==1)
                    {
                        System.out.println("Ingrese el modelo de producto que desea agregar al carrito");
                        scan.nextLine();
                        String modelo=scan.nextLine();
                        producto=tienda.buscarProducto(modelo);
                        carritoDeCompras.add(producto);
                        System.out.println("Desea agregar otro producto? 1 o 0");
                        flag=scan.nextInt();
                    }
                    break;
                case 4:
                    Tarjeta tarjeta=cargaTarjeta();
                    cliente.agregarMedioDePago(tarjeta);
                    break;
                case 5:
                    System.out.println(cliente.verCartera());
                    break;
                case 6:
                    System.out.println(tienda.mostrarProductos());
                    break;
                case 7:
                    System.out.println(carritoDeCompras.toString());
                    break;
                case 8:
                    if(reclamarCupon(cliente))
                    {
                        System.out.println("Los cupones pendientes se reclamaron exitosamente");
                    }
                    else
                    {
                        System.out.println("No tiene cupones pendientes para reclamar");
                    }
                    break;
                case 9:
                    Cupon cupon=verificarSiTieneCupones(cliente);
                    if (cupon!=null)
                    {
                        System.out.println("CUPON SELECCIONADO:" +cupon);
                    }
                    else
                    {
                        System.out.println("Usted no tiene cupones disponibles de ese rango");
                    }

                    System.out.println("Con que medio de pago desea pagar?");
                    System.out.println("1- EFECTIVO");
                    System.out.println("2- TARJETA");
                    opcion2=scan.nextInt();
                    System.out.println(opcion2);

                    if(opcion2==1)
                    {
                        System.out.println("INGRESE EL DINERO");
                        double dinero= scan.nextDouble();
                        comprarConEfectivo(dinero,cupon,carritoDeCompras,cliente);
                    } else
                    {
                        comprarConTarjeta(cliente,cupon,carritoDeCompras);
                    }
                    carritoDeCompras.clear(); //Vacia el carrito de compras
                    break;
                case 10:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    break;

            }
        }while (opcion!=10);
    }


    private void menuEmpleadosVendedor(Tienda tienda, Empleado empleado)
    {
        int opcion=0;
        do {
            System.out.println("||-------------------------------------------------||");
            System.out.println("||               MENU PRINCIPAL EMPLEADO           ||");
            System.out.println("||-------------------------------------------------||");
            System.out.println("||   1-Ver historial de compras de un cliente      ||");
            System.out.println("||   2-Vender un producto                          ||");
            System.out.println("||   3-Mostrar Productos                           ||");
            System.out.println("||   4-Ver Clientes                                ||");
            System.out.println("||   5-Consultar Sueldo                            ||");
            System.out.println("||-------------------------------------------------||");
            System.out.println("||   6-Cerrar Sesion                               ||");
            System.out.println("||-------------------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    System.out.println(tienda.mostrarClientes());
                    System.out.println("Ingrese el nombre del cliente que desea buscar:");
                    scan.nextLine();
                    String nombreCliente=scan.nextLine();
                    Cliente clienteBuscado=tienda.buscarClientePorNombre(nombreCliente);
                    if(clienteBuscado!=null)
                    {
                        System.out.println(clienteBuscado.verHistorialDeCompras(clienteBuscado));
                    }
                    else
                    {
                        System.out.println("No se encontro el cliente buscado");
                    }
                    break;
                case 2:
                    System.out.println(tienda.mostrarProductos());
                    System.out.println("Ingrese el modelo que desea comprar");
                    scan.nextLine();
                    String modelo=scan.nextLine();
                    venta(modelo,tienda,empleado.getNombre());
                    break;
                case 3:
                    menuMostrar(tienda);
                    break;
                case 4:
                    System.out.println(tienda.mostrarClientes());
                    break;
                case 5:
                    System.out.println("SUELDO: "+ empleado.getSueldo());
                    break;
                case 6:
                    System.out.println("Cerrando sesion...");
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=6);
    }


    private void menuPrincAdmin(Tienda tienda)
    {

        int opcion=0;
        try
        {
            do {
                System.out.println("||------------------------------------||");
                System.out.println("||    MENU PRINCIPAL ADMINISTRADOR    ||");
                System.out.println("||------------------------------------||");
                System.out.println("||   1-Agregar Producto               ||");
                System.out.println("||   2-Buscar Producto                ||");
                System.out.println("||   3-Mostrar Productos              ||");
                System.out.println("||   4-Modificar Precio Productos     ||");
                System.out.println("||   5-Mostrar Clientes               ||");
                System.out.println("||   6-Estadisticas                   ||");
                System.out.println("||------------------------------------||");
                System.out.println("||          OPCIONES EMPLEADOS        ||");
                System.out.println("||   7-Menu Empleados                 ||");
                System.out.println("||------------------------------------||");
                System.out.println("||   8-Cerrar Sesion                  ||");
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
                        System.out.println(tienda.mostrarClientes());
                        break;
                    case 6:
                        menuEstadisticas(tienda);
                        break;
                    case 7:
                        menuEmpleados(tienda);
                        break;
                    case 8:
                        System.out.println("Volviendo atras...");
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

    }


    private void menuEstadisticas(Tienda tienda)
    {
        int opcion=0;
        ArrayList<Cliente> clientes=new ArrayList<Cliente>(tienda.getClientes().getSet());
        ArrayList<Producto>productos=new ArrayList<Producto>(tienda.getProductos().getSet());
        do {
            System.out.println("||------------------------------------||");
            System.out.println("||          MENU ESTADISTICAS         ||");
            System.out.println("||------------------------------------||");
            System.out.println("||   1-Ver clientes con mas compras   ||");
            System.out.println("||   2-Ver productos mas vendidos     ||");
            System.out.println("||------------------------------------||");
            System.out.println("||   3-Volver atras                   ||");
            System.out.println("||------------------------------------||");
            opcion=scan.nextInt();
            switch (opcion)
            {
                case 1:
                    Collections.sort(clientes, new Comparator<Cliente>() {
                        @Override
                        public int compare(Cliente o1, Cliente o2) {
                            int aux = 0;
                            if (o1.cantidadDeCompras() < o2.cantidadDeCompras()) {
                                aux = 1;
                            } else if (o1.cantidadDeCompras() > o2.cantidadDeCompras()) {
                                aux = -1;
                            }
                            return aux;
                        }
                    });
                    System.out.println("LISTADOS POR CLIENTES CON MAS COMPRAS");
                    System.out.println(clientes);
                    break;
                case 2:
                    Collections.sort(productos, new Comparator<Producto>() {
                        @Override
                        public int compare(Producto o1, Producto o2) {
                            int aux = 0;
                            if (o1.getCantidadVendida() < o2.getCantidadVendida()) {
                                aux = 1;
                            } else if (o1.getCantidadVendida() > o2.getCantidadVendida()) {
                                aux = -1;
                            }
                            return aux;
                        }
                    });
                    System.out.println("LISTADOS PRODUCTOS MAS VENDIDOS");
                    System.out.println(productos);
                    break;
                case 3:
                    System.out.println("Voliendo atras...");
                    break;
                default:
                    System.out.println("Error, Intente nuevamente");
                    break;
            }
        }while (opcion!=3);
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

    /*private void menuCambioSucursal(Tienda tienda)
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

     */

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


    //FUNCIONES AUXILIARES PARA EL MANEJO DE LOS MENU (CARGA, MODIFICACION)

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

        return new Pantalon(precio,stock,nombre,tipotela,color,talle,tamañoCintura,tipo,0);
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

        return new Remera(precio,stock,nombre,tipotela,color,talle,cuello,mangas,tipo,0);
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

        return new Buzo(precio,stock,nombre,tipotela,color,talle,capucha,cierre,bolsillo,tipo,0);
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
        return new Media(precio,stock,nombre,tipotela,color,antideslizante,tipo,0);
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
        Empleado empleado1;
        System.out.println("1- VENDEDOR");
        System.out.println("2- ADMINISTRADOR");
        opcion=scan.nextInt();
        try {
            empleado1=cargarEmpleado(opcion,tienda.getEmpleados().size());
            empleado1.calcularSueldo();
            tienda.cargarDatosEmpleado(empleado1);
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
            tipoEmpleado=TipoEmpleado.VENDEDOR;
        } else if (opcion==2) {
            tipoEmpleado=TipoEmpleado.ADMINISTRADOR;
        }
        System.out.println("Ingrese un usuario:");
        scan.nextLine();
        String usuario=scan.nextLine();
        System.out.println("Ingrese una contraseña");
        scan.nextLine();
        String contrasena=scan.nextLine();

        return new Empleado(nombre,size+1,tipoEmpleado,true,dni,usuario,contrasena);
    }

    private Cliente cargaCliente(int size) throws MiExcepcion {
        System.out.println("Ingrese el nombre");
        scan.nextLine();
        String nombre=scan.nextLine();


        System.out.println("Ingrese el domicilio");
        String domicilio=scan.nextLine();


        System.out.println("Ingrese el dni");
        int dni=scan.nextInt();
        if(dni<1000000 || dni >99999999)
        {
            throw new MiExcepcion("DOCUMENTO INVALIDO (entre 7 y 8 digitos)");
        }


        System.out.println("Ingrese un usuario:");
        scan.nextLine();
        String usuario=scan.nextLine();


        System.out.println("Ingrese una contraseña");
        String contrasena=scan.nextLine();


        if(contrasena.length()>8)
        {
            throw new MiExcepcion("No se permiten contraseñas de mas de 8 digitos");
        }


        return new Cliente(size+1,dni,nombre,usuario,contrasena,domicilio);
    }

    public Tarjeta cargaTarjeta()
    {
        System.out.println("Ingrese el nombre de la tarjeta");
        scan.nextLine();
        String nombre=scan.nextLine();
        System.out.println("Ingrese el numero de la tarjeta");
        String numeroTarjeta=scan.nextLine();
        System.out.println("Ingrese la fecha de expiro");
        String fechaExpiro=scan.nextLine();
        System.out.println("Ingrese el titular de la tarjeta");
        String titular=scan.nextLine();
        System.out.println("Ingrese el codigo de seguridad");
        int codigo=scan.nextInt();
        System.out.println("Ingrese el monto de la tarjeta");
        int monto=scan.nextInt();
        return new Tarjeta(numeroTarjeta,fechaExpiro,titular,codigo,nombre,monto);
    }

    public void comprarConEfectivo(double dinero,Cupon cupon,ArrayList<Producto> carritoDeCompras,Cliente cliente)
    {
        double TOTAL=cliente.comprarDos(carritoDeCompras);
        System.out.println("EL TOTAL A PAGAR ES:" + TOTAL);
        if(cupon!=null)
        {
            TOTAL=TOTAL-(TOTAL*cupon.getDescuento());
            cliente.getCupones().eliminar(cupon);
        }
        System.out.println("TOTAL CON DESCUENTO ES: "+ TOTAL);
        if(dinero<TOTAL)
        {
            System.out.println("FALTAN "+ (TOTAL-dinero)+"PARA PODER EFECTUAR LA COMPRA, PORFAVOR DEPOSITE MAS DINERO");
        }
        else if (dinero==TOTAL)
        {
            System.out.println("LA COMPRA SE EFECTUO CORRECTAMENTE");
        } else if (dinero>TOTAL)
        {
            System.out.println("LA COMPRA SE EFECTUO CORRECTAMENTE");
            System.out.println("SU VUELTO ES:"+ (dinero-TOTAL));
        }
    }

    public void comprarConTarjeta(Cliente cliente,Cupon cupon,ArrayList<Producto> carritoDeCompras)
    {
        double TOTAL=cliente.comprarDos(carritoDeCompras);
        System.out.println("EL TOTAL A PAGAR ES:" + TOTAL);
        if(cupon!=null)
        {
            TOTAL=TOTAL-(TOTAL*cupon.getDescuento());
            cliente.getCupones().eliminar(cupon);
        }
        System.out.println("TOTAL CON DESCUENTO ES: "+ TOTAL);
        int opcion3=0;
        System.out.println("Ingrese el nombre de la tarjeta con la que desea pagar");
        scan.nextLine();
        String nombreTarjeta=scan.nextLine();
        Tarjeta tarjeta1=cliente.buscarTarjetaPorNombre(nombreTarjeta);
        if(tarjeta1!=null)
        {
            if (tarjeta1.getMontoTarjeta()>TOTAL)
            {
                System.out.println("El pago se efectuo con exito");
                tarjeta1.setMontoTarjeta((int) (tarjeta1.getMontoTarjeta()-TOTAL));

            } else if (tarjeta1.getMontoTarjeta()<TOTAL)
            {
                System.out.println("La tarjeta no posee el monto para realizar la compra");
            }
        } else if (tarjeta1==null)
        {
            System.out.println("La tarjeta que usted esta buscando no existe, desea agregarla? si 1 o no 0");
            opcion3=scan.nextInt();
            if(opcion3==1)
            {
                Tarjeta tarjeta3=cargaTarjeta();
                tarjeta3.setMontoTarjeta((int) (tarjeta3.getMontoTarjeta()-TOTAL));
                cliente.agregarMedioDePago(tarjeta3);
                System.out.println("La compra se efectuo con exito");
            }
            else
            {
                Tarjeta tarjeta3=cargaTarjeta();
                tarjeta3.setMontoTarjeta((int) (tarjeta3.getMontoTarjeta()-TOTAL));
                System.out.println("La compra se efectuo con exito");
            }
        }
    }

    public boolean reclamarCupon(Cliente cliente)
    {
        boolean flag=false;
        Cupon cupon;
        int i=0;
        while (i<= cliente.cantidadDeCompras())
        {

                if(i>=10 && i<=20 && cliente.getCupones().get(i).getTipoCupon()!=1)
                {
                    cupon=crearCuponNivel1();
                    cliente.agregarCupones(cupon);
                    cliente.setNivel(1);
                    System.out.println("¡FELICIDADES!, USTED SUBIO DE NIVEL, Nivel:" + cliente.getNivel());
                }
                else if (i>=20 && i<=30&& cliente.getCupones().get(i).getTipoCupon()!=2)
                {
                    cupon=crearCuponNivel2();
                    cliente.agregarCupones(cupon);
                    cliente.setNivel(2);
                    System.out.println("¡FELICIDADES!, USTED SUBIO DE NIVEL, Nivel:" + cliente.getNivel());
                } else if (i>=30 && i<=40&& cliente.getCupones().get(i).getTipoCupon()!=3)
                {
                    cupon=crearCuponNivel3();
                    cliente.agregarCupones(cupon);
                    cliente.setNivel(3);
                    System.out.println("¡FELICIDADES!, USTED SUBIO DE NIVEL, Nivel:" + cliente.getNivel());
                }
            i=i+10;
        }
        if(cliente.getCupones().size()>0)
        {
            flag=true;
        }
        return flag;
    }

    public Cupon crearCuponNivel1()
    {
        return new Cupon(1,"CUPON POR UN 10% DE LA VENTA",0.10);
    }
    public Cupon crearCuponNivel2()
    {
        return new Cupon(2,"CUPON POR UN 20% DE LA VENTA",0.20);
    }
    public Cupon crearCuponNivel3()
    {
        return new Cupon(3,"CUPON POR UN 30% DE LA VENTA",0.30);
    }

    public Cupon verificarSiTieneCupones(Cliente cliente)
    {
        Cupon cupon=null;
        if(cliente.getCupones().size()>0)
        {
            System.out.println("Desea utilizar alguno de sus cupones?");
            System.out.println(cliente.verCuponesDisponibles(cliente));
            System.out.println("Ingrese el tipo de cupon que desea utilizar");
            int opcion4=scan.nextInt();
            cupon=cliente.buscarCupon(opcion4);
        }
        return cupon;
    }

    public void venta(String modelo,Tienda tienda,String nombreVendedor)
    {
        Cliente cliente=null;
        System.out.println("Usted tiene una cuenta? (1) si o no (0)");
        int opcion2=scan.nextInt();
        System.out.println("Como desea pagar?");
        System.out.println("1- EFECTIVO");
        System.out.println("2- TARJETA");
        int opcion3=scan.nextInt();
        int opcion4=0;
        if(opcion2==1)
        {
            System.out.println("Ingrese el usuario de su cuenta");
            scan.nextLine();
            String usuario=scan.nextLine();
            cliente=tienda.buscarClientePorUsuario(usuario);
            if(opcion3==1)
            {
                System.out.println("Ingrese el dinero");
                int dinero=scan.nextInt();
                boolean rta=tienda.venderEfectivo(modelo,dinero,usuario,nombreVendedor);
                if(rta && dinero>0)
                {
                    System.out.println("La venta se efectuo correctamente");
                    System.out.println("Su vuelto: "+dinero);
                } else if (rta)
                {
                    System.out.println("La venta se efectuo correctamente");
                } else if (!rta)
                {
                    System.out.println("No se pudo efectuar la venta ya que falta dinero");
                }
            } else if (opcion3==2)
            {
                System.out.println("Desea pagar con una tarjeta nueva o con las tarjetas de su cartera?");
                System.out.println("1- TARJETA NUEVA");
                System.out.println("2- CARTERA");
                opcion4=scan.nextInt();
                boolean rta = false;
                if(opcion4==1)
                {
                    System.out.println("Ingrese la tarjeta:");
                    Tarjeta tarjeta=cargaTarjeta();
                    rta= tienda.venderConTarjeta(modelo,tarjeta,usuario,nombreVendedor);
                }
                else
                {
                    System.out.println("Ingrese el nombre de la tarjeta:");
                    scan.nextLine();
                    String nombreTarjeta=scan.nextLine();
                    Tarjeta tarjeta=cliente.buscarTarjetaPorNombre(nombreTarjeta);
                    rta=tienda.venderConTarjeta(modelo,tarjeta,cliente.getNombre(),nombreVendedor);
                }


                if(rta)
                {
                    System.out.println("La venta se efectuo correctamente");
                }
                else
                {
                    System.out.println("El monto de la tarjeta no permite efecturar la compra");
                }
            }

        }
    }

}
