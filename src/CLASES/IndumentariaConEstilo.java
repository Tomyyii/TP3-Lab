package CLASES;

import ENUMERACION.NivelDeTalle;
import ENUMERACION.TipoEstilo;

public class IndumentariaConEstilo extends Indumentaria{

    TipoEstilo estilo;
    NivelDeTalle talle;

    public IndumentariaConEstilo(double precio, int stock, String estado, boolean disponible, String tipoDeTela, String color, TipoEstilo estilo, NivelDeTalle talle) {
        super(precio, stock, estado, disponible, tipoDeTela, color);
        this.estilo = estilo;
        this.talle = talle;
    }
}
