package UtdDsa.LinearList;

public class LinearList {
    // array created
    private int[] list;
    // var to keep track of how many elements are in the array
    private int count;

    // constructor to create array of input size
    public LinearList(int size) {
        this.list = new int[size];
    }

    // default constructor
    public LinearList() {
        this.list = new int[10];
    }

    public int[] getList() {
        return this.list;
    }

    // method to insert an element at a specific index
    public void insert(int element, int index) throws Exception {
        // first check if the array is full
        if (this.count == this.list.length) {
            throw new IllegalStateException("Array is full!");
        }

        // we do not want to leave gaps so any index greater than count becomes the
        // immediate last element in the list
        if (index > this.count) {
            this.list[count] = element;
            count++;
            return;
        }

        // if a value is already at that index, then copy all the values from that index
        // onwards and shift them right
        // we start by shifting from the last element in the list to prevent losing data
        for (int i = count - 1; i >= index; i--) {
            this.list[i + 1] = this.list[i];
        }

        // after shifting set the index to the element and increment the size
        // of the list
        this.list[index] = element;
        count++;
        return;
    }

    // method to delete an item from the list
    public void delete(int index) throws Exception {
        // if the index is past how many items are in the list throw error
        if (index >= this.count) {
            throw new IllegalStateException("Index out of bounds!");
        }

        // take the value at the index and over write it with the values after it
        for (int i = index; i < this.count; i++) {
            this.list[i] = this.list[i + 1];
        }
        // set the last item back to 0 and decrement the size of the list
        this.list[this.count - 1] = 0;
        this.count--;
        return;
    }
}
