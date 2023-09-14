package models;

import main.java.models.WorldMapWrapper;

import java.awt.geom.Point2D;

public class PoiModel {

    private int id = -1;
    private String name = "";
    private PoiType type = PoiType.values()[0];
    private Point2D.Float point = null;

    public PoiModel() {
        setId(-1);
        setName("");
    }

    public PoiModel(PoiModel tempPoiData) {
        if(tempPoiData == null) { return; }

        setId(tempPoiData.getId());
        setName(tempPoiData.getName());
        setType(tempPoiData.getType());
        setPoint(tempPoiData.getPoint());
    }

    public void setPoint(Point2D.Float tempPoiData) {
        this.point = tempPoiData;
    }

    public Point2D.Float getPoint() {
        return point;
    }

    public PoiModel(int id, String name, int type, float x, float y) {
        setId(id);
        setName(name);
        setType(type);
        setPoint(new Point2D.Float(x, y));
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

    public void setType(PoiType type) {
        this.type = type;
    }

    public void setType(int type) {
        setType(PoiType.values()[type]);
    }

    public PoiType getType() {
        return type;
    }

    public boolean hasName() {
        return !this.name.equals("");
    }

    public boolean hasId() {
        return this.id >= -1;
    }

    public String toString() {
        return "\n\t\t[Room ID: " + id + "] [Room Name: " + name + "] [Room Name: " + type + "] [Room points: " + point + "]";
    }

    public WorldMapWrapper.WorldMap.Floor.POI buildPoi() {

        WorldMapWrapper.WorldMap.Floor.POI poi = new WorldMapWrapper.WorldMap.Floor.POI();
        poi.poi_iD = id;
        poi.poi_type = type.ordinal();
        poi.poi_name = name;
        poi.x = point.x;
        poi.y = point.y;

        return poi;
    }

    public boolean isReady() {
        return point != null;
    }
}
