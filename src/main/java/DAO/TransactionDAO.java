/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static POJOS.BDHibernateUtil.getSessionFactory;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionDAO {
        
        Transaction tx;
        Session session;
    
        public TransactionDAO()
    {
         session = getSessionFactory().openSession();;
    }
        
        public void AddTransaction(POJOS.Transaction us)
        {            
        tx=session.beginTransaction();  
        session.persist(us);
        tx.commit();
        }
        
    public List<POJOS.Transaction> ShowDonations(int Id)
    {
        Query q=session.createQuery("from Tranaction where matchmakerByDonorId=:id"); 
        q.setParameter("id",Id);
        List<POJOS.Transaction> list=q.list();  
        
        return list;  
    }
     
    public List<POJOS.Transaction> ShowReceivings(int Id)
    {
        Query q=session.createQuery("from Tranaction where matchmakerByRecId=:id"); 
        q.setParameter("id",Id);
        List<POJOS.Transaction> list=q.list();  
        
        return list; 
    }
    
        
    public void CloseSession(){
        session.close();
    }
}
