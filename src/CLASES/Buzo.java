package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstiloBuzo;

public class Buzo extends IndumentariaConEstilo{
    private boolean capucha;
    private boolean cierre;
    private boolean bolsillo;
    TipoEstiloBuzo estilo;

    public Buzo(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle, boolean capucha, boolean cierre, boolean bolsillo, TipoEstiloBuzo estilo) {
        super(precio, stock, nombre, tipoDeTela, color, talle);
        this.capucha = capucha;
        this.cierre = cierre;
        this.bolsillo = bolsillo;
        this.estilo = estilo;
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

    public TipoEstiloBuzo getEstilo() {
        return estilo;
    }

    public void setEstilo(TipoEstiloBuzo estilo) {
        this.estilo = estilo;
    }

    @Override
    public String getTipo() {
        return getEstilo().name();
    }

    @Override
    public String toString() {
        return super.toString() +
                "\ncapucha=" + capucha +
                "\ncierre=" + cierre +
                "\nbolsillo=" + bolsillo +
                "\nestilo=" + estilo;
    }

    @Override
    public boolean equals(Object obj) {
        boolean aux = false;
        if(obj != null){
            if(obj instanceof Buzo){
                Buzo buzoAAgregar = (Buzo) obj;
                if(buzoAAgregar.getTipo().equals(getTipo())){
                    aux = true;
                }
            }
        }
        return aux;
    }

    @Override
    public int hashCode() {
        return 1;
    }


}
