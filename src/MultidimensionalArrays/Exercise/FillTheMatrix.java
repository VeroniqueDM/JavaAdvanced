package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command = scanner.nextLine().split(", ");
        int size = Integer.parseInt(command[0]);
        String pattern = command[1];
        int num = 1;

        int[][] matrix = applyPattern(size, new int[size][size], num, pattern);

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }
    }

    private static int[][] applyPattern(int size, int[][] matrix, int num, String pattern) {
        if (pattern.equals("A")) {
            for (int col = 0; col < size; col++) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            }
            return matrix;
        } else {
            int loopCount = 0;
            for (int col = 0; col < size; col++) {
                if (loopCount % 2 == 0) {
                    for (int row = 0; row < size; row++) {
                        matrix[row][col] = num;
                        num++;
                    }
                } else {
                    for (int row = size - 1; row >= 0; row--) {
                        matrix[row][col] = num;
                        num++;
                    }
                }
                loopCount++;
            }
            return matrix;
        }
    }
}
