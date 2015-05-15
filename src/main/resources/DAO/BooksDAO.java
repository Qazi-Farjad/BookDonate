/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import static Configur.BDHibernateUtil.getSession;
import POJOS.Books;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Farjad
 */



public class BooksDAO {
    
    Books bk;
    
    public static void main(String args[]){
        BooksDAO bd = new BooksDAO();
        bd.AddBook("Shartu");
    }
    
    public void AddBook(String BookName){
        Session session = getSession();
        Transaction tx = session.beginTransaction();
        
        bk = new Books();
        
        bk.setBookName(BookName);

        
        session.persist(bk);
        tx.commit();
        session.close();
        
    }
    
}
