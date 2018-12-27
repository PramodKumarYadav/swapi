package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;
import static projectconfiguration.FileStaticFunctions.canCreateFileAndWriteStringToFile;
import static projectconfiguration.FileStaticFunctions.canReadFileLineByLine;

import java.io.*;

public class CreatePageDatabase {

    // @Test
    public void canCreatePageDatabaseForAnySwapiAPI(String apiName) throws IOException {

//        String  apiName = "people";
        String buildjsonDatabase = "";
        int pageNr = 1;

        GetResponse getResponse = new GetResponse();
        Response response = getResponse.canGiveResponse(apiName,pageNr);

        Integer responseStatus = response.getStatusCode();
        System.out.println("responseStatus : " + responseStatus);

        // Continue only if the page has resulted into resultcode 200
        assertEquals(Integer.valueOf(200),responseStatus);

        do {
            String jsonStringActualPage = response.getBody().asString();
            System.out.println(jsonStringActualPage);

            buildjsonDatabase = buildjsonDatabase + jsonStringActualPage +System.lineSeparator() ;

            pageNr = pageNr +1 ;

            response = getResponse.canGiveResponse(apiName,pageNr);
            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        System.out.println(System.lineSeparator() + "buildjsonDatabase : ");
        System.out.println(buildjsonDatabase );

        // Specify the path where you want to create this database
        String PageDataBaseLocation = EnvironmentConfiguration.TestDataLocation + "\\" + EnvironmentConfiguration.SelectTestEnvironment + "\\" + apiName + "PageDatabase.txt" ;

        // Write the database to test Data folder now
        canCreateFileAndWriteStringToFile(PageDataBaseLocation,buildjsonDatabase);

        // Read the file to see if everything is written or not.
        canReadFileLineByLine(PageDataBaseLocation);

        System.out.println("All Pages of " + apiName + " Database asserted. Everything OK. No need for detailed Tests." + System.lineSeparator());
        System.out.println("----------------------------------------------------------------------------------------");
    }
}

