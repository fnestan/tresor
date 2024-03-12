package entity;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private int width;

    private int height;

    private List<Treasure> treasures = new ArrayList<>();

    private List<Mountain> mountains = new ArrayList<>();

    private List<Adventurer> adventurers = new ArrayList<>();

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public Map() {

    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public List<Mountain> getMountains() {
        return mountains;
    }

    public void setMountains(List<Mountain> mountains) {
        this.mountains = mountains;
    }

    public List<Adventurer> getAdventurers() {
        return adventurers;
    }

    public void setAdventurers(List<Adventurer> adventurers) {
        this.adventurers = adventurers;
    }

    public void addAdventurer(Adventurer adventurer){
        this.adventurers.add(adventurer);
    }

    public void addMountain(Mountain mountain){
        this.mountains.add(mountain);

    }

    public void addTreasure(Treasure treasure){
        this.treasures.add(treasure);
    }

}
