import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        double n, ortalama;
        double toplam = 0;
        double adet = 0;
// Kullanıcıdan Veri İstenmiştir
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Lütfen Bir Sayı Giriniz: ");
        n = scanner.nextDouble();
// Gerekli Koşullu İfadeler Döngüye Eklenmiştir
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 4 == 0) {
                toplam += i;
                adet++;
            }
        }
// Koşulu Sağylayan Verilerin Ortalaması Alınıp Ekrana Yazdırılmıştır
        ortalama = toplam / adet;
        System.out.println("3 ve 4'e Tam Bölünen Sayıların Ortalaması: " + ortalama);


    }
}