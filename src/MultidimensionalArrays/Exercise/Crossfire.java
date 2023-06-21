package MultidimensionalArrays.Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Crossfire {
    private static int rows, cols;
    private static List<List<Integer>> matrix;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] dimensions = reader.readLine().split(" ");
        rows = Integer.parseInt(dimensions[0]);
        cols = Integer.parseInt(dimensions[1]);

        int counter = 1;
        matrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }

        String input;

        while (!"Nuke it from orbit".equals(input = reader.readLine())) {
            String[] tokens = input.split(" ");
            int targetRow = Integer.parseInt(tokens[0]);
            int targetCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            int rowStart = Math.max(0, targetRow - radius);
            int rowEnd = Math.min(rows - 1, targetRow + radius);
            int colStart = Math.max(0, targetCol - radius);
            int colEnd = Math.min(cols - 1, targetCol + radius);

            for (int col = colStart; col <= colEnd; col++) {
                if (inRange(targetRow, col)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            for (int row = rowStart; row <= rowEnd; row++) {
                if (inRange(row, targetCol)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            matrix.forEach(row -> row.removeIf(value -> value == 0));
            matrix.removeIf(List::isEmpty);
        }
        System.out.println(getMatrixString());

    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (List<Integer> row : matrix) {
            output.append(row.toString().replaceAll("[\\[\\],]", ""));
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

    private static boolean inRange(int row, int col) {
        return row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size();
    }
}



//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Crossfire {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
//        int rows = dimensions[0];
//        int cols = dimensions[1];
//        List<List<Integer>> matrix = new ArrayList<>();
//        int num = 1;
//        for (int row = 0; row < rows; row++) {
//            List<Integer> rowList = new ArrayList<>();
//            for (int col = 0; col < cols; col++) {
//                rowList.add(num++);
//
//            }
//            matrix.add(rowList);
//        }
//
//        String command = scanner.nextLine();
//
//        while (!command.equals("Nuke it from orbit")) {
//            int[] tokens = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
//            int row = tokens[0];
//            int col = tokens[1];
//            int radius = tokens[2];
//            crossfire(matrix, row, col, radius);
//            System.out.println();
//
//
//            command = scanner.nextLine();
//        }
//        printMatrix(matrix);
//    }
//
//    private static void crossfire(List<List<Integer>> matrix, int row, int col, int radius) {
//
//        fireUp(matrix, row, col, radius);
//        fireDown(matrix, row, col, radius);
//        fireHorizontally(matrix, row, col, radius);
////        fireLeft(matrix,row,col,radius);
////
////        fireRight(matrix,row,col,radius);
//
//
//    }
//
//    private static void fireHorizontally(List<List<Integer>> matrix, int row, int col, int radius) {
//        if (matrix.get(row).size()>0){
//            int limitLeft = Math.max(col - radius, 0);
//            int limitRight = col + radius < matrix.get(row).size() ? col + radius : matrix.get(row).size() - 1;
//            matrix.get(row).subList(limitLeft, limitRight + 1).clear();
//        }
//
//
//    }
//
////    private static void fireRight(List<List<Integer>> matrix, int row, int col, int radius) {
////        int limit = col + radius<matrix.get(row).size() ? col + radius : matrix.get(row).size()-1;
////        matrix.get(row).subList(col,limit+1).clear();
//////        list.subList(4, 9).clear();
//////
//////        for (int i = col; i <= limit; i++) {
//////            matrix.get(radius).remove(i);
//////        }
////    }
////
////    private static void fireLeft(List<List<Integer>> matrix, int row, int col, int radius) {
////        int limit = Math.max(col - radius, 0);
////        matrix.get(row).subList(limit,col).clear();
//////        for (int i = limit; i >= col; i++) {
//////            matrix.get(row).remove(i);
//////        }
////    }
//
//    private static void fireDown(List<List<Integer>> matrix, int row, int col, int radius) {
//        int limit = row + radius < matrix.size() ? col + radius : matrix.size() - 1;
//
//        for (int i = row + 1; i <= limit; i++) {
//            if (col < matrix.get(row).size()) {
//                matrix.get(i).remove(col);
//            }
//
//        }
//    }
//
//    private static void fireUp(List<List<Integer>> matrix, int row, int col, int radius) {
//        int beginning = Math.max(row - radius, 0);
//        for (int currentRow = beginning; currentRow < row; currentRow++) {
//            if (col < matrix.get(currentRow).size()) {
//                matrix.get(currentRow).remove(col);
//            }
//        }
//    }
//
//    private static void printMatrix(List<List<Integer>> matrix) {
//        for (int row = 0; row < matrix.size(); row++) {
//            for (int col = 0; col < matrix.get(row).size(); col++) {
//                System.out.print(matrix.get(row).get(col) + " ");
//            }
//            System.out.println();
//        }
//    }
//
//}
