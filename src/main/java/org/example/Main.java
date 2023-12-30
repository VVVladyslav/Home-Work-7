package org.example;

import DatabaseQueryService.DatabaseQueryService;
import DatabaseQueryService.Delet.DeletObjects;

public class Main {
    public static void main(String[] args){

        InformationFotTables informationFotTables = new InformationFotTables();

        new DatabaseInitService(); // SECOND

        DatabasePopulateService databasePopulateService = new DatabasePopulateService(); // THIRD
        databasePopulateService.main(
                informationFotTables.ids, informationFotTables.names, informationFotTables.birthdates, informationFotTables.positions, informationFotTables.salaries,
                informationFotTables.clientNum, informationFotTables.clientName,
                informationFotTables.projectIds, informationFotTables.clientIds, informationFotTables.startDates, informationFotTables.endDates,
                informationFotTables.projectIdsForWorker, informationFotTables.workerIds
        );


        DatabaseQueryService databaseQueryService = new DatabaseQueryService();
        databaseQueryService.findMaxSalaryCountWorker();
        databaseQueryService.findMaxProjectsClient(1);
        databaseQueryService.findLongestProject();
        databaseQueryService.findYoungestOldestPerson("OLDEST");
        databaseQueryService.findProjectPrice(32000 ,102000);

        DeletObjects deletObjects = new DeletObjects();
        //deletObjects.sendDelet();
    }
}