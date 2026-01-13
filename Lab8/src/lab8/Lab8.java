package lab8;

public class Lab8 {
    public static void main(String[] args) {
        //Polimorfizm
        Punkt2D punkt2D = new Punkt2D(10, 20);
        Punkt2D punkt3D = new Punkt3D(10, 20, 30);
        Punkt2D punkt3DzEtykieta = new Punkt3DzEtykieta(10, 20, 30, "PK");

        System.out.println(punkt2D);
        System.out.println(punkt3D);
        System.out.println(punkt3DzEtykieta);
    }
}
