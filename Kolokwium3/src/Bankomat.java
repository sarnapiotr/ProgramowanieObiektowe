import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bankomat implements IBankomat {
    private String lokalizacja, nazwaBanku;
    private List<Log> transakcje = new ArrayList<>();
    private Map<Integer, Integer> gotowka = new HashMap<>();

    private class Log {
        LocalDate data; String opis;
        Log(String o) { this.data = LocalDate.now(); this.opis = o; }

        @Override
        public String toString() { return data + " | " + opis; }
    }

    public Bankomat(String lokalizacja, String nazwaBanku) {
        this.lokalizacja = lokalizacja; this.nazwaBanku = nazwaBanku;
        gotowka.put(100, 10); gotowka.put(50, 10); gotowka.put(20, 0);
    }

    @Override
    public void potwierdz(String tresc) { System.out.println("[POTWIERDZENIE]: " + tresc); }

    public void obsluga(Karta karta, double kwota, boolean czyWyplata, String bankKarty) {
        Konto k = karta.konto;
        double prowizja = (!bankKarty.equals(nazwaBanku)) ? Math.max(10, kwota * 0.05) : 0;

        if (czyWyplata) {
            if (kwota == 220 && gotowka.get(20) <= 0) {
                System.out.println("Błąd: Brak banknotów 20zł w bankomacie!");
                return;
            }

            if (k.moznaWyplacic(kwota + prowizja)) {
                k.wyplac(kwota + prowizja);
                transakcje.add(new Log("Wypłata " + kwota + " (Prowizja: " + prowizja + ")"));
                potwierdz("Wypłacono " + kwota + " w " + lokalizacja);
            } else System.out.println("Błąd: Brak środków!");
        } else {
            k.wplac(kwota);
            transakcje.add(new Log("Wpłata " + kwota));
            potwierdz("Wpłacono " + kwota);
        }
    }

    public void wydrukujTransakcje(LocalDate date) {
        transakcje.stream().filter(t -> t.data.equals(date)).forEach(System.out::println);
    }

    public void resetuj(String kod) {
        if (!"999".equals(kod)) return;
        new Runnable() {
            public void run() {
                System.out.println("Raport przed resetem: " + Bankomat.this.transakcje);
                transakcje.clear();
                System.out.println("Pamięć zresetowana.");
            }
        }.run();
    }

    @Override
    public String toString() { return "Bankomat " + nazwaBanku + " " + lokalizacja + " | Logi: " + transakcje; }
}