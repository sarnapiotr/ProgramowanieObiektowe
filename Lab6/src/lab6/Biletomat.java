package lab6;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Biletomat {
    private Map<String, Double> cennik;
    private String lokalizacja;
    private List<Bilet> transakcje; //Kompozycja - klasa Biletomat zawiera klasę Bilet

    public Biletomat(String lokalizacja) {
        this.lokalizacja = lokalizacja;
        this.cennik = new HashMap<>();
        this.transakcje = new ArrayList<>();

        cennik.put("20 minutowy N", 4.0);
        cennik.put("60 minutowy N", 6.0);
        cennik.put("20 minutowy U", 2.0);
        cennik.put("60 minutowy U", 3.0);
    }

    public void kupBilet(String rodzaj, int liczba, Pieniadz pieniadz) {
        double cenaJednego = cennik.get(rodzaj);
        double suma = cenaJednego * liczba;

        if (!pieniadz.zaplac(suma)) {
            System.out.println("Niewystarczające środki do zakupu");
            return;
        }

        if (pieniadz instanceof Gotowka) {
            double reszta = pieniadz.getKwota() - suma;
            System.out.println("Zakupiono " + liczba + " " + rodzaj + " Reszta: " + reszta + " PLN");
        } else {
            System.out.println("Zakupiono " + liczba + " " + rodzaj);
        }

        for (int i = 0; i < liczba; i++) {
            transakcje.add(new Bilet(rodzaj, cenaJednego));
        }
    }

    @Override
    public String toString() {
        String wynik = "Biletomat - " + lokalizacja + "\n";

        for (Bilet b : transakcje) {
            wynik += b.toString() + "\n";
        }

        return wynik;
    }

    public void wydrukujTransakcje(LocalDate data) {
        System.out.println("Transakcje z dnia: " + data);

        for (Bilet b : transakcje) {
            if (b.getDataWydania().toLocalDate().equals(data)) {
                System.out.println(b.toString());
            }
        }
    }
}