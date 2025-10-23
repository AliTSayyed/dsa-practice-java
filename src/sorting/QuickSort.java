package sorting;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] Args) {
        Random rand = new Random();
        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100);
        }

        System.out.println("Before:");
        System.out.println(Arrays.toString(numbers));

        quickSort(numbers, 0, numbers.length - 1);

        System.out.println("After");
        System.out.println(Arrays.toString(numbers));

    }

    private static void quickSort(int[] inputArray, int lowIndex, int highIndex) {
        // recursion base case, exit if the range is 1 (ie. indecies are the same)
        // a sub array of 1 item is already sorted
        if (lowIndex >= highIndex) {
            return;
        }

        // make the pivot the value at the end of the subarray
        int pivot = inputArray[highIndex];

        // declare two pointers, one at the start of the array, the other just before
        // the pivot
        int leftP = lowIndex;
        int rightP = highIndex - 1;

        // move both pointers in towards each other
        // pause the left pointer when it reaches a value greater than the pivot
        // pause the right pointer when it reaches a value less than the pivot
        // at this point swap the values at the left and right pointers
        // continue until left pointer is at the same spot as the right pointer
        while (leftP < rightP) {
            while (inputArray[leftP] <= pivot && leftP < rightP) {
                leftP++;
            }

            while (inputArray[rightP] >= pivot && leftP < rightP) {
                rightP--;
            }

            swap(inputArray, leftP, rightP);
        }

        // After the loop, leftP == rightP at the partition point.
        // All elements to the left of leftP are ≤ pivot.
        // All elements to the right of leftP are ≥ pivot.
        // Swap the pivot into its correct final position.
        // The value at leftP when we break out must be ≥ pivot because otherwise the
        // left pointer would have continued moving
        // That's the whole point of the condition while (inputArray[leftP] <= pivot).
        swap(inputArray, leftP, highIndex);

        // recursively sort the sub array from low index to 1 index before the left
        // pointer (because the pivot value is now swapped there)
        quickSort(inputArray, lowIndex, leftP - 1);

        // recursive sort the sub array from 1 past the left pointer (again pivot value
        // is there now), up to the high index
        quickSort(inputArray, leftP + 1, highIndex);
    }

    private static void swap(int[] inputArray, int index1, int index2) {
        int temp = inputArray[index1];
        inputArray[index1] = inputArray[index2];
        inputArray[index2] = temp;
    }
}
