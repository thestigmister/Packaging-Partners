/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 * Collision Listener class for use by Enemy class
 * @author Junad
 */
public class EnemyListener implements CollisionListener{
    
    private Enemy enemy;
    private Crash crash;
    private Dalek dalek;
    private Game game;
    
    public EnemyListener(Enemy enemy, Crash crash, Dalek dalek, Game game){
        this.enemy = enemy;
        this.crash = crash;
        this.dalek = dalek;
        this.game = game;
    }
/**
 * If the Enemy object collides with Crash object, then it will decrementLivesCount and reset the position of the enemy
 * @param e 
 */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == crash) { // if the enemy collides with anything
              dalek.decrementLivesCount();
              enemy.setPosition(new Vec2(16, -9));
              //e.getReportingBody().destroy();
           }
    }
    
}
