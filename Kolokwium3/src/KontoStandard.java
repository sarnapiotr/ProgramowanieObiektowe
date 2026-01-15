public class KontoStandard extends Konto {
    public KontoStandard(String numer, String wlasciciel, double saldo) {
        super(numer, wlasciciel, "Standard", saldo);
    }

    @Override
    public boolean moznaWyplacic(double kwota) {
        return saldo >= kwota;
    }
}
