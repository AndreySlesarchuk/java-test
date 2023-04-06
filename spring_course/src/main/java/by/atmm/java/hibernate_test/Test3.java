package by.atmm.java.hibernate_test;

import by.atmm.java.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-18
 */

public class Test3 {

  public static void main(String[] args) {

    try (SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .buildSessionFactory()) {
      Session session = factory.getCurrentSession();
      session.beginTransaction();
      List<Employee> emps = session.createQuery("FROM Employee WHERE name = 'Andrey'")
          .getResultList();

      for (Employee e : emps) {
        System.out.println(e);
      }
      session.getTransaction().commit();
      System.out.println("Done!");
    }
  }

}
