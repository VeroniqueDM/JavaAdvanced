package Exam;

import java.util.Arrays;
import java.util.Scanner;

public class MouseInTheKitchen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        String[][] matrix = new String[rows][cols];
        int currentRow = -1;
        int currentCol = -1;
        int totalCheese = 0;
        for (int row = 0; row < rows; row++) {
            String[] newLine = scanner.nextLine().split("");
            matrix[row] = newLine;
            for (int col = 0; col < cols; col++) {
                if (newLine[col].equals("M")) {
                    currentRow = row;
                    currentCol = col;
                    matrix[row][col] = "*";
                } else if (newLine[col].equals("C")) {
                    totalCheese++;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isOutside = false;
        boolean happyMouse = false;
        boolean isTrapped = false;
        while (!command.equals("danger")) {
            if (command.equals("up")) {
                currentRow--;
                if (!validatePosition(currentRow, currentCol, matrix)) {
                    currentRow++;
                    isOutside = true;
                    break;
                }
                if (matrix[currentRow][currentCol].equals("@")){
                    currentRow++;
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("down")) {
                currentRow++;
                if (!validatePosition(currentRow, currentCol, matrix)) {
                    currentRow--;
                    isOutside = true;
                    break;
                }
                if (matrix[currentRow][currentCol].equals("@")){
                    currentRow--;
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("left")) {
                currentCol--;
                if (!validatePosition(currentRow, currentCol, matrix)) {
                    currentCol++;
                    isOutside = true;
                    break;
                }
                if (matrix[currentRow][currentCol].equals("@")){
                    currentCol++;
                    command = scanner.nextLine();
                    continue;
                }
            } else if (command.equals("right")) {
                currentCol++;
                if (!validatePosition(currentRow, currentCol, matrix)) {
                    currentCol--;
                    isOutside = true;
                    break;
                }
                if (matrix[currentRow][currentCol].equals("@")){
                    currentCol--;
                    command = scanner.nextLine();
                    continue;
                }
            }
            if (matrix[currentRow][currentCol].equals("C")){
                totalCheese--;
                matrix[currentRow][currentCol] = "*";
                if (totalCheese==0) {
                    happyMouse=true;
                    break;
                }
            } else if (matrix[currentRow][currentCol].equals("T")) {
                matrix[currentRow][currentCol] = "M";
                isTrapped = true;
                break;
            }
            command = scanner.nextLine();
        }
        matrix[currentRow][currentCol] = "M";
        if (isOutside) {
            System.out.println("No more cheese for tonight!");
        } else if (happyMouse) {
            System.out.println("Happy mouse! All the cheese is eaten, good night!");
        } else if (isTrapped) {
            System.out.println("Mouse is trapped!");
        } else {
            System.out.println("Mouse will come back later!");
        }
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s",matrix[row][col]);
            }
            System.out.println();
        }
    }
    private static boolean validatePosition(int currentRow, int currentCol, String[][] matrix) {
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix[currentRow].length;
    }
}
