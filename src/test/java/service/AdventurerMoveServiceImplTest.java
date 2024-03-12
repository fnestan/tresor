package service;

import entity.Adventurer;
import entity.Map;
import entity.Mountain;
import entity.Treasure;
import entity.enums.Orientatiion;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class AdventurerMoveServiceImplTest {


    @Test
    public void unTest() throws IOException {
        Map map = new Map(4,5);
        Mountain mountain1 = new Mountain(1,3);
        Mountain mountain2 = new Mountain(3,1);
        map.addMountain(mountain1);
        map.addMountain(mountain2);
        for (int i = 0; i<4 ; i++) {
            Treasure treasure = new Treasure(2,2,4);
            map.addTreasure(treasure);
        }
        for (int i = 0; i<2 ; i++) {
            Treasure treasure = new Treasure(1,2,2);
            map.addTreasure(treasure);
        }


        Adventurer adventurer = new Adventurer("paul",1,1, Orientatiion.S,"ADG");
        map.addAdventurer(adventurer);
        AdventurerMoveServiceImpl adventurerMoveService = new AdventurerMoveServiceImpl();
        Map m = adventurerMoveService.moveAdeventurers(map);
        assertEquals(m.getAdventurers().size(),1 );
        assertEquals(m.getMountains().size(),2 );
        assertEquals(m.getTreasures().size(),5 );
        assertEquals(m.getAdventurers().get(0).getTreasures().size(),1 );

    }
}
