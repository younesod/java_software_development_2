package asciipaint.model;

/**
 *
 * @author younes
 */
public interface Shape {

    /**
     * Signature method move
     *
     * @param dx
     * @param dy
     */
    void move(double dx, double dy);

    /**
     * Signature method is Inside check if a point is inside the shape
     *
     * @param p
     * @return
     */
    boolean isInside(Point p);

    /**
     * signature method getColor get the color of the shape
     *
     * @return
     */
    char getColor();
}
