import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Ukrycie implementacji
public abstract class Pracownik {
    private String imie, nazwisko, adres, pesel, etat;
    private List<DrukRMUA> archiwumRMUA = new ArrayList<>();

    public Pracownik(String imie, String nazwisko, String adres, String pesel, String etat) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.adres = adres;
        this.pesel = pesel;
        this.etat = etat;
    }

    public String getNazwisko() { return nazwisko; }
    public List<DrukRMUA> getArchiwumRMUA() { return archiwumRMUA; }

    public abstract double obliczPensje();

    public void dodajRMUA(LocalDate data, double kwota) {
        archiwumRMUA.add(new DrukRMUA(data, kwota));
    }

    public void pokazRMUA() {
        double suma = 0;
        for (DrukRMUA d : archiwumRMUA) {
            d.wyswietl();
            suma += d.getBrutto();
        }
        System.out.println("Suma wynagrodzeń: " + suma);
    }

    @Override
    public String toString() { return imie + " " + nazwisko + " (" + etat + ")"; }
}
