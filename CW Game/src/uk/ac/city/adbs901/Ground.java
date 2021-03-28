package uk.ac.city.adbs901;

import city.cs.engine.*;


/*for later use
change ground and platform design
 */
public class Ground extends Walker { //didnt use staticbody because cant jump on it

    private static final Shape groundShape = new PolygonShape(
            -24.9f,2.4f, -24.9f,-2.2f, 24.5f,-1.9f, 24.6f,2.1f);

    private static final BodyImage image =
            new BodyImage("Character Frames/ground.png", 4f);

    public Ground(World w) {
        super(w,groundShape);
        addImage(image);

    }
}
