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
import java.util.Random;

/**
 *
 * @author Akos
 */
public class World implements Drawable{
    
    Random gen;
 
    public CreatureEntity player; 
     
    private List<StructureEntity> structureList;
    private List<BulletEntity> bulletList;
    
    private int worldWidth;
    private int worldHeight;
    
    public World(){ 
        
        gen = new Random();
        
        worldWidth = 5120;
        worldHeight = 5120;
        
       player = new CreatureEntity(100, 100, 0);   
       player.setImage("playerFront"); 
       
       bulletList = new ArrayList<>();
       structureList = new ArrayList<>(); 
       
       createCity();
       
       player.setLocX(structureList.get(0).getLocX());
       player.setLocY(structureList.get(0).getLocY());
    }
    
    @Override
    public void draw(Graphics g) { 
        
         for(StructureEntity s : getStructureList()) {
             if(Viewport.isOnScreen(s))
                s.draw(g); 
            }
        
         if(Viewport.isOnScreen(player))
            player.draw(g); 
        
        for(BulletEntity b : getBulletList()) {
            if(Viewport.isOnScreen(b))
                b.draw(g); 
            }
        
    }

    void update() {
        player.update(this); 
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
    
     void mouseClick(MouseEvent e) {
        MouseEvent event = e;
        player.shoot(getBulletList(), e.getX()+Viewport.offX, e.getY()+Viewport.offY);
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

    private void createCity() {
        
        int cY = 80;
        int cX = 80;
        
        int tileSize = 64;
        
        List<Road> roadList = new ArrayList<>();
        
            int rX = cX/2;
            int rY = cY/2;
            int rL = gen.nextInt(3)+3;
            boolean isVert  = gen.nextBoolean(); 
             
            
            roadList.add(new Road(rX, rY, rL, isVert));
         
         
       if(!roadList.isEmpty()) {
           for(int i = 0; i<roadList.size(); i++) {
               Road roadTemp = roadList.get(i);
               if(roadTemp.isIsVertical())
                    for(int j = 0; j<roadTemp.getLength(); j++){
                      this.structureList.add(new StructureEntity(tileSize*roadTemp.getX(),
                              roadTemp.getY() + 4*tileSize*j, -1, tileSize*3/2, tileSize*2, true,
                              "roadVertical"));
                    }
               else
                   for(int j = 0; j<roadTemp.getLength(); j++){
                      this.structureList.add(new StructureEntity(tileSize*roadTemp.getX() + 4*tileSize*j,
                              roadTemp.getY(), -1, tileSize*2, tileSize*3/2, true,
                              "roadHorizontal"));
                    }
           }
           
       }
    }
}
