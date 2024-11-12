package com.hotelbookingproject.BLITCoding.service;

import com.hotelbookingproject.BLITCoding.model.Role;
import com.hotelbookingproject.BLITCoding.model.User;

import java.util.List;

public interface RoleService {

    List<Role> getRoles();
    Role createRole(Role role);
    void deleteRole(Long id);
    Role findByName(String name);

    User removeUserFromRole(Long userId, Long roleId);

    User assignRoleToUser(Long userId, Long roleId);

    Role removeAllUsersFromRole(Long roleId);
}
