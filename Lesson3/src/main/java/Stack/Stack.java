package Stack;

public class Stack<T> implements LIFO<T> {

    private Node<T> tail;
    private int size;

    Stack() {
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T pop() {
        T tmp = tail.value;
        tail = tail.prev;
        size--;
        return tmp;
    }

    @Override
    public T peek() {
        return tail.value;
    }

    @Override
    public void push(T value) {
        Node<T> node = new Node<>(value);
        node.prev = tail;
        tail = node;
        size++;
    }

    @Override
    public void order() {
        Node<T> tmp = tail;
        while (tmp != null){
            System.out.print(tmp.value + " ");
            tmp = tmp.prev;
        }
        System.out.println();
    }
}
