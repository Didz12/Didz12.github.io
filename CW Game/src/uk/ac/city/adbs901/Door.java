package uk.ac.city.adbs901;

import city.cs.engine.*;

public class Door extends StaticBody {

    static String filename = "Character Frames/door.png";

    private static final Shape doorShape = new PolygonShape(
            -1.66f,-2.06f, 1.65f,-2.07f, 1.65f,2.06f, -1.66f,2.02f);

    static final BodyImage image =
            new BodyImage(filename, 7f);

    public Door(World w) {
        super(w,doorShape);
        addImage(image);

    }
}
