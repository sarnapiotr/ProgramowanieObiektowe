import java.util.ArrayList;
import java.util.List;

public class Kasa {
    private String nip, nazwa, adres, nrUrzadzenia;
    private List<Paragon> rejestrParagonow = new ArrayList<>();

    public Kasa(String nip, String nazwa, String adres, String nrUrzadzenia) {
        this.nip = nip;
        this.nazwa = nazwa;
        this.adres = adres;
        this.nrUrzadzenia = nrUrzadzenia;
    }

    private class Raport {
        void drukuj() {
            double sumaDnia = 0;
            for (Paragon p : rejestrParagonow) sumaDnia += p.obliczWartosc();
            System.out.println("RAPORT");
            System.out.println("Liczba transakcji: " + rejestrParagonow.size());
            System.out.println("Suma całkowita: " + sumaDnia + " PLN");
        }
    }

    public void zarejestrujParagon(Paragon p) {
        rejestrParagonow.add(p);
    }

    public void generujRaport() {
        new Raport().drukuj();
    }

    public String getNip() {
        return nip;
    }

    public String getNazwa() {
        return nazwa;
    }

    public String getAdres() {
        return adres;
    }

    public String getNrUrzadzenia() {
        return nrUrzadzenia;
    }

    public void wydajReszte(double doZaplaty, double wplacone) {
        IOperacjaFinansowa resztaCalc = new IOperacjaFinansowa() {
            @Override
            public double obliczWartosc() { return wplacone - doZaplaty; }
        };
        System.out.printf("Do wydania: %.2f PLN\n", resztaCalc.obliczWartosc());
    }
}
