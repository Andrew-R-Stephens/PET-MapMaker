package models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.Map;

public class MapFileReader {

    public WorldMapWrapper mapsWrapper;

    public MapFileReader(WorldMapWrapper mapsWrapper) {
        this.mapsWrapper = mapsWrapper;
    }
    public boolean loadFile(String filePath) {
        //Creating a JSONObject object
        Gson gson = new GsonBuilder().create();
        //Inserting key-value pairs into the json object
        InputStream inputStream = null;
        try {
            inputStream = MapFileReader.class.getClassLoader().getResourceAsStream(filePath);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(inputStream == null) {
            return false;
        }
        JsonReader fileReader = gson.newJsonReader(new BufferedReader(new InputStreamReader(inputStream)));
        mapsWrapper = gson.fromJson(fileReader, WorldMapWrapper.class);
        try {
            fileReader.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String toString() {
        StringBuilder data = new StringBuilder();

        for(Map<String, WorldMapWrapper.WorldMap> m: this.mapsWrapper.maps) {
            data.append(m.get("map_data"));
        }

        return data.toString();
    }

}
