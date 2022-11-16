package org.example.service;

import org.example.persistance.IUserRepository;
import org.example.persistance.UserRepository;

public class Mediator implements IMediator{

    private IUserService userSrervice;
    public Mediator() {
        userSrervice = new UserService(UserRepository.getInstance());
    }

    @Override
    public IUserService getUserService() {
        return userSrervice;
    }

    @Override
    public IUserRepository getUserRepository() {
        return UserRepository.getInstance();
    }
}
