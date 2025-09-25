package edu.ccrm.io;

import edu.ccrm.domain.*;
import edu.ccrm.service.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class ImportService {

    public void importStudents(String filePath, StudentService studentService) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length >= 4) {
                Student s = new Student(
                        parts[0].trim(),
                        parts[1].trim(),
                        parts[2].trim(),
                        parts[3].trim()
                );
                studentService.addStudent(s);
            }
        }
        System.out.println("Students imported successfully from " + filePath);
    }

    public void importCourses(String filePath, CourseService courseService) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length >= 6) {
                Course c = new Course(
                        parts[0].trim(),
                        parts[1].trim(),
                        Integer.parseInt(parts[2].trim()),
                        parts[3].trim(),
                        parts[4].trim(),
                        parts[5].trim()
                );
                courseService.addCourse(c);
            }
        }
        System.out.println("Courses imported successfully from " + filePath);
    }

    public void importEnrollments(String filePath, StudentService studentService, CourseService courseService, EnrollmentService enrollmentService) throws IOException {
        Path path = Paths.get(filePath);
        if (!Files.exists(path)) {
            System.out.println("File not found: " + filePath);
            return;
        }

        List<String> lines = Files.readAllLines(path);
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }
            String[] parts = line.split(",");
            if (parts.length >= 2) {
                String studentId = parts[0].trim();
                String courseCode = parts[1].trim();
                Optional<Student> studentOpt = studentService.findById(studentId);
                Optional<Course> courseOpt = courseService.findByCode(courseCode);

                if (studentOpt.isPresent() && courseOpt.isPresent()) {
                    Student student = studentOpt.get();
                    Course course = courseOpt.get();
                    enrollmentService.enroll(student, course);

                    if (parts.length >= 3 && !parts[2].trim().isEmpty()) {
                        try {
                            Grade grade = Grade.valueOf(parts[2].trim());
                            enrollmentService.assignGrade(student, course, grade);
                        } catch (IllegalArgumentException ex) {
                            System.out.println("Invalid grade for student " + studentId + " course " + courseCode);
                        }
                    }
                } else {
                    System.out.println("Invalid student or course in line: " + line);
                }
            }
        }
        System.out.println("Enrollments imported successfully from " + filePath);
    }
}
