package CLASES;

import java.io.Serializable;

public class Cupon implements Serializable {

    private int tipoCupon;
    private String detalle;
    private double descuento;

    public Cupon(int tipoCupon, String detalle,double descuento) {
        this.tipoCupon = tipoCupon;
        this.detalle = detalle;
        this.descuento=descuento;
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

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Cupon{" +
                "tipoCupon=" + tipoCupon +
                ", detalle='" + detalle + '\'' +
                ", descuento=" + descuento +
                '}';
    }
}
