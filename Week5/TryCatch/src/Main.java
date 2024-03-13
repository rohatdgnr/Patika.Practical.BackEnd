import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        int[] arr ={10,11,12,13,14,15,16,17,18,19};
        int index;
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Dizideki indeks ");
        index = scanner.nextInt();
  ss(arr,index);
    }

    public static void ss (int[] arr, int index) {
        try {
            System.out.println( arr[index]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(" hata " +e.getMessage());
        }

    }

}