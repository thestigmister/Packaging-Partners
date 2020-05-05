/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


/**
 * Homer is 2nd player to the left of the game. AKA player 2
 * @author Junad
 */
public class Homer extends Walker{
    private static final Shape homerShape = new PolygonShape(
        0.07f,2.37f, 0.94f,1.24f, 0.96f,-0.25f, 0.44f,-2.48f, -0.57f,-2.43f, -0.94f,-0.29f, -0.53f,1.67f);
    private static final BodyImage standRightImage =
        new BodyImage("data/Homer sprites/homer stand.png", 5.25f);
    private static final BodyImage standLeftImage =
        new BodyImage("data/Homer sprites/reversed/homer stand.png", 5.25f);
    private static final BodyImage climb1Image =
            new BodyImage("data/Homer sprites/homer climb 1.png", 5.25f);
    private static final BodyImage climb2Image =
            new BodyImage("data/Homer sprites/homer climb 2.png", 5.25f);
    private static final BodyImage pickUpImage =
            new BodyImage("data/Homer sprites/homer pick up.png", 5.25f);
    private static final BodyImage putUpImage =
            new BodyImage("data/Homer sprites/homer put up.png", 5.25f);
    
    public int p2PlatPos;
    private Homer homer;

    
    public Homer(World world) {
        super(world, homerShape);
        addImage(standRightImage);
        p2PlatPos = 1;
    }
    
    /** accessors for changing image when direction changes. Moving left*/
    public BodyImage getLeftImage(){
        this.removeAllImages();
        return standLeftImage;
    }
    /** Changes the image when changing direction to the right */
    public BodyImage getRightImage(){
        this.removeAllImages();
        return standRightImage;
    }
    
    public Homer getHomer(){
        return homer;
    }
    
    public Vec2 getHomerPos(){
        Vec2 homerPos = homer.getPosition();
        return homerPos;
    }
    
    
}
