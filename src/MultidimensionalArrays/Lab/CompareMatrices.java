package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatrixInfo = scanner.nextLine().split(" ");
        int rowsMatrixOne = Integer.parseInt(firstMatrixInfo[0]);
        int colsMatrixOne = Integer.parseInt(firstMatrixInfo[1]);
        String[][] firstMatrix = new String[rowsMatrixOne][colsMatrixOne];
        for (int i = 0; i < rowsMatrixOne; i++) {
            String[] newLine = scanner.nextLine().split(" ");
            firstMatrix[i] = newLine;
        }

        String[] secondMatrixInfo = scanner.nextLine().split(" ");
        int rowsMatrixTwo = Integer.parseInt(secondMatrixInfo[0]);
        int colsMatrixTwo = Integer.parseInt(secondMatrixInfo[1]);
        String[][] secondMatrix = new String[rowsMatrixTwo][colsMatrixTwo];
        for (int i = 0; i < rowsMatrixTwo; i++) {
            String[] newLine = scanner.nextLine().split(" ");
            secondMatrix[i] = newLine;
        }

        if (rowsMatrixOne!=rowsMatrixTwo || colsMatrixTwo!=colsMatrixOne) {
            System.out.println("not equal");
        } else {
            isEqual(colsMatrixOne,rowsMatrixTwo,  firstMatrix, secondMatrix);
        }

    }

    private static void isEqual(int colsMatrixOne,int rowsMatrixTwo, String[][] firstMatrix,  String[][] secondMatrix) {
        boolean isEqual = true;
        for (int i = 0; i < rowsMatrixTwo; i++) {
            for (int j = 0; j < colsMatrixOne; j++) {
                if (!firstMatrix[i][j].equals(secondMatrix[i][j])){
                    isEqual=false;
                    break;
                }
            }
        }
        if (isEqual) {
            System.out.println("equal");
        }else {
            System.out.println("not equal");
        }
    }

}
