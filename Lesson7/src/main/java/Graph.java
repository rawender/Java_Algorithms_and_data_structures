import java.util.Scanner;

public class Graph {

    //Функция должна вернуть количество
    //знакомых у самого популярного человека
    //знакомые это друзья и друзья друзей в глубину
    //до бесконечности)))
    //самый популярный человек - это человек у
    //которого больше всего знакомых
    static int friendCounter(Scanner in){
        int n = in.nextInt(); // количество людей
        int m = in.nextInt();//количество пар связей
        //далее следуют м пар значений
        for (int i = 0; i < m; i++) {
            int from = in.nextInt(), to = in.nextInt();
            //TODO
        }
        //TODO
        return 0;
    }

    static int travelingSalesman(Scanner in){
        int n = in.nextInt();
        int [][] m = new int[n][n];//matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                m[i][j] = in.nextInt();
            }
        }
        //TODO
        return 0;
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
        return null;
    }
}
