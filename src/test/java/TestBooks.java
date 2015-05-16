/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import POJOS.Books;
//import ServiceClasses.BookService;
import java.util.List;
import org.junit.Test;

/**
 *
 * @author Farjad
 */


public class TestBooks {
@Test
        public void TestALL(){
            
//        BookService bookService = new BookService();

        Books book1 = new Books("The Brothers Karamazov");

        Books book2 = new Books("War and Peace");


        System.out.println("*** Persist - start ***");


        System.out.println("Books Persisted are :");


        System.out.println("*** Persist - end ***");

        System.out.println("*** Update - start ***");

        book1.setBookName("The Idiot");


        

        System.out.println("*** Update - end ***");

        System.out.println("*** Find - start ***");

//Enter Test Entries

        System.out.println("*** Delete - end ***");

        System.out.println("*** Persist the books into database ***");

//        bookService.persist(book1);
//        bookService.persist(book2);

        System.out.println("Books found are :");

//Enter Test Entries
        
        
        System.out.println("*** FindAll - end ***");

        System.out.println("*** DeleteAll - start ***");



        System.out.println("*** DeleteAll - end ***");

         System.exit(0);

    }

}

