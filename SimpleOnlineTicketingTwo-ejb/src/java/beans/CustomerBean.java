/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Customer;
import metier.Event;

/**
 *
 * @author diberger
 */
@Stateless
@LocalBean
public class CustomerBean {
    @PersistenceContext(unitName="SimpleOnlineTicketingTwo-ejbPU")
    private EntityManager em;
    
    public boolean validate(String nom, String password){
        try{
         Customer c = (Customer)em.createQuery("SELECT c FROM Customer c WHERE c.login = :login AND c.password = :password").setParameter("password", password).setParameter("login", nom).getSingleResult();
         return true;
        }catch(Exception e){
            return false;
        }
         
    }
    
    public void save(Customer c){
        em.persist(c);
    }
}
