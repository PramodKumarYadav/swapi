package projectconfiguration;

import net.bytebuddy.description.field.FieldDescription;
import org.junit.Test;

import java.io.*;

public class FileStaticFunctions {
    public static void canCreateFileAndWriteStringToFile(String filePath, String stringToWrite) throws IOException {
        File PageDatabaseFile =  new File(filePath);
        FileWriter writer = new FileWriter(filePath);
        writer.write(stringToWrite);
        writer.close();
    }

    public static void canReadFileLineByLine(String filePath) throws IOException {
        // Read the file to see if everything is written or not.
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String currentLine;
        System.out.println(System.lineSeparator() + "Reading each line from file : " +filePath );
        while ((currentLine = reader.readLine()) != null) {
            System.out.println(currentLine);
        }
        reader.close();
    }

    public static String canReturnALineBasedOnANumberFromAFile(String filePath, int LineNumber ) throws IOException {
        // Read the file to see if everything is written or not.
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String currentLine;
        int LineRead = 1;
        while ((currentLine = reader.readLine()) != null) {
            if (LineRead == LineNumber) {
                System.out.println("Found line at @ Line # : " + LineRead);
                break;
            }
            LineRead++;
        }
        reader.close();
        return currentLine;
    }
}