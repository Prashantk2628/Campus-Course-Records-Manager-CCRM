# Campus Course & Records Manager (CCRM)

Welcome to CCRM, a straightforward Java console application for managing student and course records in educational settings.

---

## 📝 Project Summary & Getting Started

CCRM offers a command-line interface (CLI) for administrators to efficiently manage academic data. With this tool, you can:

- Add, update, and view students, courses, enrollments, and grades
- Import/export records and create backups
- Generate transcripts and compute GPAs

### Requirements

- *Java Development Kit (JDK):* Version 17 or above

### How to Run

1. **Go to the Source Folder**  
  Open your terminal or command prompt and navigate to the `src` directory.

2. **Compile the Source Code**  
  Compile all Java files to the `bin` directory:

  ```bash
  javac -d ../bin edu/ccrm/cli/MainApp_Refactored_Methods.java edu/ccrm/domain/*.java edu/ccrm/io/*.java edu/ccrm/service/*.java
  ```
  > *Tip: If you have a `util` package, include those files as well.*

3. **Launch the Program**  
  Change to the `bin` directory and start the main class:

  ```bash
  cd ../bin
  java edu.ccrm.cli.MainApp_Refactored_Methods
  ```

  The CCRM menu will appear, ready for use.

---

## 🔄 Java Timeline (Highlights)

- *1995:* Java 1.0 debuts (“write once, run anywhere”)
- *1998:* Java 2 splits into SE, EE, and ME
- *2004:* Java 5 introduces generics, annotations, enhanced for-loops
- *2014:* Java 8 brings lambdas, streams, and default methods
- *Java 9+:* Adds modules, local variable type inference, records, pattern matching

---

## 🆚 Java Editions: ME, SE, EE

| Edition | Audience         | Typical Uses         | Key Features                  |
|---------|------------------|---------------------|-------------------------------|
| *ME*    | Mobile/Embedded  | IoT, devices        | Lightweight VM, minimal APIs  |
| *SE*    | Desktop/Server   | General applications| Core libraries, GUI, network  |
| *EE*    | Enterprise       | Web, distributed    | Servlets, EJB, JMS, JPA       |

---

## ☕ JDK, JRE, JVM: What’s the Difference?

- **JDK (Java Development Kit):** Full toolkit for developing and compiling Java programs (includes JRE, compilers, and tools)
- **JRE (Java Runtime Environment):** Environment to run Java applications (includes JVM and libraries, but no compilers)
- **JVM (Java Virtual Machine):** Executes Java bytecode on any supported platform

---

## 🪟 Installing Java & Setting Up Eclipse on Windows

### Installing the JDK

1. Download the JDK from [Oracle’s website](https://www.oracle.com/java/technologies/downloads/).
2. Run the installer and follow the instructions.
3. Set the `JAVA_HOME` environment variable and update your `PATH`.

### Setting Up Eclipse

1. Download Eclipse IDE from [eclipse.org](https://www.eclipse.org/downloads/).
2. Extract and launch `eclipse.exe`.
3. Choose a workspace directory.
4. Import the CCRM project:  
  File → Import → Existing Projects into Workspace

*Tip: Add screenshots for each step as needed.*

---

## 🗺 Syllabus Topics Mapped to Code

| Topic                  | File/Class/Method                        |
|------------------------|------------------------------------------|
| OOP Principles         | domain/Student.java, domain/Course.java  |
| File Operations        | io/DataImporter.java, io/DataExporter.java|
| Collections Framework  | service/StudentService.java              |
| Exception Handling     | service/EnrollmentService.java           |
| Assertions             | util/AssertionsDemo.java                 |
| CLI Interaction        | cli/MainApp_Refactored_Methods.java      |

---

## 📝 How to Enable Assertions

- **Enable at runtime:**  
  Add the `-ea` flag when running your Java program:

  ```bash
  java -ea edu.ccrm.cli.MainApp_Refactored_Methods
  ```

- **Example assertion:**
  ```java
  assert student != null : "Student object must not be null";
  ```

---

## 🛠 Technology Stack

- **Language:** Java  
- **Platform:** Java SE

---

## Usage Guide

This section explains how to use the CCRM system—a command-line tool for managing students, courses, and enrollments.

**Getting Started**
- **Start the Application:** Run the `MainApp` class from your compiled files.
- **View the Menu:** The main menu will display all available actions.

**--- Welcome to the CCRM System ---**
Hello! What would you like to do?
1. Register a new student
2. List all registered students
...
17. Exit

**Choose an Option:**  
Type the number for your desired action and press Enter. The program will prompt for any required details.

**Menu Overview**

*Student Management*
1. Register a student: Add a new student (ID, name, email, registration number)
2. List students: Show all registered students
3. Remove/deactivate student: Mark a student as inactive by ID
11. View student GPA: Calculate and display a student’s GPA
12. Print transcript: Show a student’s academic record

*Course Management*
4. Add course: Enter course code, title, credits, instructor, department, semester
5. List courses: Show all available courses
6. Remove/deactivate course: Mark a course as inactive by code
13. Find courses by instructor: List courses taught by a specific instructor

*Enrollment & Grading*
7. Enroll student: Add a student to a course
8. Unenroll student: Remove a student from a course
9. List enrollments: Show all current enrollments
10. Assign grades: Give a letter grade (S, A, B, C, D, F) to a student for a course

*Data Management*
14. Import data: Bulk import from CSV files
15. Export data: Save all records to `export.txt`
16. Backup: Create a backup in the `exports` directory
17. Exit: Close the application
