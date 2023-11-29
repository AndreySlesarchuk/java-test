package by.atmm.java.__hibernate.hibernate_one_to_one;

import by.atmm.java.__hibernate.hibernate_one_to_one.entity.Detail;
import by.atmm.java.__hibernate.hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-20
 * <p>
 * DROP TABLE my_db.employees;
 * CREATE TABLE my_db.details (
 * id int NOT NULL AUTO_INCREMENT,
 * city varchar(15),
 * phone_number varchar(25),
 * email varchar(30), PRIMARY KEY (id)
 * );
 * <p>
 * CREATE TABLE my_db.employees (
 * id int NOT NULL AUTO_INCREMENT,
 * name varchar(15),
 * surname varchar(25),
 * department varchar(20), salary int, details_id int
 * ,  PRIMARY KEY (id)
 * , FOREIGN KEY (details_id) REFERENCES my_db.details(id));
 */

public class Test1 {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class).buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            session = factory.getCurrentSession();
            // create Detail
            Employee emp1 = new Employee("Vasiliy", "Ivanov", "HR", 1000);
            Detail detail1 = new Detail("Brest", "+3751611111111", "vi@atmm.by");
            Employee emp2 = new Employee("Andrey", "Vasilyev", "sale", 800);
            Detail detail2 = new Detail("Minsk", "+3751711111111", "av@atmm.by");
            Employee emp3 = new Employee("Mike", "Andreev", "IT", 700);
            Detail detail3 = new Detail("Minsk", "+3751722222222", "ma@atmm.by");

            emp1.setEmpDetail(detail1);
            session.beginTransaction();
            session.save(emp1);
            emp2.setEmpDetail(detail2);
            session.save(emp2);
            emp3.setEmpDetail(detail3);
            session.save(emp3);
            //session.getTransaction().commit();

            //get Detail
            //session.beginTransaction();
            Employee emp4 = session.get(Employee.class, 2);
            //Detail detail = new Detail("Minsk", "+3751711111111", "ma@minsk.by");
            System.out.println("--------> emp4: " + emp4.getEmpDetail());

            //delete Employee
            //session.beginTransaction();
            Employee emp5 = session.get(Employee.class, 2);
            session.delete(emp5);

            session.getTransaction().commit();
            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }

}
