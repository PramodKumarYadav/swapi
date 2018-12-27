package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePagePlanets {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestPlanetsPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),1);
    }

    @Test
    public void canTestPlanetsPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),2);
    }

    @Test
    public void canTestPlanetsPage03() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),3);
    }

    @Test
    public void canTestPlanetsPage04() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),4);
    }

    @Test
    public void canTestPlanetsPage05() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),5);
    }

    @Test
    public void canTestPlanetsPage06() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),6);
    }

    @Test
    public void canTestPlanetsPage07() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),7);
    }

    @Test
    public void canTestPlanetsPage08() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("planets",thisEnv.getplanetsPageDatabaseLocation(),8);
    }

}

