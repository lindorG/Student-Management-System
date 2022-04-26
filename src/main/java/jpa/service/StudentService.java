package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

import javax.persistence.*;
import java.util.List;

public class StudentService implements StudentDAO {


    String PERSISTENCE_UNIT_NAME = "examdb";

    EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    public List<Student> getAllStudents() {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT S FROM Student AS S";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);

        System.out.printf("%s\n%-30s %-20s %-20s", "ALL STUDENTS", "EMAIL", "NAME", "COURSES");

        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Student getStudentByEmail(String sEmail) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT S FROM Student AS S WHERE S.sEmail = :email";
        TypedQuery<Student> query = em.createQuery(sql, Student.class);
        query.setParameter("email", sEmail);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validateStudent(String sEmail, String sPassword) {
        Student student = getStudentByEmail(sEmail);
        if (student == null)
            return false;
        return (student.getsPass().equals(sPassword));
    }

    public void registerStudentToCourse(String sEmail, int cId) throws InterruptedException {
        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();

        Student student = studentService.getStudentByEmail(sEmail);
        Course course = courseService.getCourseById(cId);

        String checkDuplicateCourse = String.valueOf(course);
        String studentFormatted = student.getsCourses().toString().replace("[","").replace("]","").replace(",","");

        if (studentFormatted.contains(checkDuplicateCourse)) {
            System.out.println("You're already registered to this course");
        }
        else if (sEmail != null && !(sEmail.isEmpty())) {
            EntityManager em = emFactoryObj.createEntityManager();

            em.getTransaction().begin();

            String sql = "INSERT INTO student_course (course_id, student_email) VALUES (?, ?)";
            Query query = em.createNativeQuery(sql);

            query.setParameter(1, cId);
            query.setParameter(2, sEmail);

            query.executeUpdate();

            em.getTransaction().commit();

            em.clear();

        } else if (cId <= 0 || cId >= 11) {
            System.out.println("This course does not exist");
            Thread.sleep(1000);
        } else {
            System.out.println("Your email was not found in our records");
            Thread.sleep(200);
            System.out.println("Please try again");
            Thread.sleep(800);
        }
    }

    public List<Course> getStudentCourses(String sEmail) throws InterruptedException {

        Student student = getStudentByEmail(sEmail);

        if (student.getsCourses() != null && !student.getsCourses().isEmpty()) {
            System.out.printf("%s\n%-5s %-30s %s", "YOUR COURSES", "#", "COURSE NAME", "INSTRUCTOR NAME");
            return student.getsCourses();
        } else {
            System.out.println("You are not registered to any courses");
            Thread.sleep(200);
        }
        return null;
    }
}

