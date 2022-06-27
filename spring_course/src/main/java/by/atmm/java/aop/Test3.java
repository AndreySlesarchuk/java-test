package by.atmm.java.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  @author Andrey Slesarchuk
 *  @date 2022-06-14
 */

public class Test3 {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        UniLibrary uniLibrary = context.getBean("uniLibrary", UniLibrary.class);
        String bookName = uniLibrary.returnBook();
        System.out.println("The book returned to the library: " + bookName);

        context.close();
        System.out.println("Method main ends");

    }
}
