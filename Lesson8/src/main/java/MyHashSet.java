public class MyHashSet<T> {

    private int size, hashMod;
    private Node<T> [] table;

    public MyHashSet() {
        size = 0;
        hashMod = genNextPrime(10);
        table = (Node<T>[]) new Object[hashMod];
    }

    public int size(){
        //TODO
        return size;
    }

    public void add(T value){
        //TODO
    }

    public void remove(T value){
        //TODO
    }

    public boolean contains(T value){
        //TODO
        return false;
    }

    //можно использовать хеш объекта
    private int hash(T value){
        //TODO
        return 0;
    }

    private double quality(){
        return (double)size / table.length;
    }

    private void rehash(){
        if(quality() > 2) {
            //TODO
            hashMod = genNextPrime(2 * hashMod);
        }
    }

    private int genNextPrime(int n){
        for (int i = n + 1; i > 0; i++) {
            if(isPrime(i)) return i;
        }
        return n;
    }

    //проверяет простое число или нет
    //простое - это число которое делится
    //только на себя или на 1
    private boolean isPrime(int n) {
        //TODO
        boolean res = false;
        for (int i = 2; i < n; i++) {
            res = n % i != 0;
        }
        return res;
    }
}
