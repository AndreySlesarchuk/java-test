package by.atmm.java.hibernate_one_to_one;

import by.atmm.java.hibernate_one_to_one.entity.Detail;
import by.atmm.java.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-22
 *
 *  DROP TABLE my_db.employees;
 *  CREATE TABLE my_db.details (
 *   id int NOT NULL AUTO_INCREMENT,
 *   city varchar(15),
 *   phone_number varchar(25),
 *   email varchar(30), PRIMARY KEY (id)
 * );
 *
 * CREATE TABLE my_db.employees (
 *   id int NOT NULL AUTO_INCREMENT,
 *   name varchar(15),
 *   surname varchar(25),
 *   department varchar(20), salary int, details_id int
 * ,  PRIMARY KEY (id)
 * , FOREIGN KEY (details_id) REFERENCES my_db.details(id));
 *
 */

public class Test2 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            // data create
            Employee emp1 = new Employee("Vasiliy", "Ivanov", "HR", 1000);
            Detail detail1 = new Detail("Brest", "+3751611111111", "vi@atmm.by");
            Employee emp2 = new Employee("Andrey", "Vasilyev", "sale", 800);
            Detail detail2 = new Detail("Minsk", "+3751711111111", "av@atmm.by");
            Employee emp3 = new Employee("Mike", "Andreev", "IT", 700);
            Detail detail3 = new Detail("Minsk", "+3751722222222", "ma@atmm.by");

//            emp1.setEmpDetail(detail1);
//            detail1.setEmployee(emp1);
//            emp2.setEmpDetail(detail2);
//            detail2.setEmployee(emp2);
//            emp3.setEmpDetail(detail3);
//            detail3.setEmployee(emp3);
//
//            session.beginTransaction();
//            session.save(detail1);
//            session.save(detail2);
//            session.save(detail3);
//            session.getTransaction().commit();

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 3);
            session.delete(employee);
            Detail detail = session.get(Detail.class, 4);
            // Clearing the foreign key
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }

}
