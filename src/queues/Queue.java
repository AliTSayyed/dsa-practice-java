package queues;

// this is a circular queue using a fixed size array
// a simplier queue can be a linked list queue
public class Queue {

    private int front = 0;
    private int rear = -1;
    private int size = 0;
    private int[] arr = new int[4];

    // method to add an item to the array where rear is located.
    // we only add items to the end of the array
    // we increment rear before adding the item to the array since rear is on the
    // current last item in the queue
    // to ensure rear "loops" we increment the value and take the modulus of the
    // size of the array
    // this gives an infitie loop increment where it goes 0, 1, 2, 3, 0 , 1, 2, ....
    public void enqueue(int data) {
        if (!isFull()) {
            rear = (rear + 1) % 4;
            arr[rear] = data;
            size++;
        } else {
            System.out.println("Queue is full!");
        }
    }

    // method to remove an item from the array
    // we only remove items at the front (FIFO)
    // we increment after getting the value from the array since front starts on the
    // item we want to remove
    // to ensure an infite loop of incrementing front we increment and get the
    // modulus of the size of the array
    // this will make sure both rear and front pointers "follow" each other in a
    // circular format of numbers
    // 01234, 01234, ...
    public int dequeue() {
        int data = 0;
        if (isEmpty()) {
            data = arr[front];
            front = (front + 1) % 4;
            size--;
        } else {
            System.out.println("Queue is empty");
        }
        return data;
    }

    // samething as deque but do not change the front pointer or the size
    public int peek() {
        int data = 0;
        if (isEmpty()) {
            data = arr[front];
        } else {
            System.out.println("Queue is empty");
        }
        return data;
    }

    public void show() {
        for (int i = front; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // hard coded to size in the instance var
    // can make a constructor where user inputs max size and use that instead
    public boolean isFull() {
        return size == 4;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
