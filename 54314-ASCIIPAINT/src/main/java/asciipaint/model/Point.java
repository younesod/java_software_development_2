package asciipaint.model;

/**
 *
 * @author younes
 */
public class Point {

    private double x;
    private double y;

    /**
     * Constructor of Point
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Simple getter of x
     *
     * @return
     */
    public double getX() {
        return this.x;
    }

    /**
     * Simple getter of y
     *
     * @return
     */
    public double getY() {
        return this.y;
    }

    /**
     * Method that moves a point
     *
     * @param dx
     * @param dy
     */
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * To String of Point
     *
     * @return
     */
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    /**
     * Method that calculates distance between 2 points
     *
     * @param other
     * @return
     */
    public double distanceTo(Point other) {
        return Math.sqrt(Math.pow(other.x - this.x, 2)
                + Math.pow(other.y - this.y, 2));
    }

    /**
     * Method define hashcode
     *
     * @return hashcode
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * Method that compares 2 object of Point
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Point other = (Point) obj;
        if (Double.doubleToLongBits(this.x)
                != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y)
                != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

}
