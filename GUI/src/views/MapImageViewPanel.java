package views;

import models.MapListModel;
import models.RoomModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

public class MapImageViewPanel extends JPanel {

    private MapListModel mapListModel;

    private BufferedImage image;
    private int renderWidth, renderHeight;

    private JButton button_addRoom;
    private JTextField textField_roomName;

    private RoomSpinner spinner_points, spinner_x, spinner_y;

    public void init(MapListModel mapListModel,
                     JButton button_addRoom,
                     JTextField textField_roomName,
                     RoomSpinner spinner_points,
                     RoomSpinner spinner_x, RoomSpinner spinner_y) {

        this.mapListModel = mapListModel;

        this.button_addRoom = button_addRoom;
        this.textField_roomName = textField_roomName;

        this.spinner_points = spinner_points;
        this.spinner_x = spinner_x;
        this.spinner_y = spinner_y;

        MapPanelListener listener = new MapPanelListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);

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

        g2.setStroke(new BasicStroke(2));
        g2.setColor(new Color(0, 255, 0, 25));

        Polygon shape = new Polygon();
        for(Point2D.Float p: mapListModel.getTempRoomModel().getRoomArea().getPoints()) {
            shape.addPoint((int)(p.x * getRenderWidth()) , (int)(p.y * getRenderHeight()));
        }
        g2.fillPolygon(shape);
        g2.drawPolygon(shape);

    }

    public void setTempRoom(RoomModel roomData) {
        this.mapListModel.setTempRoomModel(roomData);
    }

    class MapPanelListener implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {
            float x = e.getX() / (float)renderWidth, y = e.getY() / (float)renderHeight;

            if(e.getButton() == MouseEvent.BUTTON1) {
                mapListModel.getTempRoomModel().getRoomArea().reset();
                mapListModel.getTempRoomModel().getRoomArea().addPoint(restrictPoint(x, y));
                System.out.println(mapListModel.getTempRoomModel());
            }
            else if(e.getButton() == MouseEvent.BUTTON3) {
                mapListModel.getTempRoomModel().getRoomArea().addPoint(restrictPoint(x, y));
                System.out.println(mapListModel.getTempRoomModel());
            }

            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
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

            if(e.getModifiersEx() == (MouseEvent.BUTTON3_DOWN_MASK + MouseEvent.BUTTON1_DOWN_MASK)) {
                if (mapListModel.getTempRoomModel().getRoomArea().getPoints().size() <= 1) {
                    return;
                }

                mapListModel.getTempRoomModel().getRoomArea().getLastPoint().setLocation(restrictPoint(x, y));
                System.out.println(mapListModel.getTempRoomModel());
                repaint();
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

}
