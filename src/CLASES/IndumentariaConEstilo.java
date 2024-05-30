package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class IndumentariaConEstilo extends Indumentaria{

    private TipoEstilo estilo;
    private NivelDeTalle talle;

    public IndumentariaConEstilo(double precio, int stock, String estado, String nombre, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle) {
        super(precio, stock, estado, nombre, tipoDeTela, color);
        this.estilo = estilo;
        this.talle = talle;
    }

    public TipoEstilo getEstilo() {
        return estilo;
    }

    public NivelDeTalle getTalle() {
        return talle;
    }
}
