import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int r, a;
        double pi =3.14;
//Kullanıcıdan Veri Girilmesi İstenmiştir
        Scanner inp= new Scanner(System.in);
        System.out.print("Yarı Çapı Giriniz: ");
        r =inp.nextInt();

//Kullamıcıdan Veri Girilmesi İstenmiştir
        System.out.print("Merkez Açı Ölçüsünü Giriniz: ");
        a = inp.nextInt();

//Dairenin Alanın Hesaplanması Tanımlanmıştır
        double alan =(pi*(r*r)*a)/360;
        System.out.print("Dairenin Alanı: " + alan);
    }
}