package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class ProfessorEncounter implements CollisionListener {

    private GameLevel level;
    private Game game;

    public ProfessorEncounter(GameLevel level, Game game){
        this.level = level;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent e) {
        //if student collided with professor and the
        //conditions for completing the level are fulfilled
        //goToNextLevel
        if (e.getOtherBody() instanceof Professor
                && level.isComplete()){
            game.goToNextLevel();
        }
    }
}
    