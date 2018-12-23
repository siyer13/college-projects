package com.education.school.dao.impl;

import com.education.school.dao.StudentDAO;
import com.education.school.entity.Marks;
import com.education.school.entity.Student;
import com.education.school.exception.StudentNotFoundException;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


import java.util.List;

@Repository
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {

    private final static Logger logger = LoggerFactory.getLogger(StudentDAOImpl.class);

    private SessionFactory sessionFactory;
    private Session session;

    @Autowired
    private Student student;


    private final String FIND_STUDENT_SQL = "SELECT * FROM STUDENT WHERE STUDENT_ID = :stu_id";
    private final String GET_STUDENT_MARKS_SQL = "SELECT * FROM STUDENT JOIN MARKS WHERE ";

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        Session session = null;
        try {
            session = this.sessionFactory.openSession();
            ;
        } catch (HibernateException e) {
            e.getStackTrace();
        }
        return session;
    }


    @Override
    public void persistStudent(Student student, String txnID) throws Exception {
        boolean commited = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.save(student);
            session.flush();
            session.clear();
            session.getTransaction().commit();
            commited = true;
        }catch(Exception e) {
            logger.error(e.getMessage());
        }
        finally {
            session.close();
        }
        if(commited)
            logger.info("Student commited to DB. " + student + " txnID: " + txnID);
    }

    @Override
    public Student findStudentByID(String studentID, String txnID) throws StudentNotFoundException {
        session = getSession();
        Query query = session.createSQLQuery(FIND_STUDENT_SQL);
        query.setString("stu_id", studentID);
        List<Object[]> stu = query.list();
        if(stu.size() == 0) throw new StudentNotFoundException("Student not found");
        session.flush();
        session.clear();
        session.close();
        int column = 0;
        for (Object[] row : stu) {
           for(Object obj : row) {
              switch (column) {
                  case 0:
                      student.setStudentId(obj.toString());
                      break;
                  case 1:
                      student.setFirstName(obj.toString());
                      break;
                  case 2:
                      student.setMiddleName(obj.toString());
                      break;
                  case 3:
                      student.setLastName(obj.toString());
                      break;
                  case 4:
                      student.setCollege(obj.toString());
                      break;
                  case 5:
                      student.setDepartment(obj.toString());
                      break;
                  case 6:
                      student.setCourse(obj.toString());
                      break;
                  default:
              }
              column++;
           }
        }
        return student;
    }

    @Override
    public Marks getStudentMarkDetailsByID(String studentID, String txnID) {
        return null;
    }
}


