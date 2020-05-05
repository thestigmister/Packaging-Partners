/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 * Listener for collision with a door.  When the player collides with a door,
 * if the current level is complete the game is advanced to the next level. 
 * Door being the TardisDemat class object
 */
public class TardisListener implements CollisionListener {
    private Game game;
    
    public TardisListener(Game game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        Dalek player = game.getPlayer(); //player is dalek. if tardis collides with dalek
        Homer homer = game.getHomer();
        Crash crash = game.getCrash();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("EXTERMINATING to next level...");
            game.goNextLevel();
        }
        if (e.getOtherBody() == homer && game.isCurrentLevelCompleted()){
            System.out.println("Going to next level, D'oh...");
            game.goNextLevel();
        }
        if (e.getOtherBody() == crash && game.isCurrentLevelCompleted()){
            System.out.println("Crashing to next level...");
            game.goNextLevel();
        }
    }
}