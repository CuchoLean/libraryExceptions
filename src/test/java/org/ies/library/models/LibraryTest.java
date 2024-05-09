package org.ies.library.models;

import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;
import org.junit.Assert;
import org.junit.Test;


import java.util.Date;
import java.util.List;


public class LibraryTest {
    private Book book = new Book("1", "Libro1", "Autor1", List.of("Fantasía", "Horror"));
    private Book book2 = new Book("2", "Libro2", "Autor2", List.of("Drama", "Mal"));
    private Lend lend = new Lend("1", new Date(), "12");
    private Lend lend2 = new Lend("2", new Date(), "13");
    private Member member1 = new Member("12", "Antonio", "Q", 123, 12345);
    private Member member2 = new Member("13", "Iker", "G", 456, 12345);
    private Library library = new Library("Libreria", List.of(book, book2), List.of(member1, member2), List.of(lend, lend2));

    @Test
    public void getBook1() throws BookNotFoundException {
        Book foundBook = library.getBookByIsbn("1");
        Assert.assertEquals(book, foundBook);
    }

    //Todos los test de abajo son de un metodo
    @Test
    public void existLendTest() throws BookNotFoundException, MemberNotFoundException {
        var proof = library.existLend("1", "12");
        Assert.assertTrue(proof);
    }

    @Test
    public void notExistLendTest() throws BookNotFoundException, MemberNotFoundException {
        var proof = library.existLend("1", "13");
        Assert.assertFalse(proof);
    }

    @Test(expected = BookNotFoundException.class)
    public void existLendWrongBookTest() throws BookNotFoundException, MemberNotFoundException {
        var proof = library.existLend("1235", "13");
    }

    @Test(expected = MemberNotFoundException.class)
    public void existLendWrongMemberTest() throws BookNotFoundException, MemberNotFoundException {
        var proof = library.existLend("1", "135346");
    }
}