import java.util.Scanner;

class UcakBileti {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        int mesafe , yolculukTipi , yas ;

        Scanner input = new Scanner(System.in);
// Kullanıcıda Yolculuk İçin Veri İstenmiştir
        System.out.print("Mesafe (KM): ");
         mesafe = input.nextInt();

        System.out.print("Yaşınız: ");
         yas = input.nextInt();
// Kullanıcıdan Yolculuk Tipi Seçmesi İstenmiştir
        System.out.print("Yolculuk Tipi (1: Tek Yön, 2: Gidiş-Dönüş): ");
         yolculukTipi = input.nextInt();

// İstenilen Koşul Sağlanmazsa Hatalı Veri Girdiniz Yazdırsın
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz !");

       return;
        }

// Gerekli Koşulları Sağlanması İstenmiştir
        double toplamFiyat = mesafe * 0.10;


        if (yas < 12)
            toplamFiyat *= 0.5;
        else if (yas >= 12 && yas <= 24)
            toplamFiyat *= 0.9;
        else if (yas >= 65)
            toplamFiyat *= 0.7;


        if (yolculukTipi == 2)
            toplamFiyat *= 0.8;

        System.out.println("Toplam Tutar: " + toplamFiyat);
    }
}