import dao.StudentDao;
import model.Student;
import util.HibernateUtil;

public class Main {


  public static void main(String[] args) {
    System.out.println("Start");

    StudentDao studentDao = new StudentDao();
    Student student = new Student("Bogdan", "Judele", "b@j.com");

    studentDao.saveStudent(student);

    System.out.println("Finish");

  }
}
