public class PracownikEtatowy extends Pracownik{
    private double stawka;

    public PracownikEtatowy(String imie, String nazwisko, String adres, String pesel, String etat, double stawka) {
        super(imie, nazwisko, adres, pesel, etat);
        this.stawka = stawka;
    }

    @Override
    public double obliczPensje() { return stawka; }
}
