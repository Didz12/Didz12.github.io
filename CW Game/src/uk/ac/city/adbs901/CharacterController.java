package uk.ac.city.adbs901;

import city.cs.engine.BodyImage;
import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterController implements KeyListener {

    private static float WALKING_SPEED = 6f;
    private static float JUMP_SPEED = 8f;
    private static float SPEED_BOOST = 10f;
    private static float NORMAL_SPEED = 6f;

    private Character student;

    public CharacterController(Character s){
        student = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_A) {
            student.startWalking(-WALKING_SPEED);
            student.removeAllImages();
            student.addImage(new BodyImage("Character Frames/Player_left.png", 5f));
            //student.setAngle(180f);



            /* >>for later use

            float x_pos = student.getPosition().x;
            float y_pos = student.getPosition().y;
            student.setPosition(new Vec2(x_pos - WALKING_SPEED, y_pos));
             */

        } if (code == KeyEvent.VK_D) {
            student.startWalking(WALKING_SPEED);
            student.removeAllImages();
            student.addImage(new BodyImage("Character Frames/Player_right.png", 5f));


        } if (code == KeyEvent.VK_W) {
            student.jump(JUMP_SPEED);
        } if (code == KeyEvent.VK_SHIFT) {
            WALKING_SPEED = SPEED_BOOST;
        }

        if (code == KeyEvent.VK_3) {
            while (true) {
                System.out.println(5);
            }
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            student.stopWalking();
            student.setLinearVelocity(new Vec2(-2f, student.getLinearVelocity().y));
        } if (code == KeyEvent.VK_D) {
            student.stopWalking();
            student.setLinearVelocity(new Vec2(2f, student.getLinearVelocity().y));
        } if (code == KeyEvent.VK_SHIFT) {
            WALKING_SPEED = NORMAL_SPEED;
        }
    }



    public void updateStudent(Character student){
        this.student = student;
    }
}
