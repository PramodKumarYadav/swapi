package starwars.swapi.api;

import io.restassured.path.json.JsonPath;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class testJSON {

    @Test
    public void canReadJSONLineByLineandPreetify() throws IOException {
        // Read the file to see if everything is written or not.
        String filePath = "D:\\LeasePlan\\swagger.txt";

        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        String currentLine;
        System.out.println(System.lineSeparator() + "Reading each line from file : " +filePath );
        while ((currentLine = reader.readLine()) != null) {
            System.out.println(currentLine);
            JsonPath jsonPathExpected = new JsonPath(currentLine);
            System.out.println(jsonPathExpected.prettify());
        }
        reader.close();
    }
}
