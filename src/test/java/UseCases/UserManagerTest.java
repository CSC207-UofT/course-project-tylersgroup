package UseCases;/*
Unit tests for UserManager.java
 */

import com.example.spottywebapp.UseCases.UserManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;


public class UserManagerTest {
    UserManager manager = UserManager.getInstance();


    @Before("")
    public void setUp(){
    }

    @After("")
    public void tearDown(){
    }

    @Test
    public void testCreateAndAddUserSuccess(){
        boolean success = manager.createAndAddUser("TestUser1","User1Password");
        assert(success);
    }

    @Test
    public void testCreateAndAddUserFailure(){
        manager.createAndAddUser("TestUser1","User1Password");
        boolean success = manager.createAndAddUser("TestUser1","UpdatingMyPassword");
        assert(!success);
    }

    @Test
    public void testDeleteUserSuccess(){
        manager.createAndAddUser("TestUser1","User1Password");
        boolean success = manager.deleteUser("TestUser1");
        assert(success);
    }

    @Test
    public void testDeleteUserFailure(){
        boolean success = manager.deleteUser("TestUser10");
        assert(!success);
    }

}
