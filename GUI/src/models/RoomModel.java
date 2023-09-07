package models;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class RoomModel {

    private int id = -1;
    private String name = "";
    //private int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
    //private float x1 = -1, y1 = -1, x2 = -1, y2 = -1;

    private RoomArea roomArea = new RoomArea();

    public RoomModel() {
        setId(-1);
        setName("");
        //setCoordinates(-1, -1, -1, -1);
    }

    /**
     * Deep copy data from another RoomData
     * @param tempRoomData
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
/*

    private void setPoints(ArrayList<Point2D.Float> tempPoints) {
        for(Point2D.Float tempPoint: tempPoints) {
            this.points.add(new Point2D.Float(tempPoint.x, tempPoint.y));
        }
    }
*/

    /*
    public RoomModel(int id, String name, WorldMapWrapper.WorldMap.Floor.Room.RoomPoints points, WorldMapWrapper.WorldMap.Floor.Room.RoomDimensions dimensions) {
        setId(id);
        setName(name);
        setCoordinates(points.x, points.y, points.x + dimensions.w, points.y + dimensions.h);
    }
    */

    public RoomModel(int id, String name, WorldMapWrapper.WorldMap.Floor.Room.RoomPoints points) {
        setId(id);
        setName(name);
        //setPoints(points);
        roomArea.setPoints(points);
    }

    /*
    public void setX1(float x1) {
        this.x1 = x1;
    }

    public void setY1(float y1) {
        this.y1 = y1;
    }

    public void setX2(float x2) {
        this.x2 = x2;
    }

    public void setY2(float y2) {
        this.y2 = y2;
    }
    */

    /*
    public void setCoordinates(float x1, float y1, float x2, float y2) {
        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);

        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);

        addPoint(this.x1, this.y1);
        addPoint(this.x2, this.y1);
        addPoint(this.x2, this.y2);
        addPoint(this.x1, this.y2);
    }
    */

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
/*
    public void addPoint(float x, float y) {
        points.add(new Point2D.Float(x, y));
    }

    public void addPoint(Point2D.Float point) {
        points.add(point);
    }

    public ArrayList<Point2D.Float> getPoints() {
        return points;
    }*/
/*

    public float getWidth() {
        return this.x2 - this.x1;
    }

    public float getHeight() {
        return this.y2 - this.y1;
    }
*/

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*
    public float getX1() {
        return x1;
    }

    public float getY1() {
        return y1;
    }

    public float getX2() {
        return x2;
    }

    public float getY2() {
        return y2;
    }
    */

    /*
    public boolean isReady() {
        return (
                (this.getX1() >= 0 && this.getX2() >= 0 && this.getY1() >= 0 && this.getY2()>= 0) &&
                        (this.getWidth() > 0 && this.getHeight() >= 0)
        );
    }
    */

    public boolean hasName() {
        return !this.name.equals("");
    }

    public boolean hasId() {
        return this.id >= -1;
    }

    /*
    public void restrictPoint(float minX, float minY, float maxX, float maxY) {
        x1 = Math.max(x1, minX);
        y1 = Math.max(y1, minY);
        x2 = Math.min(x2, maxX);
        y2 = Math.min(y2, maxY);
    }
    */

    /*
    public void recalibrateCoordinates() {
        float x1 = this.x1, x2 = this.x2, y1 = this.y1, y2 = this.y2;

        this.x1 = Math.min(x1, x2);
        this.y1 = Math.min(y1, y2);
        this.x2 = Math.max(x1, x2);
        this.y2 = Math.max(y1, y2);
    }
    */

    /*
    public String toString() {
        return "\n\t\t[Room ID: " + id + "] [Room Name: " + name + "] [Coords: " + x1 + " " + y1 + " " + x2 + " " + y2 + "] [Dimensions: " + getWidth() + " " + getHeight() + "]";
    }
    */

    public String toString() {
        return "\n\t\t[Room ID: " + id + "] [Room Name: " + name + "] [Room points: " + roomArea + "]";
    }

    /*
    public WorldMapWrapper.WorldMap.Floor.Room buildRoom() {

        WorldMapWrapper.WorldMap.Floor.Room room = new WorldMapWrapper.WorldMap.Floor.Room();
        room.room_iD = id;
        room.room_name = name;
        WorldMapWrapper.WorldMap.Floor.Room.RoomPoints points = new WorldMapWrapper.WorldMap.Floor.Room.RoomPoints();
        points.x = x1;
        points.y = y1;
        room.points = points;
        WorldMapWrapper.WorldMap.Floor.Room.RoomDimensions dimensions = new WorldMapWrapper.WorldMap.Floor.Room.RoomDimensions();
        dimensions.w = getWidth();
        dimensions.h = getHeight();
        room.dimensions = dimensions;

        return room;
    }
    */

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
