package com.supremebook.administrator.model;
import java.util.Date;
public class User {
//用户的类结构,和数据库中的表属性对应
        private long id;
        private String email;
        private String password;
        private String username;
        private String role;

        public long getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }



    }





