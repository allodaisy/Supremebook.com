package com.supremebook.administrator.dao;
import com.supremebook.administrator.model.User;
import java.util.List;
//用户的数据访问对象接口，方便进行增删查改,与userDao相关sql语句相关联
public interface IUserDao {
        User selectUser(long id);

        List<User> selectAllUser();

        User selectUserByEmail(String email);

        User addUser(User user);

        User removeUser(long id);

        User modifyUser(User user);

    }
