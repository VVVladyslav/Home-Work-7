package org.example;

import java.sql.Date;

public class LongestProject {
    private int id;
    private int idClient;
    private Date StartData;
    private Date FinishData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Date getStartData() {
        return StartData;
    }

    public void setStartData(Date startData) {
        StartData = startData;
    }

    public Date getFinishData() {
        return FinishData;
    }

    public void setFinishData(Date finishData) {
        FinishData = finishData;
    }
}
