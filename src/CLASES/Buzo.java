package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class Buzo extends IndumentariaConEstilo{
    private boolean capucha;
    private boolean cierre;
    private boolean bolsillo;

    public Buzo(double precio, int stock, String estado, String nombre, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle, boolean capucha, boolean cierre, boolean bolsillo) {
        super(precio, stock, estado, nombre, tipoDeTela, color, estilo, talle);
        this.capucha = capucha;
        this.cierre = cierre;
        this.bolsillo = bolsillo;
    }

    public boolean isCapucha() {
        return capucha;
    }

    public void setCapucha(boolean capucha) {
        this.capucha = capucha;
    }

    public boolean isCierre() {
        return cierre;
    }

    public void setCierre(boolean cierre) {
        this.cierre = cierre;
    }

    public boolean isBolsillo() {
        return bolsillo;
    }

    public void setBolsillo(boolean bolsillo) {
        this.bolsillo = bolsillo;
    }

}
