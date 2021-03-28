package uk.ac.city.adbs901;

import city.cs.engine.*;

public class Key extends StaticBody {

    private static final Shape keyShape = new PolygonShape(
            -1.09f,-0.41f, -0.03f,0.65f, 0.71f,-0.15f, -0.27f,-1.02f);

    private static final BodyImage image =
            new BodyImage("Character Frames/key.png", 2f);

    public Key(World w) {
        super(w,keyShape);
        addImage(image);

    }
}
