package lab8;

public class Punkt2D {
    protected float x, y;

    public Punkt2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float[] getCoordinates() {
        return new float[]{x, y};
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public String toString(){
        return x + " " + y;
    }
}
