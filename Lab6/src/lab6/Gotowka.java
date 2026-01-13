package lab6;

//Klasa Gotówka dziedziczy po klasie Pieniądz
class Gotowka extends Pieniadz {

    public Gotowka(double kwota) {
        super(kwota);
    }

    @Override
    public boolean zaplac(double cena) {
        return kwota >= cena;
    }

    @Override
    public String toString() {
        return "Gotówka (" + kwota + " PLN)";
    }
}