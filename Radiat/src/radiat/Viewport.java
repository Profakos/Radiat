/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;


    /**
 *
 * @author Akos
 */
public class Viewport {
    private int offX; //offset from the left side of the board
    private int offY; //offset from the top of the board
    
    private int offXMax;
    private int offYMax;
    private int offXMin;
    private int offYMin;
    
    private int viewWidth;
    private int viewHeight;
    
    private int worldWidth;
    private int worldHeight;
    
    private boolean debug;
    
    public Viewport(int viewWidth, int viewHeight, int worldWidth, int worldHeight) {
        offX = 0;
        offY = 0;
        
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
        
        this.worldWidth = worldWidth;
        this.worldHeight = worldHeight;
        
        offXMax = worldWidth - viewWidth;
        offYMax = worldHeight - viewWidth;
        offXMin = 0;
        offYMin = 0;
        
        debug = false;
    }
    
    public void centerOn(int tx, int ty) {
         
       offX = tx - this.viewWidth/2;
       offY = ty - this.viewHeight/2;
       //TODO: Handle edges
       /*  
      if(offX<this.getViewWidth()/2)
           offX = 0;
       
       if(offX>this.getWorldWidth()-this.getViewWidth()/2)
           offX = this.getWorldWidth()-this.getViewWidth();
       
        if(offY<this.getViewHeight())
           offY = 0; 
       
       if(offY>this.getWorldHeight()-this.getViewHeight()/2)
           offY = this.getWorldHeight()-this.getViewHeight();
         */
    }

    /**
     * @return the offX
     */
    public int getOffX() {
        return offX;
    }

    /**
     * @param offX the offX to set
     */
    public void setOffX(int offX) {
        this.offX = offX;
    }

    /**
     * @return the offY
     */
    public int getOffY() {
        return offY;
    }

    /**
     * @param offY the offY to set
     */
    public void setOffY(int offY) {
        this.offY = offY;
    }

    /**
     * @return the offXMax
     */
    public int getOffXMax() {
        return offXMax;
    }

    /**
     * @param offXMax the offXMax to set
     */
    public void setOffXMax(int offXMax) {
        this.offXMax = offXMax;
    }

    /**
     * @return the offYMax
     */
    public int getOffYMax() {
        return offYMax;
    }

    /**
     * @param offYMax the offYMax to set
     */
    public void setOffYMax(int offYMax) {
        this.offYMax = offYMax;
    }

    /**
     * @return the offXMin
     */
    public int getOffXMin() {
        return offXMin;
    }

    /**
     * @param offXMin the offXMin to set
     */
    public void setOffXMin(int offXMin) {
        this.offXMin = offXMin;
    }

    /**
     * @return the offYMin
     */
    public int getOffYMin() {
        return offYMin;
    }

    /**
     * @param offYMin the offYMin to set
     */
    public void setOffYMin(int offYMin) {
        this.offYMin = offYMin;
    }
 
    /**
     * @return the debug
     */
    public boolean isDebug() {
        return debug;
    }

    /**
     * @param debug the debug to set
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
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
     * @return the viewWidth
     */
    public int getViewWidth() {
        return viewWidth;
    }

    /**
     * @param viewWidth the viewWidth to set
     */
    public void setViewWidth(int viewWidth) {
        this.viewWidth = viewWidth;
    }

    /**
     * @return the viewHeight
     */
    public int getViewHeight() {
        return viewHeight;
    }

    /**
     * @param viewHeight the viewHeight to set
     */
    public void setViewHeight(int viewHeight) {
        this.viewHeight = viewHeight;
    }
    
    
 
}
