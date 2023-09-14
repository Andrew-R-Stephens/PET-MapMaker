package models;

import main.java.models.WorldMapWrapper;

import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public void forceRightAngle() {

        if(points.size() != 4) { return; }

        Point2D.Float p1 = points.get(0);
        Point2D.Float p2 = points.get(1);
        Point2D.Float p3 = points.get(2);
        Point2D.Float p4 = points.get(3);

        p2.x = Math.max(p1.x, p3.x);
        p4.x = Math.min(p1.x, p3.x);
        if(p1.x > p3.x) {
            float temp = p2.x;
            p2.x = p4.x;
            p4.x = temp;
        }

        p4.y = Math.max(p1.y, p3.y);
        p2.y = Math.min(p1.y, p3.y);
        if(p1.y > p3.y) {
            float temp = p2.y;
            p2.y = p4.y;
            p4.y = temp;
        }
    }

    public float round(float d, int decimalPlace) {
        return BigDecimal.valueOf(d).setScale(decimalPlace, RoundingMode.HALF_UP).floatValue();
    }

}
