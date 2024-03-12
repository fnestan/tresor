package service;

import entity.Adventurer;
import entity.Map;
import entity.enums.Move;
import entity.enums.Orientatiion;
import helper.Check;

public class AdventurerMoveServiceImpl {

    public Map moveAdeventurers(Map map) {
        Check check = new Check();
        for (Adventurer adventurer : map.getAdventurers()) {
            for (int i = 0; i < adventurer.getMove().length(); i++) {
                int hAxe = 0;
                int vAxe = 0;
                char move = adventurer.getMove().charAt(i);
                Orientatiion orientatiion = check.setAdventurerOrientation(adventurer.getOrientatiion(),
                        Move.valueOf(String.valueOf(move)));
                adventurer.setOrientatiion(orientatiion);
                if (String.valueOf(move).equals(Move.A.toString())) {
                    switch (orientatiion) {
                        case E:
                            hAxe = adventurer.gethAxe() - 1;
                            vAxe = adventurer.getvAxe();
                            break;
                        case N:
                            vAxe = adventurer.getvAxe() - 1;
                            hAxe = adventurer.gethAxe();
                            break;
                        case O:
                            hAxe = adventurer.gethAxe() + 1;
                            vAxe = adventurer.getvAxe();
                            break;
                        case S:
                            vAxe = adventurer.getvAxe() + 1;
                            hAxe = adventurer.gethAxe();
                            break;
                    }
                    if (!check.hasAdventurer(map, adventurer.getName(), hAxe, vAxe) && !check.hasMountain(map, hAxe, vAxe) &&
                            check.isInMap(map, hAxe, vAxe)
                    ) {
                        adventurer.setvAxe(vAxe);
                        adventurer.sethAxe(hAxe);
                        check.huntTreasure(map,adventurer);
                    }
                }
            }
        }
        return map;
    }
}
