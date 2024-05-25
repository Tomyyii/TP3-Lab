package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class Pantalon extends IndumentariaConEstilo{

    private double tamañoCintura;
    private String modeloPantalon;

    public Pantalon(double precio, int stock, String estado, boolean disponible, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle, double tamañoCintura, String modeloPantalon) {
        super(precio, stock, estado, disponible, tipoDeTela, color, estilo, talle);
        this.tamañoCintura = tamañoCintura;
        this.modeloPantalon = modeloPantalon;
    }

    public double getTamañoCintura() {
        return tamañoCintura;
    }

    public void setTamañoCintura(double tamañoCintura) {
        this.tamañoCintura = tamañoCintura;
    }

    public String getModeloPantalon() {
        return modeloPantalon;
    }

    public void setModeloPantalon(String modeloPantalon) {
        this.modeloPantalon = modeloPantalon;
    }


}
