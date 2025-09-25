package edu.ccrm.service;

import edu.ccrm.domain.*;
import java.util.*;

public class EnrollmentService {
    private final List<Enrollment> enrollments = new ArrayList<>();
    private final int MAX_CREDITS_PER_SEMESTER = 18;

    public void enroll(Student student, Course course) {
        boolean alreadyEnrolled = enrollments.stream()
                .anyMatch(e -> e.getStudent().equals(student) && e.getCourse().equals(course));
        if (alreadyEnrolled) {
            System.out.println("Already enrolled!");
            return;
        }

        int totalCredits = enrollments.stream()
                .filter(e -> e.getStudent().equals(student))
                .mapToInt(e -> e.getCourse().getCredits())
                .sum();

        if (totalCredits + course.getCredits() > MAX_CREDITS_PER_SEMESTER) {
            System.out.println("Cannot enroll! Max credits per semester exceeded.");
            return;
        }

        Enrollment enrollment = new Enrollment(student, course);
        enrollments.add(enrollment);
        student.addEnrollment(enrollment);
        student.enrollCourse(course);

        System.out.println("Enrollment successful!");
    }

    public void unenroll(Student student, Course course) {
        Optional<Enrollment> enrollmentOpt = enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.getCourse().equals(course))
                .findFirst();

        if (enrollmentOpt.isPresent()) {
            Enrollment enrollment = enrollmentOpt.get();
            enrollments.remove(enrollment);
            student.getEnrollments().remove(enrollment);
            student.getEnrolledCourses().remove(course);
            System.out.println("Unenrolled successfully from " + course.getTitle());
        } else {
            System.out.println("Enrollment not found!");
        }
    }

    public void assignGrade(Student student, Course course, Grade grade) {
        Enrollment enrollment = enrollments.stream()
                .filter(e -> e.getStudent().equals(student) && e.getCourse().equals(course))
                .findFirst()
                .orElse(null);

        if (enrollment != null) {
            enrollment.setGrade(grade);
            System.out.println("Grade assigned!");
        } else {
            System.out.println("Enrollment not found!");
        }
    }

    public void listEnrollments() {
        if (enrollments.isEmpty()) {
            System.out.println("No enrollments yet.");
            return;
        }
        enrollments.forEach(System.out::println);
    }

    public double calculateGPA(Student student) {
        int credits = 0;
        int points = 0;

        for (Enrollment enrollment : enrollments) {
            if (enrollment.getStudent().equals(student) && enrollment.getGrade() != null) {
                int courseCredits = enrollment.getCourse().getCredits();
                credits += courseCredits;
                points += courseCredits * enrollment.getGrade().getPoints();
            }
        }

        if (credits == 0) {
            return 0.0;
        }
        return (double) points / credits;
    }

    public List<Enrollment> getAllEnrollments() {
        return new ArrayList<>(enrollments);
    }
}
