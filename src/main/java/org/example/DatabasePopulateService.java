package org.example;
import java.sql.*;

public class DatabasePopulateService {
    public static void insertIntoWorker(String[] worker) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.WORKER VALUES (?, ?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < 1; i++) {
                queryStatement.setInt(1, Integer.parseInt(worker[0]));
                queryStatement.setString(2, worker[1]);
                queryStatement.setDate(3, java.sql.Date.valueOf(worker[2]));
                queryStatement.setString(4, worker[3]);
                queryStatement.setInt(5, Integer.parseInt(worker[4]));

                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoClient(String[] client) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.CLIENT VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < 1; i++) {
                queryStatement.setInt(1, Integer.parseInt(client[0]));
                queryStatement.setString(2, client[1]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProject(String[] project) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT VALUES (?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < 1; i++) {
                queryStatement.setInt(1, Integer.parseInt(project[0]));
                queryStatement.setInt(2, Integer.parseInt(project[1]));
                queryStatement.setDate(3, java.sql.Date.valueOf(project[2]));
                queryStatement.setDate(4, java.sql.Date.valueOf(project[3]));
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProjectWorker(String[] projectWorker) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT_WORKER VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < 1; i++) {
                queryStatement.setInt(1, Integer.parseInt(projectWorker[0]));
                queryStatement.setInt(2, Integer.parseInt(projectWorker[1]));
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
