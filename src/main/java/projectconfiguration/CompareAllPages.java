package projectconfiguration;

import io.restassured.response.Response;

import java.io.*;

public class CompareAllPages {

    public void canCompareAllPagesForAnySwapiAPI(String apiName, String pageDatabase) throws IOException {
//        public void canCompareAllPagesForAnySwapiAPI() throws IOException {
//        String  apiName = "people";
//        String  pageDatabase = "D:\\StarWars\\TestData\\SystemTest\\peoplePageDatabase.txt";

        int pageNr = 1;
        Integer responseStatus = null;

        CompareSinglePage compareSinglePage = new CompareSinglePage();
        GetResponse getResponse = new GetResponse();

         do {
             compareSinglePage.canCompareAnySingleAPIPage(apiName,pageDatabase,pageNr);

             pageNr = pageNr +1 ;

             Response response = getResponse.canGiveResponse(apiName,pageNr);
             responseStatus = response.getStatusCode();
             System.out.println("responseStatus : " + responseStatus);

         }while (responseStatus == 200 );

        System.out.println("All Pages of " + apiName + " Database asserted w.r.t " + pageDatabase );
        System.out.println("Everything OK. No need for detailed Tests.");
        System.out.println("----------------------------------------------------------------------------------------");
    }

}


