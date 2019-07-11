public interface Fifo<T> { //очередь
    void push(T element); //добавить элемент в коллекцию
    T pop(); //возврат верхушки с удалением
    T peek(); //возврат верхушки без удаления
    int size();
    void order();//вывод на экран всей структуры
}
