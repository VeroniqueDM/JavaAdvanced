package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream fileStream =
                new FileInputStream(path);

        int currentByte = fileStream.read();
        while (currentByte >= 0) {
            System.out.print(Integer.toBinaryString(currentByte)+ " ");
//            System.out.print((char) currentByte);
            currentByte = fileStream.read();
        }
        fileStream.close();
    }
}
