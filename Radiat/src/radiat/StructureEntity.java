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

    public StructureEntity(int locX, int locY, int team, int radX, int radY, boolean collide, 
            String name) {
        super(locX, locY, team);
        
      setSpeed(0);
      setRadiusX(radX);
      setRadiusY(radY);
      setCollideType(CollideType.all);
      setPassableCollision(collide);
      setImage(name);
    }
    
    @Override
    public void update(World w) {
         
    }
    
     
}
