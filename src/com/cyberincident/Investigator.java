package com.cyberincident;

public class Investigator extends User {
    private final String specialization;

    public Investigator(int id, String name, String specialization) {
        super(id, name);
        this.specialization = specialization;
    }

    public String getSpecialization() { return specialization; }

    @Override
    public String getRole() {
        return "Investigator: " + specialization;
    }
}
