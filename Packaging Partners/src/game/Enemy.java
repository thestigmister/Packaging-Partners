/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import city.cs.engine.*;
/**
 * Enemy character class
 * @author Junad
 */
public class Enemy extends Walker{
    
    
    private int livesCount;
    
    private static final Shape enemyShape = new PolygonShape(
            2.87f,2.37f, 2.59f,-2.48f, 1.64f,-2.55f, -1.62f,-2.23f, -2.92f,1.63f, -0.34f,2.07f);
    private static final BodyImage RightImage =
        new BodyImage("data/metal gear.png", 5.25f);
    
    public Enemy(World world) {
        super(world, enemyShape);
        addImage(RightImage);
        livesCount = 3;
    }
/**
 * Attempt of having lives mutators. NullPointerExceptions occuring.
 * Utilizing the methods in Dalek class instead
 * @return livesCount
 */
    public int getLivesCount() {
        return livesCount;
    }

    public void incrementLivesCount(){
        livesCount++;
        System.out.println("Tasty! Lives: "+ livesCount);
    }
    public void decrementLivesCount(){ // i attempted to use this on the score, but i kept getting null pointer exceptions every time implement in the MyView class
        livesCount--;
        System.out.println("You muppet! Lives: "+ livesCount);
        if (livesCount == 0){
            System.exit(0);
        }
    }
    
}
