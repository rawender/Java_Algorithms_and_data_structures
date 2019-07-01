import java.lang.Object;
import java.util.Comparator;

public class MyArray<T> {

    private Object[] data;
    private int size, capacity, q;

    public MyArray() {
        size = 0;
        capacity = 1000;
        data = new Object[capacity];
    }

    void getQ(){
        System.out.println(q);
    }

    void show(){
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    //вставка в конец массива
    void add(T element){
        if(size < capacity){
            data[size] = element;
            size++;
        }
        else {
            reallocate();
            data[size] = element;
            size++;
        }
    }

    void set(int index, T value){
        data[index] = value;
    }

    T get(int index){
        return (T) data[index];
    }

    int size(){
        return size;
    }

    //вставка по индексу
    void add(int index, T element){
        //TODO
        Object[] tmp = new Object[capacity];
        if(size < capacity){
            if (index >= 0 && index <= size) {
                System.arraycopy(data, 0, tmp, 0,  index + 1);
                System.arraycopy(data, index, tmp, index + 1, size - index);
                tmp[index] = element;
                size++;
                data = tmp;
            }
        }
        else {
            if (index >= 0 && index <= size) {
                reallocate();
                System.arraycopy(data, 0, tmp, 0,  index + 1);
                System.arraycopy(data, index, tmp, index + 1, size - index);
                tmp[index] = element;
                size++;
                data = tmp;
            }
        }
    }

    //перевыделение памяти можно увеличить вместимость
    //на константу либо в константное количество раз
    //подумайте как лучше
    private void reallocate(){
        capacity *= 2;
        Object[] tmp = new Object[capacity];
        if (size >= 0) System.arraycopy(data, 0, tmp, 0, size);
        data = tmp;
    }

    //удаление последнего
    boolean remove(){
        if (size > 0) {
            size--;
        }
        return false;
    }
    //удаление по индексу
    boolean remove(int index){
        //TODO
        Object[] tmp = new Object[capacity];
        if (size > 0) {
            if (index >= 0 & index < size) {
                System.arraycopy(data, 0, tmp, 0,  index);
                System.arraycopy(data, index + 1, tmp, index, size - (index + 1));
                size--;
                data = tmp;
            }
        }
        return false;
    }

    T [] toArray(){
        //TODO
        Object[] tmp = new Object[size];
        System.arraycopy(data, 0, tmp, 0, size);
        return (T[]) tmp;
    }

    void sort(Comparator<T> c){
        int left = 0, right = size - 1;
        quickSort(data, left, right, c);
    }

    private void quickSort(Object[] data, int left, int right, Comparator<T> c) {
        if (left < right) {
            int i = left, j = right;
            T p = (T) data[(i + j) / 2];
            do {
                while (c.compare((T) data[i], p) < 0) i++;
                while (c.compare((T) data[j], p) > 0) j--;
                if (i <= j) {
                    Object tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                    i++;
                    j--;
                }
            } while (i <= j);
            quickSort(data, left, j, c);
            quickSort(data, i, right, c);
        }
    }
}
