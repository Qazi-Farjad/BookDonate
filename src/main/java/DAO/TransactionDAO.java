/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static POJOS.BDHibernateUtil.getSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;




/**
 *
 * @author Farjad
 */
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
    
}
