package CLASES;

import ENUMERACION.MedidaMedia;

public class Media extends Indumentaria{
    //antideslizante(boolean), medidaMedia (soquete, ¾, largas).
    private boolean antideslizante;
    private MedidaMedia medidaMedia;


    public Media(double precio, int stock, String estado, String nombre, String tipoDeTela, String color, boolean antideslizante, MedidaMedia medidaMedia) {
        super(precio, stock, estado, nombre, tipoDeTela, color);
        this.antideslizante = antideslizante;
        this.medidaMedia = medidaMedia;
    }

    public boolean isAntideslizante() {
        return antideslizante;
    }

    public void setAntideslizante(boolean antideslizante) {
        this.antideslizante = antideslizante;
    }

    public MedidaMedia getMedidaMedia() {
        return medidaMedia;
    }


    @Override
    public String toString() {
        return super.toString()+"Media{" +
                "antideslizante=" + antideslizante +
                ", medidaMedia=" + medidaMedia +
                '}';
    }
}
