package fr.marseille.businessmanagement.view;


import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.User;
import fr.marseille.businessmanagement.service.UserService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserSaveView.
 */
@ManagedBean
@RequestScoped
public class UserSaveView extends BaseView {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * The user service.
     */
    private UserService userService = new UserService();

    /**
     * The user.
     */
    private User user;

    /**
     * Inits the.
     */
    @PostConstruct
    public void init() {
        user = new User();
    }

    /**
     * Save.
     */
    public void save() {
        try {
            userService.save(user);
        } catch (ServiceException e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Error while Saving User: " + e.getMessage()));
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));

        this.redirectWithMessages("userIndex.jsf");
    }

    /**
     * Gets the user.
     *
     * @return the user
     */
    public User getUser() {
        return this.user;
    }

    /**
     * Instantiates a new user save view.
     */
    public UserSaveView() {
        super();
    }

}
