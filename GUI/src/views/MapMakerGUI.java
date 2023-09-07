package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import models.*;

/*
 * Created by JFormDesigner on Tue Aug 29 17:55:37 EDT 2023
 */



/**
 * @author Andrew
 */
public class MapMakerGUI extends JFrame {
    public MapMakerGUI() {
        initComponents();
    }

    public MapImageViewPanel getMapViewPanel() {
        return mapViewPanel;
    }

    private void createUIComponents() {
        // TODO: add custom component creation code here
    }

    public JButton getButton_addFloor() {
        return button_addFloor;
    }

    public JButton getButton_removeFloor() {
        return button_removeFloor;
    }

    public FloorTypeComboBox<String> getComboBox_floorTypes() {
        return comboBox_floorTypes;
    }

    public JComboBox<String> getComboBox_floorImage() {
        return comboBox_floorImage;
    }

    public JButton getButton_addRoom() {
        return button_addRoom;
    }

    public JButton getButton_removeRoom() {
        return button_removeRoom;
    }

    public JList<String> getScrollView_roomList() {
        return scrollView_roomList;
    }

    public JTextField getTextField_roomName() {
        return textField_roomName;
    }

    public JSpinner getTextField_roomID() {
        return textField_roomID;
    }

    public RoomSpinner getSpinner_points() {
        return spinner_points;
    }

    public RoomSpinner getSpinner_x() {
        return spinner_x;
    }

    public RoomSpinner getSpinner_y() {
        return spinner_y;
    }

    public JButton getButton_floorDecrement() {
        return button_floorDecrement;
    }

    public JButton getButton_floorIncrement() {
        return button_floorIncrement;
    }

    public JMenu getMenu_file() {
        return menu_file;
    }

    public JMenuItem getMenuItem_createNewMap() {
        return menuItem_createNewMap;
    }

    public JMenuItem getMenuItem_loadMap() {
        return menuItem_loadMap;
    }

    private void menuItem_loadMapPopup(MouseEvent e) {
        // TODO add your code here
    }

    private void _popup_loadmap_cancel(ActionEvent e) {
        // TODO add your code here
    }

    public JPopupMenu getPopupMenu_loadMap() {
        return popupMenu_loadMap;
    }

    public JList<String> getPopupMenu_loadMap_mapList() {
        return popupMenu_loadMap_mapList;
    }

    public JButton getButton_popup_loadMap_confirm() {
        return button_popup_loadMap_confirm;
    }

