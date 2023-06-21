package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWire = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream(pathWire);

        int currentByte = inputStream.read();
        while (currentByte>=0){
            char currentSymbol = (char) currentByte;
            if (currentSymbol != '.' && currentSymbol!=','&& currentSymbol!='!' && currentSymbol!='?'){
                outputStream.write(currentSymbol);
            }
            currentByte = inputStream.read();
        }
        inputStream.close();
        outputStream.close();
    }
}
