package starwars.swapi.api.HighPageLevelTests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class PlanetsHighPageLevelTest {

    @Test
    public void canAssertAllPlanetPagesForSwapiAPI() throws IOException {

        String  apiName = "planets";

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
        String planetsDatabase = thisEnv.getplanetsPageDatabaseLocation();
        File PlanetsPageDatabaseFile =  new File(planetsDatabase);
        BufferedReader reader = new BufferedReader(new FileReader(PlanetsPageDatabaseFile));

        do {
            System.out.println("Assert pageNr : " + pageNr);

            String jsonStringActualPlanetsPage = response.getBody().asString();
            System.out.println("jsonStringActualPeoplePage   : " + jsonStringActualPlanetsPage);

            String jsonStringExpectedPlanetsPage = reader.readLine();
            System.out.println("jsonStringExpectedPeoplePage : " + jsonStringExpectedPlanetsPage);

            assertEquals(jsonStringExpectedPlanetsPage,jsonStringActualPlanetsPage);

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
