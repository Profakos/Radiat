/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Graphics;
import java.util.Random;

/**
 *
 * @author Akos
 */
public class StructureEntity extends AbstractEntity {

    private StructureType type;
    
    private String overlay0;
    private String overlay1;
    
    public StructureEntity(int locX, int locY, int team, int radX, int radY, boolean passable, 
            String name, StructureType type) {
        super(locX, locY, team);
      Random gen = new Random();
      
      setSpeed(0);
      setRadiusX(radX);
      setRadiusY(radY);
      setCollideType(CollideType.all);
      setPassableCollision(passable);
      setImage(name);
      
      this.type = type;
      
      overlay0 = "";
      overlay1 = "";
          
      if(this.type == StructureType.house) {
        setImage(name +  gen.nextInt(6));
        this.overlay0 = name + 1 + gen.nextInt(5);
        this.overlay1 = name + 1 + gen.nextInt(5);
        
      //  if(overlay0.equals(overlay1)) overlay1 = ""; //so we won't draw the same twice
      }
      
    }
    
    @Override
    public void draw(Graphics g) {
        super.draw(g);
        g.drawImage(ImageRegistry.getImage(overlay0), locX-getRadiusX(), locY-getRadiusY(), null);
        g.drawImage(ImageRegistry.getImage(overlay1), locX-getRadiusX(), locY-getRadiusY(), null);
    }
    
    @Override
    public void update(World w) {
         
    }

    /**
     * @return the type
     */
    public StructureType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(StructureType type) {
        this.type = type;
    }

   
     
}
