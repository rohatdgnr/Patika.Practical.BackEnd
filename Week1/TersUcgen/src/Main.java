import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Kullanıcıdan Veri İsteniyor
        System.out.println(" Yıldızın Yüksekliğini Giriniz : ");
        int yukseklik = scanner.nextInt();

        // Yıldızların Üst Kısmı Tanımlanıyor
        for (int i = yukseklik; i >= 1; i--) {
            // Boşlukları ekle

            // Yıldızların Alt Kısmı Tanımlanıyor
            for (int k = 1; k <= 2 * i - 1; k++) {
                System.out.print("*");
            }

            for (int j = 1; j <= yukseklik - i; j++) {
                System.out.print(" ");

            }
            System.out.println();

        }

    }  }