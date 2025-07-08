package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 4 };
        int size = nums.length;
        int temp = 0;
        int minIndex = -1;

        System.out.println("before sorting");

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        // we loop through each item in the array and find the index of the smallest
        // value
        // after we find the smallest index we swap with the i value because that is
        // where out sorted values exist
        // there are 2 sections of the array, the sorted section and the unsorted
        // as we iterate i, the previous i is the sorted section
        // we can iterate size - 1 times for the outer for loop since the values will
        // all be sorted at that point
        for (int i = 0; i < size - 1; i++) {
            minIndex = i;
            for (int j = i; j < size; j++) {
                if (nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }
            temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
            System.out.println(Arrays.toString(nums));
        }

        System.out.println();
        System.out.println("after sorting");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
