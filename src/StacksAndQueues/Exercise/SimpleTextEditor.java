package StacksAndQueues.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String textSb = "";
        ArrayDeque<String> textVersions = new ArrayDeque<>();
        textVersions.push(textSb);
        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArr = rawCommand.split(" ");
            String command = commandArr[0];
            if (command.equals("1")) {
                String str = commandArr[1];
                textSb += str;
                textVersions.push(textSb);
            } else if (command.equals("2")) {
                int count = Integer.parseInt(commandArr[1]);
                textSb = textSb.substring(0,textSb.length()-count);
                textVersions.push(textSb);
            } else if (command.equals("3")) {
                int ind = Integer.parseInt(commandArr[1]);
                char res = textSb.charAt(ind-1);
                System.out.println(res);
            } else {
                textVersions.pop();
                textSb = textVersions.peek();
            }
        }
    }
}
