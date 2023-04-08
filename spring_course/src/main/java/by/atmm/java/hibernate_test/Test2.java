package by.atmm.java.hibernate_test;

import by.atmm.java.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-17
 */

public class Test2 {

  public static void main(String[] args) {

    try (SessionFactory factory = new Configuration()
        .configure("hibernate.cfg.xml")
        .addAnnotatedClass(Employee.class)
        .buildSessionFactory()) {

      Employee emp = new Employee("Vasily", "Ivanov", "Sales", 800);

      Session session = factory.getCurrentSession();
      session.beginTransaction();
      session.save(emp);
      session.getTransaction().commit();

      int myId = emp.getId();
      session = factory.getCurrentSession();
      session.beginTransaction();
      Employee employee = session.get(Employee.class, myId);
      session.getTransaction().commit();
      System.out.println(employee);
      System.out.println("Done!");

    }
  }

}
