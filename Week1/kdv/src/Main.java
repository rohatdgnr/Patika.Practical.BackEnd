import java.util.Scanner;
class KdvHesaplama {
    public static void main(String[] args) {

        double paraMiktari,  kdvOran = 0.18 , kdvtutari, kdvlifiyati;
        Scanner imput = new Scanner(System.in);
        System.out.println(" Ne kadar tuttu : ");
        paraMiktari = imput.nextDouble();
//0 ile 1000 arasında ise kdvOrani 0.18 değil ise kdvOrani 0.08 alınacaktır.
        double kdvOrani;
        if (paraMiktari < 0  && paraMiktari <= 1000 )  {
            kdvOrani = 0.18;

        } else {
            kdvOrani = 0.08;
        }

        kdvtutari = paraMiktari * kdvOran ;
        kdvlifiyati = paraMiktari + kdvtutari ;

        System.out.println(" KDV'siz Tutar : " + paraMiktari);
        System.out.println(" KDV Oranı  : " + kdvOran);
        System.out.println(" KDV  Tutar : " + kdvtutari);
        System.out.println(" KDV'li Tutarı : " + kdvlifiyati);


    }
}