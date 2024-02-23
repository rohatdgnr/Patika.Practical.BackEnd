import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int km;
        double Kmbasi = 2.20, toplamtutar , baslangic = 10 ;

        Scanner input = new Scanner(System.in);
        System.out.println(" Gidilen Mesafe  : ");
        km = input.nextInt();

        toplamtutar = ( km * Kmbasi );
        toplamtutar += baslangic;

        toplamtutar = ( toplamtutar < 20 ) ? 20 : toplamtutar ;
        System.out.println(" Toplam Tutar : "  + toplamtutar );



    }
}