package main;

import main.java.models.*;
import models.*;
import views.MapImageViewPanel;
import views.MapMakerGUIWrapper;
import views.RoomJListCellRenderer;
import views.RoomSpinner;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {

    private static MapFileIO mapFileIO;

    private static ImagesModel imageData;
    private static MapListModel mapListModel;

    private static MapMakerGUIWrapper window;

    private static MapImageViewPanel panel_mapView;

    private static JMenu menu_file;
    private static JMenuItem menuItem_open, menuItem_loadMap, menuItem_createNewMap, menuItem_saveAll;
    private static JPopupMenu popupMenu_loadMap;
    private static JFileChooser fileChooser_open;
    private static JList<String> popupMenu_loadMap_mapList;
    private static JButton popupMenu_loadMap_button_confirm, popupMenu_loadMap_button_cancel;

    private static JTextField textField_mapName, textField_floorName;

    private static JTabbedPane tabbedPane;

    private static JButton
            button_addFloor, button_removeFloor,
            button_floorDecrement, button_floorIncrement,
            button_addPOI, button_removePOI,
            button_addRoom, button_removeRoom,
            button_forceRightAngle;

    private static FloorTypeComboBox<String> jComboBox_floorTypes, jComboBox_poiTypes;
    private static JComboBox<String> jComboBox_floorImage;

    private static JList<String> jList_roomList, jList_poiList;

    private static JTextField textField_roomName, textField_poiName;
    private static JSpinner spinner_roomID, spinner_poiID, spinner_poix, spinner_poiy;

    private static RoomSpinner spinner_points, spinner_x, spinner_y;

    public static void main(String[] args) {

        initData();

        initWindow();
        initMenuComponents();
        initListeners();

        window.build();

    }

    public static void initData() {
        System.out.println("Initializing Data");

        //loadFile("./GUI/res/maps.json");

        imageData = new ImagesModel();

    }

    public static void initWindow() {

        window = new MapMakerGUIWrapper();

        panel_mapView = window.getMapViewPanel();

        menu_file = window.getMenu_file();

        textField_mapName = window.getTextField_mapName();
        textField_floorName = window.getTextField_floorName();

        menuItem_open = window.getMenuItem_open();
        menuItem_loadMap = window.getMenuItem_loadMap();
        menuItem_createNewMap = window.getMenuItem_createNewMap();
        menuItem_saveAll = window.getMenuItem_saveAll();

        popupMenu_loadMap = window.getPopupMenu_loadMap();
        popupMenu_loadMap_mapList = window.getPopupMenu_loadMap_mapList();

        fileChooser_open = window.getFileChooser_open();
        fileChooser_open.setCurrentDirectory(new File("./GUI/res/"));

        popupMenu_loadMap_button_confirm = window.getButton_popup_loadMap_confirm();
        popupMenu_loadMap_button_cancel = window.getButton_popup_loadmap_cancel();

        button_addFloor = window.getButton_addFloor();
        button_removeFloor = window.getButton_removeFloor();

        button_floorDecrement = window.getButton_floorDecrement() ;
        button_floorIncrement = window.getButton_floorIncrement();

        tabbedPane = window.getTabbedPane();

        button_addPOI = window.getButton_addpoi();
        button_removePOI = window.getButton_removepoi();

        jComboBox_poiTypes = window.getComboBox_poitType();

        jList_poiList = window.getJList_poiList();

        textField_poiName = window.getTextField_poiName();
        spinner_poiID = window.getTextField_poiID();

        spinner_poix = window.getSpinner_poix();
        spinner_poiy = window.getSpinner_poiy();

        button_addRoom = window.getButton_addRoom();
        button_removeRoom = window.getButton_removeRoom();

        button_forceRightAngle = window.getButton_forceRightAngle();

        jComboBox_floorTypes = window.getComboBox_floorTypes();
        jComboBox_floorImage = window.getComboBox_floorImage();

        jList_roomList = window.getScrollView_roomList();

        textField_roomName = window.getTextField_roomName() ;
        spinner_roomID = window.getTextField_roomID();

        spinner_points = window.getSpinner_points();
        spinner_x = window.getSpinner_x();
        spinner_y = window.getSpinner_y();

    }

    public static void initComponents() {
        initMenuComponents();
        initMapComponents();

        initMapListeners();
    }

    public static void initMapComponents() {

        panel_mapView.init(
                mapListModel,
                button_addFloor,
                jList_roomList,
                jList_poiList,
                textField_roomName,
                spinner_points, spinner_x, spinner_y
        );

        MapModel mapModel = mapListModel.getCurrentMap();
        jComboBox_floorTypes.setSelectedIndex(mapModel.getCurrentLayerOrdinal());

        SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel();
        spinnerNumberModel.setMinimum(0);
        spinner_roomID.setModel(spinnerNumberModel);

        textField_roomName.setCaretColor(Color.WHITE);
        textField_mapName.setText(mapListModel.getCurrentMap().mapName);
        textField_floorName.setText(mapListModel.getCurrentMap().getCurrentFloor().getFloorName());
        spinner_points.setModel(new SpinnerNumberModel(0, 0, Integer.MAX_VALUE, 1));
        spinner_x.setModel(new SpinnerNumberModel(0, -10, 10, .001));
        spinner_y.setModel(new SpinnerNumberModel(0, -10, 10, .001));

        menuItem_loadMap.setComponentPopupMenu(popupMenu_loadMap);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "*.json", "json");
        fileChooser_open.setFileFilter(filter);

        fillDataOfRoomViews(new RoomModel());
    }

    public static void initMenuComponents() {

        menuItem_loadMap.setComponentPopupMenu(popupMenu_loadMap);

        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "*.json", "json");
        fileChooser_open.setFileFilter(filter);

        for(String key: imageData.getKeySet()) {
            jComboBox_floorImage.addItem(key);
        }

        for(PoiType type: PoiType.values()) {
            jComboBox_poiTypes.addItem(type.name());
        }

        updateFloorTypeSpinner();

    }

    public static void initListeners() {
        initMenuListeners();
        initMapListeners();
    }

    public static void initMenuListeners() {

        menuItem_createNewMap.addActionListener(e -> {
            mapListModel.createNewMap();
        });

        menuItem_loadMap.addActionListener(e -> {
            menuItem_loadMap.getComponentPopupMenu().show(menu_file, 0, 0);
            DefaultListModel<String> listModel = new DefaultListModel<>();
            for(MapModel m: mapListModel.mapModels) {
                String element = m.mapName;
                listModel.addElement(element);
            }

            popupMenu_loadMap_mapList.setModel(listModel);
            popupMenu_loadMap_mapList.setSelectedIndex(popupMenu_loadMap_mapList.getFirstVisibleIndex());

            updateRoomsListView();
        });

        popupMenu_loadMap_button_cancel.addActionListener(e -> {
            menuItem_loadMap.getComponentPopupMenu().setVisible(false);
        });

        popupMenu_loadMap_button_confirm.addActionListener(e -> {
            mapListModel.setCurrentMap(popupMenu_loadMap_mapList.getSelectedIndex());
            MapModel mapModel = mapListModel.getCurrentMap();

            System.out.println(mapModel);

            resetDataOfRoomViews();
            resetDataOfPoiViews();

            panel_mapView.setImage(imageData.getValue(mapListModel.getCurrentMap().getCurrentFloor().getFloorImage()));
            textField_mapName.setText(mapListModel.getCurrentMap().mapName);
            textField_floorName.setText(mapListModel.getCurrentMap().getCurrentFloor().getFloorName());
            jComboBox_floorTypes.setSelectedIndex(mapModel.getCurrentLayerOrdinal());
            System.out.println("Selected type " + jComboBox_floorTypes.getSelectedIndex());

            button_addPOI.setText("Add POI");

            updateRoomsListView();
            updatePoisListView();

            menuItem_loadMap.getComponentPopupMenu().setVisible(false);
            panel_mapView.repaint();
        });

        menuItem_open.addActionListener(e -> {

            int returnVal = fileChooser_open.showOpenDialog(panel_mapView);
            String filePath = "";
            if(returnVal == JFileChooser.APPROVE_OPTION) {
                filePath = fileChooser_open.getSelectedFile().getName();
                System.out.println("You chose to open this file: " + filePath);
                loadFile(filePath);

                mapListModel.setCurrentMap(0);
                mapListModel.getCurrentMap().setCurrentLayer(mapListModel.getCurrentMap().getFloor(0).getFloorLayer());

                updateRoomsListView();
                resetDataOfRoomViews();
            }
        });

        menuItem_saveAll.addActionListener(e -> {
            saveFile();
        });

    }

    public static void initMapListeners() {

        button_addFloor.addActionListener(e -> {
            MapModel currentMap = mapListModel.getCurrentMap();
            currentMap.addFloor(FloorLayer.values()[currentMap.getCurrentLayerOrdinal()+1]);
            FloorModel currentFloor = currentMap.getCurrentFloor();
            currentMap.setCurrentLayer(FloorLayer.values()[currentFloor.getFloorLayer().ordinal()+1]);

            resetDataOfRoomViews();
            panel_mapView.repaint();
        });

        button_removeFloor.addActionListener(e -> {
            FloorModel currentFloor = mapListModel.getCurrentMap().getCurrentFloor();
            System.out.println(mapListModel.getCurrentMap().removeFloor(currentFloor));

            resetDataOfRoomViews();
            panel_mapView.repaint();
        });

        textField_mapName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) { }
            @Override
            public void focusLost(FocusEvent e) {
                mapListModel.getCurrentMap().mapName = textField_mapName.getText();
            }
        });

        textField_floorName.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) { }
            @Override
            public void focusLost(FocusEvent e) {
                mapListModel.getCurrentMap().getCurrentFloor().setFloorName(textField_floorName.getText());
            }
        });
        spinner_points.addChangeListener(e -> {
            RoomModel tempRoom = mapListModel.getTempRoomModel();
            spinner_x.setValue(tempRoom.getRoomArea().getPoints().get(Integer.parseInt(String.valueOf(spinner_points.getValue()))));
            panel_mapView.repaint();
        });
        spinner_x.addChangeListener(e -> {
            RoomModel tempRoom = mapListModel.getTempRoomModel();
            tempRoom.getRoomArea().getPoints().get(Integer.parseInt(String.valueOf(spinner_points.getValue()))).x = Integer.parseInt(String.valueOf(spinner_x.getValue()));

            panel_mapView.repaint();
        });
        spinner_y.addChangeListener(e -> {
            RoomModel tempRoom = mapListModel.getTempRoomModel();
            tempRoom.getRoomArea().getPoints().get(Integer.parseInt(String.valueOf(spinner_points.getValue()))).x = Integer.parseInt(String.valueOf(spinner_y.getValue()));

            panel_mapView.repaint();
        });

        jComboBox_floorImage.addItemListener(e -> {
            BufferedImage image = imageData.getValue(e.getItem().toString());
            panel_mapView.setImage(image);
        });

        button_addRoom.addActionListener(e -> {
            if(button_addRoom.getText().equals("Add Room")) {
                addTempRoomToFloorModel();
            }
            if(button_addRoom.getText().equals("Save Room")) {
                updateRoom(jList_roomList.getSelectedIndex());
                button_addRoom.setText("Add Room");
            }
        });

        button_removeRoom.addActionListener(e -> {
            int selectedIndex = jList_roomList.getSelectedIndex();
            MapModel mapModel = mapListModel.getCurrentMap();
            if(selectedIndex >= 0 && selectedIndex < mapModel.getCurrentFloor().getFloorRooms().size()) {
                jList_roomList.clearSelection();
                mapModel.getCurrentFloor().getFloorRooms().remove(selectedIndex);
                panel_mapView.repaint();
                mapListModel.setTempRoomModel(new RoomModel());
                resetDataOfRoomViews();
                updateRoomsListView();
                button_addRoom.setText("Add Room");
            }
        });

        jList_roomList.addListSelectionListener(e -> {
            if(e.getValueIsAdjusting()) {
                return;
            }

            int selectedIndex = jList_roomList.getSelectedIndex();
            MapModel mapModel = mapListModel.getCurrentMap();
            if(selectedIndex < 0 || selectedIndex > mapModel.getCurrentFloor().getFloorRooms().size()-1) {

                panel_mapView.repaint();
                button_addRoom.setText("Save Room");

                mapListModel.setTempRoomModel(new RoomModel());
                fillDataOfRoomViews(mapListModel.getTempRoomModel());

                return;
            }
            RoomModel roomData = mapModel.getCurrentFloor().getFloorRooms().get(selectedIndex);
            if(roomData != null) {
                System.out.println(roomData.getId() + " " + roomData.getName());
                fillDataOfRoomViews(roomData);
            }
            panel_mapView.repaint();
            button_addRoom.setText("Save Room");

            mapListModel.setTempRoomModel(new RoomModel(roomData));
        });

        panel_mapView.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(mapListModel == null || mapListModel.getCurrentMap() == null) {
                    return;
                }

                MapModel mapModel = mapListModel.getCurrentMap();
                switch(tabbedPane.getSelectedIndex()) {
                    case 0 -> {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            mapListModel.getTempRoomModel().setId(mapModel.getCurrentFloor().getNextAvailableRoomId());
                            jList_roomList.clearSelection();
                            jList_roomList.setSelectedIndex(-1);
                            resetDataOfRoomViews();
                            button_addRoom.setText("Add Room");
                            System.out.println("JList rooms Cleared");
                        }
                    }
                    case 1 -> {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            mapListModel.getTempPoiModel().setId(mapModel.getCurrentFloor().getNextAvailablePoiId());
                            //jList_poiList.clearSelection();
                            //jList_poiList.setSelectedIndex(-1);
                            //resetDataOfPoiViews();
                            //button_addPOI.setText("Add POI");
                            //System.out.println("JList pois Cleared");
                        }
                    }
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                //resetDataOfRoomViews();
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                switch(tabbedPane.getSelectedIndex()) {
                    case 0 -> {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (textField_roomName.getText().length() == 0) {
                                textField_roomName.requestFocus();
                            } else {
                                button_addRoom.requestFocus();
                            }
                        }
                    }
                    case 1 -> {
                        if (e.getButton() == MouseEvent.BUTTON1) {
                            if (textField_poiName.getText().length() == 0) {
                                textField_poiName.requestFocus();
                            } else {
                                button_addPOI.requestFocus();
                            }
                        }
                    }
                }

                panel_mapView.repaint();

            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        jComboBox_floorTypes.addActionListener(e -> {
            MapModel mapModel = mapListModel.getCurrentMap();
            FloorLayer currentLayer = mapModel.getCurrentFloor().getFloorLayer();
            int selectedIndex = jComboBox_floorTypes.getSelectedIndex();
            FloorLayer selectedLayer = selectedIndex < 0 ? null : FloorLayer.values()[selectedIndex];
            boolean success = selectedLayer == mapModel.setCurrentLayer(selectedLayer);
            if(!success){
                jComboBox_floorTypes.setSelectedIndex(currentLayer.ordinal());
                System.err.println("Layer does not exist!");
                return;
            }

            textField_floorName.setText(mapModel.getCurrentFloor().getFloorName());
            String imageFile = mapModel.getCurrentFloor().getFloorImage();
            panel_mapView.setImage(imageData.getValue(imageFile));
            jComboBox_floorImage.setSelectedItem(imageFile);

            updateRoomsListView();
            updatePoisListView();
            panel_mapView.repaint();
        });

        jComboBox_poiTypes.addActionListener(e -> {
            int selectedIndex = jComboBox_poiTypes.getSelectedIndex();
            PoiType selectedType = selectedIndex < 0 ? null : PoiType.values()[selectedIndex];
            mapListModel.getTempPoiModel().setType(selectedType);

            //updatePoisListView();
            panel_mapView.repaint();
        });

        jComboBox_floorImage.addActionListener(e -> {
            MapModel mapModel = mapListModel.getCurrentMap();
            mapModel.setCurrentLayer(FloorLayer.values()[jComboBox_floorTypes.getSelectedIndex()]);

            FloorModel currentFloor = mapModel.getCurrentFloor();
            if(currentFloor != null) {
                currentFloor.addImage(String.valueOf(jComboBox_floorImage.getModel().getSelectedItem()));
            }

            panel_mapView.repaint();
        });

        button_floorIncrement.addActionListener(e -> {
            MapModel currentMap = mapListModel.getCurrentMap();

            currentMap.incrementLayer();

            panel_mapView.setImage(imageData.getValue(currentMap.getCurrentFloor().getFloorImage()));
            textField_mapName.setText(currentMap.mapName);
            textField_floorName.setText(currentMap.getCurrentFloor().getFloorName());

            updateRoomsListView();
            panel_mapView.repaint();
        });

        button_floorDecrement.addActionListener(e -> {
            MapModel currentMap = mapListModel.getCurrentMap();

            mapListModel.getCurrentMap().decrementLayer();

            panel_mapView.setImage(imageData.getValue(currentMap.getCurrentFloor().getFloorImage()));
            textField_mapName.setText(currentMap.mapName);
            textField_floorName.setText(currentMap.getCurrentFloor().getFloorName());

            updateRoomsListView();
            panel_mapView.repaint();
        });

        button_forceRightAngle.addActionListener(e -> {
            //if(button_forceRightAngle.isEnabled()) { return; }
            mapListModel.getTempRoomModel().getRoomArea().forceRightAngle();
            panel_mapView.repaint();
        });

        jList_roomList.addKeyListener(new KeyListener());

        tabbedPane.addChangeListener(e -> {
            if(mapListModel == null) { return; }

            switch (tabbedPane.getSelectedIndex()) {
                case 0 -> {
                    mapListModel.setTempPoiModel(null);
                    mapListModel.setTempRoomModel(new RoomModel());
                }
                case 1 -> {
                    mapListModel.setTempRoomModel(null);
                    mapListModel.setTempPoiModel(new PoiModel());
                }
            }
        });

        button_addPOI.addActionListener(e -> {
            if(button_addPOI.getText().equals("Add POI")) {
                addTempPoiToFloorModel();
            }
            if(button_addPOI.getText().equals("Save POI")) {
                updatePoi(jList_poiList.getSelectedIndex());
                button_addPOI.setText("Add POI");
            }
        });

        button_removePOI.addActionListener(e -> {
            int selectedIndex = jList_poiList.getSelectedIndex();
            MapModel mapModel = mapListModel.getCurrentMap();
            if(selectedIndex >= 0 && selectedIndex < mapModel.getCurrentFloor().getFloorPOIs().size()) {
                jList_poiList.clearSelection();
                mapModel.getCurrentFloor().getFloorPOIs().remove(selectedIndex);
                System.out.println("Removed and current size is " + mapModel.getCurrentFloor().getFloorPOIs().size());
                panel_mapView.repaint();
                panel_mapView.setTempPoi(new PoiModel());
                resetDataOfPoiViews();
                updatePoisListView();
                button_addPOI.setText("Add POI");
            }
        });

        jList_poiList.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) {
                System.out.println("Adjusting");
                return;
            }
            System.out.println("Not adjusting");

            int selectedIndex = jList_poiList.getSelectedIndex();
            MapModel mapModel = mapListModel.getCurrentMap();
            if (selectedIndex < 0 || selectedIndex > mapModel.getCurrentFloor().getFloorPOIs().size() - 1) {
                System.out.println("PoiData selection OOB");

                panel_mapView.repaint();
                button_addPOI.setText("Save POI");

                panel_mapView.setTempPoi(new PoiModel());
                fillDataOfPoiViews(mapListModel.getTempPoiModel());

                return;
            }

            PoiModel poiData = mapModel.getCurrentFloor().getFloorPOIs().get(selectedIndex);
            if (poiData != null) {
                System.out.println("PoiData exists" + poiData.getId() + " " + poiData.getName());
                fillDataOfPoiViews(poiData);
            }
            panel_mapView.repaint();
            button_addPOI.setText("Save POI");

            mapListModel.setTempPoiModel(new PoiModel(poiData));
            System.out.println("TempModel: " + mapListModel.getTempPoiModel());
        });
    }

    public static void updateFloorTypeSpinner() {

        jComboBox_floorTypes.removeAllItems();
        for(FloorLayer layer: FloorLayer.values()) {
            jComboBox_floorTypes.addItem(layer.name());
        }
        EnabledComboBoxRenderer renderer = new EnabledComboBoxRenderer(new DefaultListSelectionModel());
        renderer.setDisabledColor(Color.LIGHT_GRAY);
        jComboBox_floorTypes.setRenderer(renderer);

    }

    public static void resetDataOfRoomViews() {
        MapModel mapModel = mapListModel.getCurrentMap();
        textField_mapName.setText(mapModel.mapName);
        fillDataOfRoomViews(mapListModel.getTempRoomModel());
    }

    public static void resetDataOfPoiViews() {
        fillDataOfPoiViews(mapListModel.getTempPoiModel());
    }

    public static void fillDataOfRoomViews(RoomModel roomData) {
        for(int i = 0; i < jComboBox_floorImage.getModel().getSize(); i++) {
            MapModel mapModel = mapListModel.getCurrentMap();
            FloorModel floorModel = mapModel.getCurrentFloor();
            String imageName = floorModel != null ? floorModel.getFloorImage() : null;
            if(imageName != null && imageName.equals(jComboBox_floorImage.getModel().getElementAt(i))) {
                jComboBox_floorImage.setSelectedItem(jComboBox_floorImage.getItemAt(i));
            }
        }
        if(roomData != null) {
            textField_roomName.setText(roomData.getName());
            spinner_roomID.setValue(roomData.getId());
        }

    }

    public static void fillDataOfPoiViews(PoiModel poiData) {

        if(poiData != null) {
            textField_poiName.setText(poiData.getName());
            spinner_poiID.setValue(poiData.getId());
            jComboBox_poiTypes.setSelectedIndex(poiData.getType().ordinal());
        }

    }

    public static void addTempRoomToFloorModel() {
        if(!mapListModel.getTempRoomModel().isReady()){
            System.out.println("Room not ready");
            return;
        }
        System.out.println("Adding temp floor to model");
        System.out.println(mapListModel.getTempRoomModel());
        System.out.println("----");

        if(!mapListModel.getTempRoomModel().hasName())
            mapListModel.getTempRoomModel().setName(textField_roomName.getText());

        MapModel currentMap = mapListModel.getCurrentMap();
        if(!mapListModel.getTempRoomModel().hasId()) {
            if (currentMap.getCurrentFloor().hasId(Integer.parseInt(String.valueOf(spinner_roomID.getValue())))) {
                mapListModel.getTempRoomModel().setId(currentMap.getCurrentFloor().getNextAvailableRoomId());
            }
        }
        currentMap.getCurrentFloor().addRoom(new RoomModel(mapListModel.getTempRoomModel()));

        mapListModel.setTempRoomModel(new RoomModel());

        panel_mapView.repaint();
        updateRoomsListView();

    }

    public static void addTempPoiToFloorModel() {
        if(!mapListModel.getTempPoiModel().isReady()){
            System.out.println("POI not ready");
            return;
        }

        PoiModel tempPoiModel = mapListModel.getTempPoiModel();

        System.out.println("Adding temp floor to model");
        System.out.println(tempPoiModel);
        System.out.println("----");

        if(!tempPoiModel.hasName())
            tempPoiModel.setName(textField_poiName.getText());

        MapModel currentMap = mapListModel.getCurrentMap();
        if(!tempPoiModel.hasId()) {
            if (currentMap.getCurrentFloor().hasId(Integer.parseInt(String.valueOf(spinner_poiID.getValue())))) {
                tempPoiModel.setId(currentMap.getCurrentFloor().getNextAvailablePoiId());
            }
        }
        currentMap.getCurrentFloor().addPoi(new PoiModel(tempPoiModel));

        mapListModel.setTempPoiModel(new PoiModel());

        panel_mapView.repaint();
        updatePoisListView();

    }

    public static void updateRoom(int listIndex) {

        RoomModel existingRoom = mapListModel.getCurrentMap().getCurrentFloor().getFloorRooms().get(listIndex);
        existingRoom.setName(textField_roomName.getText());
        existingRoom.setId(Integer.parseInt(String.valueOf(spinner_roomID.getValue())));
        existingRoom.setRoomArea(mapListModel.getTempRoomModel().getRoomArea());

        panel_mapView.repaint();
        updateRoomsListView();
    }

    public static void updatePoi(int listIndex) {

        PoiModel existingPoi = mapListModel.getCurrentMap().getCurrentFloor().getFloorPOIs().get(listIndex);
        existingPoi.setName(textField_poiName.getText());
        existingPoi.setId(Integer.parseInt(String.valueOf(spinner_poiID.getValue())));
        existingPoi.setPoint(mapListModel.getTempPoiModel().getPoint());
        existingPoi.setType(mapListModel.getTempPoiModel().getType());
        jComboBox_poiTypes.setSelectedIndex(existingPoi.getType().ordinal());
        System.out.println("Updated POI: " + existingPoi + " " + jComboBox_poiTypes.getSelectedItem());

        panel_mapView.repaint();
        updatePoisListView();

    }

    public static void updateRoomsListView() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        RoomJListCellRenderer renderer = new RoomJListCellRenderer();

        System.out.println("Current Floor " + mapListModel.getCurrentMap().getCurrentFloor());
        FloorModel floorModel = mapListModel.getCurrentMap().getCurrentFloor();
        for(int i = 0; i < floorModel.getFloorRooms().size(); i++) {
            RoomModel room = mapListModel.getCurrentMap().getCurrentFloor().getFloorRooms().get(i);

            boolean hasIdError = mapListModel.getCurrentMap().getCurrentFloor().hasMultipleOfId(room.getId());
            renderer.addIndexError(hasIdError);

            listModel.addElement(room.getId() + ": " + room.getName());
        }

        jList_roomList.setCellRenderer(renderer);
        jList_roomList.setModel(listModel);
    }

    public static void updatePoisListView() {

        DefaultListModel<String> listModel = new DefaultListModel<>();
        RoomJListCellRenderer renderer = new RoomJListCellRenderer();

        System.out.println("Current Floor " + mapListModel.getCurrentMap().getCurrentFloor());
        FloorModel floorModel = mapListModel.getCurrentMap().getCurrentFloor();
        for(int i = 0; i < floorModel.getFloorPOIs().size(); i++) {
            PoiModel poi = mapListModel.getCurrentMap().getCurrentFloor().getFloorPOIs().get(i);

            boolean hasIdError = mapListModel.getCurrentMap().getCurrentFloor().hasMultipleOfId(poi.getId());
            renderer.addIndexError(hasIdError);

            listModel.addElement(poi.getId() + ": " + poi.getName());
        }

        jList_poiList.setCellRenderer(renderer);
        jList_poiList.setModel(listModel);
    }

    public RoomModel getTempRoom() {
        return mapListModel.getTempRoomModel();
    }

    public static void loadFile(String file) {
        System.out.println(file);
        mapFileIO = new MapFileIO(file);
        MapFileReader reader = new MapFileReader(new WorldMapWrapper());
        if(mapFileIO.readFile(reader)) {
            System.out.println("Loaded file:\n" + mapFileIO);
        }
        mapListModel = new MapListModel(reader.mapsWrapper);

        initMapComponents();
    }

    public static void saveFile() {
        mapFileIO.setFile("./GUI/res/maps.json");
        MapFileWriter writer = new MapFileWriter(new WorldMapWrapper());
        mapListModel.build(writer);
        System.out.println("-----\nPrepped JSON:\n");
        System.out.println(writer.mapsWrapper.maps);
        mapFileIO.writeFile(writer);
    }


    static class KeyListener implements java.awt.event.KeyListener {

        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) { }

        @Override
        public void keyReleased(KeyEvent e) {
            switch(e.getKeyCode()) {
                case KeyEvent.VK_S: {
                    if(mapListModel.getTempRoomModel() != null) {
                        System.out.println("Attempting to square selection.");
                        mapListModel.getTempRoomModel().getRoomArea().forceRightAngle();
                        panel_mapView.repaint();
                    }
                }
            }
        }
    }


}
