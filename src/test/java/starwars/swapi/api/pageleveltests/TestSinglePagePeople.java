package starwars.swapi.api.pageleveltests;

import org.junit.Test;
import projectconfiguration.CompareSinglePage;
import projectconfiguration.EnvironmentConfiguration;

import java.io.IOException;

public class TestSinglePagePeople {

    EnvironmentConfiguration thisEnv = new EnvironmentConfiguration();
    CompareSinglePage compareSinglePage = new CompareSinglePage();

    @Test
    public void canTestPeoplePage01() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),1);
    }

    @Test
    public void canTestPeoplePage02() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),2);
    }

    @Test
    public void canTestPeoplePage03() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),3);
    }

    @Test
    public void canTestPeoplePage04() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),4);
    }

    @Test
    public void canTestPeoplePage05() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),5);
    }

    @Test
    public void canTestPeoplePage06() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),6);
    }

    @Test
    public void canTestPeoplePage07() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),7);
    }

    @Test
    public void canTestPeoplePage08() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),8);
    }

    @Test
    public void canTestPeoplePage09() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),9);
    }

    @Test
    public void canTestPeoplePage10() throws IOException {
        compareSinglePage.canCompareAnySingleAPIPage("people",thisEnv.getpeoplePageDatabaseLocation(),10);
    }
}
