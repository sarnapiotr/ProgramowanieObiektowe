package lab6;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Biletomat biletomat = new Biletomat("Politechnika");

        biletomat.kupBilet("20 minutowy N", 2, new Gotowka(20));
        biletomat.kupBilet("60 minutowy U", 1, new Karta(10));
        biletomat.kupBilet("60 minutowy N", 3, new Gotowka(50));

        System.out.println(biletomat);

        biletomat.wydrukujTransakcje(LocalDate.now());
    }
}