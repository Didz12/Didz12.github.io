package uk.ac.city.adbs901;

import city.cs.engine.*;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OpenDoor extends World implements CollisionListener {

    private Character student;
    private SoundClip doorSound;
    private GameLevel level;
    private Game game;


   // private Door door;




    public OpenDoor(Character s, GameLevel level, Game game){
        this.student = s;
        this.level = level;
        this.game = game;
    }




    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Door) {

            //upon collision

            if (student.isKey && !student.isDoorOpened()) {

                try {
                    doorSound = new SoundClip("Character Frames/door_sound.wav");
                    doorSound.play();
                } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d) {
                    System.out.println(d);
                }


                //door.removeAllImages();
                //e.getOtherBody().destroy();
                e.getOtherBody().removeAllImages();
                e.getOtherBody().addImage(new BodyImage("Character Frames/open_door.png", 7f));

                //student.doorOpened = true;

                System.out.println("Door unlocked!");

                student.setDoorOpened(true);



                game.goToNextLevel();


            } else if (student.isDoorOpened()) {
                System.out.println("You walk through the open door.");
            } else {
                System.out.println("Door locked.");
            }
        }
    }


}