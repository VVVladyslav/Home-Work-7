package org.example;
import org.example.Database;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabasePopulateService {
    public static void insertIntoWorker(int[] ids, String[] names,
                                        String[] birthdates,
                                        String[] positions, int[] salaries) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.WORKER VALUES (?, ?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < ids.length; i++) {
                queryStatement.setInt(1, ids[i]);
                queryStatement.setString(2, names[i]);
                queryStatement.setDate(3, Date.valueOf(birthdates[i]));
                queryStatement.setString(4, positions[i]);
                queryStatement.setInt(5, salaries[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoClient(int[] clientNum, String[] clientName) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.CLIENT VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < clientNum.length; i++) {
                queryStatement.setInt(1, clientNum[i]);
                queryStatement.setString(2, clientName[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProject(int[] projectIds,
                                         int[] clientIds, String[] startDates,
                                         String[] endDates) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT VALUES (?, ?, ?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < projectIds.length; i++) {
                queryStatement.setInt(1, projectIds[i]);
                queryStatement.setInt(2, clientIds[i]);
                queryStatement.setDate(3, Date.valueOf(startDates[i]));
                queryStatement.setDate(4, Date.valueOf(endDates[i]));
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoProjectWorker(int[] projectIdsForWorker, int[] workerIds) {
        try {
            Connection connection = Database.getInstance().getConnection();

            String sqlQuery;
            PreparedStatement queryStatement;

            sqlQuery = "INSERT INTO PUBLIC.PROJECT_WORKER VALUES (?, ?)";
            queryStatement = connection.prepareStatement(sqlQuery);
            for (int i = 0; i < projectIdsForWorker.length; i++) {
                queryStatement.setInt(1, projectIdsForWorker[i]);
                queryStatement.setInt(2, workerIds[i]);
                queryStatement.addBatch();
            }
            queryStatement.executeBatch();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
