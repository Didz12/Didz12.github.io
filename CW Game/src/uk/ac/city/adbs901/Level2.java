package uk.ac.city.adbs901;

import city.cs.engine.*;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;
import java.awt.*;
import java.util.Random;
import java.util.stream.IntStream;

public class Level2 extends GameLevel {


    public Level2(Game game) {
        super(game);

        // make the ground
        Shape groundShape = new BoxShape(24f, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(-11f, -12f));

        // left wall
        Shape leftWallShape = new BoxShape(0.3f, 15f);
        Body leftWall = new StaticBody(this, leftWallShape);
        leftWall.setPosition(new Vec2(-12.5f, 0f));

        // right wall
        Shape rightWallShape = new BoxShape(0.3f, 15f);
        Body rightWall = new StaticBody(this, rightWallShape);
        rightWall.setPosition(new Vec2(12.5f, 0f));

        /* for later
        //ground
        Ground ground = new Ground(this);
        ground.setPosition(new Vec2(-11f, -11f));

         */


        // make a platform
        Shape platform1Shape = new BoxShape(3, 0.5f);
        StaticBody platform1 = new StaticBody(this, platform1Shape);
        platform1.addImage(new BodyImage("Character Frames/ground.png", 0.8f));

        //generate random platform position
        Random rand = new Random();
        float rand_x = rand.nextInt(8 + 11) - 11;
        float rand_y = rand.nextInt(11);

        platform1.setPosition(new Vec2(rand_x, rand_y));


        //make a key on platform
        Key key = new Key(this);
        key.setPosition(new Vec2(rand_x - 1, rand_y + 2));



        getStudent().setPosition(new Vec2(0f, -10f));

        //make door
        Door door = new Door(this);
        door.setPosition(new Vec2(8, -8.5f));

        // key collision
        KeyPickup pickup = new KeyPickup(getStudent(), game);
        getStudent().addCollisionListener(pickup);

        // door collision
//        OpenDoor touch_door = new OpenDoor(getStudent());
//        getStudent().addCollisionListener(touch_door);





        /*
        Character student1 = new Character(this);
        student.setPosition(new Vec2(4,-5));
        */
    }

    @Override
    public boolean isComplete() {
        if (getStudent().getDoorOpen())
            return true;
        else
            return false;
    }


}