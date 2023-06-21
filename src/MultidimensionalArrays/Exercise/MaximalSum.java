package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixInfo = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixInfo[0]);
        int cols = Integer.parseInt(matrixInfo[1]);
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] newLine = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            matrix[row] = newLine;
        }
        int maxSum = Integer.MIN_VALUE;
        int maxRowIndex = 0;
        int maxColIndex = 0;
        for (int row = 0; row < rows-2; row++) {
            for (int col = 0; col < cols-2; col++) {
                int sum = matrix[row][col] +  matrix[row][col+1]+  matrix[row][col+2] +  matrix[row+1][col] +  matrix[row+1][col+1]+  matrix[row+1][col+2]
                        + matrix[row+2][col]+  matrix[row+2][col+1]+  matrix[row+2][col+2];
                if (sum>maxSum){
                    maxSum = sum;
                    maxRowIndex =row;
                    maxColIndex = col;
                }
            }
        }
        System.out.println("Sum = "+maxSum);
        for (int row = maxRowIndex; row <maxRowIndex+3 ; row++) {
            for (int col = maxColIndex; col <maxColIndex+3 ; col++) {
                System.out.printf("%d ",matrix[row][col]);
            }
            System.out.println();
        }
    }
}
