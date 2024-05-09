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
    private List<Member> members;
    private List<Lend> lends;

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

    public Member getMemberByNif(String nif) throws MemberNotFoundException {
        for (Member member : members) {
            if (member.getNif().equals(nif)) {
                return member;
            }
        }
        throw new MemberNotFoundException(nif);
    }

    public Boolean existLend(String isbn, String nif) throws BookNotFoundException, MemberNotFoundException {
        Book book = getBookByIsbn(isbn);
        Member member = getMemberByNif(nif);
        return lends.stream()
                .filter(lend -> lend.getIsbn().equals(isbn) && lend.getNif().equals(nif))
                .findFirst()
                .isPresent();

//        for (Lend lend : lends) {
//            if (lend.getIsbn().equals(isbn) && lend.getNif().equals(nif)) {
//                return true;
//            }
//        }
//        return false;
    }
}
