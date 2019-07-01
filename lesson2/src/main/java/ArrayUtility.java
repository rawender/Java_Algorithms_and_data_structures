public class ArrayUtility {

    static <T extends Comparable<? super T>>
    void sort(MyArray<T> array){
        int q = 0;
        for (int i = 0; i < array.size(); i++) {
            int swaps = 0;
            for (int j = 0; j < array.size()-i-1; j++) {
                if(array.get(j).compareTo(array.get(j+1)) > 0){
                    swaps++;
                    T tmp = array.get(j+1);
                    array.set(j+1, array.get(j));
                    array.set(j, tmp);
                }
                q++;
            }
            if(swaps == 0) break;
        }
    }

    static <T extends Comparable<? super T>>
    void insertSort(MyArray<T> array){
        //TODO
        int n = array.size();
        for ( int i = 1 ; i < n; ++i) {
            T key = array.get(i);
            int j = i - 1 ;
            while (j >= 0 && array.get(j).compareTo(key) > 0) {
                array.set(j + 1, array.get(j));
                j -= 1 ;
            }
            array.set(j + 1,key);
        }
    }

    static <T extends Comparable<? super T>>
    void selectSort(MyArray<T> array){
        //TODO
        int n = array.size();
        for ( int i = 0 ; i < n- 1 ; i++) {
            int min_idx = i;
            for ( int j = i+ 1 ; j < n; j++)
                if (array.get(j).compareTo(array.get(min_idx)) < 0)
                    min_idx = j;

                T tmp = array.get(min_idx);
                array.set(min_idx, array.get(i));
                array.set(i, tmp);
        }
    }

    static <T extends Comparable<? super T>>
    void quickSort(MyArray<T> array){
        //TODO
        int left = 0, right = array.size() - 1;
        qSort(array, left, right);

    }

    private static <T extends Comparable<? super T>>
    void qSort(MyArray <T> array, int left, int right) {
        if (left < right) {
            int i = left, j = right;
            T p = array.get((i + j) / 2);
            do {
                while (array.get(i).compareTo(p) < 0) i++;
                while (array.get(j).compareTo(p) > 0) j--;
                if (i <= j) {
                    T tmp = array.get(i);
                    array.set(i, array.get(j));
                    array.set(j, tmp);
                    i++;
                    j--;
                }
            } while (i <= j);
            qSort(array, left, j);
            qSort(array, i, right);
        }
    }

    static <T extends Comparable<? super T>>
    int binarySearch(MyArray<T> array, T value){
        //TODO
        return -1;
    }

    static <T extends Comparable<? super T>>
    int linearSearch(MyArray<T> array, T value){
        //TODO
        int index = -1;
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == value) {
                index = i;
            }
        }
        return index;
    }
}
