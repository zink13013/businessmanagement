package fr.marseille.businessmanagement.dao;

import fr.marseille.businessmanagement.dao.impl.AdresseJPADAO;
import fr.marseille.businessmanagement.dao.impl.ClientJPADAO;
import fr.marseille.businessmanagement.dao.impl.LanguageJPADAO;
import fr.marseille.businessmanagement.dao.impl.PermissionJPADAO;
import fr.marseille.businessmanagement.dao.impl.PermissionLabelJPADAO;
import fr.marseille.businessmanagement.dao.impl.ProfileJPADAO;
import fr.marseille.businessmanagement.dao.impl.ProfilePermissionJPADAO;
import fr.marseille.businessmanagement.dao.impl.ProfileUserJPADAO;
import fr.marseille.businessmanagement.dao.impl.UserJPADAO;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating DAO objects.
 */
public class DAOFactory {

    /**
     * Client *
     */
    private static ClientDAO client;

    /**
     * Adresse *
     */
    private static AdresseDAO adresse;

    /**
     * The user.
     */
    private static UserDAO user;

    /**
     * The profile.
     */
    private static ProfileDAO profile;

    /**
     * The permission.
     */
    private static PermissionDAO permission;

    /**
     * The language.
     */
    private static LanguageDAO language;

    /**
     * The permission label.
     */
    private static PermissionLabelDAO permissionLabel;

    /**
     * The profile user.
     */
    private static ProfileUserDAO profileUser;

    /**
     * The profile permission.
     */
    private static ProfilePermissionDAO profilePermission;

    /**
     * Gets adresse dao.
     *
     * @return adresse dao
     */
    public static AdresseDAO getAdresseDAO() {
        if (null == adresse) {
            adresse = new AdresseJPADAO();
        }

        return adresse;
    }

    /**
     * Gets the client dao.
     *
     * @return the client dao
     */
    public static ClientDAO getClientDAO() {
        if (null == client) {
            client = new ClientJPADAO();
        }

        return client;
    }

    /**
     * Gets the user dao.
     *
     * @return the user dao
     */
    public static UserDAO getUserDAO() {
        if (null == user) {
            user = new UserJPADAO();
        }

        return user;
    }

    /**
     * Gets the profile dao.
     *
     * @return the profile dao
     */
    public static ProfileDAO getProfileDAO() {
        if (null == profile) {
            profile = new ProfileJPADAO();
        }

        return profile;
    }

    /**
     * Gets the permission dao.
     *
     * @return the permission dao
     */
    public static PermissionDAO getPermissionDAO() {
        if (null == permission) {
            permission = new PermissionJPADAO();
        }

        return permission;
    }

    /**
     * Gets the language dao.
     *
     * @return the language dao
     */
    public static LanguageDAO getLanguageDAO() {
        if (null == language) {
            language = new LanguageJPADAO();
        }

        return language;
    }

    /**
     * Gets the permission label dao.
     *
     * @return the permission label dao
     */
    public static PermissionLabelDAO getPermissionLabelDAO() {
        if (null == permissionLabel) {
            permissionLabel = new PermissionLabelJPADAO();
        }

        return permissionLabel;
    }

    /**
     * Gets the profile user dao.
     *
     * @return the profile user dao
     */
    public static ProfileUserDAO getProfileUserDAO() {
        if (null == profileUser) {
            profileUser = new ProfileUserJPADAO();
        }

        return profileUser;
    }

    /**
     * Gets the profile permission.
     *
     * @return the profile permission
     */
    public static ProfilePermissionDAO getProfilePermission() {
        if (null == profilePermission) {
            profilePermission = new ProfilePermissionJPADAO();
        }

        return profilePermission;
    }

}
