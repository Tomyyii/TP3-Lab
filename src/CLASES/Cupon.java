package CLASES;

public class Cupon {

    private int tipoCupon;
    private String detalle;

    public Cupon(int tipoCupon, String detalle) {
        this.tipoCupon = tipoCupon;
        this.detalle = detalle;
    }

    public int getTipoCupon() {
        return tipoCupon;
    }

    public void setTipoCupon(int tipoCupon) {
        this.tipoCupon = tipoCupon;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Cupon{" +
                "tipoCupon=" + tipoCupon +
                ", detalle='" + detalle + '\'' +
                '}';
    }


}
