/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

import javax.swing.JFrame;

/**
 *
 * @author Akos
 */
public class GameFrame extends JFrame{
    
    private Board board;
    private World world;
    
    public GameFrame(){
        initUI();
        initGame(); 
    }

    private void initGame() {
        
        try {
        world = new World();
        }catch(Exception e){}
        board.setWorld(world); 
        Viewport.initView(768, 640, world.getWorldWidth(), world.getWorldHeight());
        
        board.scaleVport();
        
        board.start();
    }
    
    private void initUI(){
       
        setBoard(new Board(768, 640));
        this.add(getBoard());
        this.setFocusable(false);
        getBoard().setFocusable(true); 
        
        
       setTitle("Radiat");
       setSize(768, 640);
       setResizable(false);
       setLocationRelativeTo(null);
       setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @param board the board to set
     */
    public void setBoard(Board board) {
        this.board = board;
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
}
