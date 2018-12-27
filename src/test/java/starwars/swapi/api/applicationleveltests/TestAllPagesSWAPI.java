package starwars.swapi.api.applicationleveltests;

import org.junit.Test;
import projectconfiguration.CompareAllPages;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestAllPagesSWAPI {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareAllPages compareAllPages = new CompareAllPages();

    @Test
    public void canCompareSWAPIAPIHomePage() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("api",thisEnv.getapiPageDatabaseLocation());
    }

    @Test
    public void canCompareAllPeopleAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("people",thisEnv.getpeoplePageDatabaseLocation());
    }

    @Test
    public void canCompareAllPlanetsAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("planets",thisEnv.getplanetsPageDatabaseLocation());
    }

    @Test
    public void canCompareAllFilmsAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("films",thisEnv.getfilmsPageDatabaseLocation());
    }

    @Test
    public void canCompareAllspeciesAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("species",thisEnv.getspeciesPageDatabaseLocation());
    }

    @Test
    public void canCompareAllvehiclesAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("vehicles",thisEnv.getvehiclesPageDatabaseLocation());
    }

    @Test
    public void canCompareAllstarshipsAPIPages() throws IOException {
        compareAllPages.canCompareAllPagesForAnySwapiAPI("starships",thisEnv.getstarshipsPageDatabaseLocation());
    }
}
