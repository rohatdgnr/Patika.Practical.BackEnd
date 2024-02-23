import java.util.Scanner;

 class CinZodyagi {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        int yil , kalan ;
        Scanner scanner = new Scanner(System.in);
// Kullanıcıdan Veri Girilmesi İstenmiştir
        System.out.print(" Lütfen Doğum Yılınızı Giriniz : ");
         yil = scanner.nextInt();
// Çin Zodyağı Sembollerini İçeren Bir Dizi Oluşturlmuştur
        String[] zodyak = {"Maymun", "Horoz", "Köpek", "Domuz", "Fare", "Öküz", "Kaplan", "Tavşan", "Ejderha", "Yılan", "At", "Koyun"};

         kalan = (yil % 12);

        String burc = "";
// Yukarıdaki İşlem Yapılıp Ekrana Gerekli Bilgi Yazdırılması Beklenmektedir
        if (kalan == 0) {
            burc = "Maymun";
        } else if (kalan == 1) {
            burc = "Horoz";
        } else if (kalan == 2) {
            burc = "Köpek";
        } else if (kalan == 3) {
            burc = "Domuz";
        } else if (kalan == 4) {
            burc = "Fare";
        } else if (kalan == 5) {
            burc = "Öküz";
        } else if (kalan == 6) {
            burc = "Kaplan";
        } else if (kalan == 7) {
            burc = "Tavşan";
        } else if (kalan == 8) {
            burc = "Ejderha";
        } else if (kalan == 9) {
            burc = "Yılan";
        } else if (kalan == 10) {
            burc = "At";
        } else if (kalan == 11) {
            burc = "Koyun";
        }

        System.out.println(" Çin Zodyağına Göre Bu Yılda Doğan Birinin Burcu : " + burc );
    }
}