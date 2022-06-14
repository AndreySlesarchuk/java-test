package by.atmm.javaspringtestproject.aop;

import org.springframework.stereotype.Component;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-13
 */

@Component
public class UniLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("We take a book from UniLibrary");
    }

    public String returnBook() {
        System.out.println("We are returning a book to UniLibrary: War and Peace");
        return "War and Peace";
    }

    public void getMagazine() {
        System.out.println("We take a magazine from UniLibrary");
    }
}
