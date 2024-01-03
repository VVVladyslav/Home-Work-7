package org.example;

import org.example.DatabaseQueryService.DatabaseQueryService;
import org.example.Delet.DeletObjects;
import org.example.InsertsInto.Client;
import org.example.InsertsInto.Project;
import org.example.InsertsInto.ProjectWorker;
import org.example.InsertsInto.Worker;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args){

        new DatabaseInitService(); // SECOND
        DatabasePopulateService databasePopulateService = new DatabasePopulateService();

        // Worker worker = new Worker();
        LocalDate worker1_Birthday = LocalDate.of(2020,07,11);
        LocalDate worker2_Birthday = LocalDate.of(2001,02,12);
        LocalDate worker3_Birthday = LocalDate.of(2005,02,13);
        LocalDate worker4_Birthday = LocalDate.of(2010,05,14);
        LocalDate worker5_Birthday = LocalDate.of( 2010,10,15);
        LocalDate worker6_Birthday = LocalDate.of( 2009,10,16);
        LocalDate worker7_Birthday = LocalDate.of( 2007,11,17);
        LocalDate worker8_Birthday = LocalDate.of( 2004,12,18);
        LocalDate worker9_Birthday = LocalDate.of(2003,03,19);
        LocalDate worker10_Birthday = LocalDate.of( 2000,01,13);
        databasePopulateService.insertIntoWorker(new Worker(12,"John",worker1_Birthday,"Trainee",800));
        databasePopulateService.insertIntoWorker(new Worker(13,"Jane",worker2_Birthday,"Junior",900));
        databasePopulateService.insertIntoWorker(new Worker(14,"Jim",worker3_Birthday,"Middle",1800));
        databasePopulateService.insertIntoWorker(new Worker(15,"Joe",worker4_Birthday,"Senior",1900));
        databasePopulateService.insertIntoWorker(new Worker(16,"Jared",worker5_Birthday,"Senior",1000));
        databasePopulateService.insertIntoWorker(new Worker(17,"Jamal",worker6_Birthday,"Senior",1100));
        databasePopulateService.insertIntoWorker(new Worker(18,"Jocker",worker7_Birthday,"Senior",1200));
        databasePopulateService.insertIntoWorker(new Worker(19,"Janister",worker8_Birthday,"Middle",5000));
        databasePopulateService.insertIntoWorker(new Worker(20,"Jupiter",worker9_Birthday,"Trainee",5200));
        databasePopulateService.insertIntoWorker(new Worker(21,"Jimison",worker10_Birthday,"Middle",1300));

        //Client client = new Client();
        databasePopulateService.insertIntoClient(new Client(1, "Oleg Cl"));
        databasePopulateService.insertIntoClient(new Client(2, "Olyena Cl"));
        databasePopulateService.insertIntoClient(new Client(3, "Oksana Cl"));
        databasePopulateService.insertIntoClient(new Client(4, "Oman Cl"));
        databasePopulateService.insertIntoClient(new Client(5, "Omrika Cl"));

        //Project project = new Project();
        LocalDate startDataProject1 = LocalDate.of(2000,01,01 );
        LocalDate finishDataProject1 = LocalDate.of(2001,06,30);

        LocalDate startDataProject2 = LocalDate.of(2000,02,15);
        LocalDate finishDataProject2 = LocalDate.of(2002,11,30);

        LocalDate startDataProject3 = LocalDate.of(2000,06,10);
        LocalDate finishDataProject3 = LocalDate.of(2003,02,20);

        LocalDate startDataProject4 = LocalDate.of(2003,07,20);
        LocalDate finishDataProject4 = LocalDate.of(2004,01,10);

        LocalDate startDataProject5 = LocalDate.of(2004,03,05);
        LocalDate finishDataProject5 = LocalDate.of(2005,04,20);

        databasePopulateService.insertIntoProject(new Project(1, 1,startDataProject1, finishDataProject1));
        databasePopulateService.insertIntoProject(new Project(2, 2,startDataProject2, finishDataProject2));
        databasePopulateService.insertIntoProject(new Project(3, 3,startDataProject3, finishDataProject3));
        databasePopulateService.insertIntoProject(new Project(4, 4,startDataProject4, finishDataProject4));
        databasePopulateService.insertIntoProject(new Project(5, 5,startDataProject5, finishDataProject5));

        //ProjectWorkerAdd projectWorker = new ProjectWorker();
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(1, 12));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(2, 13));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(2, 14));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(2, 15));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(3, 16));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(4, 17));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(5, 18));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(5, 19));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(1, 20));
        databasePopulateService.insertIntoProjectWorker(new ProjectWorker(5, 21));

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