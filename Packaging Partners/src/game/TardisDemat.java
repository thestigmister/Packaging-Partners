/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.BodyImage;
import city.cs.engine.Fixture;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.SoundClip;
import city.cs.engine.Walker;
import city.cs.engine.World;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


/**
 * Object which is used as the destination in the game
 * @author Junad
 */
public class TardisDemat extends Walker{
    
        private static SoundClip level1Sound;
        private static final BodyImage demat= new BodyImage("data/demat.gif", 6.25f);
    
    static {
        try {
           level1Sound = new SoundClip("data/sfx/found.wav");
           System.out.println("Loading orange sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    public TardisDemat (World world) {
        super(world);
        Shape shape = new PolygonShape(-2.88f,3.07f, -1.05f,2.07f, -1.05f,-2.96f, -4.76f,-2.96f, -4.81f,2.07f);  //0.02f,3.06f, 1.55f,2.25f, 1.58f,-2.97f, -1.6f,-3.01f, -1.57f,2.29f for tardis.gif
        Fixture fixture = new SolidFixture(this, shape);
        addImage(demat);
        //addImage(new BodyImage("data/tardis.gif", 6.25f));
      
    }
}
