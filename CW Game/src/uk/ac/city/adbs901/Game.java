package uk.ac.city.adbs901;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import city.cs.engine.SoundClip;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private GameView view;

    //sound
    private SoundClip gameMusic;

    private CharacterController controller;
    private MouseHandler mouse;

    private String key_gui = "Key Collected: No";
    private Graphics2D g;
    private String currentLevel = "Level1"; //default level1 assuming they dont progress in the game


    /** Initialise a new Game. */
    public Game() {


        // initialize level to Level1
        level = new Level1(this);


        //background music

        try {
            gameMusic = new SoundClip("Character Frames/background_track.wav");   // Open an audio input stream
            gameMusic.setVolume(0.5);
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }


        // student.setAlwaysOutline(true);


        // make a view


        view = new GameView(level, 500, 500, this);
        view.setZoom(20);

        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        view.addMouseListener(new MouseHandler(level, view));
        view.addMouseListener(new GiveFocus(view));

        controller = new CharacterController(level.getStudent());
        view.addKeyListener(controller);



        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Stickman Adventures");
        frame.add(view);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(level, 500, 500);

        //GUI

        ControlPanel controlPanel = new ControlPanel(this);
        frame.add(controlPanel.getMainPanel(), BorderLayout.WEST);
        frame.pack();

        /*
        JLabel versionLabel = new JLabel();
        versionLabel.setFont(new Font("Verdana",1,15));
        versionLabel.setText(key_gui);
        frame.add(versionLabel, BorderLayout.WEST);
        frame.pack();

         */



        // start our game world simulation!
        level.start();
    }

    public void setKey_gui(String key_gui) {
        this.key_gui = key_gui;
    }



    public void goToNextLevel(){

        if (level instanceof Level1){
            //stop the current level
            level.stop();

            //create the new (appropriate) level
            //level now refers to new level
            view.setBackground(new ImageIcon("Character Frames/background2.png").getImage());
            level = new Level2(this);
            //change the view to look into new level
            view.setWorld(level);
            //change the controller to control the
            //student in the new world
            controller.updateStudent(level.getStudent());
            //update mouse
            view.addMouseListener(new MouseHandler(level, view));
            view.addMouseListener(new GiveFocus(view));
            currentLevel = "Level2";



            //start the simulation in the new level
            level.start();
        } else if (level instanceof Level2) {
            level.stop();
            view.setBackground(new ImageIcon("Character Frames/background3.png").getImage());
            level = new Level3(this);
            view.setWorld(level);
            controller.updateStudent(level.getStudent());
            view.addMouseListener(new MouseHandler(level, view));
            view.addMouseListener(new GiveFocus(view));
            level.start();
            currentLevel = "Level3";
        } else if (level instanceof Level3) {
            level.stop();
            view.setBackground(new ImageIcon("Character Frames/background.png").getImage());
            level = new Level4(this);
            view.setWorld(level);
            controller.updateStudent(level.getStudent());
            view.addMouseListener(new MouseHandler(level, view));
            view.addMouseListener(new GiveFocus(view));
            level.start();
            currentLevel = "Level4";
        } else if (level instanceof Level4) {
            level.stop();
            view.setBackground(new ImageIcon("Character Frames/background2.png").getImage());
            level = new Level5(this);
            view.setWorld(level);
            controller.updateStudent(level.getStudent());
            view.addMouseListener(new MouseHandler(level, view));
            view.addMouseListener(new GiveFocus(view));
            level.start();
            currentLevel = "Level5";
        }
        else if (level instanceof Level5){
            System.out.println("Well done! Game complete.");
            System.exit(0);
        }
    }


    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }

    public void pause() {
        level.stop();
    }

    public void resume() {
        level.start();
    }

    public void loadGame() {
        
    }




    public String getCurrentLevel() {
        return currentLevel;
    }
}
