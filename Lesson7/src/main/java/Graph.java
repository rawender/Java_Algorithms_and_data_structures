import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Graph {

    private static int count = 0;
    private static int minWay = 0;
    private static int [] minPath;
    private static boolean [] vertexUsed = new boolean [1000];
    //Функция должна вернуть количество
    //знакомых у самого популярного человека
    //знакомые это друзья и друзья друзей в глубину
    //до бесконечности)))
    //самый популярный человек - это человек у
    //которого больше всего знакомых
    static int friendCounter(Scanner in){
        int n = in.nextInt(); //количество людей
        int m = in.nextInt(); //количество пар связей
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<Integer>());
        }
        //далее следуют м пар значений
        for (int i = 0; i < m; i++) {
            int from = in.nextInt(), to = in.nextInt();
            //TODO
            list.get(from - 1).add(to - 1);
            list.get(to - 1).add(from - 1);
        }
        //TODO
        boolean [] used = new boolean[n];
        int frCount = 0;
        for (int i = 0; i < n; i++) {
            used[i] = true;
            count++;
            for (Integer index : list.get(i)) {
                dfs(index, list, used);
            }
            for (int j = 0; j < n; j++) {
                used[j] = false;
            }
            if (frCount < count) {
                frCount = count;
            }
            count = 0;
        }
        return frCount;
    }

    private static void dfs(int vertex, ArrayList<ArrayList<Integer>> list, boolean [] used) {
        if (!used[vertex]) {
            used[vertex] = true;
            count++;
            for (Integer v : list.get(vertex)) {
                dfs(v, list, used);
            }
        }
    }

    static int travelingSalesman(Scanner in) {
        int n = in.nextInt();
        int[][] m = new int[n][n];//matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        //TODO
        int[] arr = new int[m.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        perm(arr, m, 1);
        return minWay;
    }

    //вернуть путь с минимальным вторым городом
    //путь должен состоять из n чисел
    static int [] travelingSalesmanWay(Scanner in){
        int n = in.nextInt();
        int [][] m = new int[n][n];//matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        //TODO
        int[] arr = new int[m.length];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = i;
        }
        perm(arr, m, 1);
        return minPath;
    }

    private static void swap(int [] arr, int i, int j) {
        int a = arr[i];
        arr[i] = arr[j];
        arr[j] = a;
    }

    private static int dist(int [] arr, int [][] matrix) {
        int d = matrix[0][arr[0]] + matrix[arr[arr.length - 1]][0];
        for (int i = 1; i < arr.length; i++) {
            d += matrix[arr[i - 1]][arr[i]];
        }
        return d;
    }

    private static void perm(int [] arr, int [][] matrix, int lf) {
        if (lf >= arr.length) {
            return;
        }
        int way = dist(arr, matrix);
        if (lf == 1) {
            minWay = way;
            minPath = Arrays.copyOf(arr, arr.length);
        } else {
            if (way < minWay) {
                minWay = way;
                minPath = Arrays.copyOf(arr, arr.length);
            }
        }
        for (int i = lf + 1; i < arr.length; i++) {
            if (vertexUsed[i + 1]) {
                continue;
            }
            swap(arr, lf, i);
            vertexUsed[i + 1] = true;
            perm(arr, matrix,lf + 1);
            vertexUsed[i + 1] = false;
        }
    }
}
