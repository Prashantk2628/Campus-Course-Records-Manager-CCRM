# Campus Course & Records Manager (CCRM)

## 📝 Overview

Campus Course & Records Manager (CCRM) is a user-friendly, console-based Java application built to help educational institutions manage their student and course records with ease. Through a straightforward command-line interface (CLI), administrators can handle everyday academic tasks—like enrolling students, managing courses, tracking grades, and more. The system also supports importing/exporting data and creating backups, making record-keeping both simple and reliable.

---

## ✨ Key Features

- **Student Management**
  - Register new students quickly.
  - Browse all enrolled students.
  - Deactivate student accounts when needed.

- **Course Management**
  - Add new courses with details (code, title, credits, instructor).
  - View all available courses.
  - Deactivate courses that are no longer offered.

- **Enrollment & Grades**
  - Enroll or unenroll students in courses.
  - View all enrollment records.
  - Assign and update grades for students.

- **Academic Records**
  - Instantly calculate and display a student's GPA.
  - Generate and print academic transcripts.

- **Data Handling**
  - Search and filter courses by instructor.
  - Import data from CSV files (students, courses, enrollments).
  - Export all data to a text file.
  - Create backups for peace of mind.

---

## 📂 Project Structure

The project follows standard Java conventions, organized into clear packages for maintainability:

```
CCRM/
└── src/
    └── edu/
        └── ccrm/
            ├── cli/      # Command-line interface and menus
            ├── domain/   # Core models: Student, Course, Enrollment, etc.
            ├── io/       # Data import/export and backup
            ├── service/  # Business logic and operations
            └── util/     # Utility classes and helpers
```

---

## 🚀 Getting Started

To run CCRM, make sure you have the Java Development Kit (JDK) installed.

1. **Navigate to the Source Directory**

   Open your terminal or command prompt and go to the `src` folder inside the project.

2. **Compile the Project**

   Compile all Java files. The `-d` flag sets the output directory for compiled classes (here, `../bin`):

   ```bash
   javac -d ../bin edu/ccrm/cli/MainApp_Refactored_Methods.java edu/ccrm/domain/*.java edu/ccrm/io/*.java edu/ccrm/service/*.java
   ```
   > *Tip: Adjust the command if you have files in the `util` package.*

3. **Run the Application**

   Move to the `bin` directory and start the main class:

   ```bash
   cd ../bin
   java edu.ccrm.cli.MainApp_Refactored_Methods
   ```

   The CCRM menu will appear, and you can begin managing your campus records!

---

## 🛠 Technologies Used

- **Language:** Java
- **Platform:** Java SE (Standard Edition)

---

Feel free to explore, contribute, or suggest improvements—happy managing!