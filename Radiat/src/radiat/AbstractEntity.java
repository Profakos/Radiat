/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

/**
 *
 * @author Akos
 */
public abstract class AbstractEntity implements Drawable, Collideable {
    
    protected int locX;
    protected int locY;
    
    protected float velX;
    protected float velY;
    protected int speed;
    protected Directions facing;
    
    private int radiusX;
    private int radiusY;
    protected CollideType collideType;
    protected int team;
    private boolean passableCollision;
    
    private String image;
    
    public AbstractEntity(int locX, int locY, int team){
    this.locX = locX;
    this.locY = locY;
    this.team = team;
    
    velX = 0;
    velY = 0;
    
    facing = Directions.Down;
    
    radiusX = 0;
    radiusY = 0;
    collideType = CollideType.all; 
    passableCollision = true;
    
    image = null;
    
    }
    
    /*
     * Drawable implementation
     */
    @Override
     public void draw(Graphics g, Viewport v){
    
        Image imageDraw = ImageRegistry.getImage(getImage());
        if(imageDraw!=null) {
            g.drawImage(imageDraw, locX-getRadiusX(), locY-getRadiusY(), null);
        }
        
        if(!v.isDebug()) return;
        g.setColor(Color.darkGray);
        g.drawRect(this.locX-getRadiusX(), this.locY-getRadiusY(), 
                getRadiusX()*2, getRadiusY()*2);}; 
    
    /*
     * Collideable implementation
     */
    @Override
     public boolean isCollideableWith(Collideable c){
        switch(c.getCollideType()) {
            case none: 
                return false; 
            case other: 
                if(c.getTeam()!=getTeam()) 
                    return true;
                else
                    return false; 
            case same: 
                if(c.getTeam()==getTeam()) 
                    return true;
                else
                    return false;
            case all:
                return true;
            default:
                return false;
        } 
     };

  
     public boolean isColliding(AbstractEntity aE) {
       if(!isCollideableWith(aE)) return false;
       
       if(locX+getRadiusX()>(aE.getLocX()-aE.getRadiusX()) && 
               locX-getRadiusX()<(aE.getLocX()+aE.getRadiusX()) &&
               locY+getRadiusY()>(aE.getLocY()-aE.getRadiusY()) && 
               locY-getRadiusY()<(aE.getLocY()+aE.getRadiusY())) return true;
       
       return false;
     };

    
    /*
     * Abstract methods
     */
    
    public abstract void update(World w);

    
    /**
     * @return the locX
     */
    public int getLocX() {
        return locX;
    }

    /**
     * @param locX the locX to set
     */
    public void setLocX(int locX) {
        this.locX = locX;
    }

    /**
     * @return the locY
     */
    public int getLocY() {
        return locY;
    }

    /**
     * @param locY the locY to set
     */
    public void setLocY(int locY) {
        this.locY = locY;
    }

    /**
     * @return the facing
     */
    public Directions getFacing() {
        return facing;
    }

    /**
     * @param facing the facing to set
     */
    public void setFacing(Directions facing) {
        this.facing = facing;
    }

    /**
     * @return the velX
     */
    public float getVelX() {
        return velX;
    }

    /**
     * @param velX the velX to set
     */
    public void setVelX(float velX) {
        this.velX = velX;
    }

    /**
     * @return the velY
     */
    public float getVelY() {
        return velY;
    }

    /**
     * @param velY the velY to set
     */
    public void setVelY(float velY) {
        this.velY = velY;
    }

    /**
     * @return the speed
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * @return the collideType
     */
    @Override
    public CollideType getCollideType() {
        return collideType;
    }

    /**
     * @param collideType the collideType to set
     */
    @Override
    public void setCollideType(CollideType collideType) {
        this.collideType = collideType;
    }

    /**
     * @return the radiusX
     */
    public int getRadiusX() {
        return radiusX;
    }

    /**
     * @param radiusX the radiusX to set
     */
    public void setRadiusX(int radiusX) {
        this.radiusX = radiusX;
    }

    /**
     * @return the radiusY
     */
    public int getRadiusY() {
        return radiusY;
    }

    /**
     * @param radiusY the radiusY to set
     */
    public void setRadiusY(int radiusY) {
        this.radiusY = radiusY;
    }

    /**
     * @return the team
     */
    @Override
    public int getTeam() {
        return team;
    }

    /**
     * @param team the team to set
     */
    public void setTeam(int team) {
        this.team = team;
    }

    /**
     * @return the passableCollision
     */
    @Override
    public boolean isPassableCollision() {
        return passableCollision;
    }

    /**
     * @param passableCollision the passableCollision to set
     */
    public void setPassableCollision(boolean passableCollision) {
        this.passableCollision = passableCollision;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }
    
    
}
