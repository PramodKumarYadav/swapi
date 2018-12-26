import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class TestPeople {

    @Test
    public void canAssertAllPeopleCountForSwapiAPI() {

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

        do {
            String json = response.getBody().asString();
            System.out.println(json);

            // Use the JsonPath parsing library of RestAssured to Parse the JSON
            JsonPath jsonPath = new JsonPath(json);
            System.out.println(jsonPath.prettyPeek());

            List<String> names = jsonPath.getList("results.name");
            System.out.println(names);

            AllStarWarNames.addAll(names);

            int namesOnThisPage = names.size();
            System.out.println("namesOnThisPage : " + namesOnThisPage);

            for (int nameNr = 0 ; nameNr < namesOnThisPage ; nameNr++){
                System.out.println("namesOnThisPage[" +nameNr+ "] : " + jsonPath.getString("results[" + nameNr + "].name"));
            }

            pageNr = pageNr +1 ;

            // use RestAssured to make an HTML Call
            response = RestAssured.get("https://swapi.co/api/people/?format=json&page=" +pageNr).thenReturn();

            responseStatus = response.getStatusCode();
            System.out.println("responseStatus : " + responseStatus);

        }while (responseStatus == 200 );

        System.out.println("AllStarWarNames : " + AllStarWarNames);

    }

}
