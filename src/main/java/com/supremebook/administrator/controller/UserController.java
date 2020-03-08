package com.supremebook.administrator.controller;

import javax.servlet.http.HttpServletRequest;

import com.supremebook.administrator.model.User;
import com.supremebook.administrator.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

    @Controller
    @RequestMapping("/user")
    public class UserController {

        @Resource
        private IUserService userService;
        private long userId;
        private ObjectMapper mapper;

        //响应/showUser,
        @RequestMapping(value = "/showUser/{id}", method = RequestMethod.GET)
        public void getUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            long userId = Long.parseLong(id);
            User user = this.userService.selectUser(userId); //使用userService对指定id的用户进行查找
            ObjectMapper mapper = new ObjectMapper();

            response.getWriter().write("Database information:" + mapper.writeValueAsString(user)); //返回给response
            response.getWriter().close();
        }


        //响应loginUser
        @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
        public void loginUser(User loginUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            User user = this.userService.selectUserByEmail(loginUser.getEmail());
            ObjectMapper mapper = new ObjectMapper();
            if (user == null) {
                response.getWriter().write("账号不存在！");
            } else if (!loginUser.getPassword().equals(user.getPassword())) {
                response.getWriter().write("密码输入错误！");
            } else {
                response.getWriter().write(mapper.writeValueAsString(user));
            }
            response.getWriter().close();
        }

        //响应allUser
        @RequestMapping(value = "/allUser", method = RequestMethod.GET)
        public void allUser(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            List<User> userList = userService.selectAllUser();
            String userMsg = "";
            for (User user : userList) {
                userMsg = userMsg + "<tr>";
                userMsg = userMsg + "<td>" + user.getId() + "</td>";
                userMsg = userMsg + "<td>" + user.getUsername() + "</td>";
                userMsg = userMsg + "<td>" + user.getPassword() + "</td>";
                userMsg = userMsg + "<td>" + user.getEmail() + "</td>";
                userMsg = userMsg + "<td>" + user.getRole() + "</td>";

                userMsg = userMsg + "<td><input type='button' value='删 除' οnclick='removeUser(" + user.getId() + ")'/></td>";
                userMsg = userMsg + "</tr>";
            }
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(userMsg));
        }

        //响应showUser
        @RequestMapping(value = "/showUser", method = RequestMethod.POST)
        public void postUser(User registUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            ObjectMapper mapper = new ObjectMapper();
            User user = this.userService.selectUserByEmail(registUser.getEmail());
            if (user != null) {
                //主码为编号id，email不能重复
                response.getWriter().write("该账号已经注册过！");
            } else {

                this.userService.addUser(registUser);
                response.getWriter().write(mapper.writeValueAsString(user));
            }
            response.getWriter().close();
        }
//response.getWriter().print(),不仅可以打印输出文本格式的（包括html标签），还可以将一个对象以默认的编码方式转换为二进制字节输出
//response.getWriter().writer（）,只能打印输出文本格式的（包括html标签），不可以打印对象。

        //响应更新
        @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
        public void putUser(User updateUser, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            System.out.println(updateUser.getUsername());
            System.out.println(updateUser.getPassword());
            ObjectMapper mapper = new ObjectMapper();
            User user = this.userService.modifyUser(updateUser);
            response.getWriter().write(mapper.writeValueAsString(user));
            response.getWriter().close();
        }

        //响应删除
        @RequestMapping(value = "/removeUser/{id}", method = RequestMethod.DELETE)
        public void deleteUser(@PathVariable String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            long userId = Long.parseLong(id);
            this.userService.removeUser(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write("remove success!");
            response.getWriter().close();
        }

    }
