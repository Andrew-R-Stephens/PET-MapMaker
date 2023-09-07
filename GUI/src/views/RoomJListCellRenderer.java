package views;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RoomJListCellRenderer extends DefaultListCellRenderer {

    private final ArrayList<Boolean> hasErrorList = new ArrayList<>();

    public RoomJListCellRenderer() { }

    public void addIndexError(boolean hasError) {
        this.hasErrorList.add(hasError);
    }

    public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus );
        if ( hasErrorList.get(index) ) {
            c.setBackground( new Color(255, 0, 0, 150) );
        }
        return c;
    }
}
