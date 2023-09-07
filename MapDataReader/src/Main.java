import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**URL: <a href="https://stackoverflow.com/questions/16377754/parse-json-file-using-gson">Reference</a>**/
public class Main {

    public static void main(String[] args) throws IOException {
        //Creating a JSONObject object
        Gson gson = new GsonBuilder().create();
        //Inserting key-value pairs into the json object
        InputStream inputStream = null;
        try {
            inputStream = Main.class.getClassLoader().getResourceAsStream("maps.json");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(inputStream == null) {
            return;
        }
        JsonReader fileReader = gson.newJsonReader(new BufferedReader(new InputStreamReader(inputStream)));
        MapDataParser parser = gson.fromJson(fileReader, MapDataParser.class);

        for(Map<String, MapDataParser.WorldMap> m:parser.maps) {
            System.out.println(m.get("map_data"));
        }
    }

}

class MapDataReader {

    MapDataParser parser;

    public boolean loadFile(String file) {
        //Creating a JSONObject object
        Gson gson = new GsonBuilder().create();
        //Inserting key-value pairs into the json object
        InputStream inputStream = null;
        try {
            inputStream = MapDataReader.class.getClassLoader().getResourceAsStream(file);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        if(inputStream == null) {
            return false;
        }
        JsonReader fileReader = gson.newJsonReader(new BufferedReader(new InputStreamReader(inputStream)));
        parser = gson.fromJson(fileReader, MapDataParser.class);

        return true;
    }

    public String toString() {
        StringBuilder data = new StringBuilder();
        for(Map<String, MapDataParser.WorldMap> m:parser.maps) {
            data.append(m.get("map_data"));
        }
        return data.toString();
    }

}

class MapDataParser {

    List<Map<String, WorldMap>> maps;

    static class WorldMap {

        int map_id;
        String map_name;
        List<Floor> map_floors;
        WorldDimensions map_dimensions;

        static class WorldDimensions {

            int w, h;

            public String toString() {
                return "\n\tMap Dimensions:\n\t\tW: " + w + ", H: " + h;
            }

        }

        static class Floor {

            int floor_number;
            String floor_name;
            String image_file;
            List<Room> floor_rooms;

            static class Room {

                int room_iD;
                String room_name;

                RoomPoints points;
                RoomDimensions dimensions;

                static class RoomPoints {

                    int x, y;

                    public String toString() {
                        return "\t\t\t" + x + " " + y;
                    }

                }

                static class RoomDimensions {

                    int w, h;

                    public String toString() {
                        return "\t\t\t" + w + " " + h;
                    }

                }

                public String toString() {
                    return "\n\t\t" + room_iD + ": " + room_name + "\n\t\t\tPoints:\n\t\t" + points + "\n\t\t\tDimensions:\n\t\t" + dimensions;
                }

            }

            public String toString() {
                StringBuilder roomsStr = new StringBuilder();
                for(Room r: floor_rooms) {
                    roomsStr.append(r);
                }
                return "\n\t" + floor_number + ": " + floor_name + ", Room Count: " + floor_rooms.size() + "\n\tFloor image: " + image_file + "\n" + roomsStr + "\n";
            }

        }

        public String toString() {
            StringBuilder floorsStr = new StringBuilder();
            for(Floor f: map_floors) {
                floorsStr.append(f);
            }
            return map_id + ": " + map_name + map_dimensions + ", Floor Count: " + map_floors.size() + "\n" + floorsStr;
        }
    }

}
