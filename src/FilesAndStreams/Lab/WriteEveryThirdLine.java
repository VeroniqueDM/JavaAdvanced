package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws FileNotFoundException {

        String path = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWire = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(pathWire);

        Scanner reader = new Scanner(inputStream);
        PrintWriter writer = new PrintWriter(outputStream);

        int count = 1;
        String line = reader.nextLine();

        while (reader.hasNextLine()) {
            if (count%3==0) {
                writer.println(line);
            }

            count++;
            line = reader.nextLine();
        }






    }
}
