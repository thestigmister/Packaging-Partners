/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;

/**
 * Crash Bandicoot is the right most player. AKA player 1.
 * @author Junad
 */
public class Crash extends Walker{
    private static final Shape crashShape = new PolygonShape(
        0.15f,2.15f, 1.05f,1.83f, 1.51f,-1.1f, 1.04f,-2.31f, -0.78f,-2.29f, -1.27f,-1.08f, -0.8f,1.82f);
    private static final BodyImage standImage =
        new BodyImage("data/crash still.gif", 5f);
    private static final BodyImage climb1Image =
            new BodyImage("data/Homer sprites/homer climb 1.png", 5.25f);
    private static final BodyImage climb2Image =
            new BodyImage("data/Homer sprites/homer climb 2.png", 5.25f);
    private static final BodyImage pickUpImage =
            new BodyImage("data/Homer sprites/homer pick up.png", 5.25f);
    private static final BodyImage putUpImage =
            new BodyImage("data/Homer sprites/homer put up.png", 5.25f);
    
    public int p1PlatPos;
    private Crash crash;

    
    public Crash(World world) {
        super(world, crashShape);
        addImage(standImage);
        p1PlatPos = 1;
    }
    
    public Crash getCrash(){
        return crash;
    }
    
    

}
