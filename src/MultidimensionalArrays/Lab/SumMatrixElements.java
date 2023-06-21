package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixInfo = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] newLine = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = newLine;
        }

        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
