package org.ies.library.components;

import lombok.AllArgsConstructor;
import org.ies.library.models.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

@AllArgsConstructor
public class MemberReader implements Reader<Member> {
    private final static Logger log = LoggerFactory.getLogger(BookReader.class);
    private final Scanner sc;

    @Override
    public Member read() {
        log.info("Introduce tu nif");
        String nif = sc.nextLine();
        log.info("Introduce tu nombre");
        String name = sc.nextLine();
        log.info("Introduce tu apellido");
        String surname = sc.nextLine();
        int number = askNumber("Introduce el número");
        int zipCode = askNumber("Introduce el código postal");
        return new Member(nif, name, surname, number, zipCode);
    }

    private int askNumber(String message) {
        Integer number = null;
        do {
            log.info(message);
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                log.error("El valor introducido no es un entero");
            } finally {
                sc.nextLine();
            }
        } while (number == null);
        return number;
    }
}
