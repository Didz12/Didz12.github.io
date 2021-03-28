package uk.ac.city.adbs901;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image background;
    private Game game;
    public GameView(World w, int width, int height, Game game) {


        super(w, width, height);
        this.game = game;
        background = new ImageIcon("Character Frames/background.png").getImage();
    }

    @Override
    protected void paintBackground(Graphics2D g) {

        g.drawImage(background, 0, 0, this);
        g.setFont(new Font("AgencyFB", Font.PLAIN,20));
        g.drawString(game.getCurrentLevel(), 400, 25);
    }

    public void setBackground(Image background) {
        this.background = background;
    }


}
