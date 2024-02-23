import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Değişkenler tanımlanmıştır
        int sayi  ;
        int toplam = 0 ;

// Kullanıcıdan Veri İstenmiştir
        System.out.println(" Lütfen Bir Sayı Giriniz : ");
         sayi = scanner.nextInt();

// Basamakların Toplamını Hesapla
         toplam = 0;
         int kalan;

        while (sayi > 0) {
            kalan = sayi % 10;
            toplam += kalan;
            sayi /= 10;
        }

        // Sonucu Ekrana Yazdıralım
        System.out.println("Girilen Sayının Basamaklarının Toplamı: " + toplam);


    }
}