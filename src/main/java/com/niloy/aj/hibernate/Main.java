package com.niloy.aj.hibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Main {
    public Main(){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        List<Student> studentList;
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
//            session.save(new Student(3,"John"));

            //Get Criteria Builder
            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Student> criteriaQuery = builder.createQuery(Student.class);
            criteriaQuery.from(Student.class);

            studentList = session.createQuery(criteriaQuery).list();

            transaction.commit();
            session.close();

            studentList.forEach(System.out::println);

        } catch (HibernateException he){
            transaction.rollback();
            he.printStackTrace();
        }
    }
    public static void main(String[] args){
        System.out.println("Hello World!");
        new Main();
    }
}
