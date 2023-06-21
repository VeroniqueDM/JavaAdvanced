package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] matrix = new String[n][n];

        for (int i = 0; i < n; i++) {
            String[] newLine = scanner.nextLine().split(" ");
            matrix[i] = newLine;
        }
        String firstDiagonal = "";
        for (int row = 0; row < n; row++) {
            firstDiagonal += matrix[row][row] + " ";
        }
        String secondDiagonal = "";
        int col = 0;
        for (int row = n-1; row >=0 ; row--) {
                secondDiagonal += matrix[row][col] + " ";
                col++;

        }
        System.out.println(firstDiagonal);
        System.out.println(secondDiagonal);


    }
}
