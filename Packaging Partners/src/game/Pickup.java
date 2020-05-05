package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the player to collect things.
 * Player being Dalek and Homer. Also if the PAckaging object collides
 */
public class Pickup implements CollisionListener {
    private Dalek dalek;
    private Homer homer;
    private Packaging packaging;
    private Omnitrix omnitrix;
    private MyView view;
    private Game game;
    
    public Pickup(Dalek dalek, Homer homer, Packaging packaging, Omnitrix omnitrix, Game game) {
        this.dalek = dalek;
        this.homer = homer;
        this.packaging = packaging;
        this.omnitrix = omnitrix;
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == dalek) { // if the dalek collides with anything
           if (e.getReportingBody() instanceof Zeiton7 ){ // if the dalek collides with the crystals
              dalek.incrementZeitonCount(); 
               e.getReportingBody().destroy();
           } else if (e.getReportingBody() instanceof Omnitrix){
               System.out.println("Time increased!");
               game.getMyView().incrementTimer();
               e.getReportingBody().destroy();
           }
            
            //e.getReportingBody().destroy();
        }
        if (e.getOtherBody() == homer){ //if homer collides with anything
            if (e.getReportingBody() instanceof Zeiton7 ){ //if homer collides with the crystals
              dalek.incrementZeitonCount(); 
               e.getReportingBody().destroy();
           } else if (e.getReportingBody() instanceof Omnitrix){
               System.out.println("Time increased!");
               game.getMyView().incrementTimer();
               e.getReportingBody().destroy();
           }
           
        }
        if (e.getOtherBody() == packaging){ //if the packages collide with anything
            
            //packaging.setPosition(new Vec2(9,0));
            //packaging.moveToPlat2();
            packaging.setPosition(new Vec2(-9, -3)); //my attempt to move the package to the next conveyer
            packaging.startWalking(3); //and swap direction
            //e.getReportingBody().destroy();
            
        }
        if (e.getOtherBody() == omnitrix){
            view.incrementTimer();
        }
       
    }
    
}
