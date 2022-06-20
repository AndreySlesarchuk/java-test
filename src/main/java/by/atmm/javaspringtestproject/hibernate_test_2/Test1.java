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


        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            // create Detail
//            Employee employee = new Employee("Vasiliy", "Ivanov", "HR", 1000);
//            Detail detail = new Detail("Brest", "+3751611111111", "vi@brest.by");
//            Employee employee = new Employee("Mike", "Andreev", "IT", 700);
//            Detail detail = new Detail("Minsk", "+3751711111111", "ma@minsk.by");
//
//            employee.setEmpDetail(detail);
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            System.out.println("Done!");

            // get Detail
//            session.beginTransaction();
//            Employee emp = session.get(Employee.class, 2);
//            Detail detail = new Detail("Minsk", "+3751711111111", "ma@minsk.by");
//            System.out.println(emp.getEmpDetail());

            //delete Employee
            session.beginTransaction();
            Employee emp = session.get(Employee.class, 2);
            session.delete(emp);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }

}
