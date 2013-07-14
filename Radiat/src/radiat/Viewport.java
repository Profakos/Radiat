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
    
    private static Viewport instance = null;
    /*
      * Singleton
      */
     
        public static Viewport getInstance() {
      if(instance == null) {
         instance = new Viewport();
      }
      return instance;
   }
    
    public static int offX; //offset from the left side of the board
    public static int offY; //offset from the top of the board
    
    public static int offXMax;
    public static int offYMax;
    public static int offXMin;
    public static int offYMin;
    
    public static int viewWidth;
    public static int viewHeight;
    
    public static int worldWidth;
    public static int worldHeight;
    
    public static boolean debug;
    
    public Viewport() {
        offX = 0;
        offY = 0; 
        
        debug = false;
    }

    public static void initView(int viewWidth, int viewHeight, int worldWidth, int worldHeight) {
        Viewport.viewWidth = viewWidth;
        Viewport.viewHeight = viewHeight;
        
        Viewport.worldWidth = worldWidth;
        Viewport.worldHeight = worldHeight;
        
        offXMax = worldWidth - viewWidth;
        offYMax = worldHeight - viewWidth;
        offXMin = 0;
        offYMin = 0;
    }
    
    
    public static boolean isOnScreen(AbstractEntity aE) {
          
       if(offX+viewWidth>(aE.getLocX()-aE.getRadiusX()) && 
               offX-viewWidth<(aE.getLocX()+aE.getRadiusX()) &&
               offY+viewHeight>(aE.getLocY()-aE.getRadiusY()) && 
               offY-viewHeight<(aE.getLocY()+aE.getRadiusY())) return true;
       
       return false;
   };  
    
    public static void centerOn(int tx, int ty) {
         
       offX = tx - Viewport.viewWidth/2;
       offY = ty - Viewport.viewHeight/2;
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
 
    
    
 
}
