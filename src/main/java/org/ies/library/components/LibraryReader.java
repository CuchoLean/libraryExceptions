package org.ies.library.components;

import lombok.AllArgsConstructor;
import org.ies.library.models.Book;
import org.ies.library.models.Member;
import org.ies.library.models.Lend;
import org.ies.library.models.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class LibraryReader implements Reader<Library> {
    private final static Logger log = LoggerFactory.getLogger(BookReader.class);
    private final Scanner sc;
    private final Reader<Book> bookReader;
    private final Reader<Member> customerReader;
    private final Reader<Lend> lendReader;

    @Override
    public Library read() {
        log.info("Introduce el nombre de la biblioteca");
        String name = sc.nextLine();
        List<Book> books = askBooks("Libros");
        List<Member> members = askCustomers("Clientes");
        List<Lend> lends= askLends("Prestamos");
        return new Library(name, books, members, lends);
    }

    private List<Lend> askLends(String message) {
        List<Lend> books= new ArrayList<>();
        boolean moreLends= true;
        log.info(message);
        do {
            log.info("Introduce prestamo");
            books.add(lendReader.read());
            log.info("¿Desea meter más prestamos? (Y/n)");
            String response = sc.nextLine();
            moreLends = !response.equalsIgnoreCase("n");
        }while (moreLends);
        return books;
    }

    private List<Member> askCustomers(String message) {
        List<Member> books= new ArrayList<>();
        boolean moreCustomers= true;
        log.info(message);
        do {
            log.info("Introduce miembro");
            books.add(customerReader.read());
            log.info("¿Desea meter más miembros? (Y/n)");
            String response = sc.nextLine();
            moreCustomers = !response.equalsIgnoreCase("n");
        }while (moreCustomers);
        return books;
    }

    private List<Book> askBooks(String message) {
        List<Book> books= new ArrayList<>();
        boolean moreBooks= true;
        log.info(message);
        do {
            log.info("Introduce libro");
            books.add(bookReader.read());
            log.info("¿Desea meter más libros? (Y/n)");
            String response = sc.nextLine();
            moreBooks = !response.equalsIgnoreCase("n");
        }while (moreBooks);
        return books;
    }
}
