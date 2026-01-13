class Samolot{
    private int zasieg;
    private int iloscPaliwa;

    public Samolot(){
        this.zasieg = 0;
        this.iloscPaliwa = 0;
    }

    void fill(){
        this.iloscPaliwa += 1000;
    }

    void fill(int nowePaliwo){
        this.iloscPaliwa += nowePaliwo;
    }

    public int getIloscPaliwa() {
        return iloscPaliwa;
    }
}

public class Lab5c {
    public static void main() {
        Samolot samolot = new Samolot();

        samolot.fill();
        samolot.fill(67);

        System.out.println("Ilosc paliwa wynosi: " + samolot.getIloscPaliwa());
    }
}
