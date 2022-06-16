package by.atmm.javaspringtestproject.hibernate_test;

import by.atmm.javaspringtestproject.hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-16
 */

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).buildSessionFactory();
        try {

            Session session = factory.getCurrentSession();

//            Employee emp = new Employee("Vasily", "Ivanov", "Sales", 800);
            Employee emp = new Employee("Andrey", "Vasilyev", "IT", 700);
//            Employee emp = new Employee("Mike", "Andreev", "HR", 600);

            session.beginTransaction();
            session.save(emp);
            System.out.println("Emp after save:" + emp.toString());
//            session.getTransaction().commit();

            int myId = emp.getId();
//            session.beginTransaction();
            Employee employee = session.get(Employee.class, myId);
            session.getTransaction().commit();
            String empString = "Employee by id: " + myId + " from base: " + employee.toString();
            System.out.println(empString);

        } finally {
            factory.close();
        }

    }

}
