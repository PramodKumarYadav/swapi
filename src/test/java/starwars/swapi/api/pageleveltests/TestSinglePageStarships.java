package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePageStarships {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestStarshipsPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("starships",thisEnv.getstarshipsPageDatabaseLocation(),1);
    }

    @Test
    public void canTestStarshipsPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("starships",thisEnv.getstarshipsPageDatabaseLocation(),2);
    }

    @Test
    public void canTestStarshipsPage03() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("starships",thisEnv.getstarshipsPageDatabaseLocation(),3);
    }

    @Test
    public void canTestStarshipsPage04() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("starships",thisEnv.getstarshipsPageDatabaseLocation(),4);
    }

    @Test
    public void canTestStarshipsPage05() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("starships",thisEnv.getstarshipsPageDatabaseLocation(),5);
    }
}
