///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
///**
// *
// * @author Syed Shahwar Shah
// */
//
//
//import DAO.UsersDAO;
//import POJOS.User;
//import java.util.Iterator;
//import java.util.List;
//import org.junit.Ignore;
//import org.junit.Test;
//
//
//public class TestUsers {
//
//    private static void Print(List<User> list) {
//         
//        Iterator<User> itr=list.iterator();  
//	while(itr.hasNext())
//        {  
//            User us=itr.next();
//            
//            System.out.println("**********************");  
//            
//            System.out.println("USER");
//	    System.out.println("Id: "+us.getId()); 
//            System.out.println("Name: "+us.getEmail());  
//            System.out.println("Pass: "+us.getPassword());  
//            System.out.println("Adddress: "+us.getAddress()); 
//            System.out.println("City: "+us.getCity());  
//            System.out.println("Country: "+us.getCountry());  
//            System.out.println("Organization: "+us.getOrganization());  
//            
//            System.out.println("**********************");  
//       }
//    }
//    @Ignore
//    @Test
//        public void TestInsertUser(){
//
//           User us = new User();
//              
//           us.setName("Shahwar");
//           us.setEmail("shahwar@gmail.com");
//           us.setPassword("1234");
//           us.setAddress("NUST-H12");
//           us.setCity("Isb");
//           us.setCountry("Pakistan");        
//           us.setOrganization("Yes");
//           
//            
//           UsersDAO ud = new UsersDAO();
//           
//           ud.AddUser(us);
//             
//           ud.CloseSession();
//           
//    }
//     
//    @Test
//        p
// 
//    @Ignore   
//    @Test
//        public void TestGetUsers(){
//  
//          UsersDAO ud = new UsersDAO();
//           
//          List<User> list = ud.GetUsers();
//           
//          TestUsers.Print(list);
//             
//          ud.CloseSession();
//    }
//    
//    @Ignore
//    @Test  
//    public void TestDeleteUsers(){
//  
//          UsersDAO ud = new UsersDAO();
//           
//          ud.DeleteUserByEmail("shah@gmail.com");
//             
//          ud.CloseSession();
//    } 
//    
//    @Test
//    public void  TestUpdateUserPass(){
//        
//        UsersDAO bd = new UsersDAO();
//         
//        System.out.println("Upadte user pass");
//        
//        bd.UpdateUserPass(1,"3456");
//        
//        bd.CloseSession();
//    }
//    
//    @Test
//    public void  TestUpdateUserAddress(){
//        
//        UsersDAO bd = new UsersDAO();
//         
//        System.out.println("Upadte user address");
//        
//        bd.UpdateUserAddress(1,"Iqbal Road");
//        
//        bd.CloseSession();
//    }   
//    
//    @Test
//    public void  TestUpdateUserCity(){
//        
//        UsersDAO bd = new UsersDAO();
//         
//        System.out.println("Upadte user city");
//        
//        bd.UpdateUserCity(1,"Abbottabad");
//        
//        bd.CloseSession();
//    }
//    
//    @Test
//    public void  TestUpdateUserCountry(){
//        
//        UsersDAO bd = new UsersDAO();
//         
//        System.out.println("Upadte user country");
//        
//        bd.UpdateUserCountry(1,"Pak");
//        
//        bd.CloseSession();
//    }
//}