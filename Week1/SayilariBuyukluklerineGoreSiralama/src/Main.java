import java.util.Scanner;

class Main {
    public static void main(String[] args) {
// Değşkenler Tanımlanmıştır
        int a, b, c;

        Scanner input = new Scanner(System.in);
//Kullanıcıdan Değer Girilmesi İstenmiştir
        System.out.print(" Birinci  Sayı Giriniz:");
        a = input.nextInt();
        System.out.print(" İkinci Sayı Giriniz:");
        b = input.nextInt();
        System.out.print(" Üçünçü Sayı Giriniz:");
        c = input.nextInt();
//Kullanıcıdan Alınan Veriler Karşılaştırılmıştır
        if ((a < b) && (a < c)) {
            if (b < c) {
                System.out.println("a<b<c");
            } else {
                System.out.println("a<c<b");
            }
        } else if ((b < a) && (b < c)) {
            if (a < c) {
                System.out.println("b<a<c");
            } else {
                System.out.println("b<c<a");
            }
        } else {
            if (a < b) {
                System.out.println("c<a<b");
            } else {
                System.out.println("c<b<a");

            }
        }
    }
}