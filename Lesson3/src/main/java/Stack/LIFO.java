package Stack;

public interface LIFO<T> {
    int size();
    T pop();
    T peek();
    void push(T value);
    void order();
}
