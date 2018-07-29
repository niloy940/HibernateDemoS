package com.niloy.aj.hibernate;

import com.niloy.aj.hibernate.model.Address;
import com.niloy.aj.hibernate.model.Course;
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
        SessionFactory sessionFactory = HibernateSingleton.getSessionFactory();


        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();

            /*Student student1 = new Student(8, "Ram");
            Student student2 = new Student(9, "Rahim");
            Student student3 = new Student(10, "John");

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

            student1.setAddress(new Address("Banani", "Dhaka", "Bangladesh", "1211"));
            student2.setAddress(new Address("Kafrul", "Dhaka", "Bangladesh", "1205"));
            student3.setAddress(new Address("Mirpur", "Dhaka", "Bangladesh", "1206"));

            session.save(student1);
            session.save(student2);
            session.save(student3);

            session.save(course1);
            session.save(course2);*/


            //Get Criteria Builder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
            criteriaQuery.from(Student.class);

            List<Student> studentList = session.createQuery(criteriaQuery).list();

            studentList.forEach(System.out::println);
//            studentList.forEach(obj -> System.out.println(obj.getId()+ "." +obj.getName()));

//            Student student = session.get(Student.class, 1);
//            student.setName("Jason");

            Student student = studentList.get(8);

            System.out.println(student.getId());

            System.out.println(student.getAddress());


            transaction.commit();
            System.out.println("Committed successfully");

        } catch (HibernateException he){
            transaction.rollback();
            System.err.println(he);
        }

        session.close();
        System.exit(0);
    }
    public static void main(String[] args){
        System.out.println("Hello World!");
        new Main();
    }
}
