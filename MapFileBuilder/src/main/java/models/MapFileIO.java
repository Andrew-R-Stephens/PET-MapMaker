package main.java.models;

import java.io.File;

public class MapFileIO {

    public String filePath;

    public WorldMapWrapper mapsWrapper = new WorldMapWrapper();

    public MapFileWriter writer = new MapFileWriter(mapsWrapper);
    public MapFileReader reader = new MapFileReader(mapsWrapper);

    public MapFileIO(String filePath) {
        setFile(filePath);
    }

    public boolean writeFile(MapFileWriter writer) {
        return writer.writeFile(filePath);
    }

    public boolean readFile(MapFileReader reader) {
        return reader.loadFile(filePath);
    }

    public String setFile(String filePath) {
        this.filePath = filePath;

        File file = new File(filePath);
        /*try {
            boolean newFileCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }*/
        return file.getPath();
    }
}
