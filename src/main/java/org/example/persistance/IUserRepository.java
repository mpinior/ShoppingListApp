package org.example.persistance;

import org.example.domain.User;

import java.util.ArrayList;
import java.util.List;

public interface IUserRepository {
    void add(User user);
    void remove(User user);
    List<User> getAll();
    User find(String name);
    void saveAll();
    void save(User user);
}
