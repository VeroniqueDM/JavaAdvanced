package Generics.Exercise;

import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands= scanner.nextLine().split(",");
        String[][] field = new String[size][size];
        int dRow = -1;
        int dCol = -1;
        for (int i = 0; i < size; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            field[i] = row;
            for (int j = 0; j < size; j++) {
                if (field[i][j].equals("D")) {
                    dRow = i;
                    dCol = j;
                    field[dRow][dCol] = "+";
                }
            }
        }
        int stolenMoney = 0;
        boolean isCaught = false;
        for (int i = 0; i < commands.length; i++) {
            field[dRow][dCol] = "+";
            String command = commands[i];
            if (command.equals("up")) {
                dRow--;
                if(!isValid(dRow,size)){
                    dRow++;
                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;

                }
            } else if (command.equals("down")) {
                dRow++;
                if(!isValid(dRow,size)){
                    dRow--;
                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;

                }
            } else if (command.equals("left")) {
                dCol--;
                if(!isValid(dCol,size)){
                    dCol++;
                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }
            } else if (command.equals("right")) {
                dCol++;
                if(!isValid(dCol,size)){
                    dCol--;
                    System.out.println("You cannot leave the town, there is police outside!");
                    continue;
                }
            }
            if (field[dRow][dCol].equals("$")){
                int stolenValue = dRow*dCol;
                stolenMoney+=stolenValue;
                field[dRow][dCol] = "D";
                System.out.printf("You successfully stole %d$.%n",stolenValue);
            } else if (field[dRow][dCol].equals("P")) {
                isCaught=true;
                field[dRow][dCol] = "#";
                System.out.printf("You got caught with %d$, and you are going to jail.%n",stolenMoney);
                break;
            } else {
                field[dRow][dCol] = "D";
            }
        }
        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n",stolenMoney);
        }
        for (String[] strings : field) {
            System.out.println(String.join(" ",strings));
        }

    }

    private static boolean isValid(int ind, int size) {
        return ind >= 0 && ind < size;
    }
}
