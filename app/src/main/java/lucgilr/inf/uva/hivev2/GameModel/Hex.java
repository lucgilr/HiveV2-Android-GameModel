package lucgilr.inf.uva.hivev2.GameModel;

/**
 * The original file can be found in:
 * https://github.com/omplanet/android-hexagonal-grids/blob/master/HexagonalGrids/app/src/main/java/net/omplanet/hexagonalgrids/model/Hex.java
 * Non-cube hex coordinates (q, r)
 * Lucía Gil Román - Adding d for a 3 dimension coordinate system.
 */
public class Hex {
    private int q; //column
    private int r; //row
    private int d; //3rd dimension

    /**
     * The initial values of the coordinates are (0,0,0)
     */
    public Hex(){
        this.q=0;
        this.r=0;
        this.d=0;
    }

    /**
     * Constructor for a 2 dimension coordinate.
     * @param q //Column
     * @param r //Row
     */
    public Hex (int q, int r) {
        this.q = q;
        this.r = r;
        this.d = 0;
    }

    /**
     * Constructor for a 3 dimension coordinate,
     * @param q //Column
     * @param r //Row
     * @param d //3rd dimension
     */
    public Hex (int q, int r, int d){
        this.q=q;
        this.r=r;
        this.d=d;
    }

    public Hex (float q, float r) {
        float x = q;
        float y = -q-r;
        float z = r;

        int rx = Math.round(x);
        int ry = Math.round(y);
        int rz = Math.round(z);

        float x_diff = Math.abs(rx - x);
        float y_diff = Math.abs(ry - y);
        float z_diff = Math.abs(rz - z);

        if (x_diff > y_diff && x_diff > z_diff)
            rx = -ry-rz;
        else if (y_diff > z_diff)
            ry = -rx-rz;

        this.q = rx;
        this.r = ry;
        this.d = 0;
    }

    public Cube toCube() {
        return new Cube(q, -q-r, r);
    }

    public Cube oddRHexToCube() {
        int x = q - (r - (r&1)) / 2;
        int z = r;
        int y = -x-z;

        return new Cube(x, -x-z, z);
    }

    public String toString() {
        return q + ":" + r + ":" + d;
    }

    public String toString2D(){
        return q + ":" + r;
    }

    public int getQ() {
        return q;
    }

    public void setQ(int q) {
        this.q = q;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }
}
