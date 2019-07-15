public class OneLinkNode<T> {
    private T value;
    private OneLinkNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public OneLinkNode<T> getNext() {
        return next;
    }

    public void setNext(OneLinkNode<T> next) {
        this.next = next;
    }

    public OneLinkNode(T value) {
        this.value = value;
    }
}
