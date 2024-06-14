package CLASES;

import java.io.Serializable;

public class Tarjeta implements Serializable {
    private String nombreTarjeta;
    private String numeroTarjeta;
    private String fechaExpiro;
    private String titular;
    private int codigoSeguridad;
    private int montoTarjeta;


    public Tarjeta(String numeroTarjeta, String fechaExpiro, String titular, int codigoSeguridad,String nombreTarjeta,int montoTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiro = fechaExpiro;
        this.titular = titular;
        this.codigoSeguridad = codigoSeguridad;
        this.nombreTarjeta=nombreTarjeta;
        this.montoTarjeta=montoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getFechaExpiro() {
        return fechaExpiro;
    }

    public void setFechaExpiro(String fechaExpiro) {
        this.fechaExpiro = fechaExpiro;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getCodigoSeguridad() {
        return codigoSeguridad;
    }

    public void setCodigoSeguridad(int codigoSeguridad) {
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNombreTarjeta() {
        return nombreTarjeta;
    }

    public void setNombreTarjeta(String nombreTarjeta) {
        this.nombreTarjeta = nombreTarjeta;
    }

    public int getMontoTarjeta() {
        return montoTarjeta;
    }

    public void setMontoTarjeta(int montoTarjeta) {
        this.montoTarjeta = montoTarjeta;
    }

    @Override
    public String toString() {
        return "\nTarjeta{" +
                "nombreTarjeta='" + nombreTarjeta + '\'' +
                ", numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaExpiro='" + fechaExpiro + '\'' +
                ", titular='" + titular + '\'' +
                ", codigoSeguridad=" + codigoSeguridad +
                ", montoTarjeta=" + montoTarjeta +
                '}';
    }
}
