import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        double taban,us ;
        int   sonuc = 1 ;
        int  i ;
        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan Taban ve Üs Değerlerini İstenmiştir
        System.out.println("Taban Değerini Girin : ");
        taban = scanner.nextDouble();

        System.out.println("Üs Değerini Girin : ");
        us = scanner.nextDouble();

        // Üslü Sayıyı Hesaplanmıştır
         sonuc = 1;
        for ( i = 0; i < us; i++) {
            sonuc *= taban;
        }

        // Sonuc Çıktısı Yazdırılmıştır
        System.out.println(taban + "^" + us + " = " + sonuc);


    }
}