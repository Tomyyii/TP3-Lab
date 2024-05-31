package CLASES;

public abstract class Indumentaria extends Producto{
    //talle, tipo de tela, color
    private String tipoDeTela;
    private String color;

    public Indumentaria(double precio, int stock, String nombre, String tipoDeTela, String color) {
        super(precio, stock, nombre);
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


    @Override
    public String toString() {
        return super.toString()+
                "\ntipoDeTela='" + tipoDeTela+
                "\ncolor='" + color;
    }
}
