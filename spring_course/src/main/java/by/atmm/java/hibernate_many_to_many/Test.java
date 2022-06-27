package by.atmm.java.hibernate_many_to_many;

import by.atmm.java.hibernate_many_to_many.entity.Child;
import by.atmm.java.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-24
 */

public class Test {
    public static void main(String[] args) {
        //int i = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Child child1 = new Child("Maha", 19);
            Child child2 = new Child("Miha", 13);

            Section s1 = new Section("Music");
            Section s2 = new Section("France");
            Section s3 = new Section("Fencing");

            child1.addSectionToChild(s1);
            child1.addSectionToChild(s2);

            child2.addSectionToChild(s1);
            child2.addSectionToChild(s3);

            session.beginTransaction();
            session.persist(child1);
            session.persist(child2);
            session.getTransaction().commit();

//            session.beginTransaction();
//            List<Child> children = session.createQuery("FROM Child").getResultList();
//            for (Child child: children) {
//                System.out.println(child.getName() + " sections:");
//                child.getSections().forEach(s -> System.out.println(s.toString()));
//            }

        } finally {
            session.close();
            factory.close();
        }

    }

}
