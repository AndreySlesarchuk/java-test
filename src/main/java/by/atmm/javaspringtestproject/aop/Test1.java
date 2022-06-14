package by.atmm.javaspringtestproject.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-13
 */

public class Test1 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        uniLibrary.getBook();
        uniLibrary.getMagazine();
        String bookName = uniLibrary.returnBook();
        System.out.println("Book name:"  + bookName);

        SchoolLibrary schoolLibrary = context.getBean("schoolLibrary", SchoolLibrary.class);
        schoolLibrary.getBook();
        schoolLibrary.getMagazine();
        schoolLibrary.returnBook();
        schoolLibrary.getBook("Earth and peace");

        context.close();
    }
}
