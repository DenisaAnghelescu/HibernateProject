package util;

import java.util.Properties;
import model.Student;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

  private static SessionFactory sessionFactory;

  public static SessionFactory getSessionFactory() {

    if (sessionFactory == null) {
      /*START BOILER PLATE CODE */
      Configuration configuration = new Configuration();
      Properties settings = new Properties();
      settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");

      settings.put(Environment.URL, "jdbc:mysql://localhost:3306/jdbcbuc17?useSSL=false");
      settings.put(Environment.USER, "root");
      settings.put(Environment.PASS, "root");
      settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
      settings.put(Environment.SHOW_SQL, "true");
      settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
      settings.put(Environment.HBM2DDL_AUTO, "update");
      configuration.setProperties(settings);

      configuration.addAnnotatedClass(Student.class);

      ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
          .applySettings(configuration.getProperties()).build();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
      /*END BOILER PLATE CODE*/
    }

    return sessionFactory;
  }
}
