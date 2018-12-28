package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import java.io.IOException;

public class GetResponse {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();

    public Response canGiveResponse(String  apiName , int pageNr ) throws IOException {
//    @Test
//    public Response canGiveResponseForAPage() throws IOException {
//        String  apiName = "people";
//        int pageNr = 2;

        // Step 01: Parse response from page
        String swapiURL  =  thisEnv.getUrl();

        String apiURL = "";
        if (apiName.toString().trim().toLowerCase() == "api"){
            // Due to a bug in this API for pageNr
            if (pageNr == 1) {
                apiURL = swapiURL + "/?format=json&page=" + pageNr;
            } else {
                apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
            }
        }
        else {
            apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
        }

        System.out.println(apiURL);

        // use RestAssured to make an HTML Call
        Response response = RestAssured.get(apiURL).thenReturn();
        return response;
    }

}

