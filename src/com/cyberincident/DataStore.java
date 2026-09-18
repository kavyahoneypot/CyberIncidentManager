package com.cyberincident;

import java.io.*;
import java.util.List;

public class DataStore {
    private static final String FILE = "incidents.txt";

    public static void save(List<Incident> incidents) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (Incident i : incidents) {
                writer.write(i.getId() + "|" + clean(i.getTitle()) + "|" +
                        clean(i.getDescription()) + "|" + i.getSeverity() + "|" + i.getStatus());
                writer.newLine();
            }
        }
    }

    public static int load(IncidentManager manager) throws IOException {
        File file = new File(FILE);
        if (!file.exists()) return 0;

        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split("\\|", -1);
                if (p.length >= 5) {
                    Incident incident = new Incident(
                            Integer.parseInt(p[0]), p[1], p[2],
                            IncidentSeverity.valueOf(p[3]));
                    incident.setStatus(IncidentStatus.valueOf(p[4]));
                    manager.restore(incident);
                    count++;
                }
            }
        }
        return count;
    }

    private static String clean(String s) {
        return s.replace("|", "/").replace("\n", " ");
    }
}
