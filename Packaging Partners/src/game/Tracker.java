/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.Body;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import city.cs.engine.WorldView;
import org.jbox2d.common.Vec2;

/**
 * Unused tracker class
 * @author Junad
 */
public class Tracker implements StepListener {
    private WorldView view;
    private Body body;
    private Crash crash;
    private Homer homer;
    private Packaging packaging;
    public Tracker(WorldView view, Body body) {
        this.view = view;
    this.body = body;
    }
    public void preStep(StepEvent e) {
    
//        if (packaging.getPosition().x <= 0){
//            packaging.moveToPlat2();
//            System.out.println(packaging.getPosition());
//        }
    }
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(body.getPosition())); //need to do something in Game class for it to work
        
//         if (packaging.getPosition().x <= 0){
//            packaging.moveToPlat2();
//            System.out.println(packaging.getPosition());
//        }
        
//        //changing crash position
//        if (crash.getPosition().y <= -5){
//            crash.p1PlatPos = 1;
//            System.out.println(crash.getPosition());
//        } else if (crash.getPosition().y <= 1) {
//            crash.p1PlatPos = 2;
//            System.out.println(crash.p1PlatPos);
//        } else if (crash.getPosition().y <= 6.5f){
//            crash.p1PlatPos = 3;
//            System.out.println(crash.getPosition());
//        }
//        
//        //changing homers platPos (attempt)
//        if (homer.getPosition().y <= -6.0){ //change the variable when Homers y position is at a certain point (certain platform)
//            homer.p2PlatPos = 1;
//            System.out.println("homerPs: " + homer.getPosition());
//        } else if (homer.getPosition().y <= 0.0) {
//            homer.p2PlatPos = 2;
//            System.out.println("homer pos: " + homer.p2PlatPos);
//        } else if (homer.getPosition().y <= 6.0){
//            homer.p2PlatPos = 3;
//            System.out.println("homer Pos: " + homer.getPosition());
//        }
    }
}