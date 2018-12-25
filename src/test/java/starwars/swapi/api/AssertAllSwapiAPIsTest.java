package starwars.swapi.api;

import org.junit.Test;
import projectconfiguration.ComparePageDatabase;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class AssertAllSwapiAPIsTest {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    ComparePageDatabase comparePageDatabase = new ComparePageDatabase();

    @Test
    public void canCompareSWAPIAPIHomePage() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("api",thisEnv.getapiPageDatabaseLocation());
    }

    @Test
    public void canCompareAllPeopleAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("people",thisEnv.getpeoplePageDatabaseLocation());
    }

    @Test
    public void canCompareAllPlanetsAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("planets",thisEnv.getplanetsPageDatabaseLocation());
    }

    @Test
    public void canCompareAllFilmsAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("films",thisEnv.getfilmsPageDatabaseLocation());
    }

    @Test
    public void canCompareAllspeciesAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("species",thisEnv.getspeciesPageDatabaseLocation());
    }

    @Test
    public void canCompareAllvehiclesAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("vehicles",thisEnv.getvehiclesPageDatabaseLocation());
    }

    @Test
    public void canCompareAllstarshipsAPIPages() throws IOException {
        comparePageDatabase.canComparePageDatabaseForAnySwapiAPI("starships",thisEnv.getstarshipsPageDatabaseLocation());
    }
}
