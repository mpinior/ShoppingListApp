package org.example.IT;

import org.apache.commons.io.FileUtils;
import org.example.domain.User;

import org.example.persistance.PersistanceHelper;
import org.example.persistance.UserRepository;
import org.example.service.UserService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Paths;
import java.util.List;



public class PersistanceIT {

    UserRepository up;

    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }

    //czyscic folder
    @BeforeAll
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

        Assertions.assertNotNull(users);
    }

    @Test
    public void removeUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        up.save(generateUser("ala", "123"));
        up.remove(generateUser("ala", "123"));

        UserRepository testUp = new UserRepository(new PersistanceHelper("test_persistance"));
        List<User> users = testUp.getAll();

        Assertions.assertTrue(users.isEmpty());
    }

    @Test
    public void findUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        up.save(generateUser("ala", "123"));

        UserRepository testUp = new UserRepository(new PersistanceHelper("test_persistance"));

        Assertions.assertNotNull(testUp.find("ala"));
    }

    @Test
    public void loginUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        User user = generateUser("ala", "123");
        up.save(user);
        UserService us = new UserService(up);

        us.loginUser("ala", "123");

        Assertions.assertEquals(us.getCurrentUser().getName(), user.getName());
    }

    @Test
    public void loginNewUserIT(){
        UserRepository up = new UserRepository(new PersistanceHelper("test_persistance"));
        UserService us = new UserService(up);

        us.loginUser("ola", "123");

        Assertions.assertEquals(us.getCurrentUser().getName(), "ola");
    }

}
