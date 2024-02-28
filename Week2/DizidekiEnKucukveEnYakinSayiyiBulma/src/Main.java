import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] list = {15, 12, 788, 1, -1, -778, 2, 0};
        double seleced;


        int kucukEnyakin = Integer.MIN_VALUE;
        int buyukEnyakin = Integer.MAX_VALUE;
        Scanner scanner = new Scanner(System.in);

        System.out.print(" Lütfen Bir Sayı Giriniz : ");
        seleced = scanner.nextDouble();


        for (int i : list) {
            if (i < seleced && i > kucukEnyakin) {
                kucukEnyakin = i;
            }
            if (i > seleced && i < buyukEnyakin) {

                buyukEnyakin = i;
            }
        }

        System.out.println("Girilen sayıdan küçük en yakın sayı: " + kucukEnyakin);
        System.out.println("Girilen sayıdan büyük en yakın sayı: " + buyukEnyakin);


    }
}


