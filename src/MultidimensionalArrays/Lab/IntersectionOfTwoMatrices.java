package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] firstMatrix = readMatrix(scanner, rows);
        String[][] secondMatrix = readMatrix(scanner, rows);
        String[][] newMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (!firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    newMatrix[row][col] = "*";
                } else {
                    newMatrix[row][col] = firstMatrix[row][col];
                }
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%s ", newMatrix[row][col]);
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix(Scanner scanner, int rows) {
        String[][] firstMatrix = new String[rows][];
        for (int i = 0; i < rows; i++) {
            String[] newLine = scanner.nextLine().split(" ");
            firstMatrix[i] = newLine;
        }
        return firstMatrix;
    }
}
