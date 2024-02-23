import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Kullanıcıdan Bir Tam Sayı ve Bir Ondalıklı Sayı Alınıyor
        System.out.print(" Lütfen Bir Tam Sayı Giriniz : ");
        int tamSayi = scanner.nextInt();

        System.out.print(" Lütfen Bir Ondalıklı Sayı Giriniz: ");
        double ondalikliSayi = scanner.nextDouble();

        // Tam Sayıyı Ondalıklı Sayıya Dönüştürülüyor
        double tamSayiOndalikli = (double) tamSayi;

        // Ondalıklı Sayıyı Tam Sayıya Dönüştürülüyor
        int ondalikliSayiTam = (int) ondalikliSayi;

        // Sonuçları Ekrana Yazdırılıyor
        System.out.println("Tam Sayıyı Ondalıklı Sayıya Dönüştürme Sonucu: " + tamSayiOndalikli);
        System.out.println("Ondalıklı Sayıyı Tam Sayıya Sönüştürme Sonucu: " + ondalikliSayiTam);


    }
}