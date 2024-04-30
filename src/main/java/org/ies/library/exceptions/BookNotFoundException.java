package org.ies.library.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class BookNotFoundException extends Exception{
    private String isbn;
}
