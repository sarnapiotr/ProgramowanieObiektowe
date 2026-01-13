import java.util.Scanner;

public class Lab3b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, y;

        System.out.println("Podaj x: ");
        x = sc.nextInt();
        System.out.println("Podaj y: ");
        y = sc.nextInt();

        System.out.println("x + y = " + (x + y));
        System.out.println("x - y = " + (x - y));
        System.out.println("x * y = " + (x * y));
        System.out.println("x / y = " + ((double) x / y));
        System.out.println("x % y = " + (x % y));
        System.out.println("x ^ y = " + Math.pow(x, y));
        System.out.println("x ^ 1/y = " + Math.pow(x, 1/y));

        sc.close();
    }
}
