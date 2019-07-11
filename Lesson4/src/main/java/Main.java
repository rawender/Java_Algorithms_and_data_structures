import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i+1);
        }
        for(Iterator<Integer> iterator = list.iterator(); iterator.hasNext();){
            int value = iterator.next();
            System.out.println(value);
        }
        ArrayList list1 = new ArrayList();
        list1.toString();

        for (Integer i : list){

        }
    }
}
