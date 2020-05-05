/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import static game.Game.levelNumber;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control a Walker. At present, controls crash
 * Utilizing the arrow keys and K key
 */
public class Controller extends KeyAdapter {
    private static final float JUMPING_SPEED = 15;
    private static final float WALKING_SPEED = 4;
    private int crashY = -8;
    
    private Walker body; //private Crash body
    //private Walker crashBody;
    
    public Controller(Walker body) {
        this.body = body;
        //this.crashBody = crashBody;
    }
    
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_K) { // J = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_LEFT) {
            body.startWalking(-WALKING_SPEED); // 1 = walk left
        } else if (code == KeyEvent.VK_RIGHT) {
            body.startWalking(WALKING_SPEED); // 2 = walk right
        } if (levelNumber == 1){
        
        if (code == KeyEvent.VK_UP){
            crashY = crashY + 6 ;
            body.setPosition(new Vec2(15, crashY));
            System.out.println(body.getPosition());
            
        } else if (code == KeyEvent.VK_DOWN){
            crashY = crashY - 6 ;
            body.setPosition(new Vec2(15, crashY));
            System.out.println(body.getPosition());
            
        } 
        } else if (levelNumber == 2){
            if (code == KeyEvent.VK_UP){
            crashY = crashY + 8 ;
            body.setPosition(new Vec2(13, crashY));
            System.out.println(body.getPosition());
            
        } else if (code == KeyEvent.VK_DOWN){
            crashY = crashY - 8 ;
            body.setPosition(new Vec2(13, crashY));
            System.out.println(body.getPosition());
            
        } 
        }
        
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            body.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            body.stopWalking();
        }
    }
    
    public void setBody(Crash body) {
        this.body = body;
    }
}
