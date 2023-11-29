package by.atmm.java.__hibernate.hibernate_one_to_many_bi;

import by.atmm.java.__hibernate.hibernate_one_to_many_bi.entity.Department;
import by.atmm.java.__hibernate.hibernate_one_to_many_bi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-22
 */

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            Department dept = new Department("IT", 500, 1000);
            Employee emp1 = new Employee("Vasiliy", "Ivanov", 1000);
            Employee emp2 = new Employee("Andrey", "Vasilyev", 800);

            dept.addEmployeeToDepartment(emp1);
            dept.addEmployeeToDepartment(emp2);


            session.persist(dept);
            session.getTransaction().commit();

        } finally {
            session.close();
            factory.close();
        }
    }
}
