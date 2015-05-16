/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Syed Shahwar Shah
 */


import DAO.UsersDAO;
import POJOS.User;
import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;


public class TestUsers {

    @Test
        public void TestInsertUser(){

           User us = new User();
              
           us.setName("Shahwar");
           us.setEmail("shahwar@gmail.com");
           us.setPassword("1234");
           us.setAddress("NUST-H12");
           us.setCity("Isb");
           us.setCountry("Pakistan");        
           us.setOrganization("Yes");
           
            
           UsersDAO ud = new UsersDAO();
           
           ud.AddUser(us);
             
           ud.CloseSession();
           
    }
 
    
    
    
    
}
