package org.example;

public class DeletObjects {
    public void sendDelet(){
        Database database = new Database();
        String command = "DROP ALL OBJECTS";
        database.executeUpdate(command);
    }
}
