package queues;

public class Main {
    public static void main(String[] args) {
        Queue nums = new Queue();

        nums.enqueue(1);
        nums.enqueue(20);
        nums.show();

        System.out.println(nums.dequeue());
        nums.show();
    }
}
