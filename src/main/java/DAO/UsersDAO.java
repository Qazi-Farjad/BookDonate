/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import static POJOS.BDHibernateUtil.getSessionFactory;
import POJOS.User;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UsersDAO {
    
    Session session = null;
    Transaction tx = null;
    
    public UsersDAO()
    {
         session = getSessionFactory().openSession();;
    }
    
   
    public void AddUser(User Us){
            
        tx=session.beginTransaction();  
        session.persist(Us);
        tx.commit();
    }
        
    public List<User> GetUsers()
    {
        Query q=session.createQuery("from User "); 
        List<User> list=q.list();  

        return list;
    }
     
    public void DeleteUserByEmail(String Email)
    {
        tx=session.beginTransaction();
        Query q = session.createQuery("delete from User where email=:mail");
        q.setParameter("mail", Email);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserPass(int Id, String Password )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set password=:pass where id=:id");
        q.setParameter("id",Id);
        q.setParameter("pass",Password);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserAddress(int Id, String Address )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set address=:add where id=:id");
        q.setParameter("id",Id);
        q.setParameter("add",Address);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserCity(int Id, String City )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set city=:city where id=:id");
        q.setParameter("id",Id);
        q.setParameter("city",City);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserCountry(int Id, String Country )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set country=:country where id=:id");
        q.setParameter("id",Id);
        q.setParameter("country",Country);
        q.executeUpdate();
        tx.commit();
    }
        
        
    public void CloseSession(){
        session.close();
    }

    
}
