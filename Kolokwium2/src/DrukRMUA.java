import java.time.LocalDate;

public class DrukRMUA {
    private LocalDate data;
    private double brutto;

    public DrukRMUA(LocalDate data, double brutto) {
        this.data = data;
        this.brutto = brutto;
    }

    public LocalDate getData() { return data; }
    public double getBrutto() { return brutto; }

    public void wyswietl() {
        double emeryt = brutto * 0.0973;
        double rentowe = brutto * 0.015;
        double chorob = brutto * 0.0243;
        double zdrow = brutto * 0.0773;
        double pit = brutto * 0.0663;
        System.out.printf("RMUA %s | Brutto: %.2f | Em: %.2f | Re: %.2f | Ch: %.2f | Zd: %.2f | PIT: %.2f%n",
                data, brutto, emeryt, rentowe, chorob, zdrow, pit);
    }
}
