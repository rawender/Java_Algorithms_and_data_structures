package Stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        for (int i = 0; i < 1000000; i++) {
            s.push(i);
        }
//        while (s.size() > 0){
//            System.out.print(s.pop() + " ");
//        }
//        System.out.println();
//        s.order();
    }
}
