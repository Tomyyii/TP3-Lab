package CLASES;

import ENUMERACION.NivelDeTalle;


public abstract class IndumentariaConTalle extends Indumentaria{
//VARIABLE
    private NivelDeTalle talle;
//CONSTRUCTOR
    public IndumentariaConTalle(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle) {
        super(precio, stock, nombre, tipoDeTela, color);
        this.talle = talle;
    }
//GETTER
    public NivelDeTalle getTalle() {
        return talle;
    }
//METODO ToString
    @Override
    public String toString() {
        return super.toString()+
                "\ntalle=" + talle;
    }
}
