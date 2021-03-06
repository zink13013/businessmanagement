package fr.marseille.businessmanagement.service;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.DAOFactory;
import fr.marseille.businessmanagement.dao.ProfileDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Permission;
import fr.marseille.businessmanagement.model.Profile;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileService.
 */
public class ProfileService {

    /**
     * The Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(ProfileService.class);

    /**
     * The profile dao.
     */
    private ProfileDAO profileDAO = DAOFactory.getProfileDAO();

    /**
     * Default constructor.
     */
    public ProfileService() {
    }

    /**
     * Find.
     *
     * @param id the id
     * @return the profile
     * @throws ServiceException the service exception
     */
    public Profile find(Integer id) throws ServiceException {
        Profile profile = null;
        try {
            profile = profileDAO.find(id);
            LOG.debug("profile found:" + id);
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }

        return profile;
    }

    /**
     * Find all.
     *
     * @return the list
     * @throws ServiceException the service exception
     */
    /**
     * @throws DAOException
     * @throws ServiceException
     */
    public List<Profile> findAll() throws ServiceException {
        List<Profile> list = new ArrayList<>();
        try {
            list = profileDAO.findAll();
            ProfileService.LOG.debug("profile found:" + list.size());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return list;
    }

    /**
     * Update.
     *
     * @param profile the profile
     * @return the profile
     * @throws ServiceException the service exception
     */
    public Profile update(Profile profile) throws ServiceException {

        try {
            profileDAO.update(profile);
            LOG.debug("profile update:" + profile.getId());
        } catch (DAOException e) {
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return profile;
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the boolean
     * @throws ServiceException the service exception
     */
    public Boolean delete(Integer id) throws ServiceException {
        boolean status = false;
        try {
            status = profileDAO.delete(id);

        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return status;
    }

    /**
     * Save.
     *
     * @param profile the profile
     * @return true, if successful
     * @throws ServiceException the service exception
     */
    public boolean save(Profile profile) throws ServiceException {
        boolean status = false;
        try {
            status = profileDAO.save(profile);

        } catch (DAOException e) {
            status = false;
            LOG.error(e.getMessage());
            throw new ServiceException(e.getMessage(), e);
        }
        return status;
    }

    /**
     * Exclude.
     *
     * @param profile the profile
     * @param permission the permission
     */
    public void exclude(Profile profile, Permission permission) {

    }

    /**
     * Include.
     *
     * @param profile the profile
     * @param permission the permission
     */
    public void include(Profile profile, Permission permission) {
        // TODO implement here
    }

    /**
     * Creates the profiles.
     *
     * @return the list
     */
    public List<Profile> createProfiles() {
        List<Profile> profiles = new ArrayList<Profile>();

        for (int i = 0; i < 10; i++) {
            profiles.add(new Profile(i, "name" + i, "description" + i));
        }
        return profiles;

    }
}
