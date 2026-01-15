public class PozycjaPromocyjna extends Pozycja {
    private double rabat;

    public PozycjaPromocyjna(String nazwaTowaru, int ileSztuk, double cena, double rabat) {
        super(nazwaTowaru, ileSztuk, cena);
        this.rabat = rabat;
    }

    @Override
    public double obliczWartosc() {
        return super.obliczWartosc() * (1 - rabat);
    }

    @Override
    public String toString() {
        return super.toString() + " Rabat";
    }
}
