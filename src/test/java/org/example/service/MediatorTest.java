package org.example.service;

import org.example.persistance.IUserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class MediatorTest {

    @Test
    public void getUserService() {
        Mediator mediator = new Mediator();

        Assert.assertNotNull(mediator.getUserService());
    }

    @Test
    public void getUserRepository() {
        Mediator mediator = new Mediator();

        Assert.assertNotNull(mediator.getUserRepository());
    }
}