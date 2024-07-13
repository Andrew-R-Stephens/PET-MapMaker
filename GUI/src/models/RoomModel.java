package models;

import main.java.models.WorldMapWrapper;

public class RoomModel {

    private int id = -1;
    private String name = "";
    private RoomArea roomArea = new RoomArea();

    public RoomModel() {
        setId(-1);
        setName("");
        //setCoordinates(-1, -1, -1, -1);
    }

    /**
     * Deep copy data from another RoomData
     */
    public RoomModel(RoomModel tempRoomData) {
        if(tempRoomData == null) { return; }

        setId(tempRoomData.getId());
        setName(tempRoomData.getName());
        setRoomArea(tempRoomData.getRoomArea());
    }

    public void setRoomArea(RoomArea tempRoomArea) {
        this.roomArea = new RoomArea(tempRoomArea);
        System.out.println("Setting room area " + roomArea);
    }

    public RoomArea getRoomArea() {
        return roomArea;
    }

    public RoomModel(int id, String name, WorldMapWrapper.WorldMap.Floor.Room.RoomPoints points) {
        setId(id);
        setName(name);
        //setPoints(points);
        roomArea.setPoints(points);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasName() {
        return !this.name.equals("");
    }

    public boolean hasId() {
        return this.id >= -1;
    }

    public String toString() {
        return "\n\t\t[Room ID: " + id + "] [Room Name: " + name + "] [Room points: " + roomArea + "]";
    }

    public WorldMapWrapper.WorldMap.Floor.Room buildRoom() {

        WorldMapWrapper.WorldMap.Floor.Room room = new WorldMapWrapper.WorldMap.Floor.Room();
        room.room_iD = id;
        room.room_name = name;
        WorldMapWrapper.WorldMap.Floor.Room.RoomPoints roomPoints = roomArea.buildRoomArea();
        room.room_points = roomPoints;

        return room;
    }

    public boolean isReady() {
        return roomArea != null && roomArea.getPoints().size() >= 3;
    }
}
