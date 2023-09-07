package models;

import java.util.ArrayList;
import java.util.Map;

public class MapListModel {

    private RoomModel tempRoomModel = new RoomModel();

    private int currentMapID = 0;
    public ArrayList<MapModel> mapModels;

    public MapListModel(WorldMapWrapper worldMapWrapper) {
        mapModels = new ArrayList<>();

        for(Map<String, WorldMapWrapper.WorldMap> worldMap: worldMapWrapper.maps) {
            mapModels.add(new MapModel(worldMap.get("map_data")));
        }
    }

    public MapModel getCurrentMap() {
        if(currentMapID >= mapModels.size())
            return new MapModel();

        return mapModels.get(currentMapID);
    }

    public void createNewMap() {
        mapModels.add(new MapModel());
    }

    public void setCurrentMap(int selectedIndex) {
        if(selectedIndex >= mapModels.size()) {
            selectedIndex = Math.max(mapModels.size()-1, 0);
        }

        currentMapID = selectedIndex;
    }

    public void build(MapFileWriter writer) {
        for(MapModel mapModel: mapModels) {
            mapModel.build(writer);
        }
    }

    public RoomModel getTempRoomModel() {
        return tempRoomModel;
    }

    public void setTempRoomModel(RoomModel roomModel) {
        this.tempRoomModel = roomModel;
    }
}
