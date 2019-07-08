public class Deque<T> implements TwoSizeQueue<T>  {

    private TwoLinkNode<T> front, back;
    private int size;

    @Override
    public String toString() {
        //TODO
        TwoLinkNode<T> oneLinkNode = front;
        StringBuilder s = new StringBuilder();
        while (oneLinkNode != null){
            s.append(oneLinkNode.getValue()).append(' ');
            oneLinkNode = oneLinkNode.getNext();
        }
        return s.deleteCharAt(s.length()-1).toString();
    }

    @Override
    public void addBack(T element) {
        //TODO
        TwoLinkNode<T> twoLinkNode = new TwoLinkNode<>(element);
        if(size == 0){
            front = back = twoLinkNode;
            size++;
            return;
        }
        if (front == back) {
            front.setNext(twoLinkNode);
            twoLinkNode.setPrev(front);
            back = twoLinkNode;
            size++;
            return;
        }
        back.setNext(twoLinkNode);
        twoLinkNode.setPrev(back);
        back = twoLinkNode;
        size++;
    }

    @Override
    public void addFront(T element) {
        //TODO
        TwoLinkNode<T> twoLinkNode = front;
        front = new TwoLinkNode<>(element);
        front.setNext(twoLinkNode);
        if (twoLinkNode == null) {
            back = front;
        } else {
            twoLinkNode.setPrev(front);
        }
        size++;
    }

    @Override
    public T popBack() {
        //TODO
        TwoLinkNode<T> tmp = back;
        if (size > 0) {
            back = back.getPrev();
            back.setNext(null);
            size--;
        }
        return tmp.getValue();
    }


    @Override
    public T popFront() {
        //TODO
        TwoLinkNode<T> tmp = front;
        if (size > 0) {
            front = front.getNext();
            front.setPrev(null);
            size--;
        }
        return tmp.getValue();
    }

    @Override
    public T back() {
        //TODO
        return back.getValue();
    }

    @Override
    public T front() {
        //TODO
        return front.getValue();
    }

    @Override
    public void order() {
        //TODO
        TwoLinkNode<T> tmp = front;
        while (tmp != null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getNext();
        }
        System.out.println();
    }

    @Override
    public void reverseOrder() {
        //TODO
        TwoLinkNode<T> tmp = back;
        while (tmp != null){
            System.out.print(tmp.getValue() + " ");
            tmp = tmp.getPrev();
        }
        System.out.println();
    }

    @Override
    public int size() {
        //TODO
        return size;
    }
}
