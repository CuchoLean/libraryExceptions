package org.ies.library.components;

import lombok.AllArgsConstructor;
import org.ies.library.models.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor

public class BookReader implements Reader<Book> {

    private final static Logger log = LoggerFactory.getLogger(BookReader.class);
    private final Scanner sc;

    @Override
    public Book read() {
        log.info("Introduce el isbn");
        String isbn = sc.nextLine();
        log.info("Introduce el título");
        String title = sc.nextLine();
        log.info("Introduce el autor");
        String author = sc.nextLine();
        List<String> genres = askGenres();

        return new Book(isbn, title, author, genres);

    }

    private List<String> askGenres() {
        List<String> genres = new ArrayList<>();
        boolean moreGenres = true;
        log.info("Generos");
        do {
            log.info("Introduce un género");
            String genre = sc.nextLine();
            genres.add(genre);
            log.info("¿Desea meter más géneros");
            String response = sc.nextLine();
            moreGenres = !response.equalsIgnoreCase("n");
        } while (moreGenres);
        return genres;
    }
}