    public JButton getButton_popup_loadmap_cancel() {
        return button_popup_loadmap_cancel;
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JPanel getDialogPane() {
        return dialogPane;
    }

    public JMenuItem getMenuItem_saveAll() {
        return menuItem_saveAll;
    }

    public JTextField getTextField_mapName() {
        return textField_mapName;
    }

    public JTextField getTextField_floorName() {
        return textField_floorName;
    }

    public JMenuItem getMenuItem_open() {
        return menuItem_open;
    }

    public JFileChooser getFileChooser_open() {
        return fileChooser_open;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Andrew
        menuBar1 = new JMenuBar();
        menu_file = new JMenu();
        menuItem_open = new JMenuItem();
        menuItem_createNewMap = new JMenuItem();
        menuItem_loadMap = new JMenuItem();
        menuItem_saveAll = new JMenuItem();
        dialogPane = new JPanel();
        buttonPanel = new JPanel();
        panel16 = new JPanel();
        textField_mapName = new JTextField();
        floorLabelPanel = new JPanel();
        floorLabel = new JLabel();
        panel3 = new JPanel();
        button_addFloor = new JButton();
        button_removeFloor = new JButton();
        floorsPanel = new JPanel();
        panel6 = new JPanel();
        panel14 = new JPanel();
        comboBox_floorTypes = new FloorTypeComboBox<>();
        panel11 = new JPanel();
        panel13 = new JPanel();
        button_floorDecrement = new JButton();
        button_floorIncrement = new JButton();
        panel17 = new JPanel();
        textField_floorName = new JTextField();
        panel4 = new JPanel();
        comboBox_floorImage = new JComboBox();
        separator1 = new JSeparator();
        roomsLabelPanel = new JPanel();
        roomLabel = new JLabel();
        roomsPanel = new JPanel();
        panel2 = new JPanel();
        button_addRoom = new JButton();
        button_removeRoom = new JButton();
        panel5 = new JPanel();
        scrollPane1 = new JScrollPane();
        scrollView_roomList = new JList<>();
        panel8 = new JPanel();
        textField_roomName = new JTextField();
        textField_roomID = new JSpinner();
        panel10 = new JPanel();
        panel7 = new JPanel();
        spinner_points = new RoomSpinner();
        panel9 = new JPanel();
        spinner_x = new RoomSpinner();
        spinner_y = new RoomSpinner();
        mapViewPanel = new MapImageViewPanel();
        popupMenu_loadMap = new JPopupMenu();
        panel1 = new JPanel();
        scrollPane2 = new JScrollPane();
        popupMenu_loadMap_mapList = new JList<>();
        panel15 = new JPanel();
        button_popup_loadMap_confirm = new JButton();
        button_popup_loadmap_cancel = new JButton();
        fileChooser_open = new JFileChooser();

        //======== this ========
        setAlwaysOnTop(true);
        setTitle("PET Map Maker");
        setVisible(true);
        setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        ;

        //======== menuBar1 ========
        {
            menuBar1.setForeground(Color.black);
            menuBar1.setBackground(new Color(0x333333));
            menuBar1.setMargin(new Insets(8, 8, 8, 8));

            //======== menu_file ========
            {
                menu_file.setText("File");
                menu_file.setForeground(Color.white);
                menu_file.setBackground(new Color(0x666666));
                menu_file.setHorizontalAlignment(SwingConstants.CENTER);
                menu_file.setFont(new Font("JetBrains Mono", Font.BOLD, 12));

                //---- menuItem_open ----
                menuItem_open.setText("Open");
                menu_file.add(menuItem_open);

                //---- menuItem_createNewMap ----
                menuItem_createNewMap.setText("Create New Map");
                menu_file.add(menuItem_createNewMap);

                //---- menuItem_loadMap ----
                menuItem_loadMap.setText("Select Map");
                menu_file.add(menuItem_loadMap);

                //---- menuItem_saveAll ----
                menuItem_saveAll.setText("Save All");
                menu_file.add(menuItem_saveAll);
            }
            menuBar1.add(menu_file);
        }
        setJMenuBar(menuBar1);

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(8, 0, 8, 8));
            dialogPane.setMinimumSize(new Dimension(0, 0));
            dialogPane.setForeground(new Color(0x336600));
            dialogPane.setBackground(new Color(0x333333));
            dialogPane.setPreferredSize(null);
            dialogPane.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BoxLayout(dialogPane, BoxLayout.X_AXIS));

