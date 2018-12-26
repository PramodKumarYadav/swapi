package projectconfiguration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.*;

public class CompareAllPages {

    public void canCompareAllPagesForAnySwapiAPI(String apiName, String pageDatabase) throws IOException {

//        public void canCompareAllPagesForAnySwapiAPI() throws IOException {
//        String  apiName = "people";
//        String  pageDatabase = "D:\\StarWars\\TestData\\SystemTest\\peoplePageDatabase.txt";

        int pageNr = 1;

        EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
        String swapiURL  =  thisEnv.getUrl();

        Integer responseStatus = null;

        CompareSinglePage compareSinglePage = new CompareSinglePage();
         do {
             compareSinglePage.canCompareAnySingleAPIPage(apiName,pageDatabase,pageNr);

             pageNr = pageNr +1 ;

             // use RestAssured to make an HTML Call
             String apiURL = "";
             if (apiName.toString().trim().toLowerCase() == "api"){
                 apiURL = swapiURL + "/?format=json&page=" +pageNr ;
             }
             else {
                 apiURL = swapiURL + "/" + apiName + "/?format=json&page=" +pageNr ;
             }
             System.out.println("apiURL : "+ apiURL);
             Response response = RestAssured.get(apiURL).thenReturn();
             responseStatus = response.getStatusCode();
             System.out.println("responseStatus : " + responseStatus);

         }while (responseStatus == 200 );

        System.out.println("All Pages of " + apiName + " Database asserted w.r.t " + pageDatabase );
        System.out.println("Everything OK. No need for detailed Tests.");
        System.out.println("----------------------------------------------------------------------------------------");
    }

}


