package org.example.Delet;

import org.example.Database;

public class DeletObjects {
    public void sendDelet(){
        Database database = new Database();
        String command = "DROP ALL OBJECTS";
        database.executeUpdate(command);
    }
}
