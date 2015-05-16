/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DAO.BooksDAO;
import POJOS.Books;
import java.util.Iterator;
//import ServiceClasses.BookService;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;



public class TestBooks {

    private static void Print(List<Books> list) {
        Iterator<Books> itr=list.iterator();  
	while(itr.hasNext())
        {  
            Books bk=itr.next();  
            
            System.out.println("**********************");  
            
	    System.out.println("Book Id: "+bk.getBookId()); 
            System.out.println("Book Name: "+bk.getBookName());  
            System.out.println("Book Author: "+bk.getAuthor());  
            System.out.println("Book Class: "+bk.getClass_()); 
            System.out.println("Book Board: "+bk.getBoard());  
            System.out.println("Book Image: "+bk.getBookImage());  
            System.out.println("Book Description: "+bk.getBookDescription());  
            
            System.out.println("**********************");  
        } 
    }
@Ignore
@Test
        public void TestInsertBook(){

           Books bk = new Books();
              
           bk.setBookName("Maths-101");
           bk.setBoard("Abbottabad");
           bk.setClass_("9th");
           
            
           BooksDAO bd = new BooksDAO();
           
           bd.AddBook(bk);
           
           bd.CloseSession();
           
    }
 @Ignore      
 @Test
      public void TestGetBookById(){
          
          BooksDAO bd = new BooksDAO();
          
          Books bk = bd.FindBookById(2);
          
          System.out.println("Book By Id");
          
          System.out.println("**********************");  
            
	  System.out.println("Book Id: "+bk.getBookId()); 
          System.out.println("Book Name: "+bk.getBookName());  
          System.out.println("Book Author: "+bk.getAuthor());  
          System.out.println("Book Class: "+bk.getClass_()); 
          System.out.println("Book Board: "+bk.getBoard());  
          System.out.println("Book Image: "+bk.getBookImage());  
          System.out.println("Book Description: "+bk.getBookDescription());  
            
          System.out.println("**********************");        
          
          
          bd.CloseSession();
          
      }
        
@Ignore
@Test
        public void TestGetAllBooks(){
            
        BooksDAO bd = new BooksDAO();
        
        List<Books> list= bd.FindAllBooks();
        
        TestBooks.Print(list);
        
        bd.CloseSession();
    }

 @Ignore     
 @Test
        public void TestGetBooksByName(){
            
         BooksDAO bd = new BooksDAO();
        
        List<Books> list= bd.FindBooksByName("physics");
        
        System.out.println("by Name");
        
        TestBooks.Print(list);
        
        bd.CloseSession();

    } 
        
        
 @Ignore      
 @Test
        public void TestGetBooksByGrade(){
            
         BooksDAO bd = new BooksDAO();
        
        List<Books> list= bd.FindBooksByGrade("9th");
        
        System.out.println("by Grade");
        
        TestBooks.Print(list);
        
        bd.CloseSession();

    }  
        
       @Ignore 
        @Test
        public void TestGetBooksByAuthor(){
            
         BooksDAO bd = new BooksDAO();
        
        List<Books> list= bd.FindBooksByAuthor("Paulo Coelho");
        
        System.out.println("by Author");
        
        TestBooks.Print(list);
        
        bd.CloseSession();

    }

 @Ignore     
 @Test
       public void TestDeleteBook(){
            
         BooksDAO bd = new BooksDAO();
         
         System.out.println("Delete Book");
        
         bd.DeleteBook("Maths-101");
        
         bd.CloseSession();

    }   
       @Ignore
       @Test
       public void TestUpdateBook(){
            
         BooksDAO bd = new BooksDAO();
         
         System.out.println("Upadte Book");
        
         bd.UpdateBook("physics","Physics for Life");
        
         bd.CloseSession();

    }
    
}

