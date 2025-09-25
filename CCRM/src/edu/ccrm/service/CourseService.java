package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.*;
import java.util.stream.Collectors;

public class CourseService {
    private final Map<String, Course> coursesByCode = new HashMap<>();

    public void addCourse(Course c) {
        coursesByCode.put(c.getCode(), c);
    }

    public void listCourses() {
        if (coursesByCode.isEmpty()) {
            System.out.println("No courses available.");
            return;
        }
        for (Course course : coursesByCode.values()) {
            System.out.println(course);
        }
    }

    public Optional<Course> findByCode(String code) {
        return Optional.ofNullable(coursesByCode.get(code));
    }

    public List<Course> searchByInstructor(String instructorName) {
        return coursesByCode.values().stream()
                .filter(course -> instructorName.equalsIgnoreCase(course.getInstructor()))
                .collect(Collectors.toList());
    }

    public List<Course> filterByDepartment(String department) {
        return coursesByCode.values().stream()
                .filter(course -> {
                    try {
                        Object dept = course.getClass().getMethod("getDepartment").invoke(course);
                        return department.equalsIgnoreCase(dept != null ? dept.toString() : "");
                    } catch (Exception ex) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Course> filterBySemester(String semester) {
        return coursesByCode.values().stream()
                .filter(course -> {
                    try {
                        Object sem = course.getClass().getMethod("getSemester").invoke(course);
                        return semester.equalsIgnoreCase(sem != null ? sem.toString() : "");
                    } catch (Exception ex) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
    }

    public List<Course> getAllCourses() {
        return new ArrayList<>(coursesByCode.values());
    }
}
