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
     
    private List<StructureEntity> structureList;
    private List<BulletEntity> bulletList;
    
    private int worldWidth;
    private int worldHeight;
    
    public World(){ 
        
        worldWidth = 10000;
        worldHeight = 3000;
        
        player = new CreatureEntity(100, 100, 0); 
        beast = new CreatureEntity(600, 400, 1);
        friend = new CreatureEntity(600, 200, 0);  
     
        
       player.setImage("playerFront");
       friend.setImage("civilFront");
       beast.setImage("HallFront");
       beast.setRadiusX(44);
       beast.setRadiusY(44);
       
       bulletList = new ArrayList<>();
       structureList = new ArrayList<>();
       structureList.add(new StructureEntity(300, 100 ,-1));
       structureList.add(new StructureEntity(556, 100 ,-1));
       structureList.add(new StructureEntity(1012, 100 ,-1));
       structureList.add(new StructureEntity(300, 556 ,-1));
       structureList.add(new StructureEntity(556, 556 ,-1)); 
       structureList.add(new StructureEntity(1012, 556 ,-1));
    }
    
    @Override
    public void draw(Graphics g, Viewport v) {
         
        
        
         for(StructureEntity s : getStructureList()) {
             if(v.isOnScreen(s))
                s.draw(g, v); 
            }
        
         if(v.isOnScreen(player))
            player.draw(g, v);
        
         if(v.isOnScreen(beast))
            beast.draw(g,v); 
         
         if(v.isOnScreen(friend))  
            friend.draw(g,v);
        
        for(BulletEntity b : getBulletList()) {
            if(v.isOnScreen(b))
                b.draw(g, v); 
            }
        
    }

    void update() {
        player.update(this);
        beast.update(this);
        friend.update(this);
        if(!bulletList.isEmpty()) {
            for(BulletEntity b : getBulletList()) {
                b.update(this); 
            }
        }
        cleanUp();
    }

    private void cleanUp() {
        Iterator<BulletEntity> iter = getBulletList().iterator();
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
    
     void mouseClick(MouseEvent e, Viewport v) {
        MouseEvent event = e;
        player.shoot(getBulletList(), e.getX()+v.getOffX(), e.getY()+v.getOffY());
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

    /**
     * @return the structureList
     */
    public List<StructureEntity> getStructureList() {
        return structureList;
    }

    /**
     * @param structureList the structureList to set
     */
    public void setStructureList(List<StructureEntity> structureList) {
        this.structureList = structureList;
    }

    /**
     * @return the bulletList
     */
    public List<BulletEntity> getBulletList() {
        return bulletList;
    }

    /**
     * @param bulletList the bulletList to set
     */
    public void setBulletList(List<BulletEntity> bulletList) {
        this.bulletList = bulletList;
    }
}