            //======== buttonPanel ========
            {
                buttonPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                buttonPanel.setBackground(new Color(0x333333));
                buttonPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
                buttonPanel.setMinimumSize(null);
                buttonPanel.setMaximumSize(new Dimension(356, 20000));
                buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

                //======== panel16 ========
                {
                    panel16.setBorder(new EmptyBorder(0, 0, 0, 8));
                    panel16.setOpaque(false);
                    panel16.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    panel16.setBackground(new Color(0x333333));
                    panel16.setForeground(Color.white);
                    panel16.setLayout(new GridLayout(1, 0, 16, 0));

                    //---- textField_mapName ----
                    textField_mapName.setPreferredSize(null);
                    textField_mapName.setMaximumSize(null);
                    textField_mapName.setBorder(new TitledBorder(null, "Map Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                        new Font("JetBrains Mono", Font.BOLD, 12), Color.lightGray));
                    textField_mapName.setMargin(new Insets(8, 0, 0, 0));
                    textField_mapName.setMinimumSize(null);
                    textField_mapName.setBackground(new Color(0x333333));
                    textField_mapName.setForeground(Color.white);
                    textField_mapName.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    textField_mapName.setSelectedTextColor(Color.white);
                    textField_mapName.setSelectionColor(Color.black);
                    textField_mapName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                    panel16.add(textField_mapName);
                }
                buttonPanel.add(panel16);

                //======== floorLabelPanel ========
                {
                    floorLabelPanel.setBackground(new Color(0x00eeeeee, true));
                    floorLabelPanel.setOpaque(false);
                    floorLabelPanel.setBorder(new EmptyBorder(8, 5, 8, 5));
                    floorLabelPanel.setMinimumSize(null);
                    floorLabelPanel.setMaximumSize(null);
                    floorLabelPanel.setPreferredSize(null);
                    floorLabelPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    floorLabelPanel.setLayout(new BoxLayout(floorLabelPanel, BoxLayout.LINE_AXIS));

                    //---- floorLabel ----
                    floorLabel.setText("Floor");
                    floorLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
                    floorLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    floorLabel.setPreferredSize(null);
                    floorLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                    floorLabel.setForeground(Color.white);
                    floorLabel.setBackground(new Color(0x00eeeeee, true));
                    floorLabel.setMaximumSize(null);
                    floorLabel.setMinimumSize(null);
                    floorLabel.setFocusable(false);
                    floorLabelPanel.add(floorLabel);
                }
                buttonPanel.add(floorLabelPanel);

                //======== panel3 ========
                {
                    panel3.setOpaque(false);
                    panel3.setPreferredSize(null);
                    panel3.setMaximumSize(null);
                    panel3.setMinimumSize(null);
                    panel3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    panel3.setBorder(BorderFactory.createEmptyBorder());
                    panel3.setBackground(new Color(0x666666));
                    panel3.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 32, 5));

                    //---- button_addFloor ----
                    button_addFloor.setText("Add Floor");
                    button_addFloor.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                    button_addFloor.setForeground(Color.white);
                    button_addFloor.setBackground(new Color(0x006600));
                    button_addFloor.setPreferredSize(null);
                    button_addFloor.setMargin(null);
                    button_addFloor.setMaximumSize(null);
                    button_addFloor.setMinimumSize(null);
                    button_addFloor.setHorizontalAlignment(SwingConstants.LEADING);
                    button_addFloor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button_addFloor.setFocusable(false);
                    panel3.add(button_addFloor);

                    //---- button_removeFloor ----
                    button_removeFloor.setText("Remove Floor");
                    button_removeFloor.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                    button_removeFloor.setForeground(Color.white);
                    button_removeFloor.setBackground(new Color(0x660000));
                    button_removeFloor.setPreferredSize(null);
                    button_removeFloor.setMargin(null);
                    button_removeFloor.setMaximumSize(null);
                    button_removeFloor.setMinimumSize(null);
                    button_removeFloor.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    button_removeFloor.setFocusable(false);
                    panel3.add(button_removeFloor);
                }
                buttonPanel.add(panel3);

                //======== floorsPanel ========
                {
                    floorsPanel.setBackground(new Color(0x00eeeeee, true));
                    floorsPanel.setBorder(new EmptyBorder(0, 0, 16, 0));
                    floorsPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    floorsPanel.setLayout(new BoxLayout(floorsPanel, BoxLayout.Y_AXIS));

                    //======== panel6 ========
                    {
                        panel6.setPreferredSize(null);
                        panel6.setMinimumSize(null);
                        panel6.setMaximumSize(null);
                        panel6.setBorder(new TitledBorder(null, "Floor Layer", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                        panel6.setBackground(new Color(0x333333));
                        panel6.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel6.setLayout(new GridLayout(1, 2, 32, 0));

                        //======== panel14 ========
                        {
                            panel14.setPreferredSize(null);
                            panel14.setMaximumSize(null);
                            panel14.setMinimumSize(null);
                            panel14.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                            panel14.setBorder(BorderFactory.createEmptyBorder());
                            panel14.setBackground(new Color(0x333333));
                            panel14.setForeground(Color.white);
                            panel14.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            panel14.setLayout(new FlowLayout());

                            //---- comboBox_floorTypes ----
                            comboBox_floorTypes.setPreferredSize(null);
                            comboBox_floorTypes.setMaximumSize(null);
                            comboBox_floorTypes.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "Level", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                            comboBox_floorTypes.setMinimumSize(null);
                            comboBox_floorTypes.setBackground(new Color(0x333333));
                            comboBox_floorTypes.setForeground(Color.white);
                            comboBox_floorTypes.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            comboBox_floorTypes.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                            comboBox_floorTypes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            panel14.add(comboBox_floorTypes);
                        }
                        panel6.add(panel14);

                        //======== panel11 ========
                        {
                            panel11.setPreferredSize(null);
                            panel11.setMaximumSize(null);
                            panel11.setMinimumSize(null);
                            panel11.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                            panel11.setBorder(BorderFactory.createEmptyBorder());
                            panel11.setBackground(new Color(0x333333));
                            panel11.setForeground(Color.white);
                            panel11.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            panel11.setLayout(new BoxLayout(panel11, BoxLayout.Y_AXIS));

                            //======== panel13 ========
                            {
                                panel13.setPreferredSize(null);
                                panel13.setMaximumSize(null);
                                panel13.setMinimumSize(null);
                                panel13.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                                panel13.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "Move Layer", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                    new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                                panel13.setBackground(new Color(0x333333));
                                panel13.setForeground(Color.white);
                                panel13.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                                panel13.setLayout(new GridLayout(1, 2, 32, 0));

                                //---- button_floorDecrement ----
                                button_floorDecrement.setText("<-");
                                button_floorDecrement.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                                button_floorDecrement.setBackground(new Color(0xf3f3f3));
                                button_floorDecrement.setPreferredSize(null);
                                button_floorDecrement.setMargin(null);
                                button_floorDecrement.setMaximumSize(null);
                                button_floorDecrement.setMinimumSize(null);
                                button_floorDecrement.setForeground(Color.black);
                                button_floorDecrement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                button_floorDecrement.setFocusable(false);
                                button_floorDecrement.setHorizontalAlignment(SwingConstants.LEFT);
                                button_floorDecrement.setAlignmentX(0.5F);
                                panel13.add(button_floorDecrement);

                                //---- button_floorIncrement ----
                                button_floorIncrement.setText("->");
                                button_floorIncrement.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                                button_floorIncrement.setBackground(new Color(0xf3f3f3));
                                button_floorIncrement.setPreferredSize(null);
                                button_floorIncrement.setMargin(null);
                                button_floorIncrement.setMaximumSize(null);
                                button_floorIncrement.setMinimumSize(null);
                                button_floorIncrement.setForeground(Color.black);
                                button_floorIncrement.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                                button_floorIncrement.setFocusable(false);
                                button_floorIncrement.setHorizontalAlignment(SwingConstants.RIGHT);
                                button_floorIncrement.setAlignmentX(0.5F);
                                panel13.add(button_floorIncrement);
                            }
                            panel11.add(panel13);
                        }
                        panel6.add(panel11);
                    }
                    floorsPanel.add(panel6);

                    //======== panel17 ========
                    {
                        panel17.setBorder(new EmptyBorder(0, 0, 0, 8));
                        panel17.setOpaque(false);
                        panel17.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel17.setBackground(new Color(0x333333));
                        panel17.setForeground(Color.white);
                        panel17.setLayout(new GridLayout(1, 0, 16, 0));

                        //---- textField_floorName ----
                        textField_floorName.setPreferredSize(null);
                        textField_floorName.setMaximumSize(null);
                        textField_floorName.setBorder(new TitledBorder(null, "Floor Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 12), Color.lightGray));
                        textField_floorName.setMargin(new Insets(8, 0, 0, 0));
                        textField_floorName.setMinimumSize(null);
                        textField_floorName.setBackground(new Color(0x333333));
                        textField_floorName.setForeground(Color.white);
                        textField_floorName.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        textField_floorName.setSelectedTextColor(Color.white);
                        textField_floorName.setSelectionColor(Color.black);
                        textField_floorName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                        panel17.add(textField_floorName);
                    }
                    floorsPanel.add(panel17);

                    //======== panel4 ========
                    {
                        panel4.setPreferredSize(null);
                        panel4.setMinimumSize(null);
                        panel4.setMaximumSize(null);
                        panel4.setBorder(new EmptyBorder(16, 8, 0, 8));
                        panel4.setBackground(new Color(0x333333));
                        panel4.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel4.setLayout(new GridLayout(1, 2, 32, 0));

                        //---- comboBox_floorImage ----
                        comboBox_floorImage.setPreferredSize(null);
                        comboBox_floorImage.setMaximumSize(null);
                        comboBox_floorImage.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "Floor Image", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                        comboBox_floorImage.setMinimumSize(null);
                        comboBox_floorImage.setBackground(new Color(0x333333));
                        comboBox_floorImage.setForeground(Color.white);
                        comboBox_floorImage.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        comboBox_floorImage.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        comboBox_floorImage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        panel4.add(comboBox_floorImage);
                    }
                    floorsPanel.add(panel4);
                }
                buttonPanel.add(floorsPanel);
                buttonPanel.add(separator1);

                //======== roomsLabelPanel ========
                {
                    roomsLabelPanel.setBackground(new Color(0x333333));
                    roomsLabelPanel.setBorder(new EmptyBorder(16, 5, 8, 5));
                    roomsLabelPanel.setMinimumSize(null);
                    roomsLabelPanel.setMaximumSize(null);
                    roomsLabelPanel.setPreferredSize(null);
                    roomsLabelPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    roomsLabelPanel.setLayout(new BoxLayout(roomsLabelPanel, BoxLayout.LINE_AXIS));

                    //---- roomLabel ----
                    roomLabel.setText("Room");
                    roomLabel.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
                    roomLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    roomLabel.setPreferredSize(null);
                    roomLabel.setHorizontalTextPosition(SwingConstants.CENTER);
                    roomLabel.setForeground(Color.white);
                    roomLabel.setBackground(new Color(0x00eeeeee, true));
                    roomLabel.setMaximumSize(null);
                    roomLabel.setMinimumSize(null);
                    roomsLabelPanel.add(roomLabel);
                }
                buttonPanel.add(roomsLabelPanel);

                //======== roomsPanel ========
                {
                    roomsPanel.setBackground(new Color(0x00eeeeee, true));
                    roomsPanel.setMinimumSize(null);
                    roomsPanel.setPreferredSize(null);
                    roomsPanel.setMaximumSize(null);
                    roomsPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                    roomsPanel.setBorder(new EmptyBorder(8, 8, 8, 8));
                    roomsPanel.setLayout(new BoxLayout(roomsPanel, BoxLayout.Y_AXIS));

                    //======== panel2 ========
                    {
                        panel2.setPreferredSize(null);
                        panel2.setMaximumSize(null);
                        panel2.setMinimumSize(null);
                        panel2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                        panel2.setBorder(BorderFactory.createEmptyBorder());
                        panel2.setBackground(new Color(0x333333));
                        panel2.setForeground(Color.white);
                        panel2.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 32, 5));

                        //---- button_addRoom ----
                        button_addRoom.setText("Add Room");
                        button_addRoom.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                        button_addRoom.setBackground(new Color(0x006600));
                        button_addRoom.setPreferredSize(null);
                        button_addRoom.setMargin(null);
                        button_addRoom.setMaximumSize(null);
                        button_addRoom.setMinimumSize(null);
                        button_addRoom.setForeground(Color.white);
                        button_addRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        panel2.add(button_addRoom);

                        //---- button_removeRoom ----
                        button_removeRoom.setText("Remove Room");
                        button_removeRoom.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                        button_removeRoom.setForeground(Color.white);
                        button_removeRoom.setBackground(new Color(0x660000));
                        button_removeRoom.setPreferredSize(null);
                        button_removeRoom.setMargin(null);
                        button_removeRoom.setMaximumSize(null);
                        button_removeRoom.setMinimumSize(null);
                        button_removeRoom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                        panel2.add(button_removeRoom);
                    }
                    roomsPanel.add(panel2);

                    //======== panel5 ========
                    {
                        panel5.setOpaque(false);
                        panel5.setPreferredSize(null);
                        panel5.setMinimumSize(null);
                        panel5.setMaximumSize(null);
                        panel5.setBorder(new EmptyBorder(16, 0, 16, 0));
                        panel5.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel5.setLayout(new BorderLayout());

                        //======== scrollPane1 ========
                        {
                            scrollPane1.setPreferredSize(null);
                            scrollPane1.setMaximumSize(null);
                            scrollPane1.setMinimumSize(null);
                            scrollPane1.setOpaque(false);
                            scrollPane1.setBackground(new Color(0x00eeeeee, true));
                            scrollPane1.setViewportBorder(new TitledBorder(null, "Available Rooms", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                            scrollPane1.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            scrollPane1.setBorder(BorderFactory.createEmptyBorder());

                            //---- scrollView_roomList ----
                            scrollView_roomList.setMaximumSize(null);
                            scrollView_roomList.setMinimumSize(null);
                            scrollView_roomList.setPreferredSize(null);
                            scrollView_roomList.setBackground(Color.lightGray);
                            scrollView_roomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                            scrollView_roomList.setVisibleRowCount(10);
                            scrollView_roomList.setBorder(BorderFactory.createEmptyBorder());
                            scrollView_roomList.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                            scrollView_roomList.setSelectionBackground(Color.darkGray);
                            scrollView_roomList.setSelectionForeground(Color.white);
                            scrollView_roomList.setName("Recorded Rooms");
                            scrollView_roomList.setFixedCellHeight(20);
                            scrollView_roomList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            scrollPane1.setViewportView(scrollView_roomList);
                        }
                        panel5.add(scrollPane1, BorderLayout.CENTER);
                    }
                    roomsPanel.add(panel5);

                    //======== panel8 ========
                    {
                        panel8.setBorder(new EmptyBorder(0, 0, 0, 8));
                        panel8.setOpaque(false);
                        panel8.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel8.setBackground(new Color(0x333333));
                        panel8.setForeground(Color.white);
                        panel8.setLayout(new GridLayout(1, 0, 16, 0));

                        //---- textField_roomName ----
                        textField_roomName.setPreferredSize(null);
                        textField_roomName.setMaximumSize(null);
                        textField_roomName.setBorder(new TitledBorder(null, "Room Name", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 12), Color.lightGray));
                        textField_roomName.setMargin(new Insets(8, 0, 0, 0));
                        textField_roomName.setMinimumSize(null);
                        textField_roomName.setBackground(new Color(0x333333));
                        textField_roomName.setForeground(Color.white);
                        textField_roomName.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        textField_roomName.setSelectedTextColor(Color.white);
                        textField_roomName.setSelectionColor(Color.black);
                        textField_roomName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
                        panel8.add(textField_roomName);

                        //---- textField_roomID ----
                        textField_roomID.setPreferredSize(null);
                        textField_roomID.setMaximumSize(null);
                        textField_roomID.setBorder(new TitledBorder(null, "Room ID", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 12), Color.lightGray));
                        textField_roomID.setMinimumSize(null);
                        textField_roomID.setBackground(new Color(0x333333));
                        textField_roomID.setForeground(Color.white);
                        textField_roomID.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                        panel8.add(textField_roomID);
                    }
                    roomsPanel.add(panel8);

                    //======== panel10 ========
                    {
                        panel10.setBorder(new TitledBorder(null, "Room Points", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                            new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                        panel10.setOpaque(false);
                        panel10.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
                        panel10.setLayout(new GridLayout(2, 0));

                        //======== panel7 ========
                        {
                            panel7.setBorder(new EmptyBorder(8, 0, 8, 0));
                            panel7.setOpaque(false);
                            panel7.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
                            panel7.setPreferredSize(null);
                            panel7.setMinimumSize(null);
                            panel7.setMaximumSize(null);
                            panel7.setLayout(new BoxLayout(panel7, BoxLayout.X_AXIS));

                            //---- spinner_points ----
                            spinner_points.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "Point", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                            spinner_points.setBackground(new Color(0x333333));
                            spinner_points.setForeground(Color.white);
                            spinner_points.setPreferredSize(null);
                            spinner_points.setMinimumSize(null);
                            spinner_points.setMaximumSize(null);
                            spinner_points.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            spinner_points.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            spinner_points.setFocusable(false);
                            panel7.add(spinner_points);
                        }
                        panel10.add(panel7);

                        //======== panel9 ========
                        {
                            panel9.setBorder(new EmptyBorder(8, 0, 8, 0));
                            panel9.setOpaque(false);
                            panel9.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));
                            panel9.setPreferredSize(null);
                            panel9.setMinimumSize(null);
                            panel9.setMaximumSize(null);
                            panel9.setLayout(new BoxLayout(panel9, BoxLayout.X_AXIS));

                            //---- spinner_x ----
                            spinner_x.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "X", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                            spinner_x.setBackground(new Color(0x333333));
                            spinner_x.setForeground(Color.white);
                            spinner_x.setPreferredSize(null);
                            spinner_x.setMinimumSize(null);
                            spinner_x.setMaximumSize(null);
                            spinner_x.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            spinner_x.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            spinner_x.setFocusable(false);
                            panel9.add(spinner_x);

                            //---- spinner_y ----
                            spinner_y.setBorder(new TitledBorder(BorderFactory.createEmptyBorder(), "Y", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                                new Font("JetBrains Mono", Font.BOLD, 14), Color.lightGray));
                            spinner_y.setBackground(new Color(0x333333));
                            spinner_y.setForeground(Color.white);
                            spinner_y.setModel(new SpinnerNumberModel(0, null, null, 1));
                            spinner_y.setMinimumSize(null);
                            spinner_y.setPreferredSize(null);
                            spinner_y.setMaximumSize(null);
                            spinner_y.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
                            spinner_y.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                            spinner_y.setFocusable(false);
                            panel9.add(spinner_y);
                        }
                        panel10.add(panel9);
                    }
                    roomsPanel.add(panel10);
                }
                buttonPanel.add(roomsPanel);
            }
            dialogPane.add(buttonPanel);

            //---- mapViewPanel ----
            mapViewPanel.setBackground(new Color(0xcccccc));
            mapViewPanel.setFont(new Font("JetBrains Mono", Font.PLAIN, 12));
            mapViewPanel.setMinimumSize(null);
            mapViewPanel.setMaximumSize(null);
            mapViewPanel.setPreferredSize(new Dimension(1000, 592));
            mapViewPanel.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            dialogPane.add(mapViewPanel);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setLocationRelativeTo(getOwner());

        //======== popupMenu_loadMap ========
        {
            popupMenu_loadMap.setPreferredSize(null);
            popupMenu_loadMap.setMinimumSize(null);
            popupMenu_loadMap.setMaximumSize(null);
            popupMenu_loadMap.setLabel("Load Map");

            //======== panel1 ========
            {
                panel1.setMaximumSize(null);
                panel1.setMinimumSize(null);
                panel1.setPreferredSize(null);
                panel1.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
                . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frm\u0044es\u0069gn\u0065r \u0045va\u006cua\u0074io\u006e" , javax. swing .border . TitledBorder
                . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069al\u006fg", java .
                awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel1. getBorder () ) )
                ; panel1. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
                ) { if( "\u0062or\u0064er" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
                ;
                panel1.setLayout(new BorderLayout());

                //======== scrollPane2 ========
                {
                    scrollPane2.setPreferredSize(null);
                    scrollPane2.setMinimumSize(null);
                    scrollPane2.setMaximumSize(null);

                    //---- popupMenu_loadMap_mapList ----
                    popupMenu_loadMap_mapList.setMinimumSize(null);
                    popupMenu_loadMap_mapList.setMaximumSize(null);
                    popupMenu_loadMap_mapList.setPreferredSize(null);
                    scrollPane2.setViewportView(popupMenu_loadMap_mapList);
                }
                panel1.add(scrollPane2, BorderLayout.CENTER);
            }
            popupMenu_loadMap.add(panel1);

            //======== panel15 ========
            {
                panel15.setLayout(new FlowLayout());

                //---- button_popup_loadMap_confirm ----
                button_popup_loadMap_confirm.setText("Load Map");
                panel15.add(button_popup_loadMap_confirm);

                //---- button_popup_loadmap_cancel ----
                button_popup_loadmap_cancel.setText("Cancel");
                button_popup_loadmap_cancel.addActionListener(e -> _popup_loadmap_cancel(e));
                panel15.add(button_popup_loadmap_cancel);
            }
            popupMenu_loadMap.add(panel15);
        }

        //---- fileChooser_open ----
        fileChooser_open.setDialogTitle("Choose File");
        fileChooser_open.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Andrew
    private JMenuBar menuBar1;
    private JMenu menu_file;
    private JMenuItem menuItem_open;
    private JMenuItem menuItem_createNewMap;
    private JMenuItem menuItem_loadMap;
    private JMenuItem menuItem_saveAll;
    private JPanel dialogPane;
    private JPanel buttonPanel;
    private JPanel panel16;
    private JTextField textField_mapName;
    private JPanel floorLabelPanel;
    private JLabel floorLabel;
    private JPanel panel3;
    private JButton button_addFloor;
    private JButton button_removeFloor;
    private JPanel floorsPanel;
    private JPanel panel6;
    private JPanel panel14;
    private FloorTypeComboBox<String> comboBox_floorTypes;
    private JPanel panel11;
    private JPanel panel13;
    private JButton button_floorDecrement;
    private JButton button_floorIncrement;
    private JPanel panel17;
    private JTextField textField_floorName;
    private JPanel panel4;
    private JComboBox comboBox_floorImage;
    private JSeparator separator1;
    private JPanel roomsLabelPanel;
    private JLabel roomLabel;
    private JPanel roomsPanel;
    private JPanel panel2;
    private JButton button_addRoom;
    private JButton button_removeRoom;
    private JPanel panel5;
    private JScrollPane scrollPane1;
    private JList<String> scrollView_roomList;
    private JPanel panel8;
    private JTextField textField_roomName;
    private JSpinner textField_roomID;
    private JPanel panel10;
    private JPanel panel7;
    private RoomSpinner spinner_points;
    private JPanel panel9;
    private RoomSpinner spinner_x;
    private RoomSpinner spinner_y;
    private MapImageViewPanel mapViewPanel;
    private JPopupMenu popupMenu_loadMap;
    private JPanel panel1;
    private JScrollPane scrollPane2;
    private JList<String> popupMenu_loadMap_mapList;
    private JPanel panel15;
    private JButton button_popup_loadMap_confirm;
    private JButton button_popup_loadmap_cancel;
    private JFileChooser fileChooser_open;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}