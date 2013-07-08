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

    public StructureEntity(int locX, int locY, int team) {
        super(locX, locY, team);
        
      setSpeed(0);
      setRadiusX(64);
      setRadiusY(64);
      setCollideType(CollideType.all);
      setPassableCollision(false);
      setImage("barricade");
    }
    
    @Override
    public void update(World w) {
         
    }
    
     
}
