package org.ies.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lend {
    private String isbn;
    private Date loanDate;
    private String nif;
    private Date returnDate;
}
