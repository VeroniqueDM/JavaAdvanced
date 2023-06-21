package FilesAndStreams.Lab;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);


//        String path = "C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\FilesAndStreams\\Lab\\input.txt";
//        FileInputStream fileStream =
//                new FileInputStream(path);
//        Scanner reader = new Scanner(fileStream);
//        String firstRow =scanner.nextLine();
//        int oneByte = fileStream.read();
//        while (oneByte >= 0) {
//            System.out.print(oneByte);
//            oneByte = fileStream.read();
//        }
//        fileStream.close();


        Path inPath = Paths.get("C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");
        Path outPath = Paths.get("C:\\Users\\Veronique\\IdeaProjects\\JavaAdvanced\\src\\Java-Advanced-Files-and-Streams-Lab-Resources\\05.WriteEveryThirdLineOutput.txt");
        List<String> lines  = Files.readAllLines(inPath);

        for (String line :
                lines) {
            System.out.println(line);
        }

        Files.write(outPath,lines);
//        Returns -1 if
//        empty

//        InputStream in = null;
//        try {
//            in = new FileInputStream(path);
//        } catch (IOException e) {
//// TODO: handle exception
//        } finally {
//            if (in != null) {
//                in.close();
//            }
//        }

    }
}
