package MultidimensionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotation = Integer.parseInt(scanner.nextLine().split("[()]")[1]);
        int rotations = rotation%360;
        String input = scanner.nextLine();
        List<String> words = new ArrayList<>();
        int cols = 0;

        while (!input.equals("END")) {
            words.add(input);
            if (input.length() > cols) {
                cols = input.length();
            }
            input = scanner.nextLine();
        }

        int rows = words.size();
        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                matrix[i][j] = currentChar;

            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][col] = ' ';
                }
            }
        }

        switch (rotations) {
            case 90:
                matrix = rotate90(matrix, rows, cols);
                break;
            case 180:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix,cols, rows );
                break;
            case 270:
                matrix = rotate90(matrix, rows, cols);
                matrix = rotate90(matrix,cols, rows );
                matrix = rotate90(matrix, rows, cols);
                break;
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.printf("%s",matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static char[][] rotate90(char[][] matrix, int rows, int cols) {
        char[][] rotatedMatrix = new char[cols][rows];
        for (int col = 0; col < cols; col++) {
            int c = 0;
            for (int row = rows-1; row >= 0; row--) {
                rotatedMatrix[col][c++] = matrix[row][col];
            }
        }
        return rotatedMatrix;
    }
}

