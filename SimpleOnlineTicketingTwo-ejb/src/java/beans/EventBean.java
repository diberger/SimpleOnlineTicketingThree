/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import metier.Event;

/**
 *
 * @author diberger
 */
@Stateless
@LocalBean
public class EventBean {

    @PersistenceContext(unitName="SimpleOnlineTicketingTwo-ejbPU")
    private EntityManager em;

    /*public EventBean() {
        em = Persistence.createEntityManagerFactory("SimpleOnlineTicketingTwo-ejbPU").createEntityManager();
    }*/
    
    public void save(Event event){
        em.persist(event);
    }
    
    public List<Event> findAll(){
        return (List<Event>)em.createQuery("SELECT e FROM Event e").getResultList();
    }
}
