package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePageSpecies {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestSpeciesPage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("species",thisEnv.getspeciesPageDatabaseLocation(),1);
    }

    @Test
    public void canTestSpeciesPage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("species",thisEnv.getspeciesPageDatabaseLocation(),2);
    }

    @Test
    public void canTestSpeciesPage03() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("species",thisEnv.getspeciesPageDatabaseLocation(),3);
    }

    @Test
    public void canTestSpeciesPage04() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("species",thisEnv.getspeciesPageDatabaseLocation(),4);
    }

    @Test
    public void canTestSpeciesPage05() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("species",thisEnv.getspeciesPageDatabaseLocation(),5);
    }
}

