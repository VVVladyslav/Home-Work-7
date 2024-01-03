package org.example.InsertsInto;
import java.time.LocalDate;
public class Project {
    private int projectId;
    private int workerId;
    private LocalDate startDate;
    private LocalDate finishDate;

    public Project(int projectId, int workerId, LocalDate startDate, LocalDate finishDate) {
        this.projectId = projectId;
        this.workerId = workerId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }
}
