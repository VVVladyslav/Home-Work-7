package org.example;
import org.example.InsertsInto.Client;
import org.example.InsertsInto.Project;
import org.example.InsertsInto.ProjectWorker;
import org.example.InsertsInto.Worker;

import java.sql.*;

public class DatabasePopulateService {
    public static void insertIntoWorker(Worker worker) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.WORKER VALUES (?, ?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);

                queryStatement.setInt(1, worker.getId());
                queryStatement.setString(2, worker.getName());
                queryStatement.setDate(3, Date.valueOf(worker.getBirthDate()));
                queryStatement.setString(4, worker.getStatus());
                queryStatement.setInt(5, worker.getSalary());

                queryStatement.addBatch();

            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoClient(Client client) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.CLIENT VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);

            queryStatement.setInt(1, client.getClientId());
            queryStatement.setString(2, client.getClientName());
            queryStatement.addBatch();

            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProject(Project project) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT VALUES (?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);

            queryStatement.setInt(1, project.getProjectId());
            queryStatement.setInt(2, project.getWorkerId());
            queryStatement.setDate(3, Date.valueOf(project.getStartDate()));
            queryStatement.setDate(4, Date.valueOf(project.getFinishDate()));
            queryStatement.addBatch();

            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProjectWorker(ProjectWorker projectWorker) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT_WORKER VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);

            queryStatement.setInt(1, projectWorker.getProjectId());
            queryStatement.setInt(2, projectWorker.getUserId());

            queryStatement.addBatch();
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
