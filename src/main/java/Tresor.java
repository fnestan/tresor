import entity.Adventurer;
import entity.Map;
import service.AdventurerMoveServiceImpl;
import service.FileManagerServiceImpl;

import java.io.IOException;

class Tresor {
    public static void main(String[] args) throws IOException {
        FileManagerServiceImpl fileReaderInputService = new FileManagerServiceImpl();
        Map map = fileReaderInputService.generateMap();
        AdventurerMoveServiceImpl adventurerMoveService = new AdventurerMoveServiceImpl();
        map = adventurerMoveService.moveAdeventurers(map);
        fileReaderInputService.writeResultsFile(map);
    }
}