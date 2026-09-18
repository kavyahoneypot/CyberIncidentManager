# Cyber Incident Management System

A command-line Java application for registering, managing, searching, assigning, and reporting cybersecurity incidents.

The project demonstrates core Programming in Java concepts including object-oriented programming, inheritance, polymorphism, interfaces, enums, collections, exception handling, multithreading, lambda expressions, streams, and file I/O.

## Requirements

* JDK 17 or later
* Terminal / Command Prompt
* No GUI is required
* No external libraries or third-party dependencies are required

## Setup

### 1. Clone or download the repository

Clone the repository or download and extract the project.

### 2. Open the project root

Open a terminal in the project root directory containing the `src` folder.

### 3. Verify Java installation

Run:

```bash
java -version
javac -version
```

JDK 17 or later is required.

## Compile the Project

From the project root, run:

```bash
javac -d out src/com/cyberincident/*.java
```

This compiles the Java source files and places the generated `.class` files in the `out` directory.

## Run the Project

After successful compilation, run:

```bash
java -cp out com.cyberincident.Main
```

The application will start in the terminal and display the main menu.

## Configuration and Dependencies

No external libraries, Maven, Gradle, database, or GUI framework is required.

The application uses Java's standard library and text-file I/O for local data persistence.

## Features

* Add cybersecurity incidents
* View all incidents
* Search incidents by keyword
* Filter incidents by severity
* Assign incidents to investigators
* Update incident status
* Generate incident reports
* Save and load records using text-file I/O
* Background report generation using a Java thread
* Input validation
* Custom exception handling

## Testing

The application can be tested through its command-line menu.

Test scenarios include:

* Adding valid incidents
* Viewing stored incidents
* Searching incidents by keyword
* Filtering incidents by severity
* Assigning incidents to investigators
* Updating incident status
* Generating reports
* Saving and loading data
* Entering invalid incident IDs
* Entering invalid menu choices

Invalid inputs are handled through validation and exception handling.

## Project Structure

```text
src/
└── com/
    └── cyberincident/
        ├── Main.java
        ├── DataStore.java
        ├── Incident.java
        ├── IncidentManager.java
        ├── IncidentReport.java
        ├── IncidentSeverity.java
        ├── IncidentStatus.java
        ├── InvalidIncidentException.java
        ├── Investigator.java
        ├── Searchable.java
        └── User.java
```

### Main Components

* `Main.java` - Application entry point and command-line menu
* `Incident.java` - Incident model
* `User.java` - Base user class
* `Investigator.java` - Investigator class derived from `User`
* `IncidentSeverity.java` - Incident severity enumeration
* `IncidentStatus.java` - Incident status enumeration
* `Searchable.java` - Search functionality interface
* `IncidentManager.java` - Core incident management and collection operations
* `IncidentReport.java` - Incident report generation
* `DataStore.java` - File I/O and data persistence
* `InvalidIncidentException.java` - Custom exception for invalid incident operations

## Java Concepts Demonstrated

* Encapsulation
* Inheritance
* Method overriding
* Runtime polymorphism
* Interfaces
* Enums
* ArrayList and collections
* Lambda expressions
* Stream API
* Exception handling
* Multithreading
* Synchronization
* Character-oriented file I/O

