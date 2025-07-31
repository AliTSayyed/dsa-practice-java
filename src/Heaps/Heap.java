package Heaps;

import java.util.Arrays;

/*
 * This class will consist of a min int heap
 * It will use an array to keep track of the heap structure
 */
public class Heap {
    private int capacity = 10;
    private int size = 0;
    int[] items = new int[capacity];

    /*
     * helper functions that will return the index of the parent,
     * left child, and right child from the array. Will be useful
     * when comparing and swapping values.
     */

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    /*
     * helper functions that will check if an index has a child
     * or a parent. Necessary for while loops.
     * We check that the index is less than the size, if not then that array index
     * is empty
     * For the parent we just check that the returned index is not less than 0
     */

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    /*
     * helper function that will be used to get the values stored at indecies
     * important for comparing values in while loop statments
     */

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    // helper function to swap the values in the array
    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    /*
     * helper function to resize the array to double the capacity
     * we double since the heap nodes increase by a power of 2
     */
    private void checkResizeHeap() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    /*
     * method that will return the smallest item on the heap
     * that value will always be stored at the first index
     */
    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        return items[0];
    }

    /*
     * method that will return and remove the smallest item on the heap
     * need to re organize the heap structure after the item is removed
     * set the smallest item in the array to the first index
     * bubble the new first item down to where it should be
     */
    public int getMin() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int smallest = items[0];

        items[0] = items[size - 1];
        size--;
        bubbleDown();
        return smallest;
    }

    /*
     * method that will add an item to the heap
     * checks if the heap needs to be resized
     * will add the item to the end of the heap and will bubble it up
     * until it reaches where it should be
     */
    public void add(int value) {
        checkResizeHeap();
        items[size] = value;
        size++;
        bubbleUp();
    }

    /*
     * function that will take an item at the start of the array
     * will compare its value to its two children
     * swap with the smaller of the two children if applicable
     * continue until condition breaks while loop
     */
    private void bubbleDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(smallerChildIndex, index);
            }
            index = smallerChildIndex;
        }
    }

    /*
     * take item that was at the end of the array
     * compare it to its parent
     * if the value of the parent is greater than the child swap
     * continue until condition breaks while loop
     */
    private void bubbleUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

}
