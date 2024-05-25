package CLASES;

import ENUMERACION.MedidaMedia;

public class Media extends Indumentaria{
    //antideslizante(boolean), medidaMedia (soquete, ¾, largas).
    private boolean antideslizante;
    private MedidaMedia medidaMedia;


    public Media(double precio, int stock, String estado, boolean disponible, String tipoDeTela, String color, boolean antideslizante, MedidaMedia medidaMedia) {
        super(precio, stock, estado, disponible, tipoDeTela, color);
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




    
}
