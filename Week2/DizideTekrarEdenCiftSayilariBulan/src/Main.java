import java.util.Scanner;

public class Main {

    static boolean isFind( int [] arr, int value ) {
        for ( int i : arr) {
            if ( i == value){

            }
        }
        return false;
    }



    public static void main(String[] args) {

        int[] list = {2, 4, 4, 6, 6, 6, 8, 20, 22, 12, 12, 12, 12};
        int[] duplicate = new int[list.length];
        int startIndex = 0;

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list.length; j++) {
                if ((i != j) && (list[i] == list[j])) {
                    if (!isFind(duplicate, list[i])) {
                        duplicate[startIndex++] = list[i];
                    }
                    break;
                }

            }
        }

        for( int value : duplicate) {
            if (value !=0){
                System.out.println(value);
            }
        }
    }
}