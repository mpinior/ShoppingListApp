package org.example.persistance;

import org.example.domain.User;
import org.example.persistance.IPersistanceHelper;
import org.example.persistance.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryTest {

    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }

    @Test
    public void addUserTest(){
        //arrange
        User user = generateUser("ala", "456");
        IPersistanceHelper iPersistanceHelper= Mockito.mock(IPersistanceHelper.class);
        UserRepository repository = new UserRepository(iPersistanceHelper);

        //act
        repository.add(user);
        //assert
        Assert.assertNotNull(repository.find(user.getName()));
    }

    @Test
    public void removeUserTest(){
        //arrange
        User user = generateUser("ala", "456");
        IPersistanceHelper iPersistanceHelper= Mockito.mock(IPersistanceHelper.class);
        UserRepository repository = new UserRepository(iPersistanceHelper);

        //act
        repository.add(user);
        repository.remove(user);
        //assert
        Assert.assertNull(repository.find(user.getName()));
    }

    @Test
    public void getAllUsersTest(){
        //arrange
        User user = generateUser("ala", "456");
        User user1 = generateUser("ola", "123");
        IPersistanceHelper iPersistanceHelper= Mockito.mock(IPersistanceHelper.class);
        UserRepository repository = new UserRepository(iPersistanceHelper);
        List testList = new ArrayList();

        //act
        repository.add(user);
        repository.add(user1);
        testList.add(user1);
        testList.add(user);
        //assert

        Assert.assertEquals(testList, repository.getAll());
    }

    @Test
    public void findUserTest(){
        //arrange
        User user = generateUser("ala", "456");
        IPersistanceHelper iPersistanceHelper= Mockito.mock(IPersistanceHelper.class);
        UserRepository repository = new UserRepository(iPersistanceHelper);
        List testList = new ArrayList();

        //act
        repository.add(user);
        //assert

        Assert.assertEquals(repository.find("ala"), user);
    }


}
