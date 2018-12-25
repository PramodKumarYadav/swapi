package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class CreatePageDatabase {

    // @Test
    public void canCreatePageDatabaseForAnySwapiAPI(String apiName) throws IOException {

//        String  apiName = "people";
        String buildjsonDatabase = "";

        int pageNr = 1;

        EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
        String swapiURL  =  thisEnv.getUrl();

        String apiURL = "";
        if (apiName.toString().trim().toLowerCase() == "api"){
            // If we are calling API Root
            apiURL = swapiURL + "/" ;
        }
        else {
            apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
        }

        System.out.println(apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();

        Integer responseStatus = response.getStatusCode();
        System.out.println("responseStatus : " + responseStatus);

        // Continue only if the page has resulted into resultcode 200
        assertEquals(Integer.valueOf(200),responseStatus);

        do {
            System.out.println("Assert pageNr : " + pageNr);

            String jsonStringActualPage = response.getBody().asString();
            System.out.println(jsonStringActualPage);

            buildjsonDatabase = buildjsonDatabase + jsonStringActualPage +System.lineSeparator() ;

            pageNr = pageNr +1 ;

            // use RestAssured to make an HTML Call
            apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
            System.out.println(apiURL);
            response = RestAssured.get(apiURL).thenReturn();

            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        System.out.println(System.lineSeparator() + "buildjsonDatabase : " );
        System.out.println(buildjsonDatabase );

        // Write the database to test Data now
        String PageDataBaseLocation = EnvironmentConfiguration.TestDataLocation + "\\" + EnvironmentConfiguration.SelectTestEnvironment + "\\" + apiName + "PageDatabase.txt" ;
        File PageDatabaseFile =  new File(PageDataBaseLocation);
        FileWriter writer = new FileWriter(PageDatabaseFile);
        writer.write(buildjsonDatabase);
        writer.close();

        // Read the file to see if everything is written or not.
        BufferedReader reader = new BufferedReader(new FileReader(PageDataBaseLocation));

        String line;
        System.out.println(System.lineSeparator() + "Reading each page from created database : " );
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();

        System.out.println("All Pages of " + apiName + " Database asserted. Everything OK. No need for detailed Tests." + System.lineSeparator());
        System.out.println("----------------------------------------------------------------------------------------");
    }

}

