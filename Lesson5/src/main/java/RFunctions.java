import javafx.util.Pair;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class RFunctions {

    private static BigInteger [] memo = new BigInteger[2000];

    //функция должна находить число Фибоначчи с номер н
    BigInteger fib(int n) {
        //TODO
        if (n == 0) {
            return BigInteger.valueOf(0);
        }
        if (n == 1 || n == 2) {
            return BigInteger.valueOf(1);
        }
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] =  fib(n - 1).add(fib(n - 2));
        return memo[n];
    }

    //функция должна считать факториал числа
    BigInteger factor(int n) {
        //TODO
        BigInteger a = new BigInteger(String.valueOf(n));
        if (n == 0) {
            return BigInteger.valueOf(1);
        }
        return a.multiply(factor(n - 1));
    }

    //функция должна вводить числа из in до тех пор пока не будет введен 0
    //и вывести в out все числа в обратном порядке без 0
    void reverse(Scanner in, PrintWriter out){
        //TODO
        int x = in.nextInt();
        if (x == 0) {
            return;
        }
        reverse(in, out);
        out.print(x + " ");
    }

    //функция должна отсортировать массив слиянием
    ArrayList<Integer> mergeSort(ArrayList<Integer> list){
        //TODO
        if (list.size() <= 1) {
            return list;
        }
        Pair<ArrayList<Integer>, ArrayList<Integer>> splitList = split(list);
        ArrayList<Integer> left = splitList.getKey();
        ArrayList<Integer> right = splitList.getValue();
        return merge(mergeSort(left), mergeSort(right));
    }

    //функция должна разбить список пополам (2 2 для 4 или 3 2 для 5)
    Pair<ArrayList<Integer>, ArrayList<Integer>> split(ArrayList<Integer> list){
        //TODO
        int m;
        if (list.size() % 2 == 0) {
            m = list.size() / 2;
        } else {
            m = list.size() / 2 + 1;
        }
        ArrayList<Integer> splRight = new ArrayList<>();
        ArrayList<Integer> splLeft = new ArrayList<>();
        int count = 0;
        for (Integer aList : list) {
            if (count < m) {
                splLeft.add(aList);
            } else {
                splRight.add(aList);
            }
            count++;
        }
        return new Pair <>(splLeft, splRight);
    }

    //функция должна вернуть отсортированный список, сливаемый из двух отсортированных
    ArrayList<Integer> merge(ArrayList<Integer> left, ArrayList<Integer> right){
        //TODO
        ArrayList<Integer> mergeArray = new ArrayList <>();
        int i = 0, j = 0;
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                mergeArray.add(left.get(i));
                i++;
            } else {
                mergeArray.add(right.get(j));
                j++;
            }
        }
        while (i < left.size()) {
            mergeArray.add(left.get(i));
            i++;
        }
        while (j < right.size()) {
            mergeArray.add(right.get(j));
            j++;
        }
        return mergeArray;
    }

    private static boolean [] used = new boolean[1000];
    private static  int count = 0;

    //функция должна вернуть К-ую перестановку n-элементного множества
    //уникальных целых чисел дата
    int [] permutation(int [] data, int n, int k, int index, PrintWriter out) {
        //TODO
        if (index == n) {
            count++;
            if (count == k) {
                for (int aData : data) {
                    out.print(aData + " ");
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (used[i + 1]) continue;
            data[index] = i + 1;
            used[i + 1] = true;
            permutation(data, n, k, index + 1, out);
            used[i + 1] = false;
        }
        return data;
    }

    //функция должна вернуть максимальную массу из предметов в дата, но не превышающую
    //лимит
    long knackPack(int [] data, long limit){
        return knackPack(data, limit, 0, 0);
    }

    private long knackPack(int [] data, long limit, long start, int index){
        //TODO
        if (limit < 0) {
            return Long.MIN_VALUE;
        }
        if (index == data.length) {
            return start;
        }
        return Math.max(knackPack(data, limit - data[index], start + data[index], index + 1),
                knackPack(data, limit, start, index + 1));
    }
}
