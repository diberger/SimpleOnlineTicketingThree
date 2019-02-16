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
import metier.Category;
import metier.Event;

/**
 *
 * @author diberger
 */
@Stateless
@LocalBean
public class CategoryBean {

    @PersistenceContext(unitName="SimpleOnlineTicketingTwo-ejbPU")
    private EntityManager em;

    public void save(Category category){
        em.persist(category);
    }
    
    public List<Category> findAll(){
        return (List<Category>)em.createQuery("SELECT c FROM Category c").getResultList();
    }
}
