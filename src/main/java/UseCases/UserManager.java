/*
* A Use Case class
*
* UserManager manages all the users who use the program.
*/
package UseCases;

import java.util.*;

public class UserManager {
    //private Map<String, User> users;
    private Map<String, String> users;

    public UserManager(){
        //users = new HashMap<String, User>();
        users = new HashMap<String, String>();
    }
    public boolean addUser(String username, String password){
        if (this.users.containsKey(username)){
            return false;
        }
        else{
            this.users.put(username, password);
            return true;
        }
    }
    public boolean deleteUser(String username){
        if (this.users.containsKey(username)){
            this.users.remove(username);
            return true;
        }
        else{
            return false;
        }
    }


    public String getUser(String username){
        return users.get(username);
    }
}
