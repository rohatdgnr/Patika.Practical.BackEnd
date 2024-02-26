import java.util.Scanner;

 class UsluSayiHesaplama {
    static int escape(int base, int exponent) {
        // Taban durumu: Eğer Üs 0 ise, 1 Döndürsün
        if (exponent == 0) {
            return 1;
        }
        //  Eğer Üs 1 ise, Tabanı Döndürsün
        else if (exponent == 1) {
            return base;
        }
        // Diğer Durumlarda, Tabanı (base) Üssü Kadar Tekrar Çağırsın  ve Sonucu Döndürsün
        else {
            return base * escape(base, exponent - 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // Kullanıcıdan Veri Girişi İsteniyor
        System.out.print(" Lütfen Taban Değeri Giriniz: ");
        int base = scanner.nextInt();
        System.out.print(" Lütfen Üs Değeri Giriniz: ");
        int exponent = scanner.nextInt();

        // Üs Alma İşlemi Yapılıyor
        int result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println(" İşlemin Sonucu : " + result);

    }
}