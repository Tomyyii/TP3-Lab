package CLASES;

public abstract class Indumentaria extends Producto{
//VARIABLES
    private String tipoDeTela;
    private String color;
//CONSTRUCTOR
    public Indumentaria(double precio, int stock, String nombre, String tipoDeTela, String color) {
        super(precio, stock, nombre);
        this.tipoDeTela = tipoDeTela;
        this.color = color;
    }
//GETTERS
    public String getTipoDeTela() {
        return tipoDeTela;
    }
    public String getColor() {
        return color;
    }
//SETTERS
    public void setTipoDeTela(String tipoDeTela) {
        this.tipoDeTela = tipoDeTela;
    }
    public void setColor(String color) {
        this.color = color;
    }
//METODO ToString
    @Override
    public String toString() {
        return super.toString()+
                "\ntipoDeTela=" + tipoDeTela+
                "\ncolor=" + color;
    }
}
