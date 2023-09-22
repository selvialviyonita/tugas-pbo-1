import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class Ikan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ikan extends Actor
{
    /**
     * Act - do whatever the Ikan wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int angle=-10+Greenfoot.getRandomNumber(20);
        angle+=getRotation();
        
    List<Ikan> others=getObjectsInRange(30,Ikan.class);
        if(others.size()>0) {
            double rx=others.get(0).getX()-getX();
            double ry=others.get(0).getY()-getY();
            
            int sudut=(int)Math.round(Math.atan2(ry,rx)*180.0/Math.PI);
            angle=sudut+180;
        }
        
        int step=5;
        int posx=getX()+(int)Math.round(step*Math.cos(angle*Math.PI/180));
        int posy=getY()+(int)Math.round(step*Math.sin(angle*Math.PI/180));
        
        setLocation(posx,posy);
        setRotation(angle);
    }
}
