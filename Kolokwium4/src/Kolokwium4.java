public class Kolokwium4 {
    public static void main(String[] args) {
        Kasa kasa = new Kasa("123-456-78", "Żabka", "ul. Warszawska 24", "URZ-9988");

        Paragon p1 = new Paragon(kasa);
        p1.dodajPozycje(new Pozycja("Chleb", 2, 4.50));
        p1.dodajPozycje(new PozycjaPromocyjna("Masło", 1, 8.00, 0.20)); // Polimorfizm - Rabat 20%

        Paragon p2 = new Paragon(kasa);
        p2.dodajPozycje(new Pozycja("Woda 1.5L", 6, 2.50));
        p2.dodajPozycje(new Pozycja("Czekolada", 1, 5.50));

        kasa.zarejestrujParagon(p1);
        kasa.zarejestrujParagon(p2);

        System.out.println(p1);
        kasa.wydajReszte(p1.obliczWartosc(), 20.00);

        System.out.println(p2);

        kasa.generujRaport();
    }
}
