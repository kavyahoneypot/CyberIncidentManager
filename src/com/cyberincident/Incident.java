package com.cyberincident;

public class Incident implements Searchable {
    private final int id;
    private final String title;
    private final String description;
    private final IncidentSeverity severity;
    private IncidentStatus status;
    private Investigator investigator;

    public Incident(int id, String title, String description, IncidentSeverity severity) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.severity = severity;
        this.status = IncidentStatus.OPEN;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public IncidentSeverity getSeverity() { return severity; }
    public IncidentStatus getStatus() { return status; }
    public Investigator getInvestigator() { return investigator; }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public void assignInvestigator(Investigator investigator) {
        this.investigator = investigator;
    }

    @Override
    public boolean matches(String keyword) {
        String k = keyword.toLowerCase();
        return title.toLowerCase().contains(k)
                || description.toLowerCase().contains(k)
                || severity.name().toLowerCase().contains(k)
                || status.name().toLowerCase().contains(k);
    }

    @Override
    public String toString() {
        String person = investigator == null ? "Unassigned" : investigator.getName();
        return String.format("#%d | %s | %s | %s | %s | Investigator: %s",
                id, title, severity, status, description, person);
    }
}
