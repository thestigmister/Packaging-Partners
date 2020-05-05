/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * State which moves the package to the next conveyer and moves it leftwards.
 * @author Junad
 */
public class MoveUpCrashState extends FSMState<Packaging> {

    protected void update() {
        Packaging packaging = getContext();
        if (packaging.inRangeHomer()) {
            gotoState(new MoveUpHomerState());
        } else if (!packaging.inRangeCrash()) {
            gotoState(new LevelStartState());
        }
    else {
            packaging.startWalking(5);
        }
    }

    protected void enter() {
        Packaging packaging = getContext();
        packaging.setPosition(new Vec2(packaging.getPosition().x ,packaging.getPosition().y + 6)); //move the package just up to next plat
        packaging.startWalking(-5); //make it move in opposite direction
    }
    
    protected void exit() {}
}
