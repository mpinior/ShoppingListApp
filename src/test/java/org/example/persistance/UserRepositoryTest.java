package org.example.persistance;

import org.example.domain.User;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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
        Assertions.assertNotNull(repository.find(user.getName()));
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
        Assertions.assertNull(repository.find(user.getName()));
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

        Assertions.assertEquals(testList, repository.getAll());
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

        Assertions.assertEquals(repository.find("ala"), user);
    }


}
