/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import city.cs.engine.*;
import static game.Game.levelNumber;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 * Handles the background image and the foreground Score text. Also handles the timer.
 * @author Junad
 */
public class MyView extends UserView implements ActionListener{
    
    public Image background;
    private Image background2;
    private Image background3;
    private Shape bg;
    private Dalek dalek;
    private Game game;
    private GameLevel world;
    private Enemy enemy;
    private Timer timer;
    private int time;
    
    public MyView(World world, Game game, int width, int height ) {
        super(world, width, height);
        background3 = new ImageIcon("data/bg1.gif").getImage();
        background2 = new ImageIcon("data/bgl2.gif").getImage();
        background = new ImageIcon("data/background1.jpg").getImage();
        bg = new BoxShape(100, 10.5f);
        this.game = game;
        time = 60;
        timer = new Timer(1000, this);
        timer.setInitialDelay(100);
        timer.start();
        //this.enemy = enemy;
        //this.background2 = background2.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        this.background = background.getScaledInstance(1100, height, java.awt.Image.SCALE_SMOOTH);
    }
    /**Resets the timer to 60 seconds */
    public void resetTimer(){
        time = 60;
    }
    
    public void incrementTimer(){
        time = time + 10;
    }
    
    public void pauseTimer(){
        timer.stop();
    }
    public void unpauseTimer(){
        timer.start();
    }
    
    /** Draws the background on the screen. Changes the background based on the current level */
    @Override
    protected void paintBackground(Graphics2D g) {
        if (levelNumber == 1){
            g.drawImage(background, 0, 0, this);
        } else if (levelNumber == 2){
            g.drawImage(background2, 10, 0, this);
        } else if (levelNumber == 3){ 
            g.drawImage(background3, 0, 0, this);
        }
    }
    /**Draws the HUD, the score and lives counter */
    @Override
    protected void paintForeground(Graphics2D g) {
        g.setColor(Color.red);
        Font sHUD = new Font("Tahoma", Font.BOLD, 16);
        g.setFont(sHUD);
        g.drawString("Score: " + game.getPlayer().getScore(), 900, 20);
        g.drawString("Lives: " + game.getPlayer().getLivesCount(), 900, 40);
        g.drawString("Time: " + time , 900, 60); 
        }
/**Decreases the time by 1 second every second. Also quits the game if the time runs out */
    @Override
    public void actionPerformed(ActionEvent ae) {
        time = time - 1;
        if (time == 0){
            System.out.println("Time's up!");
            System.exit(0);
        }
    }
}
