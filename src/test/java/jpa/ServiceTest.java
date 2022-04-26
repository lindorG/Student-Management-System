package jpa;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import jpa.service.CourseService;
import jpa.service.StudentService;
import org.junit.Test;

public class ServiceTest {
    private final StudentService studentService = new StudentService();
    private final CourseService courseService = new CourseService();

    @Test
    public void getAllStudents() {
        // 1. Prints all students
        System.out.println(studentService.getAllStudents().toString().replace("[", "").replace("]", "").replace(",", ""));
    }
    @Test
    public void getStudentByEmail() {
        // 2. Prints students based on a specified email
        System.out.println(studentService.getStudentByEmail("aiannitti7@is.gd").toString().replace("[", "").replace("]", "").replace(",", ""));
    }
    @Test
    public void validateStudent() {
        // 3. Validates inputted credentials
        System.out.println(studentService.validateStudent("qllorens2@howstuffworks.com", "W6rJuxd"));
    }
    @Test
    public void registerStudentToCourse() throws InterruptedException {
        // 4. Registers a student and does not register them if they're already registered to selected course
        studentService.registerStudentToCourse("qllorens2@howstuffworks.com", 1);
    }
    @Test
    public void getStudentCourses() throws InterruptedException {
        // 5. Lists the courses a student is currently registered to
        System.out.println(studentService.getStudentCourses("aiannitti7@is.gd").toString().replace("[", "").replace("]", "").replace(",", ""));
    }
    @Test
    public void getAllCourses() {
        // 6. Prints all courses
        System.out.println(courseService.getAllCourses().toString().replace("[","").replace("]","").replace(",",""));
    }
    @Test
    public void fixRegistration() {
        // Loop over the student.getCourses(); and check if the cId == course.getId
        Student student = studentService.getStudentByEmail("aiannitti7@is.gd");
        Course course = courseService.getCourseById(1);

        String checkDuplicateCourse = String.valueOf(course);
        String studentFormatted = student.getsCourses().toString().replace("[","").replace("]","").replace(",","");

        if (studentFormatted.contains(checkDuplicateCourse)) {
            System.out.println("You've already registered to this course");
        } else {
            System.out.println("doesn't work");
        }
    }
}