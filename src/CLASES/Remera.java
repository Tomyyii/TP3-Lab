package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstiloRemera;

public class Remera extends IndumentariaConTalle {
//VARIBLES
    private String cuello;
    private String mangas;
    private TipoEstiloRemera estilo;
//CONSTRUCTOR
    public Remera(double precio, int stock, String nombre, String tipoDeTela, String color, NivelDeTalle talle, String cuello, String mangas, TipoEstiloRemera estilo) {
        super(precio, stock, nombre, tipoDeTela, color, talle);
        this.cuello = cuello;
        this.mangas = mangas;
        this.estilo = estilo;
    }
//GETTERS
    public String getCuello() {
        return cuello;
    }
    public String getMangas() {
        return mangas;
    }
    @Override
    public String getTipo() {
        return getEstilo().name();
    }
    public TipoEstiloRemera getEstilo() {
        return estilo;
    }
//SETTERS
    public void setCuello(String cuello) {
        this.cuello = cuello;
    }
    public void setMangas(String mangas) {
        this.mangas = mangas;
    }
    public void setEstilo(TipoEstiloRemera estilo) {
        this.estilo = estilo;
    }
//METODO ToString
    @Override
    public String toString() {
        return super.toString()+
                "\ncuello=" + cuello +
                "\nmangas=" + mangas +
                "\nestilo=" + estilo;
    }
//METODO HASHCODE
    @Override
    public int hashCode() {
        return  1;
    }
//METODO EQUALS
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
