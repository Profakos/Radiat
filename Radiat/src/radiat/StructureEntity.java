/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

/**
 *
 * @author Akos
 */
public class StructureEntity extends AbstractEntity {

    private StructureType type;
    
    public StructureEntity(int locX, int locY, int team, int radX, int radY, boolean collide, 
            String name, StructureType type) {
        super(locX, locY, team);
        
      setSpeed(0);
      setRadiusX(radX);
      setRadiusY(radY);
      setCollideType(CollideType.all);
      setPassableCollision(collide);
      setImage(name);
      
      this.type = type;
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
