import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
// Değşkenler Tanımlanıyor
        int sayi;
        int toplam = 0;
// Kullanıcıdan Veri İsteniyor
        Scanner scanner = new Scanner(System.in);
        System.out.print(" Lütfen Bir Sayı Giriniz : ");
        sayi = scanner.nextInt();
// Sayının Mükemmel Sayıya Uygunluğu Kontrol Ediliyor
        if (sayi <= 0) {
            System.out.println("Negatif Veya Sıfır Bir Sayı Mükemmel Sayı Olamaz.");
        } else {
//Sayı Mükemmel Sayı mıdır ?
            for (int i = 1; i < sayi; i++) {
                if (sayi % i == 0) {
                    toplam += i;
                }
            }
//Evet ise Ekrana Mükemmel Sayıdır Yazdır
            if (toplam == sayi) {
                System.out.println(sayi + " Mükemmel Sayıdır.");
// Hayır ise Mükemmel Sayı Değildir
            } else {
                System.out.println(sayi + " Mükemmel Sayı Değildir.");
            }
        }
    }
}