/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Akos
 */
public class World implements Drawable{
 
    public CreatureEntity player;
    public CreatureEntity beast;
    public CreatureEntity friend;
    
    public StructureEntity house;
    
    public List<BulletEntity> bulletList;
    
    private int worldWidth;
    private int worldHeight;
    
    public World(){ 
        
        worldWidth = 10000;
        worldHeight = 3000;
        
        player = new CreatureEntity(100, 100, 0); 
        beast = new CreatureEntity(400, 400, 1);
        friend = new CreatureEntity(600, 200, 0); 
        house = new StructureEntity(300, 100 ,-1);
     
        
       player.setImage("playerFront");
       friend.setImage("civilFront");
       beast.setImage("HallFront");
       beast.setRadiusX(44);
       beast.setRadiusY(44);
       
       bulletList = new ArrayList<>();
    }
    
    @Override
    public void draw(Graphics g, Viewport v) {
         
        
        player.draw(g, v);
        beast.draw(g,v);
        friend.draw(g,v);
        
        house.draw(g,v);
        
        for(BulletEntity b : bulletList) {
                b.draw(g, v); 
            }
        
    }

    void update() {
        player.update(this);
        beast.update(this);
        friend.update(this);
        if(!bulletList.isEmpty()) {
            for(BulletEntity b : bulletList) {
                b.update(this); 
            }
        }
        cleanUp();
    }

    private void cleanUp() {
        Iterator<BulletEntity> iter = bulletList.iterator();
        while (iter.hasNext()) {
            if (iter.next().getLifetime() <= 0) {
                iter.remove();
            }
        }
    }

    void moveKeys(int keycode, boolean b) {
        
        if(player!=null)
        switch(keycode){
                case KeyEvent.VK_W: 
                    player.setIsUp(b);
                    if(b)
                        player.setFacing(Directions.Up);
                    break;
                case KeyEvent.VK_A: 
                    player.setIsLeft(b);
                    if(b)   
                        player.setFacing(Directions.Left);
                    break;
                case KeyEvent.VK_S: 
                    player.setIsDown(b);
                    if(b)
                        player.setFacing(Directions.Down);
                    break;
                case KeyEvent.VK_D: 
                    player.setIsRight(b);
                    if(b)
                        player.setFacing(Directions.Right);
                    break;   
            }       
    }
    
     void mouseClick(MouseEvent e) {
        MouseEvent event = e;
        player.shoot(bulletList, e);
    }

    /**
     * @return the worldWidth
     */
    public int getWorldWidth() {
        return worldWidth;
    }

    /**
     * @param worldWidth the worldWidth to set
     */
    public void setWorldWidth(int worldWidth) {
        this.worldWidth = worldWidth;
    }

    /**
     * @return the worldHeight
     */
    public int getWorldHeight() {
        return worldHeight;
    }

    /**
     * @param worldHeight the worldHeight to set
     */
    public void setWorldHeight(int worldHeight) {
        this.worldHeight = worldHeight;
    }
}
