import java.util.Scanner;

public class Main  {

    public static void main(String[] args) {
      // Değişkenleri Tanımlanıyor
        int terimSayisi ;
        int a = 0, b = 1;
        int sayac = 0;
        int temp ;

        Scanner scanner = new Scanner(System.in);

        System.out.print(" Fibonacci İçin Terim Sayısı Giriniz : ");
        terimSayisi = scanner.nextInt();

        // Fibonacciyi  Hesapla ve Ekrana Yazdırır
        System.out.println("Fibonacci serisi:");
        while (sayac < terimSayisi) {
            System.out.print(a + " ");

        // İki terimi güncelle: a, b = b, a+b
            temp = a;
            a = b;
            b = temp + b;

            sayac++;
        }


    }
}