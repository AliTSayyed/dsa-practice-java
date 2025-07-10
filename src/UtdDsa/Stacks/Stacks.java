package UtdDsa.Stacks;

public class Stacks<T> {
    // Generic array to hold elements
    private T[] array;
    // pointer for stack
    int top;

    // constructor to create generic array and pointer set to -1
    @SuppressWarnings("unchecked")
    public Stacks(int size) {
        array = (T[]) new Object[size];
        top = -1;
    }

    // throw error if stack is full, else increment pointer and then set stack at
    // index to element
    public void push(T element) throws Exception {
        if (top == array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Stack is full");
        } else {
            array[++top] = element;
        }
    }

    // throw error if stack is empty else return element and decrement pointer
    public T pop() throws Exception {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("No elements in the stack!");
        } else {
            T element = array[top--];
            return element;
        }
    }

    // throw error if stack is empty else return element
    public T peek() throws Exception {
        if (top == -1) {
            throw new ArrayIndexOutOfBoundsException("No elements in the stack!");
        } else {
            T element = array[top];
            return element;
        }
    }

    // return if stack is empty
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}