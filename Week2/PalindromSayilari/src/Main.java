import java.util.Scanner;

public class Main {

    // Bu Metod Verilen Bir Sayının Palindromik Olup Olmadığını Kontrol Ediyor
    static boolean isPalindrom(int number) {
        // Değişkenler Tanımlanıyor
        int temp = number, reverseNumber = 0, lastNumber;

        // Sayıyı Tersine Çevirme İşlemi Yapılıyor
        while (temp != 0) {
            lastNumber = temp % 10;
            reverseNumber = (reverseNumber * 10) + lastNumber;
            temp /= 10;
        }

        // Tersine Çevrilmiş Sayı, Girdi Olarak Verilen Sayıya Eşitse True Döndürülüyor
        return number == reverseNumber;
    }

    public static void main(String[] args) {
        // Test Yapılıyor
        System.out.println(isPalindrom(99));
    }
}
