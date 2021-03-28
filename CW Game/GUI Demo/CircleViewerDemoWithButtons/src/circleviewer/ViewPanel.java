package circleviewer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Panel displaying a coloured circle.
 */
public class ViewPanel extends JPanel implements ChangeListener {
    private Circle circle;
    
    /**
     * Create a panel displaying a coloured circle.
     * @param circle    the circle to draw
     */
    public ViewPanel(Circle circle) {
        super();
        this.circle = circle;
        circle.addChangeListener(this);
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(240, 320));
    }
    
    /**
     * Paint the panel.
     * This method is invoked by the Java graphical system.
     * @param g the graphical context (supplied by the AWT)
     */
    @Override
    protected void paintComponent(Graphics g) {
        // clear panel to background colour
        super.paintComponent(g);
        
        int left_x = getWidth()/2 - circle.getRadius();
        int top_y = getHeight()/2 - circle.getRadius();
        int diameter = circle.getRadius() * 2;

        g.setColor(circle.getColour());
        g.fillOval(left_x, top_y, diameter, diameter);
        g.setColor(Color.BLACK);
        g.drawOval(left_x, top_y, diameter, diameter);

    }
    
    /**
     * Notify the view of a change in the model, so that the view should
     * be repainted.
     * @param e description of the change
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        repaint();
    }

}
