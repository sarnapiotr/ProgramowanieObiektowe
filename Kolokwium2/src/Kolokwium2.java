import java.time.LocalDate;

public class Kolokwium2 {
    public static void main(String[] args) {
        Firma f = new Firma("Aptiv", 1000000);

        // Polimorfizm
        Pracownik p1 = new PracownikEtatowy("Jan", "Kowalski", "Kraków", "123", "Programista", 8000);

        f.zatrudnij(p1);
        f.wyplacWynagrodzenie(LocalDate.of(2026, 1, 15));

        // Klasa anonimowa
        IOperacja raport = new IOperacja() {
            @Override
            public void wykonaj() {
                System.out.println(f.toString());
                p1.pokazRMUA();
            }
        };

        raport.wykonaj();
    }
}
