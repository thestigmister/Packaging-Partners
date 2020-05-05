/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import java.awt.Color;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 * @author Junad
 */
public class Level3 extends GameLevel{
    
    //private Dalek dalek;
    //private Crash crash;
    //private Homer homer;
    private Enemy enemy;
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
        Shape platformShape = new BoxShape(2, 0.5f);
        Shape otherPlatShape = new BoxShape(3, 0.25f);
        
        
        
        // platforms
        Shape playerFloorShape = new BoxShape(20, 0.25f);//platforms the player will walk on
        Shape Dalek1FloorShape = new BoxShape(8f, 0.35f); // platform the dalek will walk across
        Shape Dalek2FloorShape = new BoxShape(4, 0.35f); //middle platform shape
        
        Body topLeftDalekFloor = new StaticBody(this,  Dalek1FloorShape);
        topLeftDalekFloor.setPosition(new Vec2(-16.7f, 7));
        topLeftDalekFloor.setFillColor(Color.RED);
        Body topMiddleDalekFloor = new StaticBody(this, Dalek2FloorShape);
        topMiddleDalekFloor.setPosition(new Vec2(0,7));
        topMiddleDalekFloor.setFillColor(Color.red);
        Body topRightDalekFloor = new StaticBody(this, Dalek1FloorShape);
        topRightDalekFloor.setPosition(new Vec2(16.7f, 7));
        topRightDalekFloor.setFillColor(Color.RED);
        Body homerFloor = new StaticBody(this, playerFloorShape);
        homerFloor.setPosition(new Vec2(0, 1));
        homerFloor.setFillColor(Color.yellow);
        Body bottomLeftDalekFloor = new StaticBody(this,  Dalek1FloorShape);
        bottomLeftDalekFloor.setPosition(new Vec2(-16.7f, -4));
        bottomLeftDalekFloor.setFillColor(Color.RED);
        Body bottomMiddleDalekFloor = new StaticBody(this, Dalek2FloorShape);
        bottomMiddleDalekFloor.setPosition(new Vec2(0,-4));
        bottomMiddleDalekFloor.setFillColor(Color.red);
        Body bottomRightDalekFloor = new StaticBody(this, Dalek1FloorShape);
        bottomRightDalekFloor.setPosition(new Vec2(16.7f, -4));
        bottomRightDalekFloor.setFillColor(Color.red);
        Body crashFloor = new StaticBody(this,  playerFloorShape);
        crashFloor.setPosition(new Vec2(0, -11f));
        crashFloor.setFillColor(Color.orange);
//        Body conveyer5 = new StaticBody(this, conveyerShape);
//        conveyer5.setPosition(new Vec2(0, 5));
//        conveyer5.setFillColor(Color.RED);
//        Body startConveyer = new StaticBody(this, startConveyerShape);
//        startConveyer.setPosition(new Vec2(20, -7));
        
        
        //packages
        Shape packageShape = new BoxShape(1f, 0.5f);
        //Body package1 = new DynamicBody(this, packageShape);
//        for (int i = 10; i >-10; i--){
//            package1.setPosition(new Vec2(i,0));
//        }
        
        //enemy
        Enemy enemy = new Enemy(this);
        enemy.setPosition(new Vec2(16,-9));
        enemy.addCollisionListener(new EnemyListener(enemy, crash, dalek, game));
        enemy.startWalking(-3);
        

        
        
        
        //adding pickups
        Zeiton7 zeiton7 = new Zeiton7(this);
        zeiton7.setPosition(new Vec2(16,9));
        zeiton7.setGravityScale(0);
        zeiton7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));// this makes the crystal the thing that dissappears

        
        //adding multiple pickups
        for (int i = 0 ; i<2; i++){
            Zeiton7 z7 = new Zeiton7(this);
            z7.setPosition(new Vec2(i * 10 - 10, -2));
            z7.setGravityScale(0);
            z7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        }
        
        for (int i = 0 ; i<2; i++){
            Zeiton7 z7 = new Zeiton7(this);
            z7.setPosition(new Vec2(i * 11 - 10, 8));
            z7.setGravityScale(0);
            z7.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        }
        
        Omnitrix time = new Omnitrix(this);
        time.setPosition(new Vec2(6, 10));
        time.setGravityScale(0);
        time.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        
        Omnitrix omnitrix = new Omnitrix(this);
        omnitrix.setPosition(new Vec2(10, -2));
        omnitrix.setGravityScale(0);
        omnitrix.addCollisionListener(new Pickup(dalek, homer, packaging, omnitrix, game));
        
        //adding the invisble collision objects to make the package move to the next platform
//        Shape collideShape = new BoxShape(0.25f, 0.25f);
//        Body plat1Collide = new StaticBody(this, collideShape);
//        plat1Collide.setPosition(new Vec2(-12f,-6.25f));
//        plat1Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat1Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
//        plat1Collide.addCollisionListener(new Pickup(dalek, homer, packaging));
//        Body plat2Collide = new StaticBody(this, collideShape);
//        plat2Collide.setPosition(new Vec2(12f,-3.25f));
//        plat2Collide.addCollisionListener(new Pickup(dalek, homer, packaging));
//        plat2Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat2Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
//        Body plat3Collide = new StaticBody(this, collideShape);
//        plat3Collide.setPosition(new Vec2(-12f,0f));
//        plat3Collide.addCollisionListener(new Pickup(dalek, homer, packaging));
//        plat3Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat3Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
//        Body plat4Collide = new StaticBody(this, collideShape);
//        plat4Collide.setPosition(new Vec2(12f,3.25f));
//        plat4Collide.addCollisionListener(new Pickup(dalek, homer, packaging));
//        plat4Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat4Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
//        Body plat5Collide = new StaticBody(this, collideShape);
//        plat5Collide.setPosition(new Vec2(-12f,6.25f));
//        plat5Collide.addCollisionListener(new Pickup(dalek, homer, packaging));
//        plat5Collide.setFillColor(new Color(0,0,0,0));//makes it transparent
//        plat5Collide.setLineColor(new Color(0,0,0,0));//makes it transparent
// 
        // walls
        Shape wallShape = new BoxShape(0.5f, 12);
        Body leftWall = new StaticBody(this, wallShape);
        leftWall.setPosition(new Vec2(-25.2f, 0));
        Body rightWall = new StaticBody(this, wallShape);
        rightWall.setPosition(new Vec2(25.2f, 0));
    }

    @Override
    public Vec2 crashStartPosition() {
        return new Vec2(2, -9);
    }

    @Override
    public Vec2 homerStartPosition() {
        return new Vec2(-18, 6);
    }

    @Override
    public boolean isCompleted() {
        //return true; //condition to be met to progress to next level
        return dalek.getZeitonCount() >= NUM_CRYSTALS;
    }

    @Override
    public Vec2 dalekStartPosition() {
        return new Vec2(-20, 10);
    }

    @Override
    public Vec2 tardisStartPosition() {
        return new Vec2(-19.5f, -1);
    }
}
    

