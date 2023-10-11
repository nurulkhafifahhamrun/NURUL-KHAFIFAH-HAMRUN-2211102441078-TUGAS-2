import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Pipe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pipe extends Actor
{
    private int speed = -2;
    
    public Pipe() {
        GreenfootImage image = new GreenfootImage(20, 250);
        image.setColor(Color.GREEN);
        image.fill();
        setImage(image);
        
    }
    public void act()
    {
         move(speed);
        if (getX() == 0) {
            getWorld().removeObject(this);
        }
    }
}
