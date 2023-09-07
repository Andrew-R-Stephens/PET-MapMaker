package models;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.util.ArrayList;

public class FloorTypeComboBox<E> extends JComboBox<E> {

    E e;

    public FloorTypeComboBox() {
        super();
    }

    public void setModel(ArrayList<String> items) {
        removeAllItems();

        EnabledComboBoxRenderer renderer = new EnabledComboBoxRenderer(new DefaultListSelectionModel());
        renderer.setDisabledColor(Color.LIGHT_GRAY);
        setRenderer(renderer);
    }
}
