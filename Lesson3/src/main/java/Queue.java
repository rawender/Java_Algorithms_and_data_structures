public class Queue<T> implements Fifo<T>  {

    private OneLinkNode<T> head, tail;
    private int size;

    @Override
    public String toString() {
        //TODO
        OneLinkNode<T> oneLinkNode = head;
        StringBuilder s = new StringBuilder();
        while (oneLinkNode != null){
            s.append(oneLinkNode.getValue()).append(' ');
            oneLinkNode = oneLinkNode.getNext();
        }
        return s.deleteCharAt(s.length()-1).toString();
    }

    @Override
    public void push(T element) {
        //TODO
        OneLinkNode <T> oneLinkNode = new OneLinkNode <>(element);
        if (size == 0) {
            head = tail = oneLinkNode;
            size++;
            return;
        }
        tail.setNext(oneLinkNode);
        tail = tail.getNext();
        size++;
    }

    @Override
    public T pop() {
        //TODO
        OneLinkNode<T> tmp = head;
        head = head.getNext();
        size--;
        return tmp.getValue();
    }

    @Override
    public T peek() {
        //TODO
        return head.getValue();
    }

    @Override
    public int size() {
        //TODO
        return size;
    }

    @Override
    public void order() {
        //TODO
        OneLinkNode<T> tmp = head;
        while (tmp != null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }
}
