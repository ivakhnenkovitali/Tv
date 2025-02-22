package by.itclass.model.services;

import by.itclass.model.dao.UserDao;
import by.itclass.model.entities.User;

import java.util.Objects;

public class UserService {
    private static UserService service;
    private final UserDao dao;

    private UserService() {
        dao = UserDao.getInstance();
    }

    public static UserService getInstance() {
        if (Objects.isNull(service)) {
            service = new UserService();
        }
        return service;
    }

    public User getUser(String login, String password) {
        return dao.selectUser(login, password);
    }

    public boolean addUser(User user) {
        return dao.insertUser(user);
    }
}
