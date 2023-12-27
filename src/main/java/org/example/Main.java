package org.example;

import org.example.DatabaseQueryService.DatabaseQueryService;

public class Main {
    public static void main(String[] args){

        //new DatabaseInitService(); // SECOND
        //new DatabasePopulateService(); // THIRD
        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxSalaryCountWorker();
        databaseQueryService.findMaxProjectsClient();
        databaseQueryService.findLongestProject();
        databaseQueryService.findYoungestOldestPerson();
        databaseQueryService.findProjectPrice();

        //DeletObjects deletObjects = new DeletObjects();
        //deletObjects.sendDelet();
    }
}