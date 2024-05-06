package com.group.cars.Services;

import com.group.cars.Entities.Role;
import com.group.cars.Entities.User;

public interface userServices {
    void deleteAllusers();
    void deleteAllRoles();
    User saveUser(User user);
    User findUserByUsername (String username);
    Role addRole(Role role);
    User addRoleToUser(String username, String rolename);
    }
    
