package org.example;

import org.example.DatabaseQueryService.DatabaseQueryService;
import org.example.Delet.DeletObjects;
import org.example.InsertsInto.ClientAdd;
import org.example.InsertsInto.ProjectAdd;
import org.example.InsertsInto.ProjectWorkerAdd;
import org.example.InsertsInto.WorkerAdd;

public class Main {
    public static void main(String[] args){

        WorkerAdd workerAdd = new WorkerAdd();
        ClientAdd clientAdd = new ClientAdd();
        ProjectAdd projectAdd = new ProjectAdd();

        ProjectWorkerAdd projectWorkerAdd = new ProjectWorkerAdd();
        new DatabaseInitService(); // SECOND

        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        databasePopulateService.insertIntoWorker(workerAdd.worker1);
        databasePopulateService.insertIntoWorker(workerAdd.worker2);
        databasePopulateService.insertIntoWorker(workerAdd.worker3);
        databasePopulateService.insertIntoWorker(workerAdd.worker4);
        databasePopulateService.insertIntoWorker(workerAdd.worker5);
        databasePopulateService.insertIntoWorker(workerAdd.worker6);
        databasePopulateService.insertIntoWorker(workerAdd.worker7);
        databasePopulateService.insertIntoWorker(workerAdd.worker8);
        databasePopulateService.insertIntoWorker(workerAdd.worker9);
        databasePopulateService.insertIntoWorker(workerAdd.worker10);

        databasePopulateService.insertIntoClient(clientAdd.client1);
        databasePopulateService.insertIntoClient(clientAdd.client2);
        databasePopulateService.insertIntoClient(clientAdd.client3);
        databasePopulateService.insertIntoClient(clientAdd.client4);
        databasePopulateService.insertIntoClient(clientAdd.client5);

        databasePopulateService.insertIntoProject(projectAdd.project1);
        databasePopulateService.insertIntoProject(projectAdd.project2);
        databasePopulateService.insertIntoProject(projectAdd.project3);
        databasePopulateService.insertIntoProject(projectAdd.project4);
        databasePopulateService.insertIntoProject(projectAdd.project5);

        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker1);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker2);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker3);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker4);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker5);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker6);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker7);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker8);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker9);
        databasePopulateService.insertIntoProjectWorker(projectWorkerAdd.projectWorker10);


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