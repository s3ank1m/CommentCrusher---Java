import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class CommentCrusher {
    // Returns true or false if file exists or not
    public boolean fileExists(String userFile) {
        System.out.println("Test: fileExists() hit!"); // test
        boolean fileExists;
        
        File f = new File(userFile);

        // Check if file exists
        if(f.exists() && !f.isDirectory()) {
            System.out.println("Test: file exists!"); // test
            fileExists = true;
        }
        else {
            System.out.println("Test: no file exists!"); // test
            fileExists = false;
        }

        return fileExists; // temp replace this 
    }

    public void driver() throws Exception{
        System.out.println("Test: Driver Accessed!"); // test
        String fileName, outputFile;
        Scanner s = new Scanner(System.in);

        // Read in file name input from user
        System.out.println("Select file to use");
        System.out.print("> ");
        fileName = s.nextLine();
        System.out.println("Enter output file name:");
        System.out.print("> ");
        outputFile = s.nextLine();

        s.close();

        System.out.println("Test: " + fileName); // test

        // Check if file exists
        if(fileExists(fileName)) {
            // Looks for single line comments and deletes them
            System.out.println("File '" + fileName + "' Found!");
            System.out.println(new RemoveSingle().readRemove(fileName, outputFile)); // Test-ish output
        }
        else {
            System.out.println("File not found. Exiting...");
            System.exit(0); // Terminate program if a file is not found
        }
    }

    public static void main(String[] args) throws Exception{
        System.out.println("Hello World. This is only a test"); // test

        // Run driver to keep main as clean as possible
        new CommentCrusher().driver(); // This is how to run non static function
    }
}