package CLASES;

public class Tarjeta {
    private String numeroTarjeta;
    private int fechaExpiro;
    private String titular;
    private int codigoSeguridad;


    public Tarjeta(String numeroTarjeta, int fechaExpiro, String titular, int codigoSeguridad) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaExpiro = fechaExpiro;
        this.titular = titular;
        this.codigoSeguridad = codigoSeguridad;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public int getFechaExpiro() {
        return fechaExpiro;
    }

    public void setFechaExpiro(int fechaExpiro) {
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

    @Override
    public String toString() {
        return "Tarjeta{" +
                "numeroTarjeta='" + numeroTarjeta + '\'' +
                ", fechaExpiro=" + fechaExpiro +
                ", titular='" + titular + '\'' +
                ", codigoSeguridad=" + codigoSeguridad +
                '}';
    }
}
