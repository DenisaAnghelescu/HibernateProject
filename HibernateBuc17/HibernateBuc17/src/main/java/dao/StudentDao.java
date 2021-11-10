package dao;

import model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class StudentDao {

  public void saveStudent(Student student) {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Session session = sessionFactory.openSession();

    Transaction transaction = session.beginTransaction();
    session.save(student);
    transaction.commit();
  }

}
