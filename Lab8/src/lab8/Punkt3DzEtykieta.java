package lab8;

public class Punkt3DzEtykieta extends Punkt3D{
    private String etykieta;

    public Punkt3DzEtykieta(float x, float y, float z, String etykieta) {
        super(x, y, z);
        this.etykieta = etykieta;
    }

    public void setEtykieta(String etykieta) {
        this.etykieta = etykieta;
    }

    @Override
    public String toString(){
        return super.toString() + " " + etykieta;
    }
}
