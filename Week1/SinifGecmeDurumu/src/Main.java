import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Değişkenler Tanımlanmıştır
        double  Mat , Fizik , Turkce , Kimya , Muzik ;
        // Toplam Notlar ve Geçerli Notlar Tanımlanmıştır
        int toplam = 0 , sayac = 0 ;

        Scanner scanner = new Scanner(System.in);
        // Matematik Notu Hesaplanıp Koşulu Sağlayıp Sağlmadığı Kontrol Ediliyor
        System.out.print(" Matematik Notunuzu Giriniz : ");
        Mat = scanner.nextDouble();
        if  (Mat >= 0 && Mat <= 100) {

            toplam += Mat;
            sayac ++;
        }
          else {
            System.out.println(" Lütfen Geçerli Bir Not Giriniz!");
        }
          // Fizik Notu Hesaplanıp Koşulu Sağlayıp Sağlmadığı Kontrol Ediliyor
        System.out.print(" Fizik Notunuzu Giriniz : ");
        Fizik = scanner.nextDouble();
        if (Fizik >= 0 && Fizik <= 100) {
            toplam += Fizik;
            sayac ++;
         }
        else {
            System.out.println(" Lütfen Geçerli Bir Not Giriniz!");
        }
        // TürkçeNotu Hesaplanıp Koşulu Sağlayıp Sağlmadığı Kontrol Ediliyor
        System.out.print(" Türkçe  Notunuzu Giriniz : ");
        Turkce = scanner.nextDouble();
        if (Turkce >= 0 && Turkce <= 100) {
            toplam += Turkce;
            sayac ++;

           }
        else {
            System.out.println(" Lütfen Geçerli Bir Not Giriniz!");
        }
        // Kimya Notu Hesaplanıp Koşulu Sağlayıp Sağlmadığı Kontrol Ediliyor
        System.out.print(" Kimya Notunuzu Giriniz : ");
        Kimya = scanner.nextDouble();
        if (Kimya >= 0 && Kimya <= 100) {
            toplam += Kimya;
            sayac ++;
          }
        else {
            System.out.println(" Lütfen Geçerli Bir Not Giriniz!");
        }
        // Müzik Notu Hesaplanıp Koşulu Sağlayıp Sağlmadığı Kontrol Ediliyor
        System.out.print(" Müzik  Notunuzu Giriniz : ");
        Muzik = scanner.nextDouble();
        if (Muzik >= 0 && Muzik <= 100) {
            toplam += Muzik;
            sayac ++;
          }
        else {
            System.out.println(" Lütfen Geçerli Bir Not Giriniz!");
        }
// Geçerli Tüm Notlar Hesaplanıp Ekrana Yazdırılıyor
        double  ortalama = (toplam/sayac);

        System.out.println(" Ortalamanız : " + ortalama);
// Kullanıcının Ortalaması 55 ten Büyük ise "Sınıfı Geçtiniz" Değil İse "Sınıfı Geçemediniz" Yazdırılıyor
        if ( ortalama <=  55 ) {
            System.out.println(" Sınıfı Geçemediniz  ");
        }
        else {
            System.out.println(" Sınıfı Geçtiniz ");
        }



    }
}