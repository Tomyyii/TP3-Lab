package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstiloRemera;

public class Remera extends IndumentariaConEstilo{
    private String cuello;
    private String mangas;
    TipoEstiloRemera estilo;

    public Remera(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle, String cuello, String mangas, TipoEstiloRemera estilo) {
        super(precio, stock, nombre, tipoDeTela, color, talle);
        this.cuello = cuello;
        this.mangas = mangas;
        this.estilo = estilo;
    }

    public String getCuello() {
        return cuello;
    }

    public void setCuello(String cuello) {
        this.cuello = cuello;
    }

    public String getMangas() {
        return mangas;
    }

    public void setMangas(String mangas) {
        this.mangas = mangas;
    }

    public TipoEstiloRemera getEstilo() {
        return estilo;
    }

    public void setEstilo(TipoEstiloRemera estilo) {
        this.estilo = estilo;
    }

    @Override
    public String toString() {
        return super.toString()+
                "\ncuello='" + cuello +
                "\nmangas='" + mangas +
                "\nestilo=" + estilo;
    }

    @Override
    public String getTipo() {
        return getEstilo().name();
    }

    @Override
    public int hashCode() {
        return  1;
    }



    @Override
    public boolean equals(Object obj) {
        boolean aux = false;
        if(obj != null){
            if(obj instanceof Remera){
                Remera remeraAAgregar = (Remera) obj;
                if(remeraAAgregar.getTipo().equals(getTipo())){
                    aux = true;
                }
            }
        }
        return aux;
    }
}
