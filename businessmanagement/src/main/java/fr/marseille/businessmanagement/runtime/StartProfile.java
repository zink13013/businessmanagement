package fr.marseille.businessmanagement.runtime;

import fr.marseille.businessmanagement.exception.DAOException;
import fr.marseille.businessmanagement.exception.ServiceException;
import fr.marseille.businessmanagement.model.Permission;
import fr.marseille.businessmanagement.model.Profile;
import fr.marseille.businessmanagement.model.User;
import fr.marseille.businessmanagement.service.PermissionService;
import fr.marseille.businessmanagement.service.ProfileService;
import fr.marseille.businessmanagement.service.UserService;

public class StartProfile {
    private static ProfileService    profileService    = new ProfileService();
    private static UserService       userService       = new UserService();
    private static PermissionService permissionService = new PermissionService();

    public static void main(String[] args) throws ServiceException, DAOException {

        // Start.generateDatabase();
        insertProfiles();
        affectUser();
        includePermission();

        // JPAUtil.closeAll();
    }

    protected static void affectUser() throws ServiceException, DAOException {
        User user = userService.findAll().get(0);
        Profile profile = profileService.findAll().get(0);

        profile.getUsers().add(user);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void includePermission() throws ServiceException, DAOException {

        Profile profile = profileService.findAll().get(0);
        Permission permission = permissionService.findAll().get(0);
        profile.getPermissions().add(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void excludePermission() throws ServiceException, DAOException {

        Profile profile = profileService.findAll().get(0);
        Permission permission = permissionService.findAll().get(0);
        profile.getPermissions().remove(permission);
        profileService.update(profile);

        profileService.createProfiles();

    }

    protected static void insertProfiles() throws ServiceException {
        String[] applications = StartPermission.applications;
        String[] roles = { "Admin", "Chief", "Editor", "Guest" };

        for (String application : applications) {
            for (String role : roles) {
                profileService.save(
                        new Profile(null, role + "." + application, role + " of " + application + " application"));
            }
        }
    }
}
