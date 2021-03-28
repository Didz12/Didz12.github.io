package uk.ac.city.adbs901;

import city.cs.engine.*;

public class Character extends Walker {

    static String FILE_NAME = "Character Frames/Player.png";
    public boolean isKey = false;
    private boolean doorOpened;
    private boolean doorOpen;


    private static final Shape studentShape = new PolygonShape(
            -1.05f,-2.18f, -0.94f,2.37f, 0.95f,2.36f, 1.03f,-2.22f);

    private static final BodyImage image =
            new BodyImage(FILE_NAME, 5f);

    public Character(World world) {
        super(world, studentShape);
        addImage(image);
        doorOpen = false;
    }

    public boolean isDoorOpened() {
        return doorOpened;
    }

    public void setDoorOpened(boolean doorOpened) {
        this.doorOpened = doorOpened;
    }

    public void openDoor(){
        doorOpen = true;
    }

    public boolean getDoorOpen(){
        return doorOpen;
    }
}