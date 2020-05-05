/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;

/**
 * State at the beginning of the level to move the package to the left conveyer when Crash is in the vicinity
 * @author Junad
 */
public class LevelStartState extends FSMState<Packaging> {

    protected void update() {
        Packaging packaging = getContext();
        if (packaging.inRangeHomer()) {
            gotoState(new MoveUpHomerState());
        } else if (packaging.inRangeCrash()) {
            gotoState(new MoveUpCrashState());
        }
    else {
            packaging.startWalking(5);
        }
    }
/**What action happens in this state */
    protected void enter() {
        Packaging packaging = getContext();
        packaging.startWalking(-5); //make it move in opposite direction
    }
    
    protected void exit() {}
}