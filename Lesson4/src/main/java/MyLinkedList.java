import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node<T> head, tail, iteratorNode;
    private Iterator<T> iterator;
    private int size;

    public MyLinkedList() {
        head = tail = null;
        size = 0;
    }

    public Iterator<T> iterator() {

        iteratorNode = head;

        return new Iterator<T>() {

            public void remove() {
                //TODO
                //удаляем текущий,
                //следующий становится текущим
                Node <T> it = iteratorNode;
                if (hasNext()) {
                    if (iteratorNode.prev == null) {
                        iteratorNode = iteratorNode.next;
                        iteratorNode.prev = null;
                        size--;
                    } else {
                        iteratorNode = iteratorNode.next;
                        iteratorNode.prev = it.prev;
                        size--;
                    }
                }

            }

            @Override
            public boolean hasNext() {
                //TODO
                //проверка не ссылаемся ли мы на null
                return iteratorNode != null;
            }

            @Override
            public T next() {
                //TODO
                //возвращаем текущий
                // и переходим к следющему
                T value = iteratorNode.value;
                iteratorNode = iteratorNode.next;
                return value;
            }
        };
    }

    void sortedAdd(T element) {
        //TODO
        //вставляем с головы в ближайшее место,
        //для которого выполняется:
        //node.prev <= tmp <= node.next
        Node<T> node = head;
        Node<T> tmp = new Node<>(element);
        if(size == 0 ){
            head = tail = new Node<>(element);
            size++;
            return;
        }
        if (node.prev == null && node.next == null) {
            if ((Integer) tmp.value <= (Integer) node.value) {
                node.prev = tmp;
                tmp.next = node;
                head = tmp;
                size++;
            } else {
                tmp.prev = node;
                node.next = tmp;
                size++;
            }
            return;
        }
        for(int i = 0; i < size; i++) {
            if(node.prev == null
                    && (Integer) tmp.value <= (Integer) node.next.value) {
                if ((Integer) tmp.value <= (Integer) node.value) {
                    tmp.next = node;
                    node.prev = tmp;
                    size++;
                } else {
                    tmp.prev = node;
                    tmp.next = node.next;
                    node.next = tmp;
                    size++;
                }
                return;
            }
            if (node.prev != null && (Integer) node.prev.value <= (Integer) tmp.value
                    && node.next == null) {
                if ((Integer) tmp.value <= (Integer) node.value) {
                    tmp.prev = node.prev;
                    tmp.next = node;
                    node.prev = tmp;
                    size++;
                } else {
                    tmp.prev = node;
                    tmp.next = node.next;
                    node.next = tmp;
                    size++;
                }
                return;
            }
            if (node.prev != null && (Integer) node.prev.value <= (Integer) tmp.value
                    && (Integer) tmp.value <= (Integer) node.next.value) {
                if ((Integer) tmp.value <= (Integer) node.value) {
                    tmp.prev = node.prev;
                    tmp.next = node;
                    node.prev = tmp;
                    size++;
                } else {
                    tmp.prev = node;
                    tmp.next = node.next;
                    node.next = tmp;
                    size++;
                }
                return;
            }
            node = node.next;
        }

    }

    void add(T element) {
        if(size == 0) {
            head = tail = new Node<>(element);
            size++;
            return;
        }
        Node<T> node = new Node<>(element);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }

    void add(int index, T element) {
        //TODO
        if (size == 0) {
            head = tail = new Node<>(element);
            size++;
            return;
        }
        if (index == 0) {
            Node<T> node = new Node<>(element);
            node.next = head;
            tail.prev = node;
            head = node;
            size++;
            return;
        }
        if (index == size - 1) {
            Node<T> node = new Node<>(element);
            node.prev = tail;
            tail.next = node;
            tail = node;
            size++;
            return;
        }
        int cnt = 0;
        Node<T> tmp = head;
        for(int i = 0; i < size; i++) {
            if(cnt == index) {
                Node<T> node = new Node<>(element);
                Node<T> tmpPr = tmp.prev;
                node.prev = tmpPr;
                node.next = tmp;
                tmpPr.next = node;
                tmp.prev = node;
                size++;
                return;
            }
            tmp = tmp.next;
            cnt++;
        }
    }

    void remove() {
        //TODO
        if (size > 0) {
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    int size() {
        //TODO
        return size;
    }

    void remove(int index) {
        //TODO
        if (index == 0) {
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.prev;
            tail.next = null;
            size--;
            return;
        }
        int cnt = 0;
        Node<T> tmp = head;
        for(int i = 0; i < size; i++) {
            if(cnt == index) {
                Node<T> tmpPr = tmp.prev;
                Node<T> tmpNx = tmp.next;
                tmpPr.prev = tmpNx;
                tmpNx.next = tmpPr;
                size++;
                return;
            }
            tmp = tmp.next;
            cnt++;
        }
    }

    T get(int index) {
        //TODO
        int cnt = 0;
        Node<T> tmp = head;
        for(int i = 0; i < size; i++) {
            if(cnt == index) {
                return tmp.value;
            }
            tmp = tmp.next;
            cnt++;
        }
        return null;
    }

    void set(int index, T value) {
        //TODO
        int cnt = 0;
        Node<T> tmp = head;
        for(int i = 0; i < size; i++) {
            if(cnt == index) {
                tmp.value = value;
                return;
            }
            tmp = tmp.next;
            cnt++;
        }
    }

    @Override
    public String toString() {
        //TODO
        //format: [1, 2, 3, 4, 5]
        iterator = iterator();
        if (!iterator.hasNext()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (;;) {
            T e = iterator.next();
            sb.append(e == this ? "(this Collection)" : e);
            if (!iterator.hasNext()) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
        }
    }
}
