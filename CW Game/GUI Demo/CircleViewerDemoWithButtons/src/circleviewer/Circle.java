package circleviewer;

import java.awt.Color;

/**
 * Coloured circles.
 */
public class Circle extends Model {
    private int radius;
    private Color colour;

    /**
     * Constructor for objects of class Circle.
     * @param radius    the initial radius
     * @param colour    the initial colour
     */
    public Circle(int radius, Color colour) {
        super();
        this.radius = radius;
        this.colour = colour;
    }
    
    /**
     * Set the radius.
     * @param radius    the new radius
     */
    public void setRadius(int radius) {
        this.radius = radius;
        changed();
    }

    /** The circle's radius. */
    public int getRadius() {
        return radius;
    }
    
    /**
     * Set the colour.
     * @param colour    the new colour
     */
    public void setColour(Color colour) {
        this.colour = colour;
        changed();
    }
    
    /** The circle's colour. */
    public Color getColour() {
        return colour;
    }
}
