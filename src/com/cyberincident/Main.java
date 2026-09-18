package com.cyberincident;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IncidentManager manager = new IncidentManager();

    public static void main(String[] args) {
        try {
            int loaded = DataStore.load(manager);
            if (loaded > 0) System.out.println("Loaded " + loaded + " incident(s).");
        } catch (Exception e) {
            System.out.println("Could not load saved data: " + e.getMessage());
        }

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            try {
                switch (choice) {
                    case "1" -> addIncident();
                    case "2" -> list(manager.getAll());
                    case "3" -> search();
                    case "4" -> filter();
                    case "5" -> updateStatus();
                    case "6" -> assignInvestigator();
                    case "7" -> generateReport();
                    case "8" -> save();
                    case "0" -> {
                        save();
                        running = false;
                        System.out.println("Exiting. Goodbye!");
                    }
                    default -> System.out.println("Invalid menu choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== CYBER INCIDENT MANAGEMENT SYSTEM ===");
        System.out.println("1. Add incident");
        System.out.println("2. View all incidents");
        System.out.println("3. Search incidents");
        System.out.println("4. Filter by severity");
        System.out.println("5. Update incident status");
        System.out.println("6. Assign investigator");
        System.out.println("7. Generate report");
        System.out.println("8. Save data");
        System.out.println("0. Exit");
        System.out.print("Choose: ");
    }

    private static void addIncident() {
        System.out.print("Title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Description: ");
        String description = scanner.nextLine().trim();
        IncidentSeverity severity = readSeverity();

        if (title.isEmpty() || description.isEmpty())
            throw new IllegalArgumentException("Title and description cannot be empty.");

        Incident i = manager.addIncident(title, description, severity);
        System.out.println("Incident created with ID #" + i.getId());
    }

    private static IncidentSeverity readSeverity() {
        System.out.print("Severity (LOW/MEDIUM/HIGH/CRITICAL): ");
        return IncidentSeverity.valueOf(scanner.nextLine().trim().toUpperCase());
    }

    private static void list(List<Incident> incidents) {
        if (incidents.isEmpty()) {
            System.out.println("No incidents found.");
            return;
        }
        incidents.forEach(System.out::println);
    }

    private static void search() {
        System.out.print("Keyword: ");
        list(manager.search(scanner.nextLine().trim()));
    }

    private static void filter() {
        list(manager.filterBySeverity(readSeverity()));
    }

    private static void updateStatus() throws InvalidIncidentException {
        System.out.print("Incident ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Status (OPEN/INVESTIGATING/RESOLVED): ");
        IncidentStatus status = IncidentStatus.valueOf(scanner.nextLine().trim().toUpperCase());
        manager.updateStatus(id, status);
        System.out.println("Status updated.");
    }

    private static void assignInvestigator() throws InvalidIncidentException {
        System.out.print("Incident ID: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.print("Investigator name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Specialization: ");
        String specialization = scanner.nextLine().trim();

        Investigator investigator = new Investigator(id, name, specialization);
        manager.assign(id, investigator);
        System.out.println("Investigator assigned.");
    }

    private static void generateReport() throws InterruptedException {
        Thread reportThread = new Thread(new IncidentReport(manager.getAll()));
        reportThread.start();
        reportThread.join();
    }

    private static void save() {
        try {
            DataStore.save(manager.getAll());
            System.out.println("Data saved to incidents.txt");
        } catch (IOException e) {
            System.out.println("Save failed: " + e.getMessage());
        }
    }
}
