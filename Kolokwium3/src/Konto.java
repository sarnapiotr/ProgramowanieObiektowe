import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Konto {
    private String numer, wlasciciel, typ;
    protected double saldo;
    private List<String> archiwum = new ArrayList<>();

    public Konto(String numer, String wlasciciel, String typ, double saldo) {
        this.numer = numer;
        this.wlasciciel = wlasciciel;
        this.typ = typ;
        this.saldo = saldo;
    }

    public abstract boolean moznaWyplacic(double kwota);

    public void wplac(double kwota) {
        saldo += kwota;
        archiwum.add(LocalDate.now() + ": Wpłata " + kwota);
    }

    public void wyplac(double kwota) {
        saldo -= kwota;
        archiwum.add(LocalDate.now() + ": Wypłata " + kwota);
    }

    public void przelew(Konto cel, double kwota) {
        if(moznaWyplacic(kwota)) {
            this.wyplac(kwota);
            cel.wplac(kwota);
            archiwum.add(LocalDate.now() + " : Przelew do " + cel.numer + " kwota " + kwota);
        }
    }

    public void wyswietlArchiwum() {
        System.out.println("Archiwum konta " + numer + ": " + archiwum);
    }

    @Override
    public String toString(){
        return typ + " numer: " + numer + ", Właściciel: " + wlasciciel + ", Saldo: " + saldo;
    }
}
