package models;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class RoomArea {

    private ArrayList<Point2D.Float> points = new ArrayList<>();

    public RoomArea() { }

    public RoomArea(RoomArea tempRoomArea) {
        setPoints(tempRoomArea.getPoints());
    }

    public void setPoints(ArrayList<Point2D.Float> tempPoints) {
        for(Point2D.Float tempPoint: tempPoints) {
            addPoint(new Point2D.Float(tempPoint.x, tempPoint.y));
        }
    }

    public void setPoints(WorldMapWrapper.WorldMap.Floor.Room.RoomPoints tempPoints) {
        if(tempPoints == null || tempPoints.points == null) return;
        for(WorldMapWrapper.WorldMap.Floor.Room.RoomPoints.RoomPoint tempPoint: tempPoints.points) {
            addPoint(new Point2D.Float(tempPoint.x, tempPoint.y));
        }
    }

    public void reset() {
        points = new ArrayList<>();
    }

    public void addPoint(float x, float y) {
        points.add(new Point2D.Float(x, y));
    }

    public void addPoint(Point2D.Float point) {
        points.add(point);
    }

    public ArrayList<Point2D.Float> getPoints() {
        return points;
    }

    public Point2D.Float getLastPoint() {
        if(points.size() == 0) {
            return null;
        }

        return points.get(points.size()-1);
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Point2D.Float p: points) {
            s.append("\n\t\t[Point: x").append(p.x).append(" y").append(p.y).append("]");
        }
        return "[Points:" + s + "\t]";
    }

    public WorldMapWrapper.WorldMap.Floor.Room.RoomPoints buildRoomArea() {

        WorldMapWrapper.WorldMap.Floor.Room.RoomPoints room_points = new WorldMapWrapper.WorldMap.Floor.Room.RoomPoints();

        for(Point2D.Float p: points) {
            WorldMapWrapper.WorldMap.Floor.Room.RoomPoints.RoomPoint temp_point = new WorldMapWrapper.WorldMap.Floor.Room.RoomPoints.RoomPoint();
            temp_point.x = p.x;
            temp_point.y = p.y;
            room_points.points.add(temp_point);
        }

        return room_points;
    }

}
