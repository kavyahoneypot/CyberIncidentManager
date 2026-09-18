package com.cyberincident;

import java.util.List;

public class IncidentReport implements Runnable {
    private final List<Incident> incidents;

    public IncidentReport(List<Incident> incidents) {
        this.incidents = incidents;
    }

    public synchronized String generate() {
        StringBuilder report = new StringBuilder();
        report.append("\n===== CYBER INCIDENT REPORT =====\n");
        report.append("Total incidents: ").append(incidents.size()).append("\n");
        for (Incident i : incidents) {
            report.append(i).append("\n");
        }
        report.append("=================================\n");
        return report.toString();
    }

    @Override
    public void run() {
        System.out.println("\n[Background thread] Generating report...");
        System.out.println(generate());
    }
}
