public class Stack<T> implements Lifo<T>  {

    private OneLinkNode<T> tail;
    private int size;

    Stack() {
        tail = null;
        size = 0;
    }

    @Override
    public String toString() {
        OneLinkNode<T> node = tail;
        StringBuilder s = new StringBuilder();
        while (node != null){
            s.append(node.getValue()).append(' ');
            node = node.getNext();
        }
        return s.deleteCharAt(s.length()-1).toString();
    }

    @Override
    public void push(T element) {
        OneLinkNode<T> node = new OneLinkNode<>(element);
        node.setNext(tail);
        tail = node;
        size++;
    }

    @Override
    public T pop() {
        OneLinkNode<T> tmp = tail;
        tail = tail.getNext();
        size--;
        return tmp.getValue();
    }

    @Override
    public T peek() {
        //TODO
        return tail.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void order() {
        //TODO
        OneLinkNode<T> tmp = tail;
        while (tmp != null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}
