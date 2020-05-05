package game;

import fsm.FSMState;
import org.jbox2d.common.Vec2;
/**
 * State which moves package to next conveyer and moves rightwards
 * @author Junad
 */
public class MoveUpHomerState extends FSMState<Packaging> {

    protected void update() {
        Packaging packaging = getContext();
        if (!packaging.inRangeHomer()) {
            gotoState(new LevelStartState());
        } else if (packaging.inRangeCrash()) {
            gotoState(new MoveUpCrashState());
        }
    else {
            packaging.startWalking(5);
        }
    }

    protected void enter() {
        Packaging packaging = getContext();
        packaging.setPosition(new Vec2(packaging.getPosition().x ,packaging.getPosition().y + 6)); //move the package just up to next plat
        packaging.startWalking(5); //make it move in opposite direction
    }
    
    protected void exit() {}
}
