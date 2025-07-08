package linkedlists;

public class Main {
    public static void main(String[] args) {
        LinkedList nums = new LinkedList();

        nums.add(5);
        nums.add(7);
        nums.add(6);
        nums.addFirst(6);
        nums.delete(6);
        nums.printValues();
    }
}
