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
    public List<MaxProjectCountClient> findMaxProjectsClient(){
        List<MaxProjectCountClient> result = new ArrayList<>();
        try {
            Connection connection = Database.getInstance().getConnection();
            String sqlFilePath = "C:\\Users\\sergei\\IdeaProjects\\Hm6i\\src\\main\\resources\\find_max_projects_client.sql";
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

class MaxProjectCountClient {
    private String name;
    private int projectCount;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getProjectCount() {
        return projectCount;
    }
    public void setProjectCount(int projectCount) {
        this.projectCount = projectCount;
    }
}