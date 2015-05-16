/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static POJOS.BDHibernateUtil.getSessionFactory;
import POJOS.Matchmaker;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MatchmakerDAO {
    
    Session session = null;
    Transaction tx = null;
    
    public MatchmakerDAO()
    {
         session = getSessionFactory().openSession();
    }
    
   
    public void AddEntry(Matchmaker Mk){
            
        tx=session.beginTransaction();  
        session.persist(Mk);
        tx.commit();
    }
        
    public List<Matchmaker> ShowEntriesToUser(int Id)
    {
        Query q=session.createQuery("from Matchmaker where id=:id"); 
        q.setParameter("id",Id);
        List<Matchmaker> list=q.list();  
        
        return list;  
    }
     
    public List<Matchmaker> FindMatch(int BookId)
    {
        Query q=session.createQuery("from Matchmaker where bookId=:id"); 
        q.setParameter("id",BookId);
        List<Matchmaker> list=q.list();  
        
        return list; 
    }
    
    
    public void DeleteEntry(int MatchMakerId)
    {
        tx=session.beginTransaction();
        Query q = session.createQuery("delete from Matchmaker where matchmakerId=:id");
        q.setParameter("id", MatchMakerId);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateEntry(int MatchMakerId, int Quantity )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update Matchmaker set quantity=:qty where matchmakerId=:id");
        q.setParameter("id", MatchMakerId);
        q.setParameter("qty", Quantity);
        q.executeUpdate();
        tx.commit();
    }
    
        
    public void CloseSession(){
        session.close();
    }
    
}
