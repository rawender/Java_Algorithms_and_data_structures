public interface TwoSizeQueue<T> { //deque
    void addBack(T element); //добавить элемент в конец
    void addFront(T element); //добавить элемент в начало
    T popBack(); //возврат последнего с удалением
    T popFront();
    T back();
    T front();
    void order(); //вывод на экран всей структуры front to back
    void reverseOrder();//back to front
    int size();
}
