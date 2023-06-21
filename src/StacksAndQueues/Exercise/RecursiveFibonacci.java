package StacksAndQueues.Exercise;
import java.util.Scanner;

public class RecursiveFibonacci {
    private static long[] memory;
    //MEMOIZATION
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory=new long[n+1];
        long res = fib(n);
        System.out.println(res);
    }

    private static long fib(int n) {
        // ДЪНО
        if (n < 2) {
            return 1;
        }

        // MEMOIZATION
        if (memory[n]!=0){
            return memory[n];
        }
        memory[n] = fib(n - 1) + fib(n - 2);

        return memory[n];
    }


}
