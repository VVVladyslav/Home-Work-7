package org.example;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {

        new DatabaseInitService(); // SECOND
        new DatabasePopulateService(); // THIRD
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxProjectsClient();

        //DeletObjects deletObjects = new DeletObjects();
       // deletObjects.sendDelet();
    }
}