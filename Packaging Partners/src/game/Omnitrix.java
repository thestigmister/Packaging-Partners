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
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * Pickup item that increases the timer by 10 seconds
 * @author Junad
 */
public class Omnitrix extends Walker{
    
    private static final Shape lifeShape = new PolygonShape(
            0.0f,0.611f, 0.611f,0.013f, 0.011f,-0.605f, -0.603f,-0.036f);
    private static final BodyImage lifeImage =
        new BodyImage("data/omnitrix.png", 1.25f);
    private static SoundClip omnitrixSound;
    
    static {
        try {
           omnitrixSound = new SoundClip("data/omnitrixsfx.wav");
           System.out.println("Loading omnitrix sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    public Omnitrix(World world) {
        super(world, lifeShape);
        addImage(lifeImage);
    }
    
    /**Plays the sound effect when player collides with pickup, and destroys the item */
     @Override
    public void destroy(){
    omnitrixSound.play();
    super.destroy();
    }
    
}
