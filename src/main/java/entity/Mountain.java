package entity;

public class Mountain {

    private int hAxe;

    private int vAxe;

    public Mountain(int hAxe, int vAxe) {
        this.hAxe = hAxe;
        this.vAxe = vAxe;
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
}
