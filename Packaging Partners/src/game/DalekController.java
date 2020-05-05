/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Walker;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import org.jbox2d.common.Vec2;

/**
 * Controller class to control the Dalek player utilizing comma, period and space buttons
 * @author Junad
 */
public class DalekController extends KeyAdapter {
    private static final float JUMPING_SPEED = 10;
    private static final float WALKING_SPEED = 4;
    
    private Walker body; //private Crash body
    //private Walker homerBody;
    private Dalek dalek;
    
    public DalekController(Dalek dalek) {
        this.dalek = dalek;
        //this.homerBody = homerBody;
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
        //} else if (code == KeyEvent.VK_ENTER) { // J = jump
            //Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            //if (Math.abs(v.y) < 0.01f) {
                //body.jump(JUMPING_SPEED);
            //}
        } else if (code == KeyEvent.VK_COMMA) {
            dalek.startWalking(-WALKING_SPEED); // ,< = walk left
            dalek.addImage(dalek.getLeftDalek());
        } else if (code == KeyEvent.VK_PERIOD) {
            dalek.startWalking(WALKING_SPEED); // .> = walk right
            dalek.addImage(dalek.getRightDalek());
        } else if (code == KeyEvent.VK_SPACE) { // J = jump
            Vec2 v = dalek.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                dalek.jump(JUMPING_SPEED);
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
        if (code == KeyEvent.VK_COMMA) {
            dalek.stopWalking();
        } else if (code == KeyEvent.VK_PERIOD) {
            dalek.stopWalking();
        }
    }
    
    public void setBody(Dalek dalek) {
        this.dalek = dalek;
    }
}

