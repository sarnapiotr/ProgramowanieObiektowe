public class Pozycja implements IOperacjaFinansowa {
    private String nazwaTowaru;
    private int ileSztuk;
    private double cena;

    public Pozycja(String nazwaTowaru, int ileSztuk, double cena) {
        this.nazwaTowaru = nazwaTowaru;
        this.ileSztuk = ileSztuk;
        this.cena = cena;
    }

    @Override
    public double obliczWartosc() {
        return ileSztuk * cena;
    }

    @Override
    public String toString() {
        return String.format("%-15s | Cena: %6.2f | Sztuk: %2d | Wartość: %7.2f",
                nazwaTowaru, cena, ileSztuk, obliczWartosc());
    }
}
