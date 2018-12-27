package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePageAPI {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestAPIPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("api",thisEnv.getapiPageDatabaseLocation(),1);
    }

    @Test
    public void canTestAPIPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("api",thisEnv.getapiPageDatabaseLocation(),2);
    }
}
