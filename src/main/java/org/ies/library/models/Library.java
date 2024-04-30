package org.ies.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Library {
    private final static Logger log = LoggerFactory.getLogger(Library.class);
    private String name;
    private List<Book> books;
    private List<Customer> customers;
    private List<Loan> loans;

    public Book getBookByIsbn(String isbn) throws BookNotFoundException {
        return books.stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException(isbn));
//        for (Book book : books) {
//            if (book.getIsbn().equals(isbn)) {
//                return book;
//            }
//        }
//        throw new BookNotFoundException(isbn);
    }

    public Customer getCustomerByNif(String nif) throws MemberNotFoundException {
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        throw new MemberNotFoundException(nif);
    }

    public Boolean giveLoan(String isbn, String nif) throws BookNotFoundException, MemberNotFoundException {
        Book book = getBookByIsbn(isbn);
        if (book == null) {
            throw new BookNotFoundException(isbn);
        } else {
            Customer customer = getCustomerByNif(nif);
            if (customer == null) {
                throw new MemberNotFoundException(nif);
            } else {
                for (Loan loan : loans) {
                    if (loan.getIsbn().equals(isbn) && loan.getNif().equals(nif)) {
                        return true;
                    }
                }
                return false;
            }
        }
    }
}
