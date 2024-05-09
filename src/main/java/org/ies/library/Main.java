package org.ies.library;


import org.ies.library.components.*;
import org.ies.library.models.Book;
import org.ies.library.models.Lend;
import org.ies.library.models.Library;
import org.ies.library.models.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private final static Logger log = LoggerFactory.getLogger(BookReader.class);

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Reader<Book> bookReader= new BookReader(sc);
        Reader<Member> memberReader= new MemberReader(sc);
        Reader<Lend> lendReader= new LendReader(sc);
        Reader<Library> libraryReader= new LibraryReader(sc,bookReader,memberReader,lendReader);
        LibraryApp libraryApp= new LibraryApp(sc,libraryReader);
        libraryApp.run();
    }
}
