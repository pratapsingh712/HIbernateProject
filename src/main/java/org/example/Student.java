package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    private int roll_No;
    private String s_Name;
    private int s_Age;

    public int getRoll_No() {
        return roll_No;
    }

    public void setRoll_No(int roll_No) {
        this.roll_No = roll_No;
    }

    public String getS_Name() {
        return s_Name;
    }

    public void setS_Name(String s_Name) {
        this.s_Name = s_Name;
    }

    public int getS_Age() {
        return s_Age;
    }

    public void setS_Age(int s_Age) {
        this.s_Age = s_Age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "roll_No=" + roll_No +
                ", s_Name='" + s_Name + '\'' +
                ", s_Age=" + s_Age +
                '}';
    }
}
