package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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
        int maxSum = Integer.MIN_VALUE;
        int[][] maxMatrix = new int[2][2];
        for (int row = 0; row < rows-1; row++) {
            for (int col = 0; col < cols-1; col++) {
               int sum = matrix[row][col] +  matrix[row][col+1] +  matrix[row+1][col] +  matrix[row+1][col+1];
               if (sum>maxSum){
                   maxSum = sum;
                   maxMatrix[0][0] = matrix[row][col];
                   maxMatrix[0][1] = matrix[row][col+1];
                   maxMatrix[1][0] = matrix[row+1][col];
                   maxMatrix[1][1] = matrix[row+1][col+1];
               }
            }
        }
        for (int row = 0; row < maxMatrix.length; row++) {
            for (int col = 0; col < maxMatrix[row].length; col++) {
                System.out.printf("%d ",maxMatrix[row][col]);
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
