package org.example;

import org.h2.store.Data;

import java.math.BigInteger;
import java.sql.Date;

public class YoungestOldestPerson {
    private String name;
    private Date birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
