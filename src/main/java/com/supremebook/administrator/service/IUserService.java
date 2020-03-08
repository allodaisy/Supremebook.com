package com.supremebook.administrator.service;
import java.util.List;
import com.supremebook.administrator.model.User;

public interface IUserService {
        public User selectUser(long userId);

        public List<User> selectAllUser();

        public User selectUserByEmail(String email);

        public User addUser(User user);

        public User removeUser(long userId);

        public User modifyUser(User user);

    }
