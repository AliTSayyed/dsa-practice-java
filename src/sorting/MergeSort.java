package sorting;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        mergeSort(numbers);

        System.out.println("After");
        System.out.println(Arrays.toString(numbers));

    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        // recursive base case
        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength / 2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength - midIndex];

        for (int i = 0; i < midIndex; i++) {
            leftHalf[i] = inputArray[i];
        }

        for (int i = midIndex; i < inputLength; i++) {
            rightHalf[i - midIndex] = inputArray[i];
        }

        // recursively break down each array until it reaches the base case
        // when it reaches the base case, the arrays will be used to re order the
        // original input array using the merge fuction
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // merge the arrays into the correct order in the original array
        // Note: inputArray is a different array object at each recursion level
        // until the final merge writes back to the original array from main()
        merge(inputArray, leftHalf, rightHalf);
    }

    private static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;

        int i = 0, j = 0, k = 0;

        // compare the values in both halves
        // if which ever is less than needs to come first in the input array
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                k++;
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                k++;
                j++;
            }
        }

        // when the comparisons are over, there are still remaining indecies from either
        // the left or right half that need to be included in the input array, for
        // simplicity just do a while loop to check both right and left halves, even
        // thought just one of them will have remaining items
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
        }
    }
}
