package model;

import enums.UserType;

public class User {
    private String name;
    private String phoneNumber;
    Table table;

    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;

    }

    public User(String name, Table table) {
        this.name = name;
        this.table = table;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
