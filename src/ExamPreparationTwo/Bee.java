package ExamPreparationTwo;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        int beeRow = -1;
        int beeCol = -1;
        for (int row = 0; row < n; row++) {
            String[] newRow = scanner.nextLine().split("");
            matrix[row] = newRow;
            for (int col = 0; col < n; col++) {
                if (newRow[col].equals("B")) {
                    beeRow = row;
                    beeCol = col;
                    matrix[row][col] = ".";
                }
            }
        }
        boolean isOut = false;
        int pollinatedFlowers = 0;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (command.equals("up")) {
                if (!isWithinBounds(beeRow - 1, n)) {
                    isOut = true;
                    break;
                } else {
                    beeRow--;
                }
            } else if (command.equals("down")) {
                if (!isWithinBounds(beeRow + 1, n)) {
                    isOut = true;
                    break;
                } else {
                    beeRow++;
                }
            } else if (command.equals("left")) {
                if (!isWithinBounds(beeCol - 1, n)) {
                    isOut = true;
                    break;
                } else {
                    beeCol--;
                }
            } else if (command.equals("right")) {
                if (!isWithinBounds(beeCol + 1, n)) {
                    isOut = true;
                    break;
                } else {
                    beeCol++;
                }
            }
            if (matrix[beeRow][beeCol].equals("f")) {
                pollinatedFlowers++;
                matrix[beeRow][beeCol] = ".";
            } else if (matrix[beeRow][beeCol].equals("O")){
                matrix[beeRow][beeCol] = ".";
                continue;
            }

            command = scanner.nextLine();
        }
        if (isOut) {
            System.out.println("The bee got lost!");
        } if (pollinatedFlowers>=5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5-pollinatedFlowers);
        }
        if (!isOut) {
            matrix[beeRow][beeCol] = "B";
        }
        printMatrix(matrix,n);
    }

    private static void printMatrix(String[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isWithinBounds(int i, int n) {
        if (i >= 0 && i < n) {
            return true;
        }
        return false;
    }
}
