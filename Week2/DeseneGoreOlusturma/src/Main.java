import java.util.Scanner;

class DeseneGoreOlusturma {
    // Recursive metot
    static void f(int n) {

        if (n <= 0) {

            System.out.print(n + " ");
            return;
        }
        // Sayıyı Ekrana Yazdır ve 5 Azalt
        System.out.print(n + " ");
        f(n - 5);
        // Yeniden Sayıyı Ekrana Yazdırılıyor
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        // Kullanıcıdan Veri İsteniyor
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Lütfen Bir Sayı Giriniz :  ");
        int number = scanner.nextInt();
        f(number);

    }
}

