package CLASES;

import ENUMERACION.NivelDeTalle;


public abstract class IndumentariaConEstilo extends Indumentaria{
    private NivelDeTalle talle;

    public IndumentariaConEstilo(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle) {
        super(precio, stock, nombre, tipoDeTela, color);
        this.talle = talle;
    }


    public NivelDeTalle getTalle() {
        return talle;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\ntalle=" + talle;
    }
}
