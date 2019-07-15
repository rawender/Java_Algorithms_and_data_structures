import java.util.Random;

public class Main {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        for (int i = 0; i < 100; i++) {
            tree.add(new Random().nextInt(50));
        }
        System.out.println(tree.inOrder());
        System.out.println();
        System.out.println(tree.size());
    }
}
