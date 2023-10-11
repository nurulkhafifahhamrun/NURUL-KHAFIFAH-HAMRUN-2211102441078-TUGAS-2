import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class flappybirdworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FlappyBirdWorld extends World
{
    private Bird bird;
    private int pipeSpawnDelay = 100;
    private int pipeSpawnCounter = 0;
    private int score = 0;

    public FlappyBirdWorld()
    {    
        super(400, 600, 1);
        bird = new Bird();
        addObject(bird, 100, getHeight() / 2);
        showText("Score: 0", 60, 30);
    }
    
    
    public void act() {
        spawnPipes();
        updateScore();
    }

    private void spawnPipes() {
        if (pipeSpawnCounter == pipeSpawnDelay) {
            Pipe pipe = new Pipe();
            addObject(pipe, getWidth(), Greenfoot.getRandomNumber(getHeight() - 200) + 100);
            pipeSpawnCounter = 0;
        }
        pipeSpawnCounter++;
    }
    
    private void updateScore() {
        score++;
        showText("Score: " + score, 60, 30);
    }
}
