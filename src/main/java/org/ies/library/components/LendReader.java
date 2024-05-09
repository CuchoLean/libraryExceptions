package org.ies.library.components;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ies.library.models.Lend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.Scanner;

@AllArgsConstructor
public class LendReader implements Reader<Lend> {
    private final static Logger log = LoggerFactory.getLogger(BookReader.class);
    private final Scanner sc;

    @Override
    public Lend read() {
        log.info("Introduce el isbn");
        String isbn=sc.nextLine();
        Date loanDate= new Date();
        log.info("Introduce el nif");
        String nif= sc.nextLine();
        Date returnDate= new Date();
        return new Lend(isbn, loanDate, nif, returnDate);
    }
}
