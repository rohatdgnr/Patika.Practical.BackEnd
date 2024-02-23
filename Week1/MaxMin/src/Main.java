import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        double max = 0;
        double min = 0;
        double n, i, sayi;
        Scanner scanner = new Scanner(System.in);
//Kullanıcıdan Veri İstenmiştir
        System.out.print("Kaç adet sayı gireceksiniz: ");
        n = scanner.nextDouble();

//Kullanıcıdan İstenen Verileri Sayısı Kadar Ekrana Veri Girmesi İstenmiştir
        for (i = 0; i < n; i++) {
            System.out.print((i + 1) + ". sayıyı giriniz: ");
            sayi = scanner.nextDouble();
// Max ve Min Değerleri Bulmak İçin Karşılaştırma Yapılmıştır
            if (i == 0) {
                max = sayi;
                min = sayi;
            } else {
                if (sayi > max) {
                    max = sayi;
                }

                if (sayi < min) {
                    min = sayi;
                }
            }
        }
//Kullanıcıdan Alınıp Karşılaştırılan Veriler Ekrana Yazdırılıyor
        System.out.println("En büyük sayı: " + max);
        System.out.println("En küçük sayı: " + min);
    }
}