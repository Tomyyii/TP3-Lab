package CLASES;

public class Indumentaria extends Producto{
    //talle, tipo de tela, color
    private String tipoDeTela;
    private String color;

    public Indumentaria(double precio, int stock, String estado, boolean disponible, String nombre, String tipoDeTela, String color) {
        super(precio, stock, estado, disponible, nombre);
        this.tipoDeTela = tipoDeTela;
        this.color = color;
    }

    public String getTipoDeTela() {
        return tipoDeTela;
    }

    public void setTipoDeTela(String tipoDeTela) {
        this.tipoDeTela = tipoDeTela;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
