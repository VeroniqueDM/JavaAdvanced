package FunctionalProgramming.Lab;

import java.util.Scanner;

public class TheSquirrel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] directions = scanner.nextLine().split(",\\s+");
        String[][] field = new String[size][size];


        for (int row = 0; row < size; row++) {
            String[] newLine = scanner.nextLine().split("");
            field[row] = newLine;
        }
        int indRow = -1;
        int indCol = -1;
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field.length; col++) {
                if (field[row][col].equals("s")) {
                    indRow = row;
                    indCol = col;
                    break;
                }
            }
        }
        boolean isEnough = false;
        boolean isTrapped = false;
        boolean isOut = false;
        int hazelnuts = 0;

        for (String direction :
                directions) {
            if (direction.equals("up")) {
                indRow--;
            } else if (direction.equals("down")) {
                indRow++;
            } else if (direction.equals("left")) {
                indCol--;
            } else if (direction.equals("right")) {
                indCol++;
            }
            if (indRow<0 || indRow>size-1 || indCol<0 || indCol>size-1) {
                isOut = true;
                break;
            }
            String symbol = field[indRow][indCol];
            if (symbol.equals("h")){
                hazelnuts++;
                field[indRow][indCol] = "*";
                if (hazelnuts>=3) {
                    isEnough=true;
                    break;
                }
            } else if (symbol.equals("t")){
                isTrapped=true;
                break;
            }
        }
        if (isOut) {
            System.out.println("The squirrel is out of the field.");
        }else if (isTrapped) {
            System.out.println("Unfortunately, the squirrel stepped on a trap...");
        } else if (isEnough) {
            System.out.println("Good job! You have collected all hazelnuts!");
        }  else {
            System.out.println("There are more hazelnuts to collect.");
        }
        System.out.println("Hazelnuts collected: " + hazelnuts);
    }
}
