package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

//    @NotNull
//    @Size(min=2)
//    private String taskname;
//
//    @NotNull
//    @Size(min=6)
//    private String duedate;
//
//    @NotNull
//    @Size(min=3, max=15)
//    private String priority;

    private String headshot;


    private String name;

    private String realname;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getTaskname() {
//        return taskname;
//    }
//
//    public void setTaskname(String taskname) {
//        this.taskname = taskname;
//    }
//
//    public String getDuedate() {
//        return duedate;
//    }
//
//    public void setDuedate(String duedate) {
//        this.duedate = duedate;
//    }
//
//    public String getPriority() {
//        return priority;
//    }
//
//    public void setPriority(String priority) {
//        this.priority = priority;
//    }

    public String getHeadshot() {
        return headshot;
    }

    public void setHeadshot(String headshot) {
        this.headshot = headshot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }
}
