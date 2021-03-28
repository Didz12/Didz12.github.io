package circleviewer;

import javax.swing.*;

public class ControlPanel {
    private Circle circle;
    private JButton grow;
    private JButton shrink;
    private JButton quit;
    private JPanel mainPanel;

    public ControlPanel(Circle circle) {
        this.circle = circle;
        quit.addActionListener(e -> System.exit(0));
        grow.addActionListener(e -> circle.setRadius(circle.getRadius()+5));
        shrink.addActionListener(e -> circle.setRadius(circle.getRadius()-5));
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
