package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePageFilms {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestFilmsPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("films",thisEnv.getfilmsPageDatabaseLocation(),1);
    }

    @Test
    public void canTestFilmsPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("films",thisEnv.getfilmsPageDatabaseLocation(),2);
    }

}

