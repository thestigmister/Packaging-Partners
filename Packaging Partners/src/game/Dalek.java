package game;

import city.cs.engine.*;
import city.cs.engine.Walker;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Dalek character class. Also contains the methods for incrementing score
 *and altering lives count
 */
public class Dalek extends Walker {
    private int zeitonCount;
    public int livesCount;
    private int score;
    private Game game;
    private GameLevel world;
    private Enemy enemy;
    private static SoundClip gameoverSound;
    private static SoundClip ouchSound;
    private static final Shape dalekShape = new PolygonShape(
        -0.6f,1.57f, -1.24f,0.33f, -1.27f,-1.6f, 0.64f,-1.58f, 1.33f,0.44f, 0.86f,1.52f);
    private static final BodyImage RightImage =
        new BodyImage("data/dalek acc clear.png", 3.25f);
    private static final BodyImage LeftImage =
        new BodyImage("data/dalek left.png", 3.25f);
    
    static {
        try {
           gameoverSound = new SoundClip("data/gameover.wav");
           System.out.println("Loading game over sound");
           ouchSound = new SoundClip("data/found.wav");
           System.out.println("Loading ouch sound");
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
           System.out.println(e);
         }        
    }
    
    public Dalek(World world, Game game) {
        super(world, dalekShape);
        addImage(RightImage);
        zeitonCount=0;
        livesCount=3;
        score = 0 ;
        this.game = game;
    }

    private Dalek dalek;
/**
 * @return Returns the value of the score variable 
 */
    public int getScore() {
        return score;
    }
/**
 * Sets the score variable from the parameter 'score'
 * @param score 
 */
    public void setScore(int score) {
        this.score = score;
    }
/**
 * Returns the value of zeitonCount variable
 * @return zeitonCount
 */
    public int getZeitonCount(){ //accessor
        return zeitonCount;
    }
    /**
     * When called, will increment variable 'zeitonCount' by 1, and
     * also increase 'score' by 1 alongside printing to the console a message
     */
    public void incrementZeitonCount(){ //mutator
        zeitonCount++;
        score++;
        System.out.println("Zeiton crystal bonus: " + zeitonCount);
    }
    /**
     * Returns the value of variable livesCount
     * @return livesCount
     */
    public int getLivesCount(){
        return livesCount;
        //return game.getEnemy().getLivesCount();
    }
    /**
     * Increments the livesCount variable by 1 and prints a message to the console
     */
    public void incrementLivesCount(){
        livesCount++;
        System.out.println("Tasty! Lives: "+ livesCount);
    }
    /** 
     * Decreases the life count and plays the soundclip.
     * Also, if the variable livesCount becomes 0, then it exits the program
     * and prints a message 'Game Over' to the console
     */
    public void decrementLivesCount(){
        livesCount--;
        System.out.println("You muppet! Lives: "+ livesCount);
        ouchSound.play();
        if (livesCount == 0){
            game.getWorld().stop();
            game.level1Music.stop();
            game.level2Music.stop();
            game.level3Music.stop();
            System.out.println("Game Over");
            gameoverSound.play();
            GameOverScreen gameoverScreen = new GameOverScreen();
            gameoverScreen.setVisible(true);
        }
    }

     //accessors for changing image when direction changes
    /**
     * Getters used to change the image of the Dalek character when called
     * @return leftImage
     */
    public BodyImage getLeftDalek(){
        this.removeAllImages();
        return LeftImage;
    }
    /**
     * Getters used to change the image of the Dalek character when called
     * @return RightImage
     */
    public BodyImage getRightDalek(){
        this.removeAllImages();
        return RightImage;
    }
    
    /**
     * Allows us to use the Dalek class
     * @return dalek
     */
    public Dalek getPlayer(){
        return dalek;
    }
    
    public GameLevel getGameLevel(){
        return world;
    }
    
   

    
}
