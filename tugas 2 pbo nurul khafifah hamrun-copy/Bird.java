import greenfoot.*;  
import java.util.List;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bird here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bird extends Actor {
    private int velocity = 0;
    private int score = 0;
    private boolean scored = false; // Deklarasikan dan inisialisasikan scored

    public Bird() {
        setImage(new GreenfootImage("bee.png"));
    }

    public void act() {
        handleKeyPress();
        fall();
        checkCollision();
        checkScore(); // Memanggil metode checkScore() di dalam metode act()
    }

    private void handleKeyPress() {
        if (Greenfoot.isKeyDown("space")) {
            velocity = -10;
        }
    }

    private void fall() {
        setLocation(getX(), getY() + velocity);
        velocity += 1;
    }

    private void checkCollision() {
        if (isTouching(Pipe.class)) {
            Greenfoot.stop(); // Hentikan permainan jika bersentuhan dengan pipa
        }
    }

    private void checkScore() {
        flappybirdworld world = (flappybirdworld) getWorld();
        List<Pipe> pipes = world.getObjects(Pipe.class);

        for (Pipe pipe : pipes) {
        if (getX() > pipe.getX() && !scored) {
            score++;
            world.showText("Score: " + score, 60, 30);
            scored = true;
            world.removeObject(pipe);
            // Setel scored ke true agar skor hanya ditambahkan sekali saat melewati pipa
        }
            
    }
        
}
}
