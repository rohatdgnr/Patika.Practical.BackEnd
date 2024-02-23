

import java.util.Scanner;

class ArtikYil {
    public static void main(String[] args) {
// Değişkenler Tanımlanmıştır
        int yil;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Yıl giriniz: ");
        yil = scanner.nextInt();

// Bir yılın artık yıl olması için iki koşulun sağlanması gerekir:
// 1. Yılın 4'e tam bölünmesi, ancak 100'e tam bölünmemesi.
// 2. Yılın 400'e tam bölünmesi.
        boolean artikYil = (yil % 4 == 0 && yil % 100 != 0) || (yil % 400 == 0);

        System.out.println(artikYil ? yil + " bir artık yıldır." : yil + " bir artık yıl değildir.");

    }
}