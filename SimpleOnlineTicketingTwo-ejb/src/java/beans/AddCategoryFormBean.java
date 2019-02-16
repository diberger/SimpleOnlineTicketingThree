package beans;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import metier.Category;

@RequestScoped
@Named(value="addCategoryFormBean")
public class AddCategoryFormBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Category category;

    // Injection de notre EJB (Session Bean Stateless)
    @EJB
    private CategoryBean categorieDAO;

    // Initialisation de l'entité utilisateur
    public AddCategoryFormBean() {
        category  = new Category();
    }

    // Méthode d'action appelée lors du clic sur le bouton du formulaire
    // d'inscription
    public void add() {
        categorieDAO.save(category);
        FacesMessage message = new FacesMessage( "Succès de l'addition !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }

    public Category getCategory() {
        return category;
    }

  
}