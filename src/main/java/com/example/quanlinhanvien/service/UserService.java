package com.example.quanlinhanvien.service;

import com.example.quanlinhanvien.models.User;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class UserService {
    ArrayList<User> users = new ArrayList<>();

    {
        users.add(new User("An", "123"));
    }

    public boolean checkUser(String user, String pass){
        for (User x:users
             ) {
            if (x.getUsername().equals(user) && x.getPass().equals(pass)){
                return true;
            }
        }
        return false;
    }
}
