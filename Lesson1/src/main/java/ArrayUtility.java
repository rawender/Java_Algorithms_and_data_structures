class ArrayUtility {

    private int [] data;

    ArrayUtility(int[] data) {
        this.data = data;
    }

    //функция должна возвращать сумму элементов массива
    long arraySum() {
        //TODO
        int sum = 0;
        for (int aData : data) {
            sum += aData;
        }
        return (long)sum;
    }
    //функция должна возвращать среднее арифметическое
    //элементов массива
    double avg(){
        //TODO
        int sum = 0;
        for (int aData : data) {
            sum += aData;
        }
        return (double)sum/data.length;
    }

    //функция должна возвращать медиану массива
    //медиана - это элемент посередине в упорядоченном массиве для
    //нечетных длин массива
    //или среднее арифметическое двух соседних элементов посередине
    //для четных длин
    //1 2 3 4 5 - 3
    //1 2 3 4 - (2 + 3) / 2 = 2,5
    double median(){
        //TODO
        int middle = data.length/2;
        if (data.length%2 == 1) {
            return data[middle];
        } else {
            return (data[middle-1] + data[middle]) / 2.0;
        }
    }
}
