import java.time.LocalDate;

public class Kolokwium {
    public static void main(String[] args) {
        Konto k1 = new KontoStandard("111", "Adam", 500);
        Konto k2 = new KontoStandard("222", "Ewa", 1000);
        Karta karta1 = new Karta("K-1", k1);
        Karta karta2 = new Karta("K-2", k2);

        Bankomat atm = new Bankomat("Centrum", "PKO");

        atm.obsluga(karta1, 220, true, "PKO");
        atm.obsluga(karta1, 100, true, "PKO");
        atm.obsluga(karta2, 100, true, "mBank");
        atm.obsluga(karta2, 200, false, "mBank");

        System.out.println("\n--- LISTA TRANSAKCJI ATM ---");
        System.out.println(atm.toString());

        System.out.println("\n--- TRANSAKCJE Z DATY ---");
        atm.wydrukujTransakcje(LocalDate.now());

        System.out.println("\n--- INFO O KONCIE I JEGO TRANSAKCJACH ---");
        System.out.println(k2);
        k2.wyswietlArchiwum();

        System.out.println("\n--- RESET PAMIĘCI ---");
        atm.resetuj("999");
    }
}