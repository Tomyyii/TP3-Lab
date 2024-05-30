package CLASES;

import ENUMERACION.ModeloPantalon;
import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class Pantalon extends IndumentariaConEstilo{

    private double tamañoCintura;
    private String modeloPantalon;
    private ModeloPantalon modelo;

    public Pantalon(double precio, int stock, String estado, String nombre, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle, double tamañoCintura, ModeloPantalon modeloPantalon) {
        super(precio, stock, estado, nombre, tipoDeTela, color, estilo, talle);
        this.tamañoCintura = tamañoCintura;
        this.modelo = modeloPantalon;
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

    public ModeloPantalon getModelo() {
        return modelo;
    }

    public void setModelo(ModeloPantalon modelo) {
        this.modelo = modelo;
    }
}
