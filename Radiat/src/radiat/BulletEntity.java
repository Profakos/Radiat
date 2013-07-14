/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Akos
 */
public class BulletEntity extends AbstractEntity {
    
    private int lifetime;
    public double aimX;
    public double aimY;
    
    public BulletEntity(int locX, int locY, int team, int aimX, int aimY){
        super(locX, locY, team);
        
        
        float deltaX = (float)(aimX - locX);
        float deltaY = (float)(aimY - locY);
        float totalpath = (float)Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        
        if(totalpath!=0) {
            setVelX(deltaX/totalpath); 
            setVelY(deltaY/totalpath);
        }
        else {
            setVelX(0);
            setVelY(0);
        }
        
        this.aimX = aimX;
        this.aimY = aimY;
        
        this.lifetime = 30;
        
        setSpeed(15);
        setRadiusX(4);
        setRadiusY(4);
        setCollideType(CollideType.other);
        
        setImage("bullet");

    } 
    
    @Override
    public void draw(Graphics g){
         
        if(this.lifetime<=0)
            return;
        
        super.draw(g);
        
        if(!Viewport.debug) return;
        g.setColor(Color.red);
        g.drawRect(this.locX-getRadiusX(), this.locY-getRadiusY(), 
                2*getRadiusX(), 2*getRadiusY());
    }

    @Override
    public void update(World w) { 
        
        locX += this.getSpeed()*getVelX();
        locY += this.getSpeed()*getVelY();
  
         for(StructureEntity s : w.getStructureList()) {
            
             if(isColliding(s)) { 
            if(!s.isPassableCollision())
            setLifetime(0);
        }
            }
        
         
        setLifetime(getLifetime() - 1);
    }

    /**
     * @return the lifetime
     */
    public int getLifetime() {
        return lifetime;
    }

    /**
     * @param lifetime the lifetime to set
     */
    public void setLifetime(int lifetime) {
        this.lifetime = lifetime;
    }
}
