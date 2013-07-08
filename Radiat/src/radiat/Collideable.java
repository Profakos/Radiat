/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

/**
 *
 * @author Akos
 */
public interface Collideable {
    
    /*
     * @return if object can be walked over even during collision
     * If it can't, it is a wall, if it can, it could be a field on the ground, etc.
     */
    public boolean isPassableCollision();
    
    /*
     * @return if c can be hit by this
     */
    public boolean isCollideableWith(Collideable c); 
    
    /**
     * @return the collideType
     */
    public CollideType getCollideType(); 

    /**
     * @param collideType the collideType to set
     */
    public void setCollideType(CollideType collideType);
    
    /*
     * @return the team
     */
    public int getTeam();
 
}
