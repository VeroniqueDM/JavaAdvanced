package ExamPreparationOne;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> word = Arrays.stream(scanner.nextLine().split("")).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        int playerRow = -1;
        int playerCol = -1;
        for (int row = 0; row < n; row++) {
            String[] newRow = scanner.nextLine().strip().split("");
            matrix[row] = newRow;
            for (int col = 0; col < n; col++) {
                if (newRow[col].equals("P")) {
                    playerCol = col;
                    playerRow = row;
                    matrix[row][col] = "-";
                }
            }
        }

        String command = scanner.nextLine().strip();

        while (!command.equals("end")) {
            if (command.equals("up")) {
                if (!isWithinBounds(playerRow - 1, n)) {
                    removeLastLetter(word);
                    command = scanner.nextLine();
                    continue;
                } else {
                    playerRow--;
                }
            } else if (command.equals("down")) {
                if (!isWithinBounds(playerRow + 1, n)) {
                    removeLastLetter(word);
                    command = scanner.nextLine();
                    continue;
                } else {
                    playerRow++;
                }
            } else if (command.equals("left")) {
                if (!isWithinBounds(playerCol - 1, n)) {
                    removeLastLetter(word);
                    command = scanner.nextLine();
                    continue;
                } else {
                    playerCol--;
                }
            } else if (command.equals("right")) {
                if (!isWithinBounds(playerCol + 1, n)) {
                    removeLastLetter(word);
                    command = scanner.nextLine();
                    continue;
                } else {
                    playerCol++;
                }
            }
//            switch (command) {
//                case "up" -> {
//                    if (!isWithinBounds(playerRow - 1, n)) {
//                        removeLastLetter(word);
//                        command = scanner.nextLine();
//                        continue;
//                    } else {
//                        playerRow--;
//                    }
//                }
//                case "down" -> {
//                    if (!isWithinBounds(playerRow + 1, n)) {
//                        removeLastLetter(word);
//                        command = scanner.nextLine();
//                        continue;
//                    } else {
//                        playerRow++;
//                    }
//                }
//                case "left" -> {
//                    if (!isWithinBounds(playerCol - 1, n)) {
//                        removeLastLetter(word);
//                        command = scanner.nextLine();
//                        continue;
//                    } else {
//                        playerCol--;
//                    }
//                }
//                case "right" -> {
//                    if (!isWithinBounds(playerCol + 1, n)) {
//                        removeLastLetter(word);
//                        command = scanner.nextLine();
//                        continue;
//                    } else {
//                        playerCol++;
//                    }
//                }
//            }
            if (matrix[playerRow][playerCol].equals("-")) {
                command = scanner.nextLine().strip();
                continue;
            } else {
                word.add(matrix[playerRow][playerCol]);
                matrix[playerRow][playerCol] = "-";
            }

            command = scanner.nextLine().strip();
        }
        System.out.println(String.join("", word));
        matrix[playerRow][playerCol] = "P";
        printMatrix(matrix,n);
//        for (int row = 0; row < n; row++) {
//            for (int col = 0; col < n; col++) {
//                System.out.print(matrix[row][col]);
//            }
//            System.out.println();
//        }
    }

    private static void printMatrix(String[][] matrix, int n) {
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

    private static void removeLastLetter(List<String> word) {
        if (word.size() > 0) {
            word.remove(word.size() - 1);
        }
    }

    private static boolean isWithinBounds(int i, int n) {
        if (i >= 0 && i < n) {
            return true;
        }
        return false;
    }


}
