package starwars.swapi.api;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

import static projectconfiguration.FileStaticFunctions.canReturnALineBasedOnANumberFromAFile;

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
