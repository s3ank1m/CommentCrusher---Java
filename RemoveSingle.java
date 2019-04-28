import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class RemoveSingle {
    // Primary class everything revolves around. Scans each line for comments and write each line to the file with comments removed if they exist
    public int readRemove(String userFile) throws Exception {
        String currentLine, writeLine;
        
        File f = new File(userFile);
        Scanner s = new Scanner(f);

        // Read file and store each line into currentLine string and then writes it a new file
        while(s.hasNextLine()) {
            currentLine = s.nextLine();
            System.out.println("Test: " + currentLine + " Length: " + currentLine.length()); // test
            writeLine = searchDestroy(currentLine);
            // Write into the file here
            new WriteToFile().writeFile("output.txt", writeLine);
        }
        
        s.close();

        return 0;
    }

    // Pass through current line and search for single line comments starting with '//'
    public String searchDestroy(String line) throws Exception{
        int commentLocation; // Where the beginning of the comment starts
        String commentRemoved = "";

        System.out.println("line: " + line); // test

        for(int i = 0; i < line.length() - 1; i++) { // line.length - 1 due to possibility of an index out of bound error
            if(line.charAt(i) == '/' && line.charAt(i + 1) == '/') { // Scans line to see where to delete comments
                commentLocation = i; // Mark where the comment begins
                commentRemoved = removeComment(line, commentLocation); // "output.txt" is temporary
                return commentRemoved;
            }
        }

        return line; // case where there exists no comment
    }

    // Accepts line and the location of where the comments start, deletes everything proceeding '//', and returns it as a string
    public String removeComment(String line, int commentLocation) throws Exception{
        System.out.println("removeComment: " + commentLocation + ": " + line); // test
        StringBuilder sb = new StringBuilder(line);

        sb.delete(commentLocation, line.length());

        System.out.println("RemovedComment: " + sb.toString()); // test

        return sb.toString(); // returns the recieved line with comments removed
    }

    // Constructor
    public int removeSingle(String userFile) throws Exception {
        readRemove(userFile);

        return 0;
    } 

    // For testing purposes
    public static void main(String[] args) throws Exception {
        new RemoveSingle().readRemove("test.java"); // test
    }
}