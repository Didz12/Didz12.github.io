package uk.ac.city.adbs901;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;

public class KeyPickup implements CollisionListener {

    private Character student;
    private SoundClip keySound;
    private Game game;




    public KeyPickup(Character s, Game game){
        this.student = s;
        this.game = game;

    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Key) {

            //upon collision
            System.out.println("Collected Key.");
            student.isKey = true;


            try {
                keySound = new SoundClip("Character Frames/key_sound.wav");
                keySound.play();
            } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d) {
                System.out.println(d);
            }
            game.setKey_gui("Key Collected: Yes");



            e.getOtherBody().destroy();
        }
    }


}