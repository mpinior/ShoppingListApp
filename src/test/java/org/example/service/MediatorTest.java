package org.example.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MediatorTest {

    @Test
    public void getUserService() {
        Mediator mediator = new Mediator();

        Assertions.assertNotNull(mediator.getUserService());
    }

    @Test
    public void getUserRepository() {
        Mediator mediator = new Mediator();

        Assertions.assertNotNull(mediator.getUserRepository());
    }
}