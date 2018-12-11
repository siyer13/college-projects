package com.education.school.dao.impl;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.TypedQuery;
import java.sql.SQLException;

@Repository
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {

    private final static Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void persistStudent(Student student, String txnID) {
        Session session;
        try {
             session = this.sessionFactory.getCurrentSession();
        }catch(HibernateException e) {
            session = sessionFactory.openSession();
        }
        try {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        logger.info("Student details commited to DB. " + student + " txnID: "+ txnID);
    }

    @Override
    public Student findStudentByID(String studentID) {
        return null;
    }
}
