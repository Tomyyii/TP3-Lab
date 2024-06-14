package INTERFACES;

import CLASES.Cliente;
import CLASES.Producto;
import CLASES.Tienda;

public  interface IAccionesEmpleadosClientes {
    StringBuilder verHistorialDeCompras(Cliente cliente);
    StringBuilder verProductos(Tienda tienda);
    StringBuilder verCuponesDisponibles(Cliente cliente);

}


