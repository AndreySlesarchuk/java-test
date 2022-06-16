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

public class Test3 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

//            List<Employee> emps = session.createQuery("from Employee").getResultList();
//            for (Employee e : emps) {
//                System.out.println(e);
//            }

            List<Employee> emps = session
                    .createQuery("FROM Employee WHERE name = 'Andrey' AND salary > 500")
                    .getResultList();
            for (Employee e : emps) {
                System.out.println(e);
            }

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

}
