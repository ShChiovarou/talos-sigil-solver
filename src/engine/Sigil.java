package engine;

public enum Sigil {
    I(new Point[][] {
        {new Point(0,0), new Point(0,1), new Point(0,2), new Point(0,3)},
        {new Point(0,0), new Point(1,0), new Point(2,0), new Point(3,0)}
    }),
    
    J(new Point[][] {
        {new Point(0,1), new Point(1,1), new Point(2,1), new Point(2,0)},
        {new Point(0,0), new Point(1,0), new Point(1,1), new Point(1,2)},
        {new Point(0,0), new Point(0,1), new Point(1,0), new Point(2,0)},
        {new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,2)}
    }),

    L(new Point[][] {
        {new Point(0,0), new Point(1,0), new Point(2,0), new Point(2,1)},
        {new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,0)},
        {new Point(0,0), new Point(0,1), new Point(1,1), new Point(2,1)},
        {new Point(0,2), new Point(1,0), new Point(1,1), new Point(1,2)}
    }),

    S(new Point[][] {
        {new Point(0,1), new Point(0,2), new Point(1,0), new Point(1,1)},
        {new Point(0,0), new Point(1,0), new Point(1,1), new Point(2,1)}
    }),

    Z(new Point[][] {
        {new Point(0,0), new Point(0,1), new Point(1,1), new Point(1,2)},
        {new Point(0,1), new Point(1,1), new Point(1,0), new Point(2,0)}
    }),

    O(new Point[][] {
        {new Point(0,0), new Point(0,1), new Point(1,0), new Point(1,1)}
    }),

    T(new Point[][] {
        {new Point(0,0), new Point(0,1), new Point(0,2), new Point(1,1)},
        {new Point(0,1), new Point(1,0), new Point(1,1), new Point(2,1)},
        {new Point(1,0), new Point(1,1), new Point(1,2), new Point(0,1)},
        {new Point(0,0), new Point(1,0), new Point(2,0), new Point(1,1)}
    });

    public final Point[][] rotations;

    Sigil(Point[][] rotations) {
        this.rotations = rotations;
    }
}