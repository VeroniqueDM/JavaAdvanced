package MultidimensionalArrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] newLine = scanner.nextLine().split("\\s+");
            matrix[row] = newLine;
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split("\\s+");
            String keyword = tokens[0];
            if (!keyword.equals("swap") || tokens.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int oldRow = Integer.parseInt(tokens[1]);
            int oldCol = Integer.parseInt(tokens[2]);
            int newRow = Integer.parseInt(tokens[3]);
            int newCol = Integer.parseInt(tokens[4]);
            if (checkCoordinates(oldRow, oldCol, newCol, newRow, rows, cols)) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            String oldValue = matrix[oldRow][oldCol];
            String newValue = matrix[newRow][newCol];
            matrix[oldRow][oldCol] = newValue;
            matrix[newRow][newCol] =oldValue;
            printMatrix(matrix);
            command = scanner.nextLine();
        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean checkCoordinates(int oldRow, int oldCol, int newCol, int newRow, int rows, int cols) {
        return (oldRow < 0 || oldRow >= rows || oldCol < 0 || oldCol >= cols || newRow < 0 || newRow >= rows || newCol < 0 || newCol >= cols);
    }
}
