import java.util.*;
import java.io.*;

public class WriteToFile {
    //Receive fileName and create a new file using that name [This may be an unnecessary function]
    public void createFile(String fileName) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        bw.close();
    }

    public void writeFile(String fileName, String line) throws Exception{
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true));
        bw.append(line);
        bw.append("\n"); // Add in next line since this is code that should be the input
        bw.close();
    }
    
    // For testing purposes
    public static void main(String[] args) throws Exception {
        // new WriteToFile().createFile("output.txt"); // test it doesn't look like I need to create a file in its own function
        new WriteToFile().writeFile("output.txt", "Hello"); // test
        new WriteToFile().writeFile("output.txt", "\n"); // test
        new WriteToFile().writeFile("output.txt" ,"World!"); // test
        new WriteToFile().writeFile("output.txt", "\n"); // test
    }
}