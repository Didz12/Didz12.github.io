package uk.ac.city.adbs901;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class ControlPanel {
    private Game game;
    private JFrame frame;
    private JButton pause;
    private JButton play;
    private JButton quit;
    private JPanel mainPanel;
    private JButton save;
    private JButton load;

    public ControlPanel(Game game) {
        this.game = game;
        quit.addActionListener(e -> System.exit(0));
        pause.addActionListener(e -> pauseButton());
        play.addActionListener(e -> resumeButton());
        save.addActionListener(e -> saveButton());
        //load.addActionListener(e -> loadButton());



    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
    public void pauseButton() {
        game.pause();
    }

    public void resumeButton() {
        game.resume();
    }

    public void saveButton() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("save.txt");
            fw.write(game.getCurrentLevel());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
