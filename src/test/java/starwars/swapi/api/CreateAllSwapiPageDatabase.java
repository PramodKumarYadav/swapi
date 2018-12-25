package starwars.swapi.api;

import org.junit.Ignore;
import org.junit.Test;
import projectconfiguration.CreatePageDatabase;

import java.io.IOException;

@Ignore("To avoid accidental database creation")
public class CreateAllSwapiPageDatabase {

    // Create object for class CreatePageDatabase
    CreatePageDatabase createPageDatabase = new CreatePageDatabase();

    @Test
    public void canCreateSWAPIPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("api");
    }

    @Test
    public void canCreatepeoplePageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("people");
    }

    @Test
    public void canCreateplanetsPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("planets");
    }

    @Test
    public void canCreatefilmsPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("films");
    }

    @Test
    public void canCreatepspeciesPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("species");
    }

    @Test
    public void canCreatevehiclesPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("vehicles");
    }

    @Test
    public void canCreatestarshipsPageDatabase() throws IOException {
        createPageDatabase.canCreatePageDatabaseForAnySwapiAPI("starships");
    }

}
