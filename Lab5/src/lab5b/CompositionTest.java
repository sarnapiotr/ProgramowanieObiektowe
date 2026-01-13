package lab5b;

public class CompositionTest {
    public static void main(String[] args) {
        Person jan = new Person("Jan Kowalski", "Prosta 54","30111","Krakow");
        Person maria = new Person("Maria Kowalska", "Prosta 54","30111","Krakow");

        System.out.println(jan);
        System.out.println(maria.formatForMailing());

        Address podzamcze22 = new Address("Podzamcze 22","00033","Warszawa");
        Person adam = new Person("Adam Nowak", podzamcze22);
        Person rozalia = new Person("Rozalia Nowak", podzamcze22);
        System.out.println(adam);
        System.out.println(rozalia.formatForMailing());
    }
}
