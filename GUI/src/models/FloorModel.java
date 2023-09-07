package models;

import java.util.ArrayList;
import java.util.Collections;

public class FloorModel {

    public int floorId;
    private String floorName;
    private String floorImage;

    private FloorLayer floorLayer;

    private final ArrayList<RoomModel> floorRooms = new ArrayList<>();

    /*
    public FloorModel(WorldMapWrapper.WorldMap.Floor floor) {
        floorImage = floor.image_file;
        floorId = floor.floor_id;
        floorName = floor.floor_name;
        floorLayer = FloorLayer.values()[floor.floor_number];

        for(WorldMapWrapper.WorldMap.Floor.Room r: floor.floor_rooms) {
            floorRooms.add(new RoomModel(r.room_iD, r.room_name, r.points, r.dimensions));
        }
    }
    */

    public FloorModel(WorldMapWrapper.WorldMap.Floor floor) {
        floorImage = floor.image_file;
        floorId = floor.floor_id;
        floorName = floor.floor_name;
        floorLayer = FloorLayer.values()[floor.floor_number];

        for(WorldMapWrapper.WorldMap.Floor.Room r: floor.floor_rooms) {
            floorRooms.add(new RoomModel(r.room_iD, r.room_name, r.room_points));
        }
    }

    public FloorModel(FloorLayer layer) {
        this.floorLayer = layer;
    }

    public void addImage(String fileName) {
        this.floorImage = fileName;
    }

    public String getFloorImage() {
        return floorImage;
    }

    public void addRoom(RoomModel passedRoomData) {
        if(passedRoomData.getId() == -1) {
            passedRoomData.setId(floorRooms.size());
            this.floorRooms.add(passedRoomData);
        } else {
            floorRooms.add(new RoomModel(passedRoomData));
        }
    }

    public ArrayList<RoomModel> getFloorRooms() {
        return floorRooms;
    }

    public String getFloorName() {
        return floorName;
    }

    public RoomModel getLastRoom() {
        if(floorRooms.size() == 0) {
            return null;
        }
        return floorRooms.get(floorRooms.size()-1);
    }

    public RoomModel getRoomById(int id) {
        for(RoomModel room: floorRooms) {
            if(room.getId() == id)
                return room;
        }

        return null;
    }

    public int getRoomIndexById(int id) {
        int i = 0;
        for(; i < floorRooms.size(); i++) {
            if(floorRooms.get(i).getId() == id)
                return i;
        }
        return ++i;
    }

    public FloorLayer getFloorLayer() {
        return floorLayer;
    }

    public int getNextAvailableId() {
        ArrayList<Integer> ids = new ArrayList<>();
        for (RoomModel room : floorRooms) {
            ids.add(room.getId());
        }
        Collections.sort(ids);
        int index = ids.size()-1;
        return index > -1 ? ids.get(index) + 1 : 0;
    }

    public boolean hasId(int id) {
        boolean idIsTaken = false;
        for(RoomModel r: floorRooms) {
            if(r.getId() == id)
                return idIsTaken;
        }
        return false;
    }

    public boolean hasMultipleOfId(int id) {
        int count = 0;
        for(RoomModel r: floorRooms) {
            if(r.getId() == id) {
                count++;
            }
            if(count >= 2) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "\n\t[Floor ID: " + floorId + "] [Floor Name: " + floorName + "] [ Assigned Layer: " + floorLayer + " ] [Image File: "  + floorImage + "] Rooms:"  + floorRooms + "\n";
    }

    public WorldMapWrapper.WorldMap.Floor buildFloor() {

        WorldMapWrapper.WorldMap.Floor floor = new WorldMapWrapper.WorldMap.Floor();
        floor.floor_name = floorName;
        floor.floor_number = floorLayer == null ? 1 : floorLayer.ordinal();
        floor.image_file = floorImage;

        for(RoomModel r: floorRooms) {
            floor.floor_rooms.add(r.buildRoom());
        }

        return floor;
    }

    public int getLayerIndex() {
        return buildFloor().floor_number;
    }

    public void setFloorName(String floorName) {
        this.floorName = floorName;
    }

    public void setFloorLayer(FloorLayer layer) {
        this.floorLayer = layer;
    }
}
