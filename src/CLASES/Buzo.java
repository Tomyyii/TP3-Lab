package CLASES;

public class Buzo extends IndumentariaConEstilo{
    private boolean capucha;
    private boolean cierre;
    private boolean bolsillo;

    public Buzo() {
        capucha=false;
        cierre=false;
        bolsillo=false;
    }



    public boolean isCapucha() {
        return capucha;
    }

    public void setCapucha(boolean capucha) {
        this.capucha = capucha;
    }

    public boolean isCierre() {
        return cierre;
    }

    public void setCierre(boolean cierre) {
        this.cierre = cierre;
    }

    public boolean isBolsillo() {
        return bolsillo;
    }

    public void setBolsillo(boolean bolsillo) {
        this.bolsillo = bolsillo;
    }

}
