/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import fsm.FSM;
import org.jbox2d.common.Vec2;

/**
 * Class for the Package object that the player has to get to the top of the screen
 * @author Junad
 */
public class Packaging extends Walker implements StepListener{
    private static final Shape packagingShape = new PolygonShape(
        -1.062f,0.491f, 1.062f,0.496f, 1.062f,-0.491f, -1.065f,-0.496f);
    private static final BodyImage RightImage =
        new BodyImage("data/package.png", 1.02f);
    
    public static final float RANGE = 5;
    
    private enum State {
        START_PLAT, PLAT1, PLAT2, PLAT3, PLAT4, PLAT5, HOMER_LOW_PLAT, 
        HOMER_MID_PLAT, HOMER_HIGH_PIT, CRASH_LOW_PLAT, CRASH_MID_PLAT, 
        CRASH_HIGH_PLAT, MOVE_LEFT, MOVE_RIGHT
    }
    
    private Game game;
    private Packaging packaging;
    private FSM<Packaging> fsm;
    
    public Packaging(World world) {
        super(world, packagingShape);
        addImage(RightImage);
        fsm = new FSM<Packaging>(this, new LevelStartState());
        //getWorld().addStepListener(this);
    }
    
    
    public boolean inRangeHomer() {
        Body a = game.getPackage();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }
    
     public boolean inRangeCrash() {
        Body a = game.getPackage();
        float gap = getPosition().x - a.getPosition().x;
        return gap < RANGE && gap > 0;
    }

    //moves the package to the next platform when reaches end of current platform and changes direction
    public void moveToPlat2(){
        packaging.setPosition(new Vec2(-9, -3));
        packaging.startWalking(3);
    }
    public void moveToPlat3(){
        packaging.setPosition(new Vec2(9, 0));
        packaging.startWalking(-3);
    }
    public void moveToPlat4(){
        packaging.setPosition(new Vec2(9, 3));
        packaging.startWalking(3);
    }
    public void moveToPlat5(){
        packaging.setPosition(new Vec2(9, 6));
        packaging.startWalking(-3);
    }
    public void movePlat(){
        if (packaging.getPosition().x <= 0){
            packaging.moveToPlat2();
            System.out.println(packaging.getPosition());
        }
    }

    @Override
    public void preStep(StepEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void postStep(StepEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
