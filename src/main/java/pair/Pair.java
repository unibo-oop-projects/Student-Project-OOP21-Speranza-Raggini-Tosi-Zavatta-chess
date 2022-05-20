package pair;

import java.io.Serializable;

/**
 * 
 * A generic Pair.
 *
 * @param <X>
 * @param <Y>
 */
public class Pair<X, Y> implements Serializable {

    private static final long serialVersionUID = 8065526709210920611L;

    private final X x;
    private final Y y;

    /**
     * 
     * @param x
     * @param y
     */
    public Pair(final X x, final Y y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 
     * @return X
     */
    public X getX() {
        return this.x;
    }

    /**
     * 
     * @return Y
     */
    public Y getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "Pair [X=" + x + ", Y=" + y + "]";
    }
}
