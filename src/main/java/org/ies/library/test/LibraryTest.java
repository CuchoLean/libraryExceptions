package org.ies.library.test;

import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.models.Book;
import org.ies.library.models.Customer;
import org.ies.library.models.Library;
import org.ies.library.models.Loan;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

public class LibraryTest {
    private Book book= new Book("1","Libro1","Autor1", List.of("Fantasía","Horror"));
    private Book book2= new Book("2","Libro2", "Autor2", List.of("Drama","Mal"));
    private Loan loan= new Loan("1",new Date(),"12");
    private Loan loan2= new Loan("2", new Date(),"13");
    private Customer customer1=new Customer("12","Antonio","Q",123,12345);
    private Customer customer2=new Customer("13","Iker","G",456,12345);
    private Library library= new Library("Libreria", List.of(book,book2),List.of(customer1,customer2),List.of(loan,loan2));

    @Test
    public void getBook1() throws BookNotFoundException{
        Book foundBook=library.getBookByIsbn("1");

    }
}
