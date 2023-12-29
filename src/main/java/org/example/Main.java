package org.example;

import org.example.DatabaseQueryService.DatabaseQueryService;

public class Main {
    public static void main(String[] args){

        //new DatabaseInitService(); // SECOND
        //new DatabasePopulateService(); // THIRD
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxSalaryCountWorker();
        databaseQueryService.findMaxProjectsClient(1);
        databaseQueryService.findLongestProject();
        databaseQueryService.findYoungestOldestPerson("OLDEST");
        databaseQueryService.findProjectPrice(32000 ,102000);

        //DeletObjects deletObjects = new DeletObjects();
        //deletObjects.sendDelet();
    }
}