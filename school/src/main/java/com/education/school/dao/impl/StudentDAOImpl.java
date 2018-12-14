package com.education.school.dao.impl;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Marks;
import com.education.school.entity.Student;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import javax.persistence.TypedQuery;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {

    private final static Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;
    private Session session;

    private final String SQL_FIND_STUDENT = "select * from student where student_id = :stu_id";

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        Session session;
        try {
            session = this.sessionFactory.getCurrentSession();
        }catch(HibernateException e) {
            session = sessionFactory.openSession();
        }
        return session;
    }


    @Override
    public void persistStudent(Student student, String txnID) {
        session = getSession();
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
    public Student findStudentByID(String studentID, String txnID) {
        session = getSession();
        Query query = session.createSQLQuery(SQL_FIND_STUDENT);
        query.setString("stu_id", studentID);
        List<Object[]> stu =  query.list();

        for(Object[] row : stu){
            for(Object obj : row){
                System.out.print(obj + "::");
            }
            System.out.println("");
        }

        return null;
    }

    @Override
    public Marks getStudentMarkDetailsByID(String studentID, String txnID) {
        return null;
    }
}
