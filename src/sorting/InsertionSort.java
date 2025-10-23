package sorting;

import java.util.Arrays;
import java.util.Random;

public class InsertionSort {

    public static void main(String[] Args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        insertionSort(numbers);

        System.out.println("After");
        System.out.println(Arrays.toString(numbers));

    }

    private static void insertionSort(int[] inputArray) {
        // need to start by comparing elements to the elements before it
        // start at 1 since index 0 had no elements behind it
        for (int i = 1; i < inputArray.length; i++) {
            int currentValue = inputArray[i];
            int j = i - 1;

            // for each element, compare it to the one behind
            // if the element behind is greater, then shift that element over to the right
            // since we store the overwritten in currentValue, we can do this shifting
            while (j >= 0 && inputArray[j] > currentValue) {
                inputArray[j + 1] = inputArray[j];
                j--;
            }
            // while loop breaks at -1, need a + 1 to correctly 'insert' the current value
            // into the right spot
            inputArray[j + 1] = currentValue;
        }
    }

}
