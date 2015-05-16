/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import static POJOS.BDHibernateUtil.getSessionFactory;
import POJOS.User;
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
        
    public List<User> FindUsers(String Email, String Password)
    {
        Query q=session.createQuery("from User where email=:mail and password=:pass"); 
        q.setParameter("mail",Email);
        q.setParameter("pass",Password);
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
    
    public void UpdateUserPass(String Email, String Password )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set password=:pass where email=:mail");
        q.setParameter("mail",Email);
        q.setParameter("pass",Password);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserAddress(String Email, String Address )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set address=:add where email=:mail");
        q.setParameter("mail",Email);
        q.setParameter("add",Address);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserCity(String Email, String City )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set city=:city where email=:mail");
        q.setParameter("mail",Email);
        q.setParameter("city",City);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateUserCountry(String Email, String Country )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update User set country=:country where email=:mail");
        q.setParameter("mail",Email);
        q.setParameter("country",Country);
        q.executeUpdate();
        tx.commit();
    }
        
        
    public void CloseSession(){
        session.close();
    }

    
}
