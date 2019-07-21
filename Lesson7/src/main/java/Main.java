import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    //друг - есть связь
    //знакомый - друг друга, но не ты
    static String [] names = new String[]{"Ivan", "Oleg",
            "Petr", "Misha", "Aleksey"};

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int m = 1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < m; i++) {
            int from = 1, to = 1;
            list.get(from-1).add(to-1);
            list.get(to-1).add(from-1);
        }
        int cnt = 0;
        for (int i = 0; i < 9; i++) {
            if(!used[i]){
                dfs(i, list);
                cnt++;
            }
        }
        System.out.println(cnt);
        int [][] matrix = new int[][]{
                {1000, 3, 1000, 1, 1000},
                {3, 1000, 70, 1000, 1000},
                {1000, 70, 1000, 15, 1000},
                {1, 1000, 15, 1000, 4},
                {1000, 1000, 1000, 4, 1000}
        };
        floid(matrix);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("%3d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void dfs(int vertex, ArrayList<ArrayList<Integer>> list){
        if(!used[vertex]){
            used[vertex] = true;
            for (Integer v : list.get(vertex)){
                dfs(v, list);
            }
        }
    }

    static void floid(int [][] d){
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length; j++) {
                for (int k = 0; k < d.length; k++) {
                    d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
                }
            }
        }
    }

    static boolean [] used = new boolean[10];
}

