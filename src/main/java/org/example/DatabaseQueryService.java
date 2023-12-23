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
                MaxSalaryCountWorker maxSalaryCountWorker = new MaxSalaryCountWorker();
                maxSalaryCountWorker.setName(resultSet.getString("name"));
                result.add(maxSalaryCountWorker);
                maxSalaryCountWorker.setSalary(resultSet.getInt("salary"));
                System.out.println("Client -> " + maxSalaryCountWorker.getName() + ", Salary -> " + maxSalaryCountWorker.getSalary());
            }
            System.out.println();

            //connection.close();
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
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setName(resultSet.getString("name"));
                result.add(maxProjectCountClient);
                maxProjectCountClient.setProjectCount(resultSet.getInt("project_Count"));
                System.out.println("Client -> " + maxProjectCountClient.getName() + ", ProjectCount -> " + maxProjectCountClient.getProjectCount());
            }
            System.out.println();

            //connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public List<LongestProject> findLongestProject(){
        List<LongestProject> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "src/main/resources/find_longest_project.sql";
            String sqlQuery = readSqlFile(sqlFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                LongestProject longestProject = new LongestProject();
                longestProject.setId(resultSet.getInt("id"));
                result.add(longestProject);
                longestProject.setIdClient(resultSet.getInt("client_id"));
                result.add(longestProject);
                longestProject.setStartData(resultSet.getDate("start_date"));
                result.add(longestProject);
                longestProject.setFinishData(resultSet.getDate("finish_date"));
                result.add(longestProject);
                System.out.println("ID -> " + longestProject.getId() + ", Client_Id -> " + longestProject.getIdClient()
                        + ", StartData -> " + longestProject.getStartData()
                        + ", FinishData -> " + longestProject.getFinishData());
            }
            System.out.println();

            //connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
/////////////////////////////////////////////////////
    public List<YoungestOldestPerson> findYoungestOldestPerson(){
        List<YoungestOldestPerson> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "src/main/resources/find_youngest_eldest_workers.sql";
            String sqlQuery = readSqlFile(sqlFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                YoungestOldestPerson youngestOldestPerson = new YoungestOldestPerson();
                youngestOldestPerson.setName(resultSet.getString("name"));
                result.add(youngestOldestPerson);
                youngestOldestPerson.setBirthday(resultSet.getDate("birthday"));
                System.out.println("Name -> " + youngestOldestPerson.getName() + ", Birthdate -> " + youngestOldestPerson.getBirthday());
            }
            System.out.println();

            //connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<ProjectPrice> findProjectPrice(){
        List<ProjectPrice> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "src/main/resources/print_project_prices.sql";
            String sqlQuery = readSqlFile(sqlFilePath);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                ProjectPrice projectPrice = new ProjectPrice();
                projectPrice.setProjectID(resultSet.getInt("project_id"));
                result.add(projectPrice);
                projectPrice.setProjectCost(resultSet.getInt("project_cost"));
                System.out.println("PROJECT_ID -> " + projectPrice.getProjectID() + ", PROJECT_COST -> " + projectPrice.getProjectCost());
            }
            System.out.println();

            //connection.close();
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }
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

