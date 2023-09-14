package main.java.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MapFileWriter {

    public WorldMapWrapper mapsWrapper;

    public MapFileWriter(WorldMapWrapper mapsWrapper) {
        this.mapsWrapper = mapsWrapper;
    }

    public boolean writeFile(String filePath) {
        //Creating a JSONObject object
        Gson gson = new GsonBuilder().create();

        System.out.println(filePath);
        File file = new File(filePath);

        // Creates an OutputStream
        FileOutputStream outStream = null;
        try {
            outStream = new FileOutputStream(file, false);
            outStream.write("".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (outStream == null) {
            return false;
        }
        // Creates an OutputStreamWriter
        OutputStreamWriter output = new OutputStreamWriter(outStream);
        JsonWriter writer = new JsonWriter(output);
        gson.toJson(mapsWrapper, WorldMapWrapper.class, writer);
        try {
            writer.flush();
            writer.close();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

}
