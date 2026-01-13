package lab6;

abstract class Pieniadz {
    protected double kwota;

    public Pieniadz(double kwota) {
        this.kwota = kwota;
    }

    public abstract boolean zaplac(double cena);

    public double getKwota() {
        return kwota;
    }

    @Override
    public abstract String toString();
}