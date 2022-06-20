package by.atmm.javaspringtestproject.hibernate_test_2;

import by.atmm.javaspringtestproject.hibernate_test_2.entity.Detail;
import by.atmm.javaspringtestproject.hibernate_test_2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-20
 */

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee employee = new Employee("Vasiliy", "Ivanov", "HR", 1000);
            Detail detail = new Detail("Brest", "+3751611111111", "vi@brest.by");

            employee.setEmpDetail(detail);
            session.beginTransaction();

            session.save(employee);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            factory.close();
        }

    }

}
