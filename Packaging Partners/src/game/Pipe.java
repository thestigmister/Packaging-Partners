/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.World;

/**
 * Simple pipe image
 * @author Junad
 */
public class Pipe extends DynamicBody{
    private static final Shape pipeShape = new PolygonShape(
            1.34f,1.72f, 1.33f,0.71f, 1.03f,-1.61f, -1.04f,-1.61f, -1.36f,0.75f, -1.33f,1.72f);
    private static final BodyImage RightImage =
        new BodyImage("data/warp pipe.png", 3.5f);
    
    private Pipe pipe;
    
    public Pipe(World world) {
        super(world, pipeShape);
        addImage(RightImage);
        
    }
    
    
}
