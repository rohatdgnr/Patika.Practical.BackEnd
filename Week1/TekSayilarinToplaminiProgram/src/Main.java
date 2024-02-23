import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        double sayi;
        double toplam = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Bir Sayı Girin (Programı Sonlandırmak İçin Tek Bir Sayı Girin): ");
            sayi = scanner.nextDouble();

// Girilen Sayı Çift ve  4'ün Katı ise Toplama Eklenir
            if (sayi % 2 == 0 && sayi % 4 == 0) {
                toplam += sayi;
            }
// Girilen Sayı Tek ise Döngüden Çıkılır

            if (sayi % 2 != 0) {
                break;
            }
        }

        System.out.println("Girilen Çift ve 4'ün Katları Olan Sayıların Toplamı: " + toplam);


    }
}