import java.util.Random;
import java.util.Scanner ;
public class Main {
    public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
// Değişkenler Tanımlanmıştır
        double boy , kilo , vki ;

// Kullanıcıdan Veri Girilmesi İstenmiştir
        System.out.println(" Lütfen Kilonuzu (kg) Giriniz : ");
        kilo = scanner.nextDouble();
        System.out.println(" Lütfen Boyunuzu (m) Giriniz : ");
        boy = scanner.nextDouble();
// Vücut Kitle İndeksi Formülü Tanımlanmıştır
        vki =  kilo / ( boy * boy)  ;

        System.out.println(" Vücut Kitle Endeksiniz : " + vki );








}
}