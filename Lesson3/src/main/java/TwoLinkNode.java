public class TwoLinkNode<T> {
    private T value;
    private TwoLinkNode<T> prev, next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public TwoLinkNode<T> getPrev() {
        return prev;
    }

    public void setPrev(TwoLinkNode<T> prev) {
        this.prev = prev;
    }

    public TwoLinkNode<T> getNext() {
        return next;
    }

    public void setNext(TwoLinkNode<T> next) {
        this.next = next;
    }

    public TwoLinkNode(T value) {
        this.value = value;
    }
}
