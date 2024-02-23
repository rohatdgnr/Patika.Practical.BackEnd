import java.util.Scanner ;
public class Main {
    public static void main(String[] args) {

// Değişkenler Ve Fiyatları tanımlanıştır
      double Armut , Elma  , Domates   , Muz   , Patlican  ;
      double arFiyat = 2.14 , elFiyat = 3.97 , domFiyat = 1.11 , muFiyat = 0.95 , patFiyat = 5 ;
        Scanner scanner = new Scanner(System.in);
// Kullanıcıdan Kaçar Kilo İstediği Girilmesi İstenmiştir
        System.out.println(" Armut Kaç Kilo : ");
         Armut= scanner.nextDouble();
        System.out.println(" Elma  Kaç Kilo :");
         Elma= scanner.nextDouble();
        System.out.println(" Domates Kaç Kilo :");
         Domates= scanner.nextDouble();
        System.out.println(" Muz Kaç Kilo : ");
         Muz= scanner.nextDouble();
        System.out.println(" Patlican Kaç Kilo : ");
         Patlican= scanner.nextDouble();
// Değişkenler Ve  Birim Fiyatları Çarpılıp Tümü Toplam Fiyat Çıkması İçin Toplanmıştır
         double toplam = Armut * arFiyat + Elma * elFiyat + Domates * domFiyat + Muz * muFiyat + Patlican * patFiyat ;
         System.out.println(" Toplam Fiyat " + toplam );






    }
}