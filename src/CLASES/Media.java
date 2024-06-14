package CLASES;

import ENUMERACION.MedidaMedia;

public class Media extends Indumentaria{
//VARIABLES
    private boolean antideslizante;
    private MedidaMedia medidaMedia;
//CONSTRUCTOR
    public Media(double precio, int stock, String nombre, String tipoDeTela, String color, boolean antideslizante, MedidaMedia medidaMedia,int cantidadVendida) {
        super(precio, stock, nombre, tipoDeTela, color,cantidadVendida);
        this.antideslizante = antideslizante;
        this.medidaMedia = medidaMedia;
    }
//GETTERS
    public boolean isAntideslizante() {
        return antideslizante;
    }
    public MedidaMedia getMedidaMedia() {
        return medidaMedia;
    }
    @Override
    public String getTipo() {
        return getMedidaMedia().name();
    }
//SETTER
    public void setAntideslizante(boolean antideslizante) {
        this.antideslizante = antideslizante;
    }
//METODO ToString
    @Override
    public String toString() {
        return super.toString() +
                "\nantideslizante=" + antideslizante +
                "\nmedidaMedia=" + medidaMedia;
    }
//METODO EQUALS
    @Override
    public boolean equals(Object obj) {
        boolean aux = false;
        if(obj != null){
            if(obj instanceof Media){
                Media mediaAAgregar = (Media) obj;
                if(mediaAAgregar.getTipo().equals(getTipo())){
                    aux = true;
                }
            }
        }
        return aux;
    }
//METODO HASHCODE
    @Override
    public int hashCode() {
        return 1;
    }

}
