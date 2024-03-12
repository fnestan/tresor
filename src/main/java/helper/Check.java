package helper;

import entity.Adventurer;
import entity.Map;
import entity.Mountain;
import entity.Treasure;
import entity.enums.Move;
import entity.enums.Orientatiion;

import java.util.Iterator;

public class Check {

    public boolean hasMountain(Map map, int hAxe, int vAxe) {
        for (Mountain mountain : map.getMountains()) {
            if (mountain.gethAxe() == hAxe && mountain.getvAxe() == vAxe) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAdventurer(Map map, String name, int hAxe, int vAxe) {
        for (Adventurer adventurer : map.getAdventurers()) {
            if (adventurer.gethAxe() == hAxe && adventurer.getvAxe() == vAxe && !adventurer.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public Map huntTreasure(Map map, Adventurer adventurer) {
        Iterator<Treasure> it =  map.getTreasures().iterator();
        while (it.hasNext()) {
            Treasure treasure = it.next();
            if (treasure.gethAxe() == adventurer.gethAxe() && treasure.getvAxe() == adventurer.getvAxe()) {
                adventurer.addTreasure(treasure);
                it.remove();
                return map;
            }
        }
        return map;
    }

    public Orientatiion setAdventurerOrientation(Orientatiion orientatiion, Move move){
        if (move.equals(Move.D) || move.equals(Move.G)){
            switch (orientatiion){
                case E:
                    if (move.equals(Move.D)){
                        orientatiion = Orientatiion.N;
                    }else {
                        orientatiion = Orientatiion.S;
                    }
                    break;
                case N:
                    if (move.equals(Move.D)){
                        orientatiion = Orientatiion.O;
                    }else {
                        orientatiion = Orientatiion.E;
                    }
                    break;
                case O:
                    if (move.equals(Move.D)){
                        orientatiion = Orientatiion.S;
                    }else {
                        orientatiion = Orientatiion.N;
                    }
                    break;
                case S:
                    if (move.equals(Move.D)){
                        orientatiion = Orientatiion.E;
                    }else {
                        orientatiion = Orientatiion.O;
                    }
                    break;
            }
        }
        return orientatiion;
    }

    public boolean isInMap(Map map, int hAxe, int vAxe) {
        return (hAxe >= 0 && vAxe >= 0 && hAxe <= map.getHeight() && vAxe <= map.getWidth());
    }

    public int getNbTreasureArea(Map map, int hAxe, int vAxe) {
        int total = 0;
        for (Treasure treasure: map.getTreasures()) {
            if (treasure.getvAxe() == vAxe && treasure.gethAxe() == hAxe){
                total++;
            }
        }
        return total;
    }
}
