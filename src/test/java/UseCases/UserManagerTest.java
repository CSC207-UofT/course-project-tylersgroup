package UseCases;/*
Unit tests for UserManager.java
 */

import Entities.UserList;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;


public class UserManagerTest {
    UserManager manager;

    @Before("")
    public void setUp(){
        manager = new UserManager();
    }

    @After("")
    public void tearDown(){

    }

    @Test
    public void testAddUserSuccess(){
        boolean success = manager.addUser("TestUser1","User1Password");
        assert(success);
    }

    @Test
    public void testAddUserFailure(){
        manager.addUser("TestUser1","User1Password");
        boolean success = manager.addUser("TestUser1","UpdatingMyPassword");
        assert(!success);
    }

    @Test
    public void testDeleteUserSuccess(){
        manager.addUser("TestUser1","User1Password");
        boolean success = manager.deleteUser("TestUser1");
        assert(success);
    }

    @Test
    public void testDeleteUserFailure(){
        boolean success = manager.deleteUser("TestUser1");
        assert(!success);
    }

}
