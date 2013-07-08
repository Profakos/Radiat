/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Akos
 */
public class Board extends JPanel implements ActionListener{
    
         
    public Viewport v;
    public Timer timer;
    
    private World world;
    
        
    /*
    * Constructor
    */
         
    public Board(int width, int height) {
        ImageRegistry.getInstance();
             
        
        v = new Viewport(width, height, 1000, 1000); 
        
        addKeyListener(new BoardKeyAdapter());
        addMouseListener(new BoardMouseAdapter());
        
        timer = new Timer(40, this);  
        
        this.setBackground(Color.darkGray);
    }
    
    public void start(){ 
        if(world!=null)
            timer.start();
    }
        
    /*
     *  Overrides
     */
    @Override
    public void actionPerformed(ActionEvent e) { //main game loop
        
        if(world!=null)
            Update();
        repaint();
    }
    
        @Override
    public void paintComponent(Graphics g) { 

        super.paintComponent(g);
        doDrawing(g);
        g.dispose();
    }
        
    /*
     * Painting
     */
        
    void scaleVport() { 
        v.setWorldWidth(world.getWorldWidth());
        v.setWorldHeight(world.getWorldHeight());
    }
    
    public void doDrawing(Graphics g){
          
        v.centerOn(world.player.getLocX(), world.player.getLocY());
        g.clearRect(0, 0, WIDTH, HEIGHT);
        
        g.translate(-v.getOffX(), -v.getOffY());
        world.draw(g, v);
        g.translate(v.getOffX(), v.getOffY());
    }

    /*
     * Main game loop
     */
    private void Update() {
        
        world.update();
}
    

    /**
     * @return the world
     */
    public World getWorld() {
        return world;
    }

    /**
     * @param world the world to set
     */
    public void setWorld(World world) {
        this.world = world;
    }

   

    
    /*
     * Handling of events
     */
    
    public class BoardKeyAdapter extends KeyAdapter {
        
        @Override
        public void keyPressed(KeyEvent e) {
            
            int keycode = e.getKeyCode();
            
            world.moveKeys(keycode, true); 
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int keycode = e.getKeyCode();
            world.moveKeys(keycode, false); 
        }
    }
    
    public class BoardMouseAdapter extends MouseAdapter {
  
        @Override
        public void mousePressed(MouseEvent e) {
           world.mouseClick(e);
        } 
        
    }
}
