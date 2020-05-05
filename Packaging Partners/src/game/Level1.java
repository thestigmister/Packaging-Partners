/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * Level 1 of the game
 * @author Junad
 */
public class Level1 extends GameLevel {
    
    //private Dalek dalek;
    //private Crash crash;
    //private Homer homer;
    private Packaging packaging;
    private int NUM_CRYSTALS;
    private static SoundClip level1Sound;
    
    static {
        try {
           level1Sound = new SoundClip("data/found.wav");
           //System.out.println("Loading Level 1 sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        /** 
         * Number of pickups to be collected
         */
        NUM_CRYSTALS = 4;
        
        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        

        // make a platform
        Shape platformShape = new BoxShape(2, 0.5f);
        Shape otherPlatShape = new BoxShape(3, 0.25f);
        
        /**Creates the platforms for both players to stand on */
        //right players platforms - lowest, middle, top
        Body p1lplat = new StaticBody(this, platformShape);
        p1lplat.setPosition(new Vec2(15, -10.5f));
        p1lplat.setFillColor(Color.ORANGE);
        Body p1mplat = new StaticBody(this, platformShape);
        p1mplat.setPosition(new Vec2(15 , -4));
        p1mplat.setFillColor(Color.orange);
        Body p1tplat = new StaticBody(this, platformShape);
        p1tplat.setPosition(new Vec2(15 , 2));
        p1tplat.setFillColor(Color.ORANGE);
        //left players platforms - lower, middle, top
        Body p2lplat =  new StaticBody(this, platformShape);
        p2lplat.setPosition(new Vec2(-15 , 5));
        p2lplat.setFillColor(Color.YELLOW);
        Body p2mplat =  new StaticBody(this, platformShape);
        p2mplat.setPosition(new Vec2(-15 , -1));
        p2mplat.setFillColor(Color.YELLOW);
        Body p2tplat =  new StaticBody(this, platformShape);
        p2tplat.setPosition(new Vec2(-15 , -7));
        p2tplat.setFillColor(Color.YELLOW);
        
        Body bossPlat = new StaticBody(this, otherPlatShape);
        bossPlat.setPosition(new Vec2(21.5f , -4));
        
        
        Body plat7 = new StaticBody(this, platformShape);
        plat7.setPosition(new Vec2(-20, 5));
        
        
        
        
        // conveyers
        Shape conveyerShape = new BoxShape(10, 0.5f);
        Shape startConveyerShape = new BoxShape(4, 0.45f);
        
        Body conveyer1 = new StaticBody(this, conveyerShape);
        conveyer1.setPosition(new Vec2(0, -7));
        conveyer1.setFillColor(Color.RED);
        Body conveyer2 = new StaticBody(this, conveyerShape);
        conveyer2.setPosition(new Vec2(0, -4));
        conveyer2.setFillColor(Color.RED);
        Body conveyer3 = new StaticBody(this, conveyerShape);
        conveyer3.setPosition(new Vec2(0, -1));
        conveyer3.setFillColor(Color.RED);
        Body conveyer4 = new StaticBody(this, conveyerShape);
        conveyer4.setPosition(new Vec2(0, 2));
        conveyer4.setFillColor(Color.RED);
        Body conveyer5 = new StaticBody(this, conveyerShape);
        conveyer5.setPosition(new Vec2(0, 5));
        conveyer5.setFillColor(Color.RED);
        Body startConveyer = new StaticBody(this, startConveyerShape);
        startConveyer.setPosition(new Vec2(20.75f, -7));
        startConveyer.setFillColor(Color.RED);
        
        
        //packages
        Shape packageShape = new BoxShape(1f, 0.5f);
        //Body package1 = new DynamicBody(this, packageShape);
//        for (int i = 10; i >-10; i--){
//            package1.setPosition(new Vec2(i,0));
//        }
        
        
        Packaging packaging = new Packaging(this);
        packaging.setPosition(new Vec2(9,-6));
        System.out.println(packaging.getPosition().x);
        //packaging.setFriction(1.0f);
        //packaging.setLinearVelocity(new Vec2(-20,0));
        packaging.startWalking(-3);
        //packaging.movePlat();
        
        
        //move package to next platform when reaches end of current one. make a sensor
        if (packaging.getPosition().x <= 0){
            packaging.moveToPlat2();
            System.out.println(packaging.getPosition());
        }  
        
                
        //adding pickups
        //Zeiton7 zeiton7 = new Zeiton7(this);
        //zeiton7.setPosition(new Vec2(4,-9));
        //zeiton7.setGravityScale(0);
        //zeiton7.addCollisionListener(new Pickup(dalek, homer, packaging));// this makes the crystal the thing that dissappears

        
        //adding multiple pickups
        for (int i = 0 ; i<4; i++){
            Zeiton7 z7 = new Zeiton7(this);
            z7.setPosition(new Vec2(i * 10 - 20, -9));
            z7.setGravityScale(0);
            z7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        }
        
        Omnitrix time = new Omnitrix(this);
        time.setPosition(new Vec2(5, -9));
        time.setGravityScale(0);
        time.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        
        
        //adding the invisble collision objects to make the package move to the next platform
        Shape collideShape = new BoxShape(0.25f, 0.25f);
        Body plat1Collide = new StaticBody(this, collideShape);
        plat1Collide.setPosition(new Vec2(-12f,-6.25f));
        plat1Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat1Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        plat1Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        
        Body plat1Block = new StaticBody(this, collideShape);
        plat1Block.setPosition(new Vec2(-18f,-6.25f));
        plat1Block.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat1Block.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat2Collide = new StaticBody(this, collideShape);
        plat2Collide.setPosition(new Vec2(12f,-3.25f));
        plat2Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat2Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat2Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat3Collide = new StaticBody(this, collideShape);
        plat3Collide.setPosition(new Vec2(-12f,0f));
        plat3Collide.addCollisionListener(new Pickup(dalek, homer, packaging,  omnitrix, game));
        plat3Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat3Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat3Block = new StaticBody(this, collideShape);
        plat3Block.setPosition(new Vec2(-18f,0));
        plat3Block.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat3Block.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat4Collide = new StaticBody(this, collideShape);
        plat4Collide.setPosition(new Vec2(12f,3.25f));
        plat4Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat4Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat4Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat5Collide = new StaticBody(this, collideShape);
        //plat5Collide.setPosition(new Vec2(-12f,6.25f));
        plat5Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat5Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat5Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        
        Body plat5Block = new StaticBody(this, collideShape);
        plat5Block.setPosition(new Vec2(-18f,6.25f));
        plat5Block.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat5Block.setLineColor(new Color(0,0,0,0));//makes it transparent
 
        // walls
        Shape wallShape = new BoxShape(0.5f, 12);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-25.2f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(25.2f, 0));
    }
    
    public Dalek getPlayer() { //allows dalek to be controlled Controller class
        return dalek;
    }
    
    
    @Override
    public Vec2 crashStartPosition() {
        return new Vec2(15, -8);
    }

    @Override
    public Vec2 homerStartPosition() {
        return new Vec2(-15, -5);
    }

    @Override
    public boolean isCompleted() {
        //return true; //condition to be met to progress to next level
        return dalek.getZeitonCount() == NUM_CRYSTALS;
    }

    @Override
    public Vec2 dalekStartPosition() {
        return new Vec2(-4, -10);}

    @Override
    public Vec2 tardisStartPosition() {
        return new Vec2(-17, 8);
    }
}
