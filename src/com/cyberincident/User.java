package com.cyberincident;

public class User {
    private final int id;
    private final String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public String getRole() {
        return "User";
    }

    @Override
    public String toString() {
        return id + " - " + name + " (" + getRole() + ")";
    }
}
