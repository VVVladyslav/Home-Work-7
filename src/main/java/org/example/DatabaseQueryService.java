package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxSalaryCountWorker> findMaxSalaryCountWorker(){
        List<MaxSalaryCountWorker> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "src/main/resources/find_max_salary_worker.sql";
            String sqlQuery = readSqlFile(sqlFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                MaxSalaryCountWorker client = new MaxSalaryCountWorker();
                client.setName(resultSet.getString("name"));
                result.add(client);
                client.setSalary(resultSet.getInt("salary"));
                System.out.println("Client -> " + client.getName() + ", Salary -> " + client.getSalary());
            }

            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "src/main/resources/find_max_projects_client.sql";
            String sqlQuery = readSqlFile(sqlFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                MaxProjectCountClient client = new MaxProjectCountClient();
                client.setName(resultSet.getString("name"));
                result.add(client);
                client.setProjectCount(resultSet.getInt("project_Count"));
                System.out.println("Client -> " + client.getName() + ", ProjectCount -> " + client.getProjectCount());
            }

            connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////
//    public List<LongestProject> findLongestProject(){
//        List<LongestProject> result = new ArrayList<>();
//        try {
//            Connection connection = Database.getInstance().getConnection();
//            String sqlFilePath = "src/main/resources/find_longest_project.sql";
//            String sqlQuery = readSqlFile(sqlFilePath);
//            Statement statement = connection.createStatement();
//            ResultSet resultSet = statement.executeQuery(sqlQuery);
//
//            while (resultSet.next()) {
//                LongestProject client = new LongestProject();
//                client.setId(resultSet.getInt("id"));
//                result.add(client);
//                client.setIdClient(resultSet.getInt("client_id"));
//                result.add(client);
//                client.setStartData(resultSet.getInt("start_data"));
//                result.add(client);
//                client.setFinishData(resultSet.getInt("finish_data"));
//                result.add(client);
//                System.out.println("ID -> " + client.getId() + ", Client_Id -> " + client.getIdClient() + ", StartData -> " + client.getStartData()
//                        + ", FinishData -> " + client.getFinishData());
//            }
//
//            connection.close();
//        } catch (SQLException | IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    private String readSqlFile(String filePath) throws IOException {
        StringBuilder query = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                query.append(line).append("\n");
            }
        }
        return query.toString();
    }
}

