import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
// Değişkenler Tanımlanmışdır
        boolean asalMi ;

        System.out.println("1 ile 100 arasındaki asal sayılar:");

// Belirlenen Aralığın Asal Olup OLmadığı Kontrol Ediliyor
        for (int i = 2; i <= 100; i++) {
             asalMi = true;

//  Sayıların Asal Olup Olmadığı Sorgulanıyor
            for (int j = 2; j * j <= i; j++) {
                if (i % j == 0) {
                    asalMi = false;
                    break;
                }
            }

// Asal Olanlar Ekrana Yazdırılıyor
            if (asalMi) {
                System.out.print(i + " ");
            }
        }
    }
}