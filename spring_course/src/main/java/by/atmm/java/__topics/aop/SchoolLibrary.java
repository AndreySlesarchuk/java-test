package by.atmm.java.__topics.aop;

import org.springframework.stereotype.Component;

/**
 * @author Andrey Slesarchuk
 * @date 2022-06-14
 */

@Component
public class SchoolLibrary extends AbstractLibrary {

    @Override
    public void getBook() {
        System.out.println("We take a book from SchoolLibrary");
    }

    public void getBook(String bookName) {
        System.out.println("We take a book from SchoolLibrary: " + bookName);
    }


    public void returnBook() {
        System.out.println("We return a book to SchoolLibrary");
    }

    public String returnBook(String bookName) {
        return bookName;
    }

    public void getMagazine() {
        System.out.println("We take a magazine from SchoolLibrary");
    }
}
