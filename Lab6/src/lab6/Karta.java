package lab6;

//Klasa Karta dziedziczy po klasie Pieniądz
class Karta extends Pieniadz {
    public Karta(double kwota) {
        super(kwota);
    }

    @Override
    public boolean zaplac(double cena) {
        if (kwota >= cena) {
            kwota -= cena;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Karta (saldo: " + kwota + " PLN)";
    }
}