package fr.marseille.businessmanagement.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import fr.marseille.businessmanagement.dao.ProfileDAO;
import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.model.Profile;
import fr.marseille.businessmanagement.util.JPAUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class ProfileJPADAO.
 */
public class ProfileJPADAO implements ProfileDAO {

    /**
     * The Constant LOG.
     */
    private static final Logger LOG = Logger.getLogger(ProfileJPADAO.class);

    /**
     * Instantiates a new profile jpadao.
     */
    public ProfileJPADAO() {

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileDAO#save(fr.marseille.permissionmanagement.model.Profile)
     */
    @Override
    public boolean save(Profile profile) throws DAOException {

        boolean status = false;
        try {

            // Debute une transaction
            JPAUtil.beginTransaction();

            JPAUtil.getEntityManager().persist(profile);

            JPAUtil.commitTransaction();

        } catch (RuntimeException e) {

            String msg = "persist : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return status;

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileDAO#findAll()
     */
    @Override
    public List<Profile> findAll() throws DAOException {

        List<Profile> profiles = new ArrayList<>();
        try {

            profiles = (List<Profile>) JPAUtil.getEntityManager().createQuery("from Profile").getResultList();

        } catch (RuntimeException e) {

            String msg = "findAll : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return profiles;

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileDAO#find(java.lang.Integer)
     */
    @Override
    public Profile find(Integer id) throws DAOException {

        // Debute une transaction
        Profile profile = null;
        try {
            profile = JPAUtil.getEntityManager().find(Profile.class, id);

        } catch (RuntimeException e) {

            String msg = "find : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }

        return profile;

    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileDAO#update(fr.marseille.permissionmanagement.model.Profile)
     */
    @Override
    public Profile update(Profile profile) throws DAOException {

        try {
            JPAUtil.beginTransaction();
            JPAUtil.getEntityManager().merge(profile);
            JPAUtil.commitTransaction();
        } catch (RuntimeException e) {

            String msg = "update : " + e.getMessage();
            LOG.error(msg);
            JPAUtil.rollbackTransaction();
            throw new DAOException(msg, e);
        }
        return profile;
    }

    /* (non-Javadoc)
     * @see fr.marseille.permissionmanagement.dao.ProfileDAO#delete(java.lang.Integer)
     */
    @Override
    public boolean delete(Integer id) throws DAOException {
        boolean status = false;
        Profile profile = this.find(id);
        if (null != profile) {
            try {
                JPAUtil.beginTransaction();
                JPAUtil.getEntityManager().remove(profile);
                JPAUtil.commitTransaction();

            } catch (RuntimeException e) {

                String msg = "delete : " + e.getMessage();
                LOG.error(msg);
                JPAUtil.rollbackTransaction();
                throw new DAOException(msg, e);
            }
        }
        return status;

    }
}
