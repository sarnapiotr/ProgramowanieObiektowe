import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paragon {
    private List<Pozycja> pozycje =  new ArrayList<>();;
    private LocalDate data;
    private Kasa kasa;

    public Paragon(Kasa kasa) {
        this.data = LocalDate.now();
        this.kasa = kasa;
    }

    public void dodajPozycje(Pozycja p) {
        pozycje.add(p);
    }

    public double obliczWartosc() {
        double suma = 0;
        for(Pozycja p : pozycje) {
            suma += p.obliczWartosc();
        }
        return suma;
    }

    @Override
    public String toString() {
        String out = "";
        for(Pozycja p : pozycje) {
            out += pozycje.toString();
        }
        return out;
    }
}
