package com.example.allela.fbprojo;

public class User {
    private String names,emails,ages,unique;

    public User(String names, String emails, String ages, String unique) {
        this.names = names;
        this.emails = emails;
        this.ages = ages;
        this.unique = unique;
    }

    public User() {
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getEmails() {
        return emails;
    }

    public void setEmails(String emails) {
        this.emails = emails;
    }

    public String getAges() {
        return ages;
    }

    public void setAges(String ages) {
        this.ages = ages;
    }

    public String getUnique() {
        return unique;
    }

    public void setUnique(String unique) {
        this.unique = unique;
    }
}
