package game;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.awt.print.Book;

public class Level2  extends GameLevel{

    public Level2(Game game){
        //the base class will create the student, professor
        //and the ProfessorEncounter
        super(game);

        //we still need to set the positions of the student
        //and professor
        getStudent().setPosition(new Vec2(8, -10));
        getProfessor().setPosition(new Vec2(-8,-10));

        //we're setting up BooksPickup here though we could
        //also add it to the GameLevel class
        getStudent().addCollisionListener(new BooksPickup(getStudent()));

        // make the ground
        Shape shape = new BoxShape(11, 0.5f);
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));

        // make some walls
        Shape wallShape = new BoxShape(0.5f, 6f);
        StaticBody wall1 = new StaticBody(this, wallShape);
        wall1.setPosition(new Vec2(-11.5f, -6));

        StaticBody wall2 = new StaticBody(this, wallShape);
        wall2.setPosition(new Vec2(11.5f, -6));

        //create some pickups (books)
        for (int i=0; i<10; i++){
            Books books = new Books(this);
            books.setPosition(new Vec2(-5+i*2f,0));
        }


    }
    @Override
    public boolean isComplete() {
        if (getStudent().getBookCount() == 10)
            return true;
        else
            return false;
    }
}
