package game;

import city.cs.engine.*;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import javax.swing.JFrame;

/**
 * A world with some bodies.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    //private GameWorld world;
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    //private UserView view;
    private MyView view;
    public static int levelNumber;
    private Controller crashController;
    private DalekController dalekController;
    private HomerController homerController;
    private Enemy enemy;
    private ControlPanel panel;
    
    public static SoundClip level1Music;
    public static SoundClip level2Music;
    public static SoundClip level3Music;
    
    final JFrame frame = new JFrame("Milestone 2");

    /** Initialise a new Game. */
    public Game() {
        levelNumber= 1;
        //levelNumber= 2;
        
        /** 
         * Background music for each level in the game. Music swap handled in @method goToNextLevel 
         */
        try {
            level1Music = new SoundClip("data/doctor who theme.wav");   // Open an audio input stream
            level1Music.loop();  // Set it to continous playback (looping)
            System.out.println("Loading Level 1 bgm");
            level2Music = new SoundClip("data/paperboy theme.wav");
            level2Music.loop();
            level2Music.stop();
            System.out.println("Loading Level 2 bgm");
            level3Music = new SoundClip("data/mgstot.wav");
            level3Music.loop();
            level3Music.stop();
            System.out.println("Loading Level 3 bgm");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }  


        // make the world
        //world = new GameWorld();
        
        //world = new Level2();
        world = new Level1();
        world.populate(this);

        // make a view
        view = new MyView(world, this, 1000, 500);
        
        // make a panel
        panel = new ControlPanel(this);

        // uncomment this to draw a 1-metre grid over the view
         //view.setGridResolution(1);

        // add some mouse actions
        // add this to the view, so coordinates are relative to the view
        //view.addMouseListener(new MouseHandler(view));

        // display the view in a frame
        //final JFrame frame = new JFrame("Milestone 2");

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        //display the panel in the window
        frame.add(panel,BorderLayout.SOUTH);//move the panel to the south (bottom) of the screen
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
         // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        //view.addMouseListener(new GiveFocus(frame));
        //link the controllers to the players
        frame.addKeyListener(new DalekController(world.getPlayer()));//listens to key presses in the world for the dalek
        frame.addKeyListener(new Controller(world.getCrash()));//links controller to crash
        frame.addKeyListener(new HomerController(world.getHomer()));//links controller2 to homer
        
        //other stuff
        //System.out.println(homer.getPosition());
        //world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
         //JFrame debugView = new DebugViewer(world, 1000, 500);

        // start!
        world.start();
    }
    
    
    
       /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }
    
    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (levelNumber == 3) {
            System.out.println("You're Winner!");
            System.exit(0);
        } else {
            int currentScore= world.getPlayer().getScore(); //
            levelNumber++;
            //music
            level1Music.stop();
            level2Music.play();
            level2Music.loop();
            view.resetTimer();
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            
            world.getPlayer().setScore(currentScore);
            // switch the keyboard control to the new player
            Dalek dalek = world.getPlayer();
            
            frame.addKeyListener(new DalekController(world.getPlayer()));//listens to key presses in the world for the dalek
            frame.addKeyListener(new Controller(world.getCrash()));//links controller to crash
            frame.addKeyListener(new HomerController(world.getHomer()));//links controller2 to homer
            
            
            //world.addStepListener(listener);
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
        if (levelNumber == 3){
             int currentScore3= world.getPlayer().getScore();
            // get a new world
            world = new Level3();
            //music
            level2Music.stop();
            level3Music.play();
            level3Music.loop();
            view.resetTimer();
            // fill it with bodies
            world.populate(this);
            // switch the keyboard control to the new player
            Dalek dalek = world.getPlayer();
            
            world.getPlayer().setScore(currentScore3);
            
            frame.addKeyListener(new DalekController(world.getPlayer()));//listens to key presses in the world for the dalek
            frame.addKeyListener(new Controller(world.getCrash()));//links controller to crash
            frame.addKeyListener(new HomerController(world.getHomer()));//links controller2 to homer
            
            //world.addStepListener(new Tracker(view, world.getPlayer()));
            //world.addStepListener(listener);
            // show the new world in the view
            view.setWorld(world);

            world.start();
        }
    }
    
    /**
     * Used to restart the game without having to exit the game or open another window
     * Stops all music regardless of what level the user has just exited from
     * Starts level 1 music and starts a new level 1 as it did when starting the program for the first time
     */
    public void restartGame(){
        levelNumber = 1;
        level1Music.stop(); //stop bgm and restart it
        level2Music.stop(); //stop all other bgm playing
        level3Music.stop();
        level1Music.play();//start level 1 bgm
        world = new Level1();
        world.populate(this);
        view.resetTimer();
        // switch the keyboard control to the new player
        Dalek dalek = world.getPlayer();
        frame.addKeyListener(new DalekController(world.getPlayer()));//listens to key presses in the world for the dalek
        frame.addKeyListener(new Controller(world.getCrash()));//links controller to crash
        frame.addKeyListener(new HomerController(world.getHomer()));//links controller2 to homer
        // show the new world in the view
        view.setWorld(world);

        world.start();
    } 
/**
 * Allows us to utilize other methods in the GameLevel class
 * @return world
 */
    public GameLevel getWorld() {
        return world;
    }
/**
 * Allows us to use Dalek class
 * @return world.getPlayer()
 */
    public Dalek getPlayer(){
        return world.getPlayer();
    }
/**
 * Allows us to use Homer class
 * @return world.getHomer()
 */
    public Homer getHomer(){
        return world.getHomer();
    }
    /**
 * Allows us to use Crash class
 * @return world.getCrash()
 */
    public Crash getCrash(){
        return world.getCrash();
    }
    /**
 * Allows us to use Enemy class
 * @return world.getEnemy()
 */
    public Enemy getEnemy(){
        return world.getEnemy();
    }
    /**
 * Allows us to use Packaging class
 * @return world.getPAckage()
 */
    public Packaging getPackage(){
        return world.getPackage();
    }
    /**
     * Allows us to use MyView class
     * @return view
     */
    public MyView getMyView(){
        return view;
    }
    
    /** Run the game. */
    public static void main(String[] args) {
        new Game();
    }


}
