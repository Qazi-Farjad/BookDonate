/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import static POJOS.BDHibernateUtil.getSessionFactory;
import POJOS.Books;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;




public class BooksDAO {
    
    Session session = null;
    Transaction tx = null;
    
    public BooksDAO()
    {
        session = getSessionFactory().openSession();
    }
    
   
    public void AddBook(Books Bk){
  
        tx=session.beginTransaction();
        session.persist(Bk);
        tx.commit();
    }
        
    public List<Books> FindAllBooks()
    {
        Query q=session.createQuery("from Books");  
        List<Books> list=q.list();  

        return list;  
    }
    
   
    public Books FindBookById(int Id)
    {
        Query q=session.createQuery("from Books where bookId=:id ");  
        q.setParameter("id",Id);
        List<Books> list=q.list();
        
        Iterator<Books> itr=list.iterator();  
        
        Books bk = null;
	while(itr.hasNext())
        {  
            bk=itr.next();
        }
       
        return bk;
    }
    
    public List<Books> FindBooksByName(String BookName)
    {
        Query q=session.createQuery("from Books where bookName=:name ");  
        q.setParameter("name",BookName);
        List<Books> list=q.list();  

        return list;  
    }
    
    public List<Books> FindBooksByGrade(String Grade)
    {
        Query q=session.createQuery("from Books where class_=:grade "); 
        q.setParameter("grade",Grade);
        List<Books> list=q.list();  

        return list;  
    }
    
    public List<Books> FindBooksByAuthor(String Author)
    {
        Query q=session.createQuery("from Books where author=:author "); 
        q.setParameter("author",Author);
        List<Books> list=q.list();  

        return list;  
    }
     
    
    public void DeleteBook(String BookName)
    {
        tx=session.beginTransaction();
        Query q = session.createQuery("delete from Books where bookName=:name");
        q.setParameter("name", BookName);
        q.executeUpdate();
        tx.commit();
    }
    
    public void UpdateBook(String BookName,String Description )
    {
        tx=session.beginTransaction();
        Query q=session.createQuery("Update Books set bookDescription=:desc where bookName=:name");
        q.setParameter("name",BookName);
        q.setParameter("desc",Description);
        q.executeUpdate();
        tx.commit();
    }
        
        
    public void CloseSession(){
        session.close();
    }        
 }
    

