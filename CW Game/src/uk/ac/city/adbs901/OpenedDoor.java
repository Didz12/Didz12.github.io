package uk.ac.city.adbs901;

import city.cs.engine.*;

public class OpenedDoor extends StaticBody {

    static String filename = "Character Frames/open_door.png";

    private static final Shape doorShape = new PolygonShape(
            -1.66f,-2.06f, 1.65f,-2.07f, 1.65f,2.06f, -1.66f,2.02f);

    static final BodyImage image =
            new BodyImage(filename, 7f);

    public OpenedDoor(World w) {
        super(w,doorShape);
        addImage(image);

    }
}
