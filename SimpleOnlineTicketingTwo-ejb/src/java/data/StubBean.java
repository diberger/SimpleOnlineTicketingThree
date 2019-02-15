/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import metier.Category;
import metier.Event;

/**
 *
 * @author diberger
 */
@Stateless
@LocalBean
public class StubBean {
    
    @PersistenceContext(unitName="SimpleOnlineTicketingTwo-ejbPU")
    private EntityManager em;
    
    private Category festoche;
    
    public void loadCategories(){
        festoche = new Category("Festoche");
        em.persist(festoche);
        em.flush();
    }
    
    public void loadEvents(){
        Event event = new Event("Suicide collectif","IUT clermont-Fd",new Date(),"Un suicide collectif est la solution",0);
        event.setCategory(festoche);
        em.persist(event);
        em.flush();
    }
    
}
