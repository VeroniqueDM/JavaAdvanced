package DefiningClasses.Exercise;

import java.util.Scanner;

public class BlindMansBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimensions = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(dimensions[0]);
        int cols = Integer.parseInt(dimensions[1]);

        String[][] field = new String[rows][cols];


        for (int row = 0; row < rows; row++) {
            String[] newLine = scanner.nextLine().split("\\s+");
            field[row] = newLine;
        }
        int indRow = -1;
        int indCol = -1;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if (field[row][col].equals("B")) {
                    indRow = row;
                    indCol = col;
                    break;
                }
            }
        }
        String direction = scanner.nextLine();
        boolean isEnough = false;
        int moves = 0;
        int playersTouched = 0;

        while (!direction.equals("Finish")) {
            moves++;
            if (direction.equals("up")) {
                indRow--;
                if (indRow < 0 || field[indRow][indCol].equals("O")) {
                    moves--;
                    indRow++;
                }
            } else if (direction.equals("down")) {
                indRow++;
                if (indRow > rows - 1 || field[indRow][indCol].equals("O")) {
                    moves--;
                    indRow--;
                }
            } else if (direction.equals("left")) {
                indCol--;
                if (indCol < 0 || field[indRow][indCol].equals("O")) {
                    moves--;
                    indCol++;
                }
            } else if (direction.equals("right")) {
                indCol++;
                if (indCol > cols - 1 || field[indRow][indCol].equals("O")) {
                    moves--;
                    indCol--;
                }
            }
            String symbol = field[indRow][indCol];
            if (symbol.equals("P")) {
                playersTouched++;
                field[indRow][indCol] = "-";
                if (playersTouched >= 3) {
                    isEnough = true;
                    break;
                }
            }
            direction = scanner.nextLine();
        }
        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d",playersTouched,moves);
    }
}
