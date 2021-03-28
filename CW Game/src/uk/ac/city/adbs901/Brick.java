package uk.ac.city.adbs901;

import city.cs.engine.*;

public class Brick extends Walker {

    private static final Shape brickShape = new PolygonShape(
            -1.82f,0.77f, -1.85f,-0.85f, 0.97f,-0.88f, 0.95f,0.73f);

    private static final BodyImage image =
            new BodyImage("Character Frames/brick.png", 2f);

    public Brick(World w) {
        super(w,brickShape);
        addImage(image);

    }
}
