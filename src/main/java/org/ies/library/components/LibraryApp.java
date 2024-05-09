package org.ies.library.components;

import lombok.AllArgsConstructor;
import org.ies.library.exceptions.BookNotFoundException;
import org.ies.library.exceptions.MemberNotFoundException;
import org.ies.library.models.Book;
import org.ies.library.models.Member;
import org.ies.library.models.Library;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

@AllArgsConstructor
public class LibraryApp implements App {
    private final static Logger log = LoggerFactory.getLogger(BookReader.class);
    private final Scanner sc;
    private Reader<Library> libraryReader;

    @Override
    public void run() {
        Library library = libraryReader.read();
        int opt;
        do {
            opt = chooseOption();
            if (opt == 1) {
                runOption1(library);
            } else if (opt == 2) {
                runOption2(library);
            } else if (opt == 3) {
                runOption3(library);
            }
        } while (opt != 4);
    }

    private void runOption3(Library library) {
        log.info("ISBN del libro");
        String isbn = sc.nextLine();
        log.info("NIF del miembro");
        String nif = sc.nextLine();
        try {
            boolean exist = library.existLend(isbn, nif);
            if (exist) {
                log.info("El prestamo existe");
            } else {
                log.info("El prestamo no existe");
            }
        } catch (BookNotFoundException e) {
            log.error("El libro no existe");
        } catch (MemberNotFoundException e) {
            log.error("El miembro no existe");
        }
    }

    private void runOption2(Library library) {
        log.info("NIF del miembro");
        String nif = sc.nextLine();
        try {
            Member member = library.getMemberByNif(nif);
            member.toString();
        } catch (MemberNotFoundException e) {
            log.error("El miembro no existe");
        }
    }

    private void runOption1(Library library) {
        log.info("ISBN del libro");
        String isbn = sc.nextLine();
        try {
            Book book = library.getBookByIsbn(isbn);
            book.toString();
        } catch (BookNotFoundException e) {
            log.error("El libro no existe");
        }
    }

    private int chooseOption() {
        log.info("1. Mostrar libro");
        log.info("2. Mostrar socio");
        log.info("3. Existe prestamo");
        log.info("4. Salir");

        int opt = askNumber("Elige una opción");
        sc.nextLine();
        while (opt < 1 || opt > 4) {
            log.info("Opción inválida, elige una opción válida");
            opt = sc.nextInt();
            sc.nextLine();
        }
        return opt;
    }

    private int askNumber(String message) {
        Integer zipCode = null;
        do {
            log.info(message);
            try {
                zipCode = sc.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
            } finally {
                sc.nextLine();
            }
        } while (zipCode == null);
        return zipCode;
    }

}
