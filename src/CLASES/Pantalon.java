package CLASES;

import ENUMERACION.ModeloPantalon;
import ENUMERACION.NivelDeTalle;


public class Pantalon extends IndumentariaConTalle {
//VARIABLES
    private double tamañoCintura;
    private ModeloPantalon modelo;
//CONSTRUCTOR
    public Pantalon(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle, double tamañoCintura, ModeloPantalon modeloPantalon) {
        super(precio, stock, nombre, tipoDeTela, color, talle);
        this.tamañoCintura = tamañoCintura;
        this.modelo = modeloPantalon;
    }
//GETTERS
    public double getTamañoCintura() {
        return tamañoCintura;
    }
    public ModeloPantalon getModelo() {
        return modelo;
    }
    @Override
    public String getTipo() {
        return getModelo().name();
    }
//SETTERS
    public void setTamañoCintura(double tamañoCintura) {
        this.tamañoCintura = tamañoCintura;
    }
    public void setModelo(ModeloPantalon modelo) {
        this.modelo = modelo;
    }
//METODO ToString
    @Override
    public String toString() {
        return super.toString()+
                "\ntamañoCintura=" + tamañoCintura +
                "\nmodelo=" + modelo;
    }
//MEOTDO EQUALS
    @Override
    public boolean equals(Object obj) {
        boolean aux = false;
        if(obj != null){
            if(obj instanceof Pantalon){
                Pantalon pantalonAAgregar = (Pantalon) obj;
                if(pantalonAAgregar.getTipo().equals(getTipo())){
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
