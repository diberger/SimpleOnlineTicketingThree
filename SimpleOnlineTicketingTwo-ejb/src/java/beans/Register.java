package beans;

import java.io.IOException;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import metier.Customer;

@RequestScoped
@Named(value="register")
public class Register implements Serializable {
    private static final long serialVersionUID = 1L;

    private Customer customer;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private CustomerBean customerDAO;

    // Initialisation de l'entité utilisateur
    public Register() {
        customer  = new Customer();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void add() throws IOException {
        customerDAO.save(customer);
        FacesMessage message = new FacesMessage( "Succès de l'addition !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        FacesContext context = FacesContext.getCurrentInstance();  
        HttpServletResponse respon  = ((HttpServletResponse)context.getExternalContext().getResponse());  
        HttpServletRequest req = (HttpServletRequest)context.getExternalContext().getRequest();
        respon.sendRedirect(req.getContextPath() + "/faces/login.xhtml");
        context.responseComplete();  
    }

    public Customer getCustomer() {
        return customer;
    }
  
}