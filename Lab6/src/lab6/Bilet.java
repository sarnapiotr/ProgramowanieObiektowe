package lab6;

import java.time.LocalDateTime;

class Bilet {
    private String rodzaj;
    private double cena;
    private LocalDateTime dataWydania;

    public Bilet(String rodzaj, double cena) {
        this.rodzaj = rodzaj;
        this.cena = cena;
        this.dataWydania = LocalDateTime.now();
    }

    public double getCena() {
        return cena;
    }

    public LocalDateTime getDataWydania() {
        return dataWydania;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    @Override
    public String toString() {
        return dataWydania + " : " + rodzaj + " : " + cena + " PLN";
    }
}