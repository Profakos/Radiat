/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package radiat;

/**
 *
 * @author Akos
 */
public class Road {
    private int x;
    private int y;
    private int length;
    private boolean isVertical;
    
    
    public Road(String s) { 
        String[] split = s.split(" ");
        this.x = Integer.parseInt(split[0]);
        this.y = Integer.parseInt(split[1]);
        this.length = Integer.parseInt(split[2]);
        this.isVertical = Boolean.parseBoolean(split[3]);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the length
     */
    public int getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * @return the isVertical
     */
    public boolean isIsVertical() {
        return isVertical;
    }

    /**
     * @param isVertical the isVertical to set
     */
    public void setIsVertical(boolean isVertical) {
        this.isVertical = isVertical;
    }
}
