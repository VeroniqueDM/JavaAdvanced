package MultidimensionalArrays.Lab;

import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] matrixInfo = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(matrixInfo[0]);
        int columns = Integer.parseInt(matrixInfo[0]);
        String[][] matrix = new String[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] newLine= scanner.nextLine().split(" ");
            matrix[i] = newLine;
        }
        String n = scanner.nextLine();
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals(n)) {
                    if (!isFound){
                        isFound=true;
                    }
                    System.out.println(i + " " + j);
                }
            }
        }
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
