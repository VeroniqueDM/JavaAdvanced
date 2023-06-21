package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            int [] newLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = newLine;
        }
        int sumPrimaryDiagonal=0;
        int sumSecondaryDiagonal=0;

        for (int row = 0; row < n; row++) {
            sumPrimaryDiagonal += matrix[row][row];
        }
        int col = n-1;
        for (int row = 0; row < n; row++) {

                sumSecondaryDiagonal+=matrix[row][col];
                col--;
        }

        int res = Math.abs(sumPrimaryDiagonal-sumSecondaryDiagonal);
        System.out.println(res);

    }
}
