import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArray<Integer> arr = new MyArray<>();
        for (int i = 0; i < 100; i++) {
            arr.add(new Random().nextInt(1000));
        }
        arr.show();
        arr.sort(Comparator.comparingInt(o -> o));
        arr.show();
    }
}
