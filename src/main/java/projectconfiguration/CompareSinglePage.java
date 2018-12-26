package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static projectconfiguration.FileStaticFunctions.canReturnALineBasedOnANumberFromAFile;

public class CompareSinglePage {


    public void canCompareAnySingleAPIPage(String  apiName ,String  pageDatabase, int pageNr ) throws IOException {

//        @Test
//        public void canCompareSinglePageForAnySwapiAPI() throws IOException {
//        String  apiName = "people";
//        String  pageDatabase = "D:\\StarWars\\TestData\\SystemTest\\peoplePageDatabase.txt";
//        int pageNr = 2;

        System.out.println("Assert pageNr : " + pageNr);

        // Step 01: Parse response from page
        EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
        String swapiURL  =  thisEnv.getUrl();

        String apiURL = "";
        if (apiName.toString().trim().toLowerCase() == "api"){
            // If we are calling API Root
            apiURL = swapiURL + "/?format=json&page=" +pageNr ;
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

        String jsonStringActualPage = response.getBody().asString();
        System.out.println("jsonStringActualPage   : " + jsonStringActualPage);

        JsonPath jsonPathActual = new JsonPath(jsonStringActualPage);

        // Step 02: Parse the expectedPage from expectedPageDatabase
        String jsonStringExpectedPage = canReturnALineBasedOnANumberFromAFile(pageDatabase,pageNr);
        System.out.println("jsonStringExpectedPage : " + jsonStringExpectedPage);

        JsonPath jsonPathExpected = new JsonPath(jsonStringExpectedPage);

//            assertEquals(jsonStringExpectedPage,jsonStringActualPage);
        assertEquals(jsonPathExpected.prettify(),jsonPathActual.prettify());

        System.out.println(System.lineSeparator() + "Page " + pageNr +  " of " + apiName + " Database asserted w.r.t " + pageDatabase + "Line nr : " + pageNr );
        System.out.println("Everything OK at this page. No need for detailed tests on this page.");
        System.out.println("----------------------------------------------------------------------------------------");

    }

}
