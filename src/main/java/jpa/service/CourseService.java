package jpa.service;

import jpa.dao.CourseDAO;
import jpa.entitymodels.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class CourseService implements CourseDAO {

    String PERSISTENCE_UNIT_NAME = "examdb";

    EntityManagerFactory emFactoryObj =
            Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

    @Override
    public List<Course> getAllCourses() {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT C FROM Course AS C";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);

        System.out.printf("%s\n%-5s %-30s %s", "ALL COURSES", "#", "COURSE NAME", "INSTRUCTOR NAME");

        try {
            return query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }

    public Course getCourseById(Integer cId) {
        EntityManager em = emFactoryObj.createEntityManager();

        String sql = "SELECT C FROM Course AS C WHERE C.cId = :id";
        TypedQuery<Course> query = em.createQuery(sql, Course.class);
        query.setParameter("id", cId);

        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
