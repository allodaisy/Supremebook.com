package com.supremebook.administrator.service.impl;

import com.supremebook.administrator.dao.IUserDao;
import com.supremebook.administrator.model.User;
import com.supremebook.administrator.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
//@service 是对@component 的进一步拓展，被@service注解标注的类会被Spring认定是业务逻辑层，里面有spring对业务逻辑层管理的一对逻辑
public class UserServiceImpl implements IUserService {

    @Resource
//    resource 按照name+type两种方式对bean进行装配
    private IUserDao userDao;

    public User selectUser(long userId) {
        return this.userDao.selectUser(userId);
    }

    public List<User> selectAllUser() {
        return this.userDao.selectAllUser();
    }

    public User selectUserByEmail(String email) {
        return this.userDao.selectUserByEmail(email);
    }

    public User addUser(User user) {
        return this.userDao.addUser(user);
    }

    public User removeUser(long userId) {
        return this.userDao.removeUser(userId);
    }

    public User modifyUser(User user) {
        return this.userDao.modifyUser(user);
    }

}



