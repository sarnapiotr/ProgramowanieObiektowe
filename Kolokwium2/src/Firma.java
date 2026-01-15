import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Firma {
    private String nazwa;
    private double kapital;
    private List<Pracownik> pracownicy = new ArrayList<>();
    private List<String> rejestrKadr = new ArrayList<>();

    // Klasa wewnętrzna
    private class KadryRejestr {
        void log(String akcja, String dane) {
            rejestrKadr.add(LocalDate.now() + " - " + akcja + ": " + dane);
        }
    }
    private KadryRejestr kadry = new KadryRejestr();

    public Firma(String nazwa, double kapital) { this.nazwa = nazwa; this.kapital = kapital; }

    public void zatrudnij(Pracownik p) {
        pracownicy.add(p);
        kadry.log("Zatrudnienie", p.toString());
    }

    public void zwolnij(Pracownik p) {
        if(pracownicy.remove(p)) kadry.log("Zwolnienie", p.toString());
    }

    public String danePracownika(Pracownik p) { return p.toString(); }

    public void wyswietlRejestr() { rejestrKadr.forEach(System.out::println); }

    public void wyplacWynagrodzenie(LocalDate data) {
        for (Pracownik p : pracownicy) {
            double kwota = p.obliczPensje();
            p.dodajRMUA(data, kwota);
        }
    }

    public void wydrukujTransakcje(LocalDate data) {
        System.out.println("Wypłaty z dnia " + data + ":");
        for (Pracownik p : pracownicy) {
            for (DrukRMUA d : p.getArchiwumRMUA()) {
                if (d.getData().equals(data)) System.out.println(p.getNazwisko() + " - " + d.getBrutto());
            }
        }
    }

    @Override
    public String toString() {
        return "Firma: " + nazwa + " | Kapitał: " + kapital + " | Pracowników: " + pracownicy.size();
    }
}