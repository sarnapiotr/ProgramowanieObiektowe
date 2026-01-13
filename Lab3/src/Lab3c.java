import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Lab3c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());

        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }

        sc.close();
    }
}
