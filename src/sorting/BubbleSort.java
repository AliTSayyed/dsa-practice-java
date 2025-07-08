package sorting;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = { 6, 5, 2, 8, 9, 4 };
        int size = nums.length;
        int temp = 0;

        System.out.println("before sorting");

        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        // create a double for loop (n^2 time)
        // we are trying to compare values to each other but are only looking at 2
        // values at a time
        // we compare the value we are on and the value after it. If the value after is
        // less than the value we are on, we swap
        // by the end of the first iteration the largest value in the entire array will
        // be at the end
        // every following iteration (in the first for loop) will require less checks
        // than the previous iteration since the last
        // value in the iteration will always be the largest value of that iteration
        // hence we do size - i - 1
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(nums));
        }

        System.out.println();
        System.out.println("after sorting");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}