package org.example.persistance;

import org.example.domain.User;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UserRepository implements IUserRepository {
    private final Set<User> users;
    private IPersistanceHelper persistencyHelper;

    public UserRepository(IPersistanceHelper persistencyHelper){
        users = new HashSet<>();
        this.persistencyHelper = persistencyHelper;
    }

    @Override
    public void saveAll() {
        for (var project : users) {
            save(project);
        }
    }

    @Override
    public void save(User user) {
        persistencyHelper.saveUserFile(user);
    }

    @Override
    public void add(User user) {
        users.add(user);
    }

    @Override
    public void remove(User user) {
        var userName = user.getName();
        var file = persistencyHelper.getAllUserFiles().stream().filter(x -> userName.equals(IPersistanceHelper.getFileNameWithoutExtension(x))).findFirst();
        file.ifPresent(persistencyHelper::removeFile);
        users.remove(user);
    }

    @Override
    public List<User> getAll() {
        for (var file : persistencyHelper.getAllUserFiles()) {
            loadUser(file);
        }

        return users.stream().collect(Collectors.toList());
    }

    @Override
    public User find(String name) {
        //TODO maybe null, if name does not exist
        User user;
        try {
            user = getAll().stream().filter(x -> x.getName().equals(name)).findFirst().get();
        }
        catch(Exception e){
            user = null;
        }
        return user;
    }

    private User loadUser(File file) {
        var userName = IPersistanceHelper.getFileNameWithoutExtension(file);

        if (users.stream().anyMatch(x -> x.getName().toString().equals(userName))) {
            //noinspection OptionalGetWithoutIsPresent
            return users.stream().filter(x -> x.getName().toString().equals(userName)).findFirst().get();
        }
        var newProject = persistencyHelper.loadFile(file, User.class);

        users.add(newProject);
        return newProject;
    }
}
