package com.example.spottyv2.Controllers;

import com.example.spottyv2.Entities.DefaultUser;
import com.example.spottyv2.Entities.SpotifyUser;
import com.example.spottyv2.Entities.User;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MakeUserControllerTest {
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void makeUser() {
        MakeUserController userMaker = new MakeUserController();
        User user1 = userMaker.makeUser("123", true);
        User user2 = userMaker.makeUser("456", false);
        Assertions.assertTrue(user1 instanceof SpotifyUser);
        Assertions.assertSame("123", user1.getUsername());
        Assertions.assertTrue(user2 instanceof DefaultUser);
        Assertions.assertSame("456", user2.getUsername());

    }
}
