package org.example.service;

import org.example.persistance.IPersistanceHelper;
import org.example.persistance.IUserRepository;
import org.example.persistance.PersistanceHelper;
import org.example.persistance.UserRepository;

public class Mediator implements IMediator{

    private IUserService userSrervice;
    private IUserRepository userRepository;
    private IPersistanceHelper persistanceHelper;
    public Mediator() {
        this.persistanceHelper = new PersistanceHelper();
        this.userRepository = new UserRepository(persistanceHelper);
        userSrervice = new UserService(userRepository);
    }

    @Override
    public IUserService getUserService() {
        return userSrervice;
    }

    @Override
    public IUserRepository getUserRepository() {
        return userRepository;
    }
}
