package org.example.service;

import org.example.persistance.IUserRepository;

public interface IMediator {

    IUserService getUserService();

    IUserRepository getUserRepository();
}
