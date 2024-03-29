package by.atmm.java.__hibernate.hibernate_test;

import by.atmm.java.__hibernate.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-19
 */

public class Test5 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 3);
            emp.setSalary(1100);

            session.delete(emp);

            session.createQuery("DELETE Employee WHERE name = 'Andrey'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

}
