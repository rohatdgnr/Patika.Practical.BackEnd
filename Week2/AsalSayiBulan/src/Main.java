import java.util.Scanner;

public class Main {

    // Asal Sayı Olup Olmadığı Kontrol Ediliyor
    static boolean isPrime(int number, int divisor) {

        if (number < 2)
            return false;

        if (divisor == 1)
            return true;

        if (number % divisor == 0)
            return false;

        return isPrime(number, divisor - 1);
    }


    static boolean isPrime(int number) {
        return isPrime(number, (int) Math.sqrt(number));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Bir sayı giriniz: ");
        int number = scanner.nextInt();

        // Girilen sayının asal olup olmadığını kontrol et
        boolean result = isPrime(number);

        // Sonucu Ekrana Yazdır
        if (result) {
            System.out.println(number + " Bir Asal Sayıdır.");
        } else {
            System.out.println(number + " Bir Asal Sayı Değildir.");
        }


    }
}