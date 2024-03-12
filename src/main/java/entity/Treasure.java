package entity;

public class Treasure {

    private int hAxe;

    private int vAxe;

    private int nb;

    public Treasure(int hAxe, int vAxe, int nb) {
        this.hAxe = hAxe;
        this.vAxe = vAxe;
        this.nb = nb;
    }

    public int gethAxe() {
        return hAxe;
    }

    public void sethAxe(int hAxe) {
        this.hAxe = hAxe;
    }

    public int getvAxe() {
        return vAxe;
    }

    public void setvAxe(int vAxe) {
        this.vAxe = vAxe;
    }

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }
}
