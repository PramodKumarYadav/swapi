package starwars.swapi.api.HighPageLevelTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class PeopleHighPageLevelTest {

    @Test
    public void canAssertAllPeoplePagesForSwapiAPI() throws IOException {

        String  apiName = "people";

        int pageNr = 1;

        EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
        String swapiURL  =  thisEnv.getUrl();

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(swapiURL + "/" + apiName + "/?format=json&page=" +pageNr).thenReturn();

        Integer responseStatus = response.getStatusCode();
        System.out.println("responseStatus : " + responseStatus);

        // Continue only if the page has resulted into resultcode 200
        assertEquals(Integer.valueOf(200),responseStatus);

        // Step 02: Parse the expectedPageDatabase into bufferedReader (so that we can iterate it page by page)
        String peopleDatabase = thisEnv.getpeoplePageDatabaseLocation();
        File PeoplePageDatabaseFile =  new File(peopleDatabase);
        BufferedReader reader = new BufferedReader(new FileReader(PeoplePageDatabaseFile));

        do {
            System.out.println("Assert pageNr : " + pageNr);

            String jsonStringActualPeoplePage = response.getBody().asString();
            System.out.println("jsonStringActualPeoplePage   : " + jsonStringActualPeoplePage);

            String jsonStringExpectedPeoplePage = reader.readLine();
            System.out.println("jsonStringExpectedPeoplePage : " + jsonStringExpectedPeoplePage);

            assertEquals(jsonStringExpectedPeoplePage,jsonStringActualPeoplePage);

            pageNr = pageNr +1 ;

            // use RestAssured to make an HTML Call
            response = RestAssured.get(swapiURL + "/" + apiName + "/?format=json&page=" +pageNr).thenReturn();

            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        reader.close();
        System.out.println("All Pages of " + apiName + " Database asserted. Everything OK. No need for detailed Tests." + System.lineSeparator());
        System.out.println("----------------------------------------------------------------------------------------");

    }

}
