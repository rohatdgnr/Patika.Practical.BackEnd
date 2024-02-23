import java.util.Scanner;

class HesapMakinesi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double sayi1, sayi2;
        System.out.print("İlk sayıyı girin: ");
        sayi1 = scanner.nextDouble();
        System.out.print("İkinci sayıyı girin: ");
        sayi2 = scanner.nextDouble();

        System.out.println("Yapmak istediğiniz işlemi seçin:");
        System.out.println("1. Toplama");
        System.out.println("2. Çıkarma");
        System.out.println("3. Çarpma");
        System.out.println("4. Bölme");

        int secim = scanner.nextInt();

        switch (secim) {
            case 1:
                System.out.println("Sonuç: " + (sayi1 + sayi2));
                break;
            case 2:
                System.out.println("Sonuç: " + (sayi1 - sayi2));
                break;
            case 3:
                System.out.println("Sonuç: " + (sayi1 * sayi2));
                break;
            case 4:
                if (sayi2 != 0)
                    System.out.println("Sonuç: " + (sayi1 / sayi2));
                else
                    System.out.println("Bir sayıyı 0'a bölemezsiniz!");
                break;
            default:
                System.out.println("Geçersiz seçim!");
        }


    }
}