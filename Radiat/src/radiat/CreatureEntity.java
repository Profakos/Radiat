/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author Akos
 */
public class CreatureEntity extends AbstractEntity{
    
    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    
    private boolean alive;
    
    public CreatureEntity(int locX, int locY, int team){
      super(locX, locY, team);
      
      isLeft = false;
      isRight = false;
      isUp = false;
      isDown = false; 
      
      setSpeed(10);
      setRadiusX(16);
      setRadiusY(32);
      setCollideType(CollideType.other);
      
      alive = true;
      
    } 
    
    @Override
    public void draw(Graphics g){
        
        if(!this.alive)
            return;
        
         super.draw(g);
        
         
         if(!Viewport.debug) return;
         
        if(getTeam()==0)
            g.setColor(Color.black);
        
        if(getTeam()==1)
            g.setColor(Color.blue);
        
        g.drawRect(this.locX-getRadiusX(), this.locY-getRadiusY(), 
                getRadiusX()*2, getRadiusY()*2);
        
        
                g.setColor(Color.red);
        switch(getFacing()) {
            case Up : 
                g.drawRect(this.locX-4, this.locY-getRadiusY()-8, 8, 8);
                break;
            case Left:
                g.drawRect(this.locX-getRadiusX()-8, this.locY-4, 8, 8);
                break;
            case Down:
                g.drawRect(this.locX-4, this.locY+getRadiusY(), 8, 8);
                break;
            case Right:
                g.drawRect(this.locX+getRadiusX(), this.locY-4, 8, 8);
                break;
        }
    }

    @Override
    public void update(World w) {
         
        setVelX(0);
        setVelY(0);
         
        if(isIsLeft())
            setVelX(getVelX() - 1);
        if(isIsRight())
            setVelX(getVelX() + 1);
        if(isIsUp())
            setVelY(getVelY() -1);
        if(isIsDown())
            setVelY(getVelY() + 1);  
        
        for(int i = 0; i<getSpeed(); i++)
            {
                locX += getVelX();
                locY += getVelY();
                
                 for(StructureEntity s : w.getStructureList()) {
                    if(isColliding(s) && !s.isPassableCollision())
                    { 
                        locX -= getVelX(); 
                        locY -= getVelY(); 
                    }
                 }
            }
        
    }
    
    
    public void shoot(List<BulletEntity> b, int targetX, int targetY) {
        if(b.size()>50) return;
        
         
        
        int dy = targetY - getLocY();
        int dx = targetX - getLocX();
        
        if(Math.abs(dx)>=Math.abs(dy))
            facing = dx > 0 ? Directions.Right : Directions.Left;
        else
            facing = dy > 0 ? Directions.Down : Directions.Up;
        
        /*
        if(e.getX()<getLocX()) facing = Directions.Left;
        if(e.getY()<getLocX()) facing = Directions.Up;
        
        if(e.getX()>getLocX()) facing = Directions.Right;
        if(e.getY()>getLocX()) facing = Directions.Down;
        */
        int offX = 0;
        int offY = 0;
        
        switch(facing) {
            case Up: 
                offY -= getRadiusY();
                break;
            case Left:
                offX -= getRadiusX();
                break;
            case Down:
                offY += getRadiusY();
                break;
            case Right:
                offX += getRadiusX();
                break;
        }
        
        b.add(new BulletEntity(getLocX()+offX, getLocY()+offY, getTeam(), targetX, targetY));
    }

    /**
     * @return the isLeft
     */
    public boolean isIsLeft() {
        return isLeft;
    }

    /**
     * @param isLeft the isLeft to set
     */
    public void setIsLeft(boolean isLeft) {
        this.isLeft = isLeft;
    }

    /**
     * @return the isRight
     */
    public boolean isIsRight() {
        return isRight;
    }

    /**
     * @param isRight the isRight to set
     */
    public void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    /**
     * @return the isUp
     */
    public boolean isIsUp() {
        return isUp;
    }

    /**
     * @param isUp the isUp to set
     */
    public void setIsUp(boolean isUp) {
        this.isUp = isUp;
    }

    /**
     * @return the isDown
     */
    public boolean isIsDown() {
        return isDown;
    }

    /**
     * @param isDown the isDown to set
     */
    public void setIsDown(boolean isDown) {
        this.isDown = isDown;
    }

    /**
     * @return the alive
     */
    public boolean isAlive() {
        return alive;
    }

    /**
     * @param alive the alive to set
     */
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    
    
     
}
