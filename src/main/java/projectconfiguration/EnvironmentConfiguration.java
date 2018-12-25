package projectconfiguration;

public class EnvironmentConfiguration {

    public static final String SelectTestEnvironment = "SystemTest";
    public static final String ProjectLocation = "D:\\StarWars";
    public static final String TestDataLocation = ProjectLocation + "\\TestData";

    private String Domain = "";
    private String SubDomain = "";
    private String apiPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\apiPageDatabase.txt";
    private String peoplePageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\peoplePageDatabase.txt";
    private String planetsPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\planetsPageDatabase.txt";
    private String filmsPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\filmsPageDatabase.txt";
    private String speciesPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\speciesPageDatabase.txt";
    private String vehiclesPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\vehiclesPageDatabase.txt";
    private String starshipsPageDatabaseLocation = TestDataLocation + "\\" + SelectTestEnvironment + "\\starshipsPageDatabase.txt";

    public EnvironmentConfiguration()  {
        this(SelectTestEnvironment);
    }

    public EnvironmentConfiguration(String SelectTestEnvironment)  {
        switch (SelectTestEnvironment) {
            case "SystemTest":
                // System Test Configuration
                Domain = "swapi.co";
                SubDomain = "api";
                break;
            case "ChainTest":
                // Chain Test Configuration
                Domain = "swapi.co.c1"; // This is dummy value. To be replaced with real value (when available)
                SubDomain = "api";
                break;
            case "PreProductionTest":
                // Chain Test Configuration
                Domain = "swapi.co.p1";
                SubDomain = "api";
                break;
            default:
                // System Test Configuration
                Domain = "swapi.co";
                SubDomain = "api";
                break;
        }
    }

    // Sample : "https://swapi.co/api/people/?format=json&page=1"
    public String getUrl() {
        String swapiURL = "https://" + Domain + "/" + SubDomain;
        System.out.println("swapiURL : " + swapiURL);
        return swapiURL ;
    }

    public String getProjectLocation() {
        System.out.println("ProjectLocation : " + ProjectLocation);
        return ProjectLocation ;
    }

    public String getapiPageDatabaseLocation() {
        System.out.println("apiPageDatabaseLocation : " + apiPageDatabaseLocation);
        return apiPageDatabaseLocation;
    }

    public String getpeoplePageDatabaseLocation() {
        System.out.println("PeopleDatabaseLocation : " + peoplePageDatabaseLocation);
        return peoplePageDatabaseLocation;
    }

    public String getplanetsPageDatabaseLocation() {
        System.out.println("PeopleDatabaseLocation : " + planetsPageDatabaseLocation);
        return planetsPageDatabaseLocation;
    }

    public String getfilmsPageDatabaseLocation() {
        System.out.println("filmsPageDatabaseLocation : " + filmsPageDatabaseLocation);
        return filmsPageDatabaseLocation;
    }

    public String getspeciesPageDatabaseLocation() {
        System.out.println("speciesPageDatabaseLocation : " + speciesPageDatabaseLocation);
        return speciesPageDatabaseLocation;
    }

    public String getvehiclesPageDatabaseLocation() {
        System.out.println("vehiclesPageDatabaseLocation : " + vehiclesPageDatabaseLocation);
        return vehiclesPageDatabaseLocation;
    }

    public String getstarshipsPageDatabaseLocation() {
        System.out.println("starshipsPageDatabaseLocation : " + starshipsPageDatabaseLocation);
        return starshipsPageDatabaseLocation;
    }

//    public static String getUrl() {
//        System.out.println(Domain);
//        return "https://" + Domain + "/" + SubDomain ;
//    }

}
