package UtdDsa.LinearList;

// import java.util.Arrays;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        LinearList listArr = new LinearList();

        try {
            listArr.insert(3, 0);
            System.out.println(Arrays.toString(listArr.getList()));
            listArr.insert(2, 0);
            System.out.println(Arrays.toString(listArr.getList()));
            listArr.insert(10, 8);
            System.out.println(Arrays.toString(listArr.getList()));
            listArr.insert(1, 0);
            System.out.println(Arrays.toString(listArr.getList()));

            listArr.delete(1);
            System.out.println(Arrays.toString(listArr.getList()));
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
