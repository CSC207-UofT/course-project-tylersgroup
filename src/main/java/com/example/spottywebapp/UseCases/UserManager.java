package com.example.spottywebapp.UseCases;


import com.example.spottywebapp.Entities.Playlist;
import com.example.spottywebapp.Entities.User;
import com.example.spottywebapp.Entities.UserList;


/**
 * A Use Case class
 *
 * UserManager manages all the users who use the program.
 */
public class UserManager {
    // Making UserManager a singleton
    private static UserManager USERMANAGER = null;

    // instance attributes of UserManager
    private UserList users;

    // Constructor
    public UserManager(){
        users = new UserList();
    }

    /**
     * Instantiate the singleton UserManager.
     * @return the UserManager singleton
     */
    public static UserManager getInstance(){
        if (USERMANAGER == null){
            USERMANAGER = new UserManager();
        }
        return USERMANAGER;
    }

    /**
     * Set users of UserManager.
     * @param users a UserList object containing all the users
     */
    public void setUserList(UserList users){
        this.users = users;
    }

    /**
     * Checks if username exists already.
     * @param username username of a user
     * @return whether username exists already
     */
    public boolean concurrentUser(String username){
        return users.concurrentUser(username);
    }

    /**
     * Create and adds a new user to the users (UserList).
     * @param username username of user to be added to users
     * @param password password of user to be added to users
     * @return if adding user is successful
     */
    public boolean createAndAddUser(String username, String password){
        User newUser = createUser(username, password);
        return addNewUser(newUser);
    }

    /**
     * Creates a new user.
     * @param username username of user to be created
     * @param password password of user to be created
     * @return a new User entity
     */
    private User createUser(String username, String password){
        return new User(username, password);
    }

    /**
     * Adds a newUser (User entity) to users.
     * @param newUser a newly created User entity
     * @return whether adding the new user to users is successful
     */
    public boolean addNewUser(User newUser) {
        String username = newUser.getUsername();
        if (this.users.concurrentUser(username)) {
            return false;
        } else {
            this.users.addUser(username, newUser);
            return true;
        }
    }

    /**
     * Deletes a user specified by username.
     * @param username username of the user to be deleted
     * @return whether deletion of user is successful
     */
    public boolean deleteUser(String username){
        if (this.users.concurrentUser(username)){
            this.users.removeUser(username);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Changes the password of user.
     * @param username username of user
     * @param newPassword new password
     * @return whether changing password is successful
     */
    public boolean changePassword(String username, String newPassword){
        if (this.users.concurrentUser(username)){
            User user = this.users.getUser(username);
            user.setPassword(newPassword);
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Gets a User entity using username.
     * @param username username of user
     * @return the User entity with the specified username
     */
    public User getUser(String username){
        // can throw noSuchElementException
        return users.getUser(username);
    }
}