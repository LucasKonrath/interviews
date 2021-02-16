package dynamicProgramming;

import java.util.HashMap;

public class Fibonacci {

    public int fib(int n){

        HashMap<Integer, Integer> fibSequence = new HashMap<>();

        fibSequence.put(0, 0);
        fibSequence.put(1, 1);
        fibSequence.put(2, 1);

        if(n < 3){
            return fibSequence.get(n);
        }

        for(int i = 3; i <= n; i++){
            fibSequence.put(i, fibSequence.get(i - 1) + fibSequence.get(i - 2));
        }

        return fibSequence.get(n);
    }

    public int fibRecursive(int n){
        if(n == 0){
            return 0;
        } else if(n <= 2){
            return 1;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public static void main(String[] args) {
        Fibonacci fib = new Fibonacci();
        System.out.println(fib.fib(3));
        System.out.println(fib.fibRecursive(3));
    }

}
