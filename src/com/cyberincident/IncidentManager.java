package com.cyberincident;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IncidentManager {
    private final List<Incident> incidents = new ArrayList<>();
    private int nextId = 1;

    public synchronized Incident addIncident(String title, String description, IncidentSeverity severity) {
        Incident incident = new Incident(nextId++, title, description, severity);
        incidents.add(incident);
        return incident;
    }

    public List<Incident> getAll() {
        return new ArrayList<>(incidents);
    }

    public Incident findById(int id) throws InvalidIncidentException {
        return incidents.stream()
                .filter(i -> i.getId() == id)
                .findFirst()
                .orElseThrow(() -> new InvalidIncidentException("Incident #" + id + " was not found."));
    }

    public List<Incident> search(String keyword) {
        return incidents.stream()
                .filter(i -> i.matches(keyword))
                .collect(Collectors.toList());
    }

    public List<Incident> filterBySeverity(IncidentSeverity severity) {
        return incidents.stream()
                .filter(i -> i.getSeverity() == severity)
                .collect(Collectors.toList());
    }

    public void updateStatus(int id, IncidentStatus status) throws InvalidIncidentException {
        findById(id).setStatus(status);
    }

    public void assign(int id, Investigator investigator) throws InvalidIncidentException {
        findById(id).assignInvestigator(investigator);
    }

    public void restore(Incident incident) {
        incidents.add(incident);
        if (incident.getId() >= nextId) nextId = incident.getId() + 1;
    }
}
