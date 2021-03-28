package game;

import city.cs.engine.World;

public abstract class GameLevel extends World {
    private Student student;
    private Professor professor;

    public GameLevel(Game game){
        //all levels have a student, a professor
        //and the student needs to reach the professor
        //to complete the game (hence a ProfessorEncounter)
        student = new Student(this);
        professor = new Professor(this);
        ProfessorEncounter encounter = new ProfessorEncounter(this, game);
        student.addCollisionListener(encounter);
    }

    public Student getStudent(){
        return student;
    }
    public Professor getProfessor(){
        return professor;
    }
    public abstract boolean isComplete();
}
