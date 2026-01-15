import java.util.ArrayList;
import java.util.List;

interface Narzedzie {
    void wyswietlStan();
}

abstract class SprzetBase implements Narzedzie {
    private String nazwa;
    private boolean czyDostepne;

    public SprzetBase(String nazwa){
        this.nazwa = nazwa;
        this.czyDostepne = true;
    }

    public String getNazwa() {
        return nazwa;
    }

    public boolean isCzyDostepne() {
        return czyDostepne;
    }

    public void setCzyDostepne(boolean czyDostepne) {
        this.czyDostepne = czyDostepne;
    }
}

class Elektronarzedzie extends SprzetBase {
    private int mocWaty;

    public Elektronarzedzie(String nazwa, int mocWaty){
        super(nazwa);
        this.mocWaty = mocWaty;
    }

    class ModulZasilania{
        void sprawdzBaterie(){
            System.out.println("Zasilanie dla " + getNazwa() + ": OK");
        }
    }

    @Override
    public void wyswietlStan() {
        System.out.println("Elektronarzędzie: " + getNazwa() + " Moc: " + mocWaty + " Dostępne: " + isCzyDostepne());
    }
}

public class Kolokwium1 {
    public static void main(String[] args) {
        List<Narzedzie> magazynZdzicha = new ArrayList<>();

        magazynZdzicha.add(new Elektronarzedzie("Wiertarka Bosh", 750));

        Narzedzie mlotekSasiada = new Narzedzie(){
            @Override
            public void wyswietlStan() {
                System.out.println("Narzedzie: Młotek Sąsiada Dostępne: zawsze");
            }
        };
        magazynZdzicha.add(mlotekSasiada);

        for(Narzedzie n : magazynZdzicha){
            n.wyswietlStan();
        }

        Elektronarzedzie szlifierka = new Elektronarzedzie("Szlifierka kątowa", 1200);
        Elektronarzedzie.ModulZasilania modul = szlifierka.new ModulZasilania();
        modul.sprawdzBaterie();
    }
}
