/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * This class is so the package itself moves along the belt
 * @author Junad
 */
public class ConveyerBelt implements StepListener{
    private Body body;
    private Packaging packaging;
    
    public ConveyerBelt (Body body, Packaging packaging){
        this.body = body;
        this.packaging = packaging;
    }

   
    public void preStep(StepEvent e) {
    }

    @Override
    public void postStep(StepEvent e) {
        packaging.setLinearVelocity(new Vec2(-10,0));
        packaging.setPosition(new Vec2(-10,0));
    }
    
}
