package by.atmm.javaspringtestproject.hibernate_test;

import by.atmm.javaspringtestproject.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-16
 */

public class Test4 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Employee emp = session.get(Employee.class, 1);
            emp.setSalary(1100);

            session.createQuery("UPDATE Employee SET salary = 1000 WHERE name = 'Andrey'")
                    .executeUpdate();

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

}
