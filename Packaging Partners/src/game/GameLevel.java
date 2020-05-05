package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    protected Crash crash;
    protected Homer homer;
    protected Dalek dalek;
    protected Enemy enemy;
    protected Packaging packaging;
    protected TardisDemat tardisdemat;
    protected Omnitrix omnitrix;
    protected MyView view;
    
    public Crash getCrash() {
        return crash;
    }
    public Homer getHomer(){
        return homer;
    }
    public Dalek getPlayer(){
        return dalek;
    }
    public Enemy getEnemy(){
        return enemy;
    }
    public Packaging getPackage(){
        return packaging;
    }
    public MyView getView(){
        return view;
    }
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {
        crash = new Crash(this);
        crash.setPosition(crashStartPosition());
        homer = new Homer(this);
        homer.setPosition(homerStartPosition());
        dalek = new Dalek(this, game);
        dalek.setPosition(dalekStartPosition());
        tardisdemat = new TardisDemat(this);
        tardisdemat.setPosition(tardisStartPosition());
        tardisdemat.addCollisionListener(new TardisListener(game));
        
    }
    
    /** The initial position of the player. */
    public abstract Vec2 crashStartPosition(); //initial position of Crash
    public abstract Vec2 homerStartPosition(); //initial position of Homer
    public abstract Vec2 dalekStartPosition(); //initial position of Dalek
    public abstract Vec2 tardisStartPosition(); //initial position of TARDIS
    
    /** The position of the exit door. */
    //public abstract Vec2 doorPosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
