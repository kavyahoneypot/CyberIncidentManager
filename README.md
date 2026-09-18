# Cyber Incident Management System

A command-line Java application for registering, managing, searching, assigning, and reporting cybersecurity incidents. The project demonstrates core Programming in Java concepts including OOP, inheritance, polymorphism, interfaces, enums, collections, exception handling, multithreading, lambda/streams, and file I/O.

## Requirements
- JDK 17 or later
- Terminal/Command Prompt

## Setup and Run

1. Extract or clone this repository.
2. Open a terminal in the project root.
3. Compile:
   ```bash
   javac -d out src/com/cyberincident/*.java
   ```
4. Run:
   ```bash
   java -cp out com.cyberincident.Main
   ```

No external libraries or GUI are required.

## Features
- Add cybersecurity incidents
- View all incidents
- Search incidents by keyword
- Filter incidents by severity
- Assign incidents to investigators
- Update incident status
- Generate a report
- Save/load records using text-file I/O
- Background report generation using a Java thread
- Input validation and custom exceptions

## Testing
Use the menu to add incidents, search/filter them, update status, assign investigators, generate a report, and save data. Invalid incident IDs and invalid menu choices are handled through validation and exceptions.

## Project Structure
- `Main.java` - application entry point and menu
- `Incident.java` - incident model
- `User.java` - base user class
- `Investigator.java` - inherited investigator class
- `IncidentSeverity.java` - severity enum
- `IncidentStatus.java` - status enum
- `Searchable.java` - search interface
- `IncidentManager.java` - core collection/business operations
- `IncidentReport.java` - report generation
- `DataStore.java` - file I/O persistence
- `InvalidIncidentException.java` - custom exception

## Java Concepts Demonstrated
Encapsulation, inheritance, method overriding, runtime polymorphism, interfaces, enums, ArrayList/collections, streams and lambda expressions, exception handling, threads, synchronization, and character-oriented file I/O.
