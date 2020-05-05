/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Controller specifically for Homer
 * @author Junad
 */
public class HomerController extends KeyAdapter {
    private static final float JUMPING_SPEED = 10;
    private static final float WALKING_SPEED = 4;
    private float homerY = -5;
    
    Packaging packaging;
    
    //private Homer body;
    private Homer homer;
    //private Walker homerBody;
    
    public HomerController(Homer homer){
        this.homer=homer;
    }
    
    //public HomerController(Homer body) {
        //this.body = body;
        //this.homerBody = homerBody;
    //}
    
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_Q) { // Q = quit
            System.exit(0);
        } else if (code == KeyEvent.VK_J) { // J = jump
            Vec2 v = homer.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                homer.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            homer.startWalking(-WALKING_SPEED); // move left
            homer.addImage(homer.getLeftImage()); //changes character image to left
            //System.out.println(body.getPosition());
        } else if (code == KeyEvent.VK_D) {
            homer.startWalking(WALKING_SPEED); // move right
            homer.addImage(homer.getRightImage()); 
            //System.out.println(body.getPosition());
        } else if (code == KeyEvent.VK_W){
            homerY = homerY + 6.15f ;
            homer.setPosition(new Vec2(-15, homerY));
            //homer.setPosition(homer.getHomerPos());
            System.out.println(homer.getPosition());
            
        } else if (code == KeyEvent.VK_S){
            homerY = homerY - 6 ;
            homer.setPosition(new Vec2(-15, homerY));
            System.out.println(homer.getPosition());
            
        } 
        
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            homer.stopWalking();
        } else if (code == KeyEvent.VK_D) {
            homer.stopWalking();
        }
    }
    
    public void setBody(Homer homer) {
        this.homer = homer;
    }
}
