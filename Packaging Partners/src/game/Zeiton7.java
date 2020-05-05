/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Item that the player has to pickup to score points. Player being Dalek and Homer too
 * Although Dalek is main player to pick up this item
 * @author Junad
 */
public class Zeiton7 extends Walker{
    private int zeitonCount;
    private static SoundClip zeitonSound;
    private static final Shape dalekShape = new PolygonShape(
        0.003f,0.696f, -0.266f,0.37f, -0.272f,-0.341f, 0.008f,-0.693f, 0.246f,-0.396f, 0.295f,0.085f, 0.194f,0.437f);
    private static final BodyImage RightImage =
        new BodyImage("data/Zeiton 7.2.png", 1.5f);
    
        
    
    static {
        try {
           zeitonSound = new SoundClip("data/getitm19.wav");
           System.out.println("Loading zeiton sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    
    public Zeiton7(World world) {
        super(world, dalekShape);
        addImage(RightImage);
        zeitonCount = 0;
    }
   /**
    * 
    * @return zeitonCount 
    */
    public int getZeitonCount(){
        return zeitonCount;
    }
    /**
     * Increments the zeitonCount variable by 1 and prints message to the console
     */
    public void incrementZeitonCount(){
        zeitonCount++;
        System.out.println("Extra point");
    } 
    /**Plays the sound effect when player collides with pickup, and destroys the item */
     @Override
    public void destroy(){
    zeitonSound.play();
    super.destroy();
    }
   
}
