package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DatabasePopulateService {
    public DatabasePopulateService() {
        main(new String[]{"start"});
    }
    public static void main(String[] args) {

        Database database = new Database();
        StringBuilder fileContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\sergei\\IdeaProjects\\Hm6i\\src\\main\\resources\\populate_db.sql"))) {
            String line;
            while ((line = br.readLine()) != null) {
                fileContent.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        String contentAsString = fileContent.toString();
        database.executeUpdate(contentAsString);
    }
}
