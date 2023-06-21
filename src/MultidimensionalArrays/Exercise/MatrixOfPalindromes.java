package MultidimensionalArrays.Exercise;

import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] info = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(info[0]);
        int cols = Integer.parseInt(info[1]);

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String palindrome = "";
                char firstAndLast = (char) (row+97);
                char middle = (char) (col + row + 97);
                palindrome = String.valueOf(firstAndLast) + middle+ firstAndLast;
                matrix[row][col] = palindrome;
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col]+ " ");
            }
            System.out.println();
        }

    }
}
