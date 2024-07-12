package main.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class WorldMapWrapper {

    public List<Map<String, WorldMap>> maps = new ArrayList<>();

    public static class WorldMap {

        public int map_id;
        public String map_name = "";
        public String map_name_short = "";
        public ArrayList<Floor> map_floors = new ArrayList<>();
        public WorldDimensions map_dimensions = new WorldDimensions();

        public static class WorldDimensions {

            public int w, h;

            public String toString() {
                return "\n\tMap Dimensions:\n\t\tW: " + w + ", H: " + h;
            }

        }

        public static class Floor {

            public int floor_id;
            public int floor_number;
            public String floor_name = "";
            public String image_file = "";
            public ArrayList<POI> floor_pois = new ArrayList<>();
            public ArrayList<Room> floor_rooms = new ArrayList<>();

            public static class Room {

                public int room_iD;
                public String room_name = "";

                public RoomPoints room_points = new RoomPoints();

                public String toString() {
                    //return "\n\t\t" + room_iD + ": " + room_name + "\n\t\t\tPoints:\n\t\t" + points + "\n\t\t\tDimensions:\n\t\t" + dimensions;
                    return "\n\t\t" + room_iD + ": " + room_name + "\n\t\t\tPoints:" + room_points;
                }

                public static class RoomPoints {

                    public ArrayList<RoomPoint> points = new ArrayList<>();

                    public String toString() {
                        StringBuilder pointsStr = new StringBuilder();
                        for (RoomPoint r : points) {
                            pointsStr.append(r);
                        }
                        return pointsStr.toString();
                    }

                    public static class RoomPoint {

                        public float x = 0;
                        public float y = 0;

                        public String toString() {
                            return "\n\t\t\t\t[x: " + x + ", y: " + y + "]";
                        }
                    }
                }
            }

            public static class POI {

                public int poi_iD;
                public String poi_name = "";
                public int poi_type = -1;

                public float x = 0;
                public float y = 0;

                public String toString() {
                    return "\n\t\t" + poi_iD + ": " + poi_name + ", Type:" + poi_name + "\n\t\t\tPoints: " + x + " " + y;
                }

            }

            public String toString() {
                StringBuilder roomsStr = new StringBuilder();
                for (Room r : floor_rooms) {
                    roomsStr.append(r);
                }

                StringBuilder poiStr = new StringBuilder();
                for (POI p : floor_pois) {
                    poiStr.append(p);
                }

                return "\n\t" + floor_number + ": " + floor_name + ", Room Count: " + floor_rooms.size() + "\n\tFloor image: " + image_file + "\nRooms\n" + roomsStr + "\nPOIs\n" + poiStr + "\n";
            }

        }

        public String toString() {
            StringBuilder floorsStr = new StringBuilder();
            for (Floor f : map_floors) {
                floorsStr.append(f);
            }
            return map_id + ": " + map_name + ", " + map_name_short + ", " + map_dimensions + ", Floor Count: " + map_floors.size() + "\n" + floorsStr;
        }
    }
}