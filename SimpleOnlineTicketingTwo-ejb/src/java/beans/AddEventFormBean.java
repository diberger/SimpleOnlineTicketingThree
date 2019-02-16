package beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import metier.Event;

@RequestScoped
@Named(value="addEventFormBean")
public class AddEventFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Event event;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private EventBean eventDAO;

    // Initialisation de l'entité utilisateur
    public AddEventFormBean() {
        event  = new Event();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void add() {
        eventDAO.save(event);
        FacesMessage message = new FacesMessage( "Succès de l'addition !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

    public Event getEvent() {
        return event;
    }

  
}