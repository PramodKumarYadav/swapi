import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TestAssertPeople {

    @Test
    public void canAssertAllPeopleCountForSwapiAPI() throws IOException {

        int pageNr = 1;

        EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
        String swapiURL  =  thisEnv.getUrl();

//        String swapiURL  =  EnvironmentConfiguration.getUrl();
        System.out.println("swapiURL : " + swapiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(swapiURL +"/people/?format=json&page=" +pageNr).thenReturn();

        Integer responseStatus = response.getStatusCode();
        System.out.println("responseStatus : " + responseStatus);

        // Continue only if the page has resulted into resultcode 200
        assertEquals(Integer.valueOf(200),responseStatus);

        List<String> AllStarWarNames = new ArrayList<>();

        // Step 02: Parse the expectedPageDatabase into bufferedReader (so that we can iterate it page by page)
        File PeoplePageDatabaseFile =  new File("D:\\StarWars\\TestData\\PeoplePageDataBase.txt");
        BufferedReader reader = new BufferedReader(new FileReader(PeoplePageDatabaseFile));

        do {
            String jsonStringActualPeoplePage = response.getBody().asString();
            System.out.println("jsonStringActualPeoplePage   : " + jsonStringActualPeoplePage);

            // Use the JsonPath parsing library of RestAssured to Parse the JSON
            JsonPath jsonPathActualPeoplePage = new JsonPath(jsonStringActualPeoplePage);

            List<String> actualNames = jsonPathActualPeoplePage.getList("results.name");
            // System.out.println(names);

            AllStarWarNames.addAll(actualNames);

            String jsonStringExpectedPeoplePage = reader.readLine();
            System.out.println("jsonStringExpectedPeoplePage : " + jsonStringExpectedPeoplePage);

            assertEquals(jsonStringExpectedPeoplePage,jsonStringActualPeoplePage);

            // Use the JsonPath parsing library of RestAssured to Parse the JSON
            JsonPath jsonPathExpectedPeoplePage = new JsonPath(jsonStringExpectedPeoplePage);
            // System.out.println(jsonPathPeopleExpected.prettyPeek());

            List<String> expectedNames = jsonPathExpectedPeoplePage.getList("results.name");
            // System.out.println(ExpectedNames);

            int countOfNamesOnTheActualPage = actualNames.size();
            System.out.println("namesOnTheActualPage : " + countOfNamesOnTheActualPage);

            int countOfNamesOnExpectedPage = expectedNames.size();
            System.out.println("namesOnExpectedPage  : " + countOfNamesOnExpectedPage);

            assertEquals(countOfNamesOnExpectedPage,countOfNamesOnTheActualPage);

            for (int nameNr = 0 ; nameNr < countOfNamesOnTheActualPage ; nameNr++){
                System.out.println("namesOnTheActualPage[" +nameNr+ "] : " + jsonPathActualPeoplePage.getString("results[" + nameNr + "].name"));
                System.out.println("namesOnExpectedPage[" +nameNr+ "]  : " + jsonPathExpectedPeoplePage.getString("results[" + nameNr + "].name"));
            }

            pageNr = pageNr +1 ;

            // use RestAssured to make an HTML Call
            response = RestAssured.get("https://swapi.co/api/people/?format=json&page=" +pageNr).thenReturn();

            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        reader.close();
        System.out.println("AllStarWarNames : " + AllStarWarNames);

    }

}
