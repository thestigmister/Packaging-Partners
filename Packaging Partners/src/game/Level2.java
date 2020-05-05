/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.jbox2d.common.Vec2;

/**
 * Level 2 of the game
 * @author Junad
 */
public class Level2 extends GameLevel{
    
    
    //private Dalek dalek;
    //private Crash crash;
    //private Homer homer;
    private Packaging packaging;
    private int NUM_CRYSTALS;
    
    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);
        
        NUM_CRYSTALS = 4;
        // make the ground
        Shape groundShape = new BoxShape(30, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));
        

        // make a platform
        Shape platformShape = new BoxShape(1.5f, 0.5f);
        Shape otherPlatShape = new BoxShape(3, 0.25f);
        
        
        //right players platforms - lowest, middle, top
        Body p1lplat = new StaticBody(this, platformShape);
        p1lplat.setPosition(new Vec2(13, -10.5f));
        p1lplat.setFillColor(Color.ORANGE);
        Body p1mplat = new StaticBody(this, platformShape);
        p1mplat.setPosition(new Vec2(13 , -1));
        p1mplat.setFillColor(Color.ORANGE);
        Body p1tplat = new StaticBody(this, platformShape);
        p1tplat.setPosition(new Vec2(13 , 7));
        p1tplat.setFillColor(Color.ORANGE);
        //left players platforms - lower, middle, top
        Body p2lplat =  new StaticBody(this, platformShape);
        p2lplat.setPosition(new Vec2(-15 , -7));
        p2lplat.setFillColor(Color.YELLOW);
        Body p2mplat =  new StaticBody(this, platformShape);
        p2mplat.setPosition(new Vec2(-15 , -1));
        p2mplat.setFillColor(Color.YELLOW);
        Body p2tplat =  new StaticBody(this, platformShape);
        p2tplat.setPosition(new Vec2(-17 , 5));
        p2tplat.setFillColor(Color.YELLOW);
        
        Body bossPlat = new StaticBody(this, otherPlatShape);
        bossPlat.setPosition(new Vec2(-21.7f , -4));
        
        
        // conveyers from bottom to top
        Shape conveyerShape = new BoxShape(12, 0.5f);
        Shape conveyer3Shape = new BoxShape(6.5f, 0.5f);
        Shape shortConveyerShape = new BoxShape(4.5f, 0.5f);
        Shape shorterConveyerShape = new BoxShape(3f, 0.5f);
        Shape startConveyerShape = new BoxShape(4, 0.45f);
        Shape slideConveyerShape = new BoxShape(3, 0.5f);
        Shape bottomConveyerShape = new BoxShape(10, 0.5f);
        
        
        Body conveyer1 = new StaticBody(this, bottomConveyerShape);
        conveyer1.setPosition(new Vec2(0, -7));
        conveyer1.setFillColor(Color.RED);
        //conveyer 2 is tilted one
        Body conveyer2 = new StaticBody(this, slideConveyerShape);
        conveyer2.setPosition(new Vec2(-5.85f, -2.5f));
        conveyer2.setAngle(10);
        conveyer2.setFillColor(Color.red);
        
        Body conveyer3 = new StaticBody(this, conveyer3Shape);
        conveyer3.setPosition(new Vec2(3.5f, -0.5f));
        conveyer3.setFillColor(Color.red);
        
        
        Body conveyer4 = new StaticBody(this, shortConveyerShape);
        conveyer4.setPosition(new Vec2(-5.5f, 3.5f));
        conveyer4.setFillColor(Color.red);
        
        Body pl2Cmplat = new StaticBody(this, platformShape);
        pl2Cmplat.setPosition(new Vec2(1.5f, 2));
        pl2Cmplat.setFillColor(Color.orange);
        
        Body conveyer4pt2= new StaticBody(this, shorterConveyerShape);
        conveyer4pt2.setPosition(new Vec2(7f, 3.5f));
        conveyer4pt2.setFillColor(Color.red);
        
        Body conveyer5 = new StaticBody(this, conveyerShape);
        conveyer5.setPosition(new Vec2(-2, 8));
        conveyer5.setFillColor(Color.red);
        
        Body startConveyer = new StaticBody(this, startConveyerShape);
        startConveyer.setPosition(new Vec2(20, 7));
        startConveyer.setFillColor(Color.red);
        
        Shape goalConveyerShape = new BoxShape(3, 0.5f);
        Body goalConveyer = new StaticBody(this, goalConveyerShape);
        goalConveyer.setPosition(new Vec2(21.5f, -9));
        
        //packages      
        
        Packaging packaging = new Packaging(this);
        packaging.setPosition(new Vec2(9,0));
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
        
        Pipe pipe = new Pipe(this);
        pipe.setPosition(new Vec2(25, 10));
        pipe.setGravityScale(0);
        
        
        //adding pickups
        Zeiton7 zeiton7 = new Zeiton7(this);
        zeiton7.setPosition(new Vec2(4,-9));
        zeiton7.setGravityScale(0);
        zeiton7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));// this makes the crystal the thing that dissappears

        
        //adding multiple pickups
        for (int i = 0 ; i<4; i++){
            Zeiton7 z7 = new Zeiton7(this);
            z7.setPosition(new Vec2(i * 10 - 20, -9));
            z7.setGravityScale(0);
            z7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        }
        //timer powerups
        Omnitrix time = new Omnitrix(this);
        Omnitrix time2 = new Omnitrix(this);
        time.setPosition(new Vec2(-15, -9));
        time.setGravityScale(0);
        time.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        time2.setPosition(new Vec2(-15, 2));
        time2.setGravityScale(0);
        time2.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        
        //adding the invisble collision objects to make the package move to the next platform
        Shape collideShape = new BoxShape(0.25f, 0.25f);
        Body plat1Collide = new StaticBody(this, collideShape);
        //plat1Collide.setPosition(new Vec2(-12f,-6.25f));
        plat1Collide.setPosition(new Vec2(-12f,0f));
        plat1Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat1Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        plat1Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        Body plat2Collide = new StaticBody(this, collideShape);
        plat2Collide.setPosition(new Vec2(12f,-3.25f));
        plat2Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat2Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat2Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        Body plat3Collide = new StaticBody(this, collideShape);
        plat3Collide.setPosition(new Vec2(-12f,0f));
        plat3Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat3Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat3Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
//        Body plat4Collide = new StaticBody(this, collideShape);
//        plat4Collide.setPosition(new Vec2(12f,3.25f));
//        plat4Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
//        plat4Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat4Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
        Body plat5Collide = new StaticBody(this, collideShape);
        plat5Collide.setPosition(new Vec2(-12f,6.25f));
        plat5Collide.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        plat5Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
        plat5Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
 
        // walls
        Shape wallShape = new BoxShape(0.5f, 12);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-25.2f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(25.2f, 0));
    }

    @Override
    public Vec2 crashStartPosition() {
        return new Vec2(13, -8);
    }

    @Override
    public Vec2 homerStartPosition() {
        return new Vec2(-15, -5);
    }

    @Override
    public boolean isCompleted() {
        //return true; //condition to be met to progress to next level
        return dalek.getZeitonCount() >= NUM_CRYSTALS;
    }

    @Override
    public Vec2 dalekStartPosition() {
        return new Vec2(-4, -10);}

    @Override
    public Vec2 tardisStartPosition() {
        return new Vec2(25, -5.5f);
    }
}
    

