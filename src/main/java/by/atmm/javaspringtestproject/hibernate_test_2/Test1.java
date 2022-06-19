package by.atmm.javaspringtestproject.hibernate_test_2;

import by.atmm.javaspringtestproject.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-16
 */

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {

            Employee emp = new Employee("Vasily", "Ivanov", "Sales", 800);

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(emp);
            session.getTransaction().commit();

        } finally {
            factory.close();
        }

    }

}
