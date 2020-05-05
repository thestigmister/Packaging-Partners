///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package game;
//
//import city.cs.engine.*;
//import java.awt.Color;
//import org.jbox2d.common.Vec2;
//
///**
// *
// */
//public class GameWorld extends World {
//    private Dalek dalek;
//    private Crash crash;
//    private Homer homer;
//    //variables to be used
//    public int packagePlatPos; //not final
//    public int p1PlatPos;
//    public int p2PlatPos;
//   
//    Walker getPlayer;
//    public GameWorld() {
//        super();
//        
//
//        //initialising variable to be used
//        packagePlatPos = 1;
//        p1PlatPos = 1;
//        p2PlatPos = 1;
//        
//        
//        
//        
//        // make the ground
//        Shape groundShape = new BoxShape(30, 0.5f);
//        Body ground = new StaticBody(this, groundShape);
//        ground.setPosition(new Vec2(0, -11.5f));
//        
//
//        // make a platform
//        Shape platformShape = new BoxShape(2, 0.5f);
//        Shape otherPlatShape = new BoxShape(3, 0.25f);
//        
//        
//        //right players platforms - lowest, middle, top
//        Body p1lplat = new StaticBody(this, platformShape);
//        p1lplat.setPosition(new Vec2(15, -10.5f));
//        Body p1mplat = new StaticBody(this, platformShape);
//        p1mplat.setPosition(new Vec2(15 , -4));
//        Body p1tplat = new StaticBody(this, platformShape);
//        p1tplat.setPosition(new Vec2(15 , 2));
//        //left players platforms - lower, middle, top
//        Body p2lplat =  new StaticBody(this, platformShape);
//        p2lplat.setPosition(new Vec2(-15 , 5));
//        Body p2mplat =  new StaticBody(this, platformShape);
//        p2mplat.setPosition(new Vec2(-15 , -1));
//        Body p2tplat =  new StaticBody(this, platformShape);
//        p2tplat.setPosition(new Vec2(-15 , -7));
//        
//        Body bossPlat = new StaticBody(this, otherPlatShape);
//        bossPlat.setPosition(new Vec2(21 , -4));
//        
//        
//        Body plat7 = new StaticBody(this, platformShape);
//        plat7.setPosition(new Vec2(-20, 5));
//        
//        
//        
//        // conveyers
//        Shape conveyerShape = new BoxShape(10, 0.5f);
//        Shape startConveyerShape = new BoxShape(4, 0.45f);
//        
//        Body conveyer1 = new StaticBody(this, conveyerShape);
//        conveyer1.setPosition(new Vec2(0, -7));
//        conveyer1.setFillColor(Color.RED);
//        Body conveyer2 = new StaticBody(this, conveyerShape);
//        conveyer2.setPosition(new Vec2(0, -4));
//        conveyer2.setFillColor(Color.RED);
//        Body conveyer3 = new StaticBody(this, conveyerShape);
//        conveyer3.setPosition(new Vec2(0, -1));
//        conveyer3.setFillColor(Color.RED);
//        Body conveyer4 = new StaticBody(this, conveyerShape);
//        conveyer4.setPosition(new Vec2(0, 2));
//        conveyer4.setFillColor(Color.RED);
//        Body conveyer5 = new StaticBody(this, conveyerShape);
//        conveyer5.setPosition(new Vec2(0, 5));
//        conveyer5.setFillColor(Color.RED);
//        Body startConveyer = new StaticBody(this, startConveyerShape);
//        startConveyer.setPosition(new Vec2(20, -7));
//        
//        
//        //packages
//        Shape packageShape = new BoxShape(1f, 0.5f);
//        //Body package1 = new DynamicBody(this, packageShape);
////        for (int i = 10; i >-10; i--){
////            package1.setPosition(new Vec2(i,0));
////        }
//        
//        
//        Packaging packaging = new Packaging(this);
//        packaging.setPosition(new Vec2(9,-6));
//        System.out.println(packaging.getPosition().x);
//        //packaging.setFriction(1.0f);
//        //packaging.setLinearVelocity(new Vec2(-20,0));
//        packaging.startWalking(-3);
//        //packaging.movePlat();
//        
//        
//        //move package to next platform when reaches end of current one. make a sensor
//        if (packaging.getPosition().x <= 0){
//            packaging.moveToPlat2();
//            System.out.println(packaging.getPosition());
//        }
//
//        // make a character
//        dalek = new Dalek(this); //dont need to reinitialise since its declared at the top so i can move with keyboard
//        dalek.setPosition(new Vec2(-4, -10));
//        //bird.startWalking(3.25f);
//        
//        crash = new Crash(this);
//        crash.setPosition(new Vec2(15, -8));
//        
//        
//       homer = new Homer(this);
//       homer.setPosition(new Vec2(-15,-5));
//       //homer.startWalking(3);
//  
////        Tardis tardis = new Tardis(this);
////        tardis.setPosition(new Vec2(-20,-10));
////        tardis.startWalking(2f);
//        
//        //person to deliver to
//        TardisDemat tardisdemat = new TardisDemat(this);
//        tardisdemat.setPosition(new Vec2(-17, 8));
//        
//        
//        //changing characters position
//        //changing homers platPos (attempt)
//        if (homer.getPosition().y == -6.0){ //change the variable when Homers y position is at a certain point (certain platform)
//            p2PlatPos = 1;
//            System.out.println(homer.getPosition());
//        } else if (homer.getPosition().y == 0.0) {
//            p2PlatPos = 2;
//            System.out.println(p2PlatPos);
//        } else if (homer.getPosition().y == 6.0){
//            p2PlatPos = 3;
//            System.out.println(homer.getPosition());
//        }
//        
//        //changing crashes platPos
//        if (crash.getPosition().y == -5){
//            p2PlatPos = 1;
//            System.out.println(crash.getPosition());
//        } else if (crash.getPosition().y == 1) {
//            p2PlatPos = 2;
//            System.out.println(p2PlatPos);
//        } else if (crash.getPosition().y == 6.5f){
//            p2PlatPos = 3;
//            System.out.println(crash.getPosition());
//        }
//        
//        //adding pickups
//        Zeiton7 zeiton7 = new Zeiton7(this);
//        zeiton7.setPosition(new Vec2(4,-9));
//        zeiton7.setGravityScale(0);
//        zeiton7.addCollisionListener(new Pickup(dalek, homer, packaging));// this makes the crystal the thing that dissappears
//        
//        //adding multiple pickups
//        for (int i = 0 ; i<3; i++){
//            Zeiton7 z7 = new Zeiton7(this);
//            z7.setPosition(new Vec2(i * 2 - 10, -9));
//            z7.setGravityScale(0);
//            z7.addCollisionListener(new Pickup(dalek, homer, packaging));
//        }
//        
//        //adding the invisble collision objects to make the package move to the next platform
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
//        // walls
//        Shape wallShape = new BoxShape(0.5f, 12);
//        Body leftWall = new StaticBody(this, wallShape);
//        leftWall.setPosition(new Vec2(-24.5f, 0));
//        Body rightWall = new StaticBody(this, wallShape);
//        rightWall.setPosition(new Vec2(24.5f, 0));
//        
//       
//        
//    
//        
//    }
//    public Dalek getPlayer() { //allows dalek to be controlled Controller class
//        return dalek;
//    }
//    public Crash getCrash(){ //allows crash to be controlled by the Controller class
//        return crash;
//    }
//    public Homer getHomer() { //allows homer to be controlled by Homer Controller Class
//        return homer;
//    }
//
//    
//   
//}
//
//
