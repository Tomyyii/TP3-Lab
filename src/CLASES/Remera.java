package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class Remera extends IndumentariaConEstilo{
    private String cuello;
    private String mangas;

    public Remera(double precio, int stock, String estado, String nombre, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle, String cuello, String mangas) {
        super(precio, stock, estado, nombre, tipoDeTela, color, estilo, talle);
        this.cuello = cuello;
        this.mangas = mangas;
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

    @Override
    public String toString() {
        return super.toString()+"Remera{" +
                "cuello='" + cuello + '\'' +
                ", mangas='" + mangas + '\'' +
                '}';
    }
}
