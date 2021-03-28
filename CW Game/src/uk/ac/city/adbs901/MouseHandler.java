package uk.ac.city.adbs901;


import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler extends MouseAdapter {

    private GameLevel level;
    private GameView view;


    public MouseHandler(GameLevel w, GameView v){
        level = w;
        view = v;

    }

    @Override
    public void mousePressed(MouseEvent e) {
        //create Books and add them to world
        Brick brick = new Brick(level);
        //get the mouse coordinates
        Point mousePoint = e.getPoint();
        //transform them to world coordinates
        Vec2 worldPoint = view.viewToWorld(mousePoint);
        //position the books

        brick.setPosition(worldPoint);
    }

    //we have to implement the other methods to satisfy
    //the interface, but we can leave them empty.

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }


    public void updateMouse(GameLevel level, GameView view){
        this.level = level;
        this.view = view;
    }

}
