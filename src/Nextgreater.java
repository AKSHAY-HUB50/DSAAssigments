
import java.util.Scanner;

public class Nextgreater {
    public static int nextGreaterForKey(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == key) {

                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] > key) {
                        return arr[j];
                    }
                }

                return -1;             }
        }

        return -2;
    }


    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter element: ");
        int key = sc.nextInt();

        int nge = nextGreaterForKey(arr, key);

        if (nge == -2) {
            System.out.println("Element not present in array");
        } else {
            System.out.println("Next Greater Element of " + key + " is: " + nge);
        }
    }
}
