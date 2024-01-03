package org.example.InsertsInto;

import java.time.LocalDate;
import java.util.Date;

public class Worker {

    private int id;
    private String name;
    private LocalDate  birthDate;
    private String status;
    private int salary;

    public Worker(int id, String name, LocalDate  birthDate, String status, int salary) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.status = status;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

