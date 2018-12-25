package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.io.*;

public class ComparePageDatabase {

 public void canComparePageDatabaseForAnySwapiAPI(String apiName, String pageDatabase) throws IOException {

//        public void canComparePageDatabaseForAnySwapiAPI() throws IOException {
//        String  apiName = "people";
//        String  pageDatabase = "D:\\StarWars\\TestData\\SystemTest\\peoplePageDatabase.txt";

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

        // Step 02: Parse the expectedPageDatabase into bufferedReader (so that we can iterate it page by page)
        File PageDatabaseFile =  new File(pageDatabase);
        BufferedReader reader = new BufferedReader(new FileReader(PageDatabaseFile));

        do {
            System.out.println("Assert pageNr : " + pageNr);

            String jsonStringActualPage = response.getBody().asString();
            System.out.println("jsonStringActualPage   : " + jsonStringActualPage);

            String jsonStringExpectedPage = reader.readLine();
            System.out.println("jsonStringExpectedPage : " + jsonStringExpectedPage);

            assertEquals(jsonStringExpectedPage,jsonStringActualPage);

            pageNr = pageNr +1 ;

            // use RestAssured to make an HTML Call
            apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
            System.out.println(apiURL);
            response = RestAssured.get(apiURL).thenReturn();

            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        reader.close();

        System.out.println("All Pages of " + apiName + " Database asserted w.r.t " + pageDatabase );
        System.out.println("Everything OK. No need for detailed Tests.");
        System.out.println("----------------------------------------------------------------------------------------");

    }

}


