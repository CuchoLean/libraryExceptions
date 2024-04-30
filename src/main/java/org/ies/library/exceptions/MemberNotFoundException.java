package org.ies.library.exceptions;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class MemberNotFoundException extends Exception{
    private  String nif;
}
