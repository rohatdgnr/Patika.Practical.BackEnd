import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       double sayi , i ;
        // Kullanıcıdan bir sayı alınır
        System.out.print(" Lütfen Bir Sayı Giriniz: ");
        sayi = scanner.nextInt();

        // 4 ve 5'in kuvvetlerini ekrana yazdırma işlemi başlatılır
        System.out.println("4  ve 5 kuvvetleri:");

        // 1'den kullanıcının girdiği sayıya kadar olan her sayı için kuvvetler hesaplanır ve yazdırılır
        for ( i = 1; i <= sayi; i++) {
            // 4'ün i. kuvveti hesaplanır ve yazdırılır
            System.out.println("4^" + i + " = " + Math.pow(4, i));
            // 5'in i. kuvveti hesaplanır ve yazdırılır
            System.out.println("5^" + i + " = " + Math.pow(5, i));
        }
    }
}