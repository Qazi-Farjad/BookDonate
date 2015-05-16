/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Syed Shahwar Shah
 */


import DAO.MatchmakerDAO;
import POJOS.Matchmaker;
import java.util.Iterator;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;

public class TestMatchmaker {
   
    @Test
        public void TestInsertUser(){
 
            
            
           Matchmaker mk = new Matchmaker();
           MatchmakerDAO ud = new MatchmakerDAO();
           
           
           
           ud.AddEntry(mk);
           
           
           
           ud.CloseSession();    
    }
    
}
