import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class salju here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Salju extends Actor
{
    /**
     * Act - do whatever the salju wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage image1 = new GreenfootImage("brick.jpg");
    GreenfootImage image2 = new GreenfootImage("snowman.jpg");
    int indexku;
    public Salju(int indexDiArray)
    {
        setImage(image1);
        indexku = indexDiArray;
    }
    public void act()
    {
        if(Greenfoot.mousePressed(this))
        {
            setImage(image2);
            Background.counterKlik++;
            Background.statusKlik[indexku] = true;
        }
    }
}
