package org.example.IT;

import org.apache.commons.io.FileUtils;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.IPersistanceHelper;
import org.example.persistance.PersistanceHelper;
import org.example.persistance.UserRepository;
import org.example.service.UserService;
import org.junit.*;


import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class PersistanceIT {

    UserRepository up;

    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }

    //czyscic folder
    @BeforeClass
    public static void setUp(){
        String path = Paths.get(".").toAbsolutePath().toString();
        StringBuilder sb = new StringBuilder(path);
        sb.setLength(sb.length()-1);
        path = sb.toString();
        File directory = new File(path + "test_persistance");
        try{
            FileUtils.deleteDirectory(directory);
        }
        catch(Exception e){
            System.out.println("Not exists.");
        }
    }

    @Test
    public void addUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        up.save(generateUser("ala", "123"));

        UserRepository testUp = new UserRepository(new PersistanceHelper("test_persistance"));
        List<User> users = testUp.getAll();

        Assert.assertNotNull(users);
    }

    @Test
    public void removeUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        up.save(generateUser("ala", "123"));
        up.remove(generateUser("ala", "123"));

        UserRepository testUp = new UserRepository(new PersistanceHelper("test_persistance"));
        List<User> users = testUp.getAll();

        Assert.assertTrue(users.isEmpty());
    }

    @Test
    public void findUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        up.save(generateUser("ala", "123"));

        UserRepository testUp = new UserRepository(new PersistanceHelper("test_persistance"));

        Assert.assertNotNull(testUp.find("ala"));
    }

    @Test
    public void loginUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        User user = generateUser("ala", "123");
        up.save(user);
        UserService us = new UserService(up);

        us.loginUser("ala", "123");

        Assert.assertEquals(us.getCurrentUser().getName(), user.getName());
    }

    @Test
    public void loginNewUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        UserService us = new UserService(up);

        us.loginUser("ola", "123");

        Assert.assertEquals(us.getCurrentUser().getName(), "ola");
    }

}
