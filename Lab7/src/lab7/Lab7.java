package lab7;

class Kwadrat implements Figura {
    private float a;

    public Kwadrat(float a) {
        this.a = a;
    }

    @Override
    public float obliczObwod() {
        return 4 * a;
    }

    @Override
    public float obliczPowierzchnie() {
        return a * a;
    }
}

class Trojkat implements Figura{
    private float a, b, c, h;

    public Trojkat(float a, float b, float c, float h) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.h = h;
    }

    @Override
    public float obliczObwod() {
        return a + b + c;
    }

    @Override
    public float obliczPowierzchnie() {
        return (float) 1/2 * a * h;
    }
}

class Trapez implements Figura{
    private float a, b, c, d, h;

    public Trapez(float b, float c, float d, float h, float a) {
        this.b = b;
        this.c = c;
        this.d = d;
        this.h = h;
        this.a = a;
    }

    @Override
    public float obliczObwod() {
        return a + b + c + d;
    }

    @Override
    public float obliczPowierzchnie() {
        return (float) 1/2 * (a + b) * h;
    }
}

public class Lab7 {
    public static void main(String[] args) {
        Kwadrat kwadrat = new Kwadrat(2);
        System.out.println(kwadrat.obliczObwod());
        System.out.println(kwadrat.obliczPowierzchnie());

        Trojkat trojkat = new Trojkat(1, 2, 3, 4);
        System.out.println(trojkat.obliczObwod());
        System.out.println(trojkat.obliczPowierzchnie());

        Trapez trapez = new Trapez(1, 2, 3, 4, 5);
        System.out.println(trapez.obliczObwod());
        System.out.println(trapez.obliczPowierzchnie());
    }
}
