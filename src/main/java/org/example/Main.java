package org.example;

import org.example.DatabaseQueryService.DatabaseQueryService;
import org.example.Delet.DeletObjects;

public class Main {
    public static void main(String[] args){

        DataVariables dataVariables = new DataVariables();

        new DatabaseInitService(); // SECOND

        DatabasePopulateService databasePopulateService = new DatabasePopulateService(); // THIRD
        databasePopulateService.main(
                dataVariables.ids, dataVariables.names, dataVariables.birthdates, dataVariables.positions, dataVariables.salaries,
                dataVariables.clientNum, dataVariables.clientName,
                dataVariables.projectIds, dataVariables.clientIds, dataVariables.startDates, dataVariables.endDates,
                dataVariables.projectIdsForWorker, dataVariables.workerIds
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