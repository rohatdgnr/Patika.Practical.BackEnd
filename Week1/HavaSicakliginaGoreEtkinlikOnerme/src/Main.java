import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int sicaklik;

        Scanner scanner = new Scanner(System.in);

        System.out.println(" Lütfen Hava Sıcaklığını Giriniz : ");
        sicaklik = scanner.nextInt();

        if (sicaklik <= 5) {
            System.out.println(" Kayak Yapabilirsin ");
        } else if (sicaklik >= 5 && sicaklik < 15) {
            System.out.println(" Sinemaya Gidelisiniz ");
        } else if (sicaklik >= 15 && sicaklik < 25) {
            System.out.println(" Piknik Yapmaya Gidelisiniz ");
        } else if (sicaklik >= 25) {
            System.out.println(" Yüzmeye Gidelisiniz ");
        }
    }
}