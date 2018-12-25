package starwars.swapi.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import projectconfiguration.EnvironmentConfiguration;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParsePeopleDatbase {
    @Test
    public void outputFileToSystemOutWithBufferedReader() throws IOException {
        File inputFile =  new File("D:\\StarWars\\TestData\\PeoplePageDataBase.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));

        String line;
        String expectedPeoplejson = "";
        while ((line = reader.readLine()) != null) {
            expectedPeoplejson = expectedPeoplejson + line;
            System.out.println(line);
        }
        System.out.println(expectedPeoplejson);
        reader.close();

        // Use the JsonPath parsing library of RestAssured to Parse the JSON
        JsonPath jsonPath = new JsonPath(expectedPeoplejson);
        System.out.println(jsonPath.prettyPeek());

//        try{
//            String line;
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//            }
//
//        }finally {
//            reader.close();
//        }
    }

//    @Test
//    public void canAssertAllPeopleCountForSwapiAPI() {
//
//        List<String> AllStarWarNames = new ArrayList<>();
//
//        do {
//
//            String json = response.getBody().asString();
//            System.out.println(json);
//
//            // Use the JsonPath parsing library of RestAssured to Parse the JSON
//            JsonPath jsonPath = new JsonPath(json);
//
//            List<String> names = jsonPath.getList("results.name");
//            // System.out.println(names);
//
//            AllStarWarNames.addAll(names);
//
//            int namesOnThisPage = names.size();
//            System.out.println("namesOnThisPage : " + namesOnThisPage);
//
//            for (int nameNr = 0 ; nameNr < namesOnThisPage ; nameNr++){
//                System.out.println("namesOnThisPage[" +nameNr+ "] : " + jsonPath.getString("results[" + nameNr + "].name"));
//            }
//
//            pageNr = pageNr +1 ;
//
//            // use RestAssured to make an HTML Call
//            response = RestAssured.get("https://swapi.co/api/people/?format=json&page=" +pageNr).thenReturn();
//
//            responseStatus = response.getStatusCode();
//            System.out.println("responseStatus : " + responseStatus);
//
//        }while (responseStatus == 200 );
//
//        System.out.println("AllStarWarNames : " + AllStarWarNames);
//
//    }
}
