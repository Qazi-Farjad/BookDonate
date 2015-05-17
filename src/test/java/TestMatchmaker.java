/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Syed Shahwar Shah
 */


import DAO.BooksDAO;
import DAO.MatchmakerDAO;
import DAO.UsersDAO;
import POJOS.Books;
import POJOS.Matchmaker;
import POJOS.User;
import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TestMatchmaker {

    @Ignore
    @Test
        public void TestInsertEntry(){
           
           UsersDAO ud = new UsersDAO();
           User us =ud.GetUserByEmail("shahwar@gmail.com");
           
           BooksDAO bd = new BooksDAO();
           Books bk = bd.FindBookById(2);
          
           Matchmaker mk = new Matchmaker();
           
           mk.setUser(us);
           mk.setBooks(bk);
           mk.setDonRec("D");
           mk.setQuantity(1);
           
           MatchmakerDAO md = new MatchmakerDAO();
           md.AddEntry(mk);
          
           md.CloseSession();    
    }
     
    @Ignore
    @Test 
    public void TestShowEntriesToUser(){
        
        UsersDAO ud = new UsersDAO();
        User us =ud.GetUserByEmail("shahwar@gmail.com");
        
        MatchmakerDAO md = new MatchmakerDAO();
        List<Matchmaker> list = md.ShowEntriesToUser(us);
        
        TestMatchmaker.print(list);
        md.CloseSession();    
    }
    
    @Ignore
    @Test 
    public void TestFindMatch(){
        
        BooksDAO bd = new BooksDAO();
        Books bk = bd.FindBookById(2);
        
        MatchmakerDAO md = new MatchmakerDAO();
        List<Matchmaker> list = md.FindMatch(bk);
        
        TestMatchmaker.print(list);
        md.CloseSession();    
    }
    
    @Ignore
    @Test 
    public void TestDeleteEntry(){
        
         MatchmakerDAO md = new MatchmakerDAO();
         md.DeleteEntry(3);
         md.CloseSession(); 
    }
    
    @Ignore
    @Test 
    public void TestUpdateEntry(){
        
         MatchmakerDAO md = new MatchmakerDAO();
         md.UpdateEntry(2,5);
         md.CloseSession(); 
    }
      
    private static void print(List<Matchmaker> list) {
        
        System.out.println("Matchmaker Print");
        Iterator<Matchmaker> itr=list.iterator();  
	while(itr.hasNext())
        {
            Matchmaker mk=itr.next();
            
            System.out.println("**********************");  
            
	    System.out.println("Match Maker Id: "+mk.getMatchmakerId()); 
            
            User us = mk.getUser();
            System.out.println("User Id: "+us.getId());  
            
            Books bk = mk.getBooks();
            System.out.println("Book Id: "+bk.getBookId());  
            
            System.out.println("Quantity: "+mk.getQuantity()); 
            
            System.out.println("DonRec: "+ mk.getDonRec());
           
            System.out.println("**********************"); 
        
        }
    } 
}
