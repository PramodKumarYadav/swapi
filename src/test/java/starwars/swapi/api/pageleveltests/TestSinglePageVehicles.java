package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePageVehicles {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestVehiclesPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),1);
    }

    @Test
    public void canTestVehiclesPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),2);
    }

    @Test
    public void canTestVehiclesPage03() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),3);
    }

    @Test
    public void canTestVehiclesPage04() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),4);
    }

    @Test
    public void canTestVehiclesPage05() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),5);
    }
    @Test
    public void canTestVehiclesPage06() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("vehicles",thisEnv.getvehiclesPageDatabaseLocation(),5);
    }

}
