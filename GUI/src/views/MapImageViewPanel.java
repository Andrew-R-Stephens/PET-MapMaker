package views;

import models.MapListModel;
import models.PoiModel;
import models.RoomModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MapImageViewPanel extends JPanel {

    private MapListModel mapListModel;

    private BufferedImage image;
    private int renderWidth, renderHeight;

    private JButton button_addRoom;
    private JTextField textField_roomName;

    private JList<String> jList_roomList, jList_poiList;

    private RoomSpinner spinner_points, spinner_x, spinner_y;

    private MapPointThread mapPointThread;
    private MouseEvent currentMouseEvent;

    public void init(MapListModel mapListModel,
                     JButton button_addRoom,
                     JList<String> jList_roomList,
                     JList<String> jList_poiList,
                     JTextField textField_roomName,
                     RoomSpinner spinner_points,
                     RoomSpinner spinner_x, RoomSpinner spinner_y) {

        this.mapListModel = mapListModel;

        this.button_addRoom = button_addRoom;
        this.textField_roomName = textField_roomName;

        this.jList_roomList = jList_roomList;
        this.jList_poiList = jList_poiList;

        this.spinner_points = spinner_points;
        this.spinner_x = spinner_x;
        this.spinner_y = spinner_y;

        MapPanelListener listener = new MapPanelListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

        addKeyListener(new KeyListener());

        addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                setImage(image);
            }

            @Override
            public void componentMoved(ComponentEvent e) { }

            @Override
            public void componentShown(ComponentEvent e) { }

            @Override
            public void componentHidden(ComponentEvent e) { }
        });

        mapPointThread = new MapPointThread(new MapPointRunnable());
        mapPointThread.start();

    }

    public void setImage(BufferedImage image) {

        this.image = image;

        if(this.image == null) {
            repaint();
            return;
        }

        double imageMaxSide = Math.max(image.getWidth(), image.getHeight());
        double panelMaxSide = Math.max(getWidth(), getHeight());

        double ratio = panelMaxSide / imageMaxSide;
        /*
        double imageMinSide = Math.min(image.getWidth(), image.getHeight());
        double panelMinSide = Math.min(getWidth(), getHeight());

        double ratio = panelMinSide / imageMinSide;
        */
        renderWidth = (int)(image.getWidth() * ratio);
        renderHeight = (int)(image.getHeight() * ratio);

        mapListModel.getCurrentMap().mapDimensions = new Dimension(renderWidth, renderHeight);

        repaint();

    }

    public int getRenderWidth() {
        return renderWidth;
    }

    public int getRenderHeight() {
        return renderHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);

        g2.fillRect(0, 0, getWidth(), getHeight());
        if(image != null) {
            g2.drawImage(image, 0, 0, renderWidth, renderHeight, null);
        }

        if(mapListModel == null) {
            return;
        }

        if(mapListModel.getTempRoomModel() != null) {
            g2.setStroke(new BasicStroke(2));
            g2.setColor(new Color(0, 255, 0, 25));

            Polygon shape = new Polygon();
            for (Point2D.Float p : mapListModel.getTempRoomModel().getRoomArea().getPoints()) {
                shape.addPoint((int) (p.x * getRenderWidth()), (int) (p.y * getRenderHeight()));
            }
            g2.fillPolygon(shape);
            g2.drawPolygon(shape);
        }

        if(mapListModel.getTempPoiModel() != null) {
            g2.setColor(new Color(255, 255, 0, 100));

            Point2D.Float p = mapListModel.getTempPoiModel().getPoint();
            if(p != null) {
                g2.fillOval((int) (p.x * getRenderWidth()) - 7, (int) (p.y * getRenderHeight()) - 7, 15, 15);
                g2.drawOval((int) (p.x * getRenderWidth()) - 7, (int) (p.y * getRenderHeight()) - 7, 15, 15);
            }
        }



    }

    public void setTempRoom(RoomModel roomData) {
        this.mapListModel.setTempRoomModel(roomData);
    }

    public void setTempPoi(PoiModel poiData) {
        this.mapListModel.setTempPoiModel(poiData);
    }

    class MapPanelListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            float x = e.getX() / (float)renderWidth, y = e.getY() / (float)renderHeight;

            if(mapListModel.getTempRoomModel() != null) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mapListModel.getTempRoomModel().getRoomArea().reset();
                    mapListModel.getTempRoomModel().getRoomArea().addPoint(restrictPoint(x, y));
                    System.out.println(mapListModel.getTempRoomModel());
                } else if (e.getButton() == MouseEvent.BUTTON3) {
                    mapListModel.getTempRoomModel().getRoomArea().addPoint(restrictPoint(x, y));
                    System.out.println(mapListModel.getTempRoomModel());
                }
            }

            if(mapListModel.getTempPoiModel() != null) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    mapListModel.getTempPoiModel().setPoint(restrictPoint(x, y));
                    System.out.println(mapListModel.getTempPoiModel());
                }
            }

            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON2) {
                currentMouseEvent = e;
                System.out.println("middle mouse");
                mapPointThread.restart();
            }

            repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            repaint();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            float x = e.getX() / (float)renderWidth, y = e.getY() / (float)renderHeight;

            if(mapListModel.getTempRoomModel() != null) {
                if (e.getModifiersEx() == (MouseEvent.BUTTON3_DOWN_MASK + MouseEvent.BUTTON1_DOWN_MASK)) {
                    if (mapListModel.getTempRoomModel().getRoomArea().getPoints().size() <= 1) {
                        return;
                    }

                    mapListModel.getTempRoomModel().getRoomArea().getLastPoint().setLocation(restrictPoint(x, y));
                    System.out.println(mapListModel.getTempRoomModel());
                    repaint();
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) { }

    }

    public Point2D.Float restrictPoint(float x, float y) {
        x = Math.max(x, 0);
        x = Math.min(x, getRenderWidth());

        y = Math.max(y, 0);
        y = Math.min(y, getRenderHeight());

        return new Point2D.Float(x, y);
    }

    public class MapPointThread extends Thread {

        MapPointRunnable runnable;

        public MapPointThread(MapPointRunnable runnable) {
            this.runnable = runnable;
        }

        public void restart() {
            runnable.restart();
        }

        @Override
        public void run() {
            System.out.println("testing");
            runnable.run();
        }
    }

    public class MapPointRunnable implements Runnable {
        int currentIndex = 0;
        boolean isRunning = false;
        @Override
        public void run() {

            ArrayList<RoomModel> rooms = mapListModel.getCurrentMap().getCurrentFloor().getFloorRooms();
            for(currentIndex = 0; currentIndex < rooms.size(); currentIndex++) {
                isRunning = true;
                if(currentMouseEvent == null) { break; }

                RoomModel roomModel = rooms.get(currentIndex);

                Polygon shape = new Polygon();
                for(Point2D.Float p: roomModel.getRoomArea().getPoints()) {
                    shape.addPoint((int)(p.x * getRenderWidth()) , (int)(p.y * getRenderHeight()));
                }
                if(shape.contains(currentMouseEvent.getPoint())) {
                    System.out.println("setting temp room");
                    setTempRoom(roomModel);
                    jList_roomList.setSelectedIndex(currentIndex);
                    repaint();
                }
            }

            isRunning = false;
        }

        public void restart() {
            currentIndex = 0;
            if(!isRunning) {
                run();
            }

        }

        public void stop() {
            currentIndex = mapListModel.getCurrentMap().getCurrentFloor().getFloorRooms().size();
        }
    }

    class KeyListener implements java.awt.event.KeyListener {

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
                        repaint();
                    }
                }
            }
        }
    }

}
