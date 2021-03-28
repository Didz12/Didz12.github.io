package uk.ac.city.adbs901;

import city.cs.engine.World;

public abstract class GameLevel extends World {
    private Character student;
    private Door door;
    private MouseHandler mouse;


    public GameLevel(Game game){

        student = new Character(this);

        OpenDoor encounter = new OpenDoor(student, this, game);
        student.addCollisionListener(encounter);
    }

    public Character getStudent(){
        return student;
    }

    public MouseHandler getMouse() {
        return mouse;
    }

    public Door getDoor() {
        return door;
    }

    public abstract boolean isComplete();
}
