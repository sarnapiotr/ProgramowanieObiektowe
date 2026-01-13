package lab8;

public class Punkt3D extends Punkt2D{
    protected float z;

    public Punkt3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    @Override
    public float[] getCoordinates() {
        return new float[]{x, y, z};
    }

    public void setZ(float z) {
        this.z = z;
    }

    @Override
    public String toString(){
        return super.toString() + " "  + z;
    }
}
