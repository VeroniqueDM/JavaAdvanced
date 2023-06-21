import java.util.ArrayDeque;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
//        stack.push(13);
//        stack.push(16);
//        stack.push(1345);
        stack.add(12);
        stack.add(143);
        stack.add(56);
        stack.add(357);
        System.out.println(stack);
        stack.pop();
        System.out.println(stack);

//        while (!stack.isEmpty()) {
//            int topElement = stack.pop();
//            System.out.println(topElement);
//        }
    }
}
