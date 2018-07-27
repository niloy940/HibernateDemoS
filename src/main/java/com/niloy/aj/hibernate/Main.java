package com.niloy.aj.hibernate;

import com.niloy.aj.hibernate.model.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    public Main(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();


        List<Student> studentList;

        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            /*Student student1 = new Student(5, "EEE");
            Student student2 = new Student(6, "FFF");
            Student student3 = new Student(7, "GGG");

            Course course1 = new Course("CSE4048", "Advanced Java", 3.0);
            Course course2 = new Course("CSE4041", "Artificial Intelligence", 3.0);

            student1.addCourse(course1);
            student1.addCourse(course2);
            student2.addCourse(course1);
            student3.addCourse(course1);
            student3.addCourse(course2);

            course1.addStudent(student1);
            course1.addStudent(student2);
            course1.addStudent(student3);
            course2.addStudent(student1);
            course2.addStudent(student3);

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.save(course1);
            session.save(course2);*/


            //Get Criteria Builder
            /*CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
            criteriaQuery.from(Student.class);

            studentList = session.createQuery(criteriaQuery).list();

            studentList.forEach(System.out::println);*/


             Student student;

            student = session.get(Student.class, 6);
//            student.setName("Jason");

            System.out.println(student);

            transaction.commit();

        } catch (HibernateException he){
            transaction.rollback();
            he.printStackTrace();
        }

        session.close();
        System.exit(0);
    }
    public static void main(String[] args){
        System.out.println("Hello World!");
        new Main();
    }
}
