package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws FileNotFoundException {

        String pathRead = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = new FileInputStream(pathRead);

        Scanner scanner = new Scanner(inputStream);

 // IF WE WANT TO WRITE THE OUTPUT TO A FILE:
//
//        String pathWire = "..." ;
//        FileOutputStream outputStream = new FileOutputStream(pathWire);
//        PrintWriter writer = new PrintWriter(outputStream);

         while (scanner.hasNext()){
            if(scanner.hasNextInt()) {
                int num = scanner.nextInt();
                System.out.println(num);

                // WRITING TO A FILE:

//                writer.println(num);
            }
            scanner.next();
        }
//        writer.close();
    }
}
