import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Kullanıcıdan Veri İsteniyor
        System.out.println(" Yıldızın Yüksekliğini Giriniz : ");
        int yukseklik = scanner.nextInt();


        for (int i = 1; i <= yukseklik; i++) {
// Boşluklar Ekleniyor
            for (int j = 1; j <= yukseklik - i; j++) {
                System.out.print(" ");
            }
// Yıldızlar Ekleniyor
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

// Yıldızların Üst Kısmı Tanımlanıyor
        for (int i = yukseklik - 1; i >= 1; i--) {
            // Boşlukları ekle
            for (int j = 1; j <= yukseklik - i; j++) {
                System.out.print(" ");
            }
// Yıldızların Alt Kısmı Tanımlanıyor
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}