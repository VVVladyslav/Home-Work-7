package DatabaseQueryService;

import org.example.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseQueryService {
    public List<MaxSalaryCountWorker> findMaxSalaryCountWorker(){
        List<MaxSalaryCountWorker> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "SELECT * FROM worker WHERE SALARY = (SELECT MAX(SALARY) FROM worker);";
            PreparedStatement queryStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = queryStatement.executeQuery();

            while (resultSet.next()) {
                MaxSalaryCountWorker maxSalaryCountWorker = new MaxSalaryCountWorker();
                maxSalaryCountWorker.setName(resultSet.getString("name"));
                maxSalaryCountWorker.setSalary(resultSet.getInt("salary"));
                result.add(maxSalaryCountWorker);
                //System.out.println("Client -> " + maxSalaryCountWorker.getName() + ", Salary -> " + maxSalaryCountWorker.getSalary());
            }
            //System.out.println();

            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public List<MaxProjectCountClient> findMaxProjectsClient(Object threshold) {
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "SELECT c.ID, c.NAME, COUNT(p.ID) AS PROJECT_COUNT " +
                    "FROM client c " +
                    "LEFT JOIN project p ON c.ID = p.CLIENT_ID " +
                    "GROUP BY c.ID, c.NAME " +
                    "HAVING COUNT(p.ID) = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setObject(1, threshold);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                MaxProjectCountClient maxProjectCountClient = new MaxProjectCountClient();
                maxProjectCountClient.setName(resultSet.getString("name"));
                maxProjectCountClient.setProjectCount(resultSet.getInt("PROJECT_COUNT"));
                result.add(maxProjectCountClient);
                //System.out.println("Client -> " + maxProjectCountClient.getName() + ", ProjectCount -> " + maxProjectCountClient.getProjectCount());
            }

            // connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////
    public List<LongestProject> findLongestProject(){
        List<LongestProject> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlQuery = "SELECT *\n" +
                    "FROM project\n" +
                    "WHERE DATEDIFF('MONTH', START_DATE, FINISH_DATE) = (\n" +
                    "    SELECT MAX(DATEDIFF('MONTH', START_DATE, FINISH_DATE))\n" +
                    "    FROM project\n" +
                    ");";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();

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
                /*System.out.println("ID -> " + longestProject.getId() + ", Client_Id -> " + longestProject.getIdClient()
                        + ", StartData -> " + longestProject.getStartData()
                        + ", FinishData -> " + longestProject.getFinishData());
                 */
            }
            //System.out.println();

            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
/////////////////////////////////////////////////////
public List<YoungestOldestPerson> findYoungestOldestPerson(String type) {
    List<YoungestOldestPerson> result = new ArrayList<>();
    try {
        Connection connection = Database.getInstance().getConnection();
        String sqlQuery = "SELECT ?, NAME, BIRTHDAY " +
                "FROM worker " +
                "WHERE BIRTHDAY = (SELECT ";

        if ("YOUNGEST".equals(type)) {
            sqlQuery += "MIN(BIRTHDAY) FROM worker)";
        }
        if ("OLDEST".equals(type)) {
            sqlQuery += "MAX(BIRTHDAY) FROM worker)";
        }

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            YoungestOldestPerson youngestOldestPerson = new YoungestOldestPerson();
            youngestOldestPerson.setName(resultSet.getString("name"));
            youngestOldestPerson.setBirthday(resultSet.getDate("birthday"));
            result.add(youngestOldestPerson);
            //System.out.println("Name -> " + youngestOldestPerson.getName() + ", Birthdate -> " + youngestOldestPerson.getBirthday());
        }

        // connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}
public List<ProjectPrice> findProjectPrice(int minProjectCost, int maxProjectCost) {
    List<ProjectPrice> result = new ArrayList<>();
    try {
        Connection connection = Database.getInstance().getConnection();
        String sqlQuery = "SELECT p.ID AS PROJECT_ID, " +
                "SUM(w.SALARY * DATEDIFF('MONTH', p.START_DATE, p.FINISH_DATE)) AS PROJECT_COST " +
                "FROM project p " +
                "JOIN project_worker pw ON p.ID = pw.PROJECT_ID " +
                "JOIN worker w ON pw.WORKER_ID = w.ID " +
                "GROUP BY p.ID " +
                "HAVING PROJECT_COST BETWEEN ? AND ? " +
                "ORDER BY PROJECT_COST DESC;";

        PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
        preparedStatement.setInt(1, minProjectCost);
        preparedStatement.setInt(2, maxProjectCost);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            ProjectPrice projectPrice = new ProjectPrice();
            projectPrice.setProjectID(resultSet.getInt("project_id"));
            projectPrice.setProjectCost(resultSet.getInt("project_cost"));
            result.add(projectPrice);
            //System.out.println("PROJECT_ID -> " + projectPrice.getProjectID() + ", PROJECT_COST -> " + projectPrice.getProjectCost());
        }

        connection.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return result;
}
    /*private String readSqlFile(String filePath) throws IOException {
        StringBuilder query = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                query.append(line).append("\n");
            }
        }
        return query.toString();
    }
     */
}

