package circleviewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A simple demo of a graphical interface to a model.
 */
public class CircleViewer {
    /**
     * Constructor for objects of class CircleViewer
     */
    public CircleViewer() {
        JFrame window = new JFrame("A green circle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // default layout manager is BorderLayout
        
        Circle circle = new Circle(50, Color.GREEN);

        ControlPanel controlPanel = new ControlPanel(circle);

        window.add(controlPanel.getMainPanel(), BorderLayout.WEST);

        ViewPanel panel = new ViewPanel(circle);
        window.add(panel, BorderLayout.CENTER);

        JLabel versionLabel = new JLabel();
        versionLabel.setText("Version 5.0");
        window.add(versionLabel, BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);
    }
    
    public static void main(String args[]) {
        new CircleViewer();
    }
}
