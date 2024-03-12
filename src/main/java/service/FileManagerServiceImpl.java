package service;

import entity.Adventurer;
import entity.Map;
import entity.Mountain;
import entity.Treasure;
import entity.enums.Element;
import entity.enums.Orientatiion;
import helper.Check;

import java.io.*;

public class FileManagerServiceImpl {

    final String MAP = "C";
    final String ADVENTURER = "A";
    final String MOUNTAIN = "M";
    final String TREASURE = "T";

    public Map generateMap() throws IOException {
        File initialFile = new File("carte.txt");
        Map map = new Map();
        InputStream targetStream = new FileInputStream(initialFile);
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(targetStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.startsWith("#")) {
                   String[] element = line.split(" - ");
                   String type = Element.valueOf(element[0]).toString();
                    switch (type) {
                        case MAP:
                            map.setHeight(Integer.parseInt(element[2]));
                            map.setWidth(Integer.parseInt(element[1]));
                            break;
                        case ADVENTURER:
                            Adventurer adventurer = new Adventurer(element[1],Integer.parseInt(element[2]),
                                    Integer.parseInt(element[3]), Orientatiion.valueOf(element[4]),element[5]);
                            map.addAdventurer(adventurer);
                            break;
                        case TREASURE:
                            for(int i = 0; i < Integer.parseInt(element[3]); i++){
                                Treasure treasure = new Treasure(Integer.parseInt(element[1]),Integer.parseInt(element[2]),
                                        Integer.parseInt(element[3]));
                                map.addTreasure(treasure);
                            }
                            break;
                        case MOUNTAIN:
                            Mountain mountain = new Mountain(Integer.parseInt(element[1]),Integer.parseInt(element[2]));
                            map.addMountain(mountain);
                            break;
                    }
                }
            }
        }
        return map;
    }

    public void writeResultsFile(Map map)
            throws IOException {
        Check check = new Check();
        String str = "C - "+ map.getWidth()+ " - "+ map.getHeight();
        BufferedWriter writer = new BufferedWriter(new FileWriter("sortie.txt"));
        writer.write(str);
        writer.newLine();
        int currHAxeTreasure = 0;
        int currVAxeTreasure = 0;
        for (Mountain mountain: map.getMountains()) {
            String moun = "M - "+ mountain.gethAxe()+ " - "+ mountain.getvAxe();
            writer.write(moun);
            writer.newLine();
        }
        for (Treasure treasure: map.getTreasures()) {
            if (currHAxeTreasure != treasure.gethAxe() || currVAxeTreasure != treasure.getvAxe()) {
                currHAxeTreasure = treasure.gethAxe();
                currVAxeTreasure = treasure.getvAxe();
                String adv = "T - "+ treasure.gethAxe()+ " - "+ treasure.getvAxe()+" - "+ check.getNbTreasureArea(map,treasure.gethAxe(),treasure.getvAxe());
                writer.write(adv);
                writer.newLine();
            }
        }
        for (Adventurer adventurer: map.getAdventurers()) {
            String adv = "A - "+ adventurer.getName()+ " - "+ adventurer.gethAxe()+ " - "+ adventurer.getvAxe()
                    + " - "+ adventurer.getOrientatiion().toString()+ " - "+ adventurer.getTreasures().size();
            writer.write(adv);
            writer.newLine();
        }

        writer.close();
    }
}