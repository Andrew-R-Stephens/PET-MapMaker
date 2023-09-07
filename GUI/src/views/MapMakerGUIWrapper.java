package views;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class MapMakerGUIWrapper extends MapMakerGUI {

    public void build() {

        getDialogPane().removePropertyChangeListener(getDialogPane().getPropertyChangeListeners()[0]);
        getDialogPane().setBorder(new EmptyBorder(0,0,0,0));
        getPanel1().removePropertyChangeListener(getPanel1().getPropertyChangeListeners()[0]);
        getPanel1().setBorder(new EmptyBorder(0,0,0,0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }


}
