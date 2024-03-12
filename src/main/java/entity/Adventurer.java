package entity;

import entity.enums.Orientatiion;

import java.util.ArrayList;
import java.util.List;

public class Adventurer {

    private String name;

    private int hAxe;

    private int vAxe;

    private Orientatiion orientatiion;

    private String move;

    private List<Treasure> treasures = new ArrayList<>();

    public Adventurer(String name, int hAxe, int vAxe, Orientatiion orientatiion, String move) {
        this.name = name;
        this.hAxe = hAxe;
        this.vAxe = vAxe;
        this.orientatiion = orientatiion;
        this.move = move;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Orientatiion getOrientatiion() {
        return orientatiion;
    }

    public void setOrientatiion(Orientatiion orientatiion) {
        this.orientatiion = orientatiion;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public void addTreasure(Treasure treasure){
        this.treasures.add(treasure);

    }
}
